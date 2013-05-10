(ns foursquare-clj.core
  (:require [clj-http.client :as http]))

(def FOURSQUARE-ROOT-URL "https://api.foursquare.com/v2")
(def LAST-VERIFIED-DATE "20130430")

(def ^:dynamic *with-multi* false)

(defn replace-uri-params
  [path arg-map]
  (letfn [(replace-fn [match]
            (let [[match param-name] match
                  param-value (get arg-map (keyword param-name))]
              (if-not (nil? param-value)
                (str param-value)
                (throw
                 (RuntimeException. (str "Parameter: " param-name " not present in argument map."))))))]
    (clojure.string/replace path #"\{:([a-zA-Z\-]+)\}" replace-fn)))

(defn make-uri
  [root path arg-map]
  (let [path-replaced (replace-uri-params path arg-map)]
    (clojure.string/join "/" [root path-replaced])))

(defmacro def-foursquare-endpoint
  [default-method resource-path & rest]
  (let [rest-arg-map (apply sorted-map rest)
        param-free-name (clojure.string/replace resource-path #"/\{:([a-zA-Z\-]+)\}" "")
        dashed-name (clojure.string/replace param-free-name #"[^a-zA-Z]+" "-") ; convert group of symbols to a dash
        clean-name (clojure.string/replace dashed-name #"-$" "")
        fn-name (symbol clean-name)]
    `(defn ~fn-name
       [& {:as args#}]
       (let [args# (merge ~rest-arg-map args#)
             method# (or (:method args#) ~default-method)
             uri# (make-uri FOURSQUARE-ROOT-URL ~resource-path args#)
             access-token# (get args# :access-token)
             query-params# (get args# :query-params)
             query-params# {:query-params (merge query-params#
                                                 {:v LAST-VERIFIED-DATE}
                                                 (when access-token#
                                                   {:oauth_token access-token#}))}
             request-map# (merge args#
                                  {:url uri#
                                   :method method#
                                   :as :json
                                   :coerce :always}
                                  query-params#)]
         (if-not *with-multi*
           (http/request request-map#)
           request-map#)))))

(def-foursquare-endpoint :post "multi")

(def join-query-string
  (partial clojure.string/join "?"))

(def join-uri
  (partial clojure.string/join ","))

(defn do-multi
  [access-token & requests]
  (let [paths (map #(clojure.string/replace (:url %) FOURSQUARE-ROOT-URL "") requests)
        query-params (map :query-params requests)
        query-strings (map http/generate-query-string query-params)
        uri-pairs (partition 2 (interleave paths query-strings))
        uris (map join-query-string uri-pairs)
        encoded-uris (join-uri uris)]
    (multi :access-token access-token :form-params {:requests encoded-uris})))


(defmacro with-multi
  [access-token & requests]
  (binding [*with-multi* true]
    (let [multi-requests (doall (map eval requests))]
      `(do-multi ~access-token ~@multi-requests))))





