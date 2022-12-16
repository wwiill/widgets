(ns widgets.app
  (:require
   [kee-frame.core :as k]
   [re-frame.core :as r]
   [widgets.config :as config]
   [widgets.components.index :as index]
   [widgets.components.widget :as widget]
   [widgets.components.widget-form :as widget-form]
   [widgets.components.widgets :as widgets]
   ))

(enable-console-print!)

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(def routes [["/" :index]
             ["/widgets" :widgets]
             ["/widgets/:id" :widget]
             ["/widget/form" :widget-form]])


(defn root-view []
  [k/switch-route (fn [route] (-> route :data :name))
   :index index/view
   :widget widget/view
   :widgets widgets/view
   :widget-form widget-form/view
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
