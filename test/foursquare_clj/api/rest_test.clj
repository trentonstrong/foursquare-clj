(ns foursquare-clj.api.rest-test
  (:use [clojure test]
        [foursquare-clj.api.rest]
        [foursquare-clj.test-utils]))

(defn is-http-200
  [f & args]
  (let [args (concat args [:access-token *access-token*])
        result (apply f args)]
    (is (= 200 (:status result)))))
    
  

(deftest test-users
  (is-http-200 users-leaderboard)
  (is-http-200 users-requests)
  (is-http-200 users-search :query-params {:name "Thomas Pynchon"}))

(deftest test-users-aspects
  (is-http-200 users-badges)
  (is-http-200 users-checkins)
  (is-http-200 users-friends)
  (is-http-200 users-lists)
  (is-http-200 users-mayorships)
  (is-http-200 users-photos)
  (is-http-200 users-tips)
  (is-http-200 users-venuehistory))

(deftest test-venues
  (is-http-200 venues-categories)
  (is-http-200 venues-explore :query-params {:near "Los Angeles, CA"})
  (is-http-200 venues-managed)
  (is-http-200 venues-search  :query-params {:near "Los Angeles, CA"})
  (is-http-200 venues-suggestcompletion :query-params {:ll "34.0522,-118.2428"
                                                       :query "Far"})
  (is-http-200 venues-trending :query-params {:ll "34.0522,-118.2428"}))

