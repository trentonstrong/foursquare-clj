(ns foursquare-clj.core
  (:require [clj-http.client :as http]))

(def FOURSQUARE-ROOT-URL "https://api.foursquare.com")
(def LAST-VERIFIED-DATE "20130430")

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
  [root version path arg-map]
  (let [path-replaced (replace-uri-params path arg-map)]
    (clojure.string/join "/" [root version path-replaced])))

(defmacro def-foursquare-endpoint
  [default-method version resource-path & rest]
  (let [rest-arg-map (apply sorted-map rest)
        param-free-name (clojure.string/replace resource-path #"/\{:([a-zA-Z\-]+)\}" "")
        dashed-name (clojure.string/replace param-free-name #"[^a-zA-Z]+" "-") ; convert group of symbols to a dash 
        clean-name (clojure.string/replace dashed-name #"-$" "")
        fn-name (symbol clean-name)]
    `(defn ~fn-name
       [& {:as args#}]
       (let [args# (merge ~rest-arg-map args#)
             method# (or (:method args#) ~default-method)
             uri# (make-uri FOURSQUARE-ROOT-URL ~version ~resource-path args#)
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
         (if-not (:multi args#)
           (http/request request-map#)
           request-map#)))))


                                                            


