(ns widgets.components.widget-form 
  (:require [kee-frame.core :as k]))

(defn view [route]
  [:div
   [:h1 "Add a widget"]
   [:div [:a {:href (k/path-for [:widgets])} "Back"]]])