(ns widgets.components.index
  (:require [kee-frame.core :as k]))

(defn view [route]
  [:div
   [:h1 "Index"] 
   [:div [:a {:href (k/path-for [:widgets])} "Widgets"]]])