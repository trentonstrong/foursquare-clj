(ns foursquare-clj.test-utils
  (:import
   (java.util Properties)))

(defn load-config-file
  "this loads a config file from the classpath"
  [file-name]
  (let [file-reader (.. (Thread/currentThread)
                        (getContextClassLoader)
                        (getResourceAsStream file-name))
        props (Properties.)]
    (.load props file-reader)
    (into {} props)))

(def ^:dynamic *config* (try
                          (load-config-file "test.config")
                          (catch Exception e
                            nil)))

(def ^:dynamic *access-token* (or (System/getenv "USER_ACCESS_TOKEN")
                                  (get *config* "user.access.token")))