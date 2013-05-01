(ns foursquare-clj.core-test
  (:use [clojure test]
        [foursquare-clj core]))

(deftest test-replace-uri-params
  (let [case1 (replace-uri-params "users/checkins" {})
        case2 (replace-uri-params "users/checkins/" {})
        case3 (replace-uri-params "users/checkins/{:id}" {:id 4})]
    (is (= "users/checkins" case1))
    (is (= "users/checkins/" case2))
    (is (= "users/checkins/4" case3))))

(deftest test-make-uri
  (let [case1 (make-uri FOURSQUARE-ROOT-URL "v2" "user/checkins" {})
        case2 (make-uri FOURSQUARE-ROOT-URL "v2" "user/checkins/{:id}" {:id 4})]
    (is (= "https://api.foursquare.com/v2/user/checkins" case1))
    (is (= "https://api.foursquare.com/v2/user/checkins/4" case2))))