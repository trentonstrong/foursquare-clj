(ns foursquare-clj.api.rest-test
  (:use [clojure test]
        [foursquare-clj.core :only [with-multi]]
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
  (is-http-200 users)
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

(deftest test-venues-aspects
  (is-http-200 venues :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-events :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-herenow :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-hours :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-likes :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-links :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-listed :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-menu :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-nextvenues :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-photos :venue-id "50462e2fe4b0a43d9cf8ec5f")
  (is-http-200 venues-similar :venue-id "50462e2fe4b0a43d9cf8ec5f")
;  (is-http-200 venues-stats :venue-id "50462e2fe4b0a43d9cf8ec5f") ; need to be venue manager
  (is-http-200 venues-tips :venue-id "50462e2fe4b0a43d9cf8ec5f"))

(deftest test-checkins
  (is-http-200 checkins-recent))

(deftest test-checkins-aspects
  (let [checkin-id (get-in (checkins-recent :access-token *access-token*)
                           [:body :response :recent 0 :id])]
    (is-http-200 checkins :checkin-id checkin-id)
    (is-http-200 checkins-likes :checkin-id checkin-id)))

(deftest test-with-multi
  (let [response (with-multi *access-token*
                   (users)
                   (users-friends))]
    (is (= 200 (:status response)))
    (is (= 2 (count (get-in response [:body :response :responses]))))))