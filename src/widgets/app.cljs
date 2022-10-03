(ns widgets.app
  (:require
   [kee-frame.core :as k]
   [re-frame.core :as r]
   [widgets.config :as config]
   ))

(enable-console-print!)

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(def routes [["/" :index]
             ["/widgets" :widgets]
             ["/widgets/:id" :widget]])

(defn index-view []
  [:div "index"])

(defn widgets-view []
  [:div "widgets-view"])

(defn widget-view [route]
  [:div (str "widget-view:" (-> route :path-params :id))])

(defn root-view []
  [k/switch-route (fn [route] (-> route :data :name))
   :index index-view
   :widgets widgets-view
   :widget widget-view
   nil [:div "Loading..."]])
  
(defn ^:dev/after-load mount-root []
  (r/clear-subscription-cache!)
  (k/start! {:log {:level :info
                    :ns-blacklist ["kee-frame.event-logger"]}
              :initial-db {:foo "bar"}
              :routes routes
              :root-component [root-view]}))

(defn init []
  (dev-setup)
  (mount-root))
