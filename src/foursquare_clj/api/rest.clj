(ns foursquare-clj.api.rest
  (:use [foursquare-clj.core :only [def-foursquare-endpoint]]))

;; USERS
(def-foursquare-endpoint :get "v2" "users/leaderboard")
(def-foursquare-endpoint :get "v2" "users/requests")
(def-foursquare-endpoint :get "v2" "users/search")

(def-foursquare-endpoint :get "v2" "users/{:user-id}" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/badges" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/checkins" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/friends" :user-id "self")
(def-foursquare-endpoint :get "v2" "users/{:user-id}/following" :user-id "self")
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
 
;; VENUES
(def-foursquare-endpoint :post "v2" "venues/add")

(def-foursquare-endpoint :get "v2" "venues/categories")
(def-foursquare-endpoint :get "v2" "venues/explore")
(def-foursquare-endpoint :get "v2" "venues/managed")
(def-foursquare-endpoint :get "v2" "venues/search")
(def-foursquare-endpoint :get "v2" "venues/suggestcompletion")
(def-foursquare-endpoint :get "v2" "venues/timeseries")
(def-foursquare-endpoint :get "v2" "venues/trending")

(def-foursquare-endpoint :get "v2" "venues/{:venue-id}")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/events")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/herenow")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/hours")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/likes")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/links")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/listed")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/menu")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/nextvenues")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/photos")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/similar")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/stats")
(def-foursquare-endpoint :get "v2" "venues/{:venue-id}/tips")

(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/dislike")
(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/edit")
(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/flag")
(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/like")
(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/proposeedit")
(def-foursquare-endpoint :post "v2" "venues/{:venue-id}/setrole")

;; VENUEGROUPS
(def-foursquare-endpoint :post "v2" "venuegroups/add")
(def-foursquare-endpoint :post "v2" "venuegroups/delete")

(def-foursquare-endpoint :get "v2" "venuegroups/list")

(def-foursquare-endpoint :get "v2" "venuegroups/{:group-id}")
(def-foursquare-endpoint :get "v2" "venuegroups/{:group-id}/timeseries")
(def-foursquare-endpoint :get "v2" "venuegroups/{:group-id}/campaigns")

(def-foursquare-endpoint :post "v2" "venuegroups/{:group-id}/addvenue")
(def-foursquare-endpoint :post "v2" "venuegroups/{:group-id}/edit")
(def-foursquare-endpoint :post "v2" "venuegroups/{:group-id}/removevenue")
(def-foursquare-endpoint :post "v2" "venuegroups/{:group-id}/update")

;; CHECKINS

(def-foursquare-endpoint :post "v2" "checkins/add")

(def-foursquare-endpoint :get "v2" "checkins/recent")

(def-foursquare-endpoint :get "v2" "checkins/{:checkin-id}")
(def-foursquare-endpoint :get "v2" "checkins/{:checkin-id}/likes")

(def-foursquare-endpoint :post "v2" "checkins/{:checkin-id}/addcomment")
(def-foursquare-endpoint :post "v2" "checkins/{:checkin-id}/addpost")
(def-foursquare-endpoint :post "v2" "checkins/{:checkin-id}/deletecomment")
(def-foursquare-endpoint :post "v2" "checkins/{:checkin-id}/like")
(def-foursquare-endpoint :post "v2" "checkins/{:checkin-id}/reply")

;; TIPS

(def-foursquare-endpoint :post "v2" "tips/add")

(def-foursquare-endpoint :get "v2" "tips/{:tip-id}")
(def-foursquare-endpoint :get "v2" "tips/{:tip-id}/likes")
(def-foursquare-endpoint :get "v2" "tips/{:tip-id}/listed")
(def-foursquare-endpoint :get "v2" "tips/{:tip-id}/saves")

(def-foursquare-endpoint :post "v2" "tips/{:tip-id}/flag")
(def-foursquare-endpoint :post "v2" "tips/{:tip-id}/like")
(def-foursquare-endpoint :post "v2" "tips/{:tip-id}/unmark")

;; LISTS

(def-foursquare-endpoint :post "v2" "lists/add")

(def-foursquare-endpoint :get "v2" "lists/{:list-id}")
(def-foursquare-endpoint :get "v2" "lists/{:list-id}/followers")
(def-foursquare-endpoint :get "v2" "lists/{:list-id}/saves")
(def-foursquare-endpoint :get "v2" "lists/{:list-id}/suggestphoto")
(def-foursquare-endpoint :get "v2" "lists/{:list-id}/suggesttip")
(def-foursquare-endpoint :get "v2" "lists/{:list-id}/suggestvenues")

(def-foursquare-endpoint :post "v2" "lists/{:list-id}/additem")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/deleteitem")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/follow")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/moveitem")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/share")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/unfollow")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/update")
(def-foursquare-endpoint :post "v2" "lists/{:list-id}/updateitem")



