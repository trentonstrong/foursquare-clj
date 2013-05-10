(ns foursquare-clj.api.rest
  (:use [foursquare-clj.core :only [def-foursquare-endpoint]]))

;; USERS
(def-foursquare-endpoint :get  "users/leaderboard")
(def-foursquare-endpoint :get  "users/requests")
(def-foursquare-endpoint :get  "users/search")

(def-foursquare-endpoint :get  "users/{:user-id}" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/badges" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/checkins" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/friends" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/following" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/lists" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/mayorships" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/photos" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/tips" :user-id "self")
(def-foursquare-endpoint :get  "users/{:user-id}/venuehistory" :user-id "self")

(def-foursquare-endpoint :post  "users/{:user-id}/approve" :user-id "self")
(def-foursquare-endpoint :post  "users/{:user-id}/deny" :user-id "self")
(def-foursquare-endpoint :post  "users/{:user-id}/request" :user-id "self")
(def-foursquare-endpoint :post  "users/{:user-id}/setpings" :user-id "self")
(def-foursquare-endpoint :post  "users/{:user-id}/unfriend" :user-id "self")
(def-foursquare-endpoint :post  "users/{:user-id}/update" :user-id "self")
 
;; VENUES
(def-foursquare-endpoint :post  "venues/add")

(def-foursquare-endpoint :get  "venues/categories")
(def-foursquare-endpoint :get  "venues/explore")
(def-foursquare-endpoint :get  "venues/managed")
(def-foursquare-endpoint :get  "venues/search")
(def-foursquare-endpoint :get  "venues/suggestcompletion")
(def-foursquare-endpoint :get  "venues/timeseries")
(def-foursquare-endpoint :get  "venues/trending")

(def-foursquare-endpoint :get  "venues/{:venue-id}")
(def-foursquare-endpoint :get  "venues/{:venue-id}/events")
(def-foursquare-endpoint :get  "venues/{:venue-id}/herenow")
(def-foursquare-endpoint :get  "venues/{:venue-id}/hours")
(def-foursquare-endpoint :get  "venues/{:venue-id}/likes")
(def-foursquare-endpoint :get  "venues/{:venue-id}/links")
(def-foursquare-endpoint :get  "venues/{:venue-id}/listed")
(def-foursquare-endpoint :get  "venues/{:venue-id}/menu")
(def-foursquare-endpoint :get  "venues/{:venue-id}/nextvenues")
(def-foursquare-endpoint :get  "venues/{:venue-id}/photos")
(def-foursquare-endpoint :get  "venues/{:venue-id}/similar")
(def-foursquare-endpoint :get  "venues/{:venue-id}/stats")
(def-foursquare-endpoint :get  "venues/{:venue-id}/tips")

(def-foursquare-endpoint :post  "venues/{:venue-id}/dislike")
(def-foursquare-endpoint :post  "venues/{:venue-id}/edit")
(def-foursquare-endpoint :post  "venues/{:venue-id}/flag")
(def-foursquare-endpoint :post  "venues/{:venue-id}/like")
(def-foursquare-endpoint :post  "venues/{:venue-id}/proposeedit")
(def-foursquare-endpoint :post  "venues/{:venue-id}/setrole")

;; VENUEGROUPS
(def-foursquare-endpoint :post  "venuegroups/add")
(def-foursquare-endpoint :post  "venuegroups/delete")

(def-foursquare-endpoint :get  "venuegroups/list")

(def-foursquare-endpoint :get  "venuegroups/{:group-id}")
(def-foursquare-endpoint :get  "venuegroups/{:group-id}/timeseries")
(def-foursquare-endpoint :get  "venuegroups/{:group-id}/campaigns")

(def-foursquare-endpoint :post  "venuegroups/{:group-id}/addvenue")
(def-foursquare-endpoint :post  "venuegroups/{:group-id}/edit")
(def-foursquare-endpoint :post  "venuegroups/{:group-id}/removevenue")
(def-foursquare-endpoint :post  "venuegroups/{:group-id}/update")

;; CHECKINS

(def-foursquare-endpoint :post  "checkins/add")

(def-foursquare-endpoint :get  "checkins/recent")

(def-foursquare-endpoint :get  "checkins/{:checkin-id}")
(def-foursquare-endpoint :get  "checkins/{:checkin-id}/likes")

(def-foursquare-endpoint :post  "checkins/{:checkin-id}/addcomment")
(def-foursquare-endpoint :post  "checkins/{:checkin-id}/addpost")
(def-foursquare-endpoint :post  "checkins/{:checkin-id}/deletecomment")
(def-foursquare-endpoint :post  "checkins/{:checkin-id}/like")
(def-foursquare-endpoint :post  "checkins/{:checkin-id}/reply")

;; TIPS

(def-foursquare-endpoint :post  "tips/add")

(def-foursquare-endpoint :get  "tips/{:tip-id}")
(def-foursquare-endpoint :get  "tips/{:tip-id}/likes")
(def-foursquare-endpoint :get  "tips/{:tip-id}/listed")
(def-foursquare-endpoint :get  "tips/{:tip-id}/saves")

(def-foursquare-endpoint :post  "tips/{:tip-id}/flag")
(def-foursquare-endpoint :post  "tips/{:tip-id}/like")
(def-foursquare-endpoint :post  "tips/{:tip-id}/unmark")

;; LISTS

(def-foursquare-endpoint :post  "lists/add")

(def-foursquare-endpoint :get  "lists/{:list-id}")
(def-foursquare-endpoint :get  "lists/{:list-id}/followers")
(def-foursquare-endpoint :get  "lists/{:list-id}/saves")
(def-foursquare-endpoint :get  "lists/{:list-id}/suggestphoto")
(def-foursquare-endpoint :get  "lists/{:list-id}/suggesttip")
(def-foursquare-endpoint :get  "lists/{:list-id}/suggestvenues")

(def-foursquare-endpoint :post  "lists/{:list-id}/additem")
(def-foursquare-endpoint :post  "lists/{:list-id}/deleteitem")
(def-foursquare-endpoint :post  "lists/{:list-id}/follow")
(def-foursquare-endpoint :post  "lists/{:list-id}/moveitem")
(def-foursquare-endpoint :post  "lists/{:list-id}/share")
(def-foursquare-endpoint :post  "lists/{:list-id}/unfollow")
(def-foursquare-endpoint :post  "lists/{:list-id}/update")
(def-foursquare-endpoint :post  "lists/{:list-id}/updateitem")



