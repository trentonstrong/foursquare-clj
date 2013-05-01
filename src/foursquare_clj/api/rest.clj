(ns foursquare-clj.api.rest
  (:use [foursquare-clj.core :only [def-foursquare-endpoint]]))

;; USERS
(def-foursquare-endpoint :get "v2" "users/leaderboard")
(def-foursquare-endpoint :get "v2" "users/requests")
(def-foursquare-endpoint :get "v2" "users/search")

(def-foursquare-endpoint :get "v2" "users/{:user-id}/badges" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/checkins" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/friends" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/lists" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/mayorships" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/photos" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/tips" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/venuehistory" :user-id "self")

(def-foursquare-endpoint :post "v2" "users/{:user-id}/approve" :user-id "self")
(def-foursquare-endpoint :post "v2" "users/{:user-id}/deny" :user-id "self")
(def-foursquare-endpoint :post "v2" "users/{:user-id}/request" :user-id "self")
(def-foursquare-endpoint :post "v2" "users/{:user-id}/setpings" :user-id "self")
(def-foursquare-endpoint :post "v2" "users/{:user-id}/unfriend" :user-id "self")
(def-foursquare-endpoint :post "v2" "users/{:user-id}/update" :user-id "self")
;; 


;; VENUES

(def-foursquare-endpoint :post "v2" "venues/add")

(def-foursquare-endpoint :get "v2" "venues/categories")
(def-foursquare-endpoint :get "v2" "venues/explore")
(def-foursquare-endpoint :get "v2" "venues/managed")
(def-foursquare-endpoint :get "v2" "venues/search")
(def-foursquare-endpoint :get "v2" "venues/suggestcompletion")
(def-foursquare-endpoint :get "v2" "venues/timeseries")
(def-foursquare-endpoint :get "v2" "venues/trending")