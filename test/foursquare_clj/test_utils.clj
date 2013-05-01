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

(def ^:dynamic *config* (load-config-file "test.config"))

(def ^:dynamic *access-token* (get *config* "user.access.token"))