(ns widgets.components.widget 
  (:require [kee-frame.core :as k]
            [re-frame.core :as r]))

(defn view [_route]
  (let [w (r/subscribe [:widget])]
    [:div 
     [:h1 (:name @w)]
     [:div [:a {:href (k/path-for [:widgets])} "Back"]]]))

(r/reg-sub :widget
           (fn [db] (get db :widget)))

(k/reg-controller :widget
                  {:params (fn [route]
                             (when (-> route :data :name (= :widget))
                               (-> route
                                   :path-params
                                   :id)))
                   :start  (fn [_ctx id] [:widget/load id])})

(k/reg-chain :widget/load
             (fn [{:keys [db]} [id]]
               {:db (assoc db :widget {:id id :name (str "widget-" id)})}))

