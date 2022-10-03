(ns widgets.components.widgets 
  (:require [kee-frame.core :as k]
            [re-frame.core :as r]))

(defn view [_route]
  (let [ws (r/subscribe [:widgets])]
    [:div
     [:h1 "Widgets"]
     [:ul
      (for [[k w] @ws]
        ^{:key k} [:li [:a {:href (k/path-for [:widget {:id k}])} (:name w)]])]
     [:div [:a {:href (k/path-for [:widget-form])} "Add"]]
     [:div [:a {:href (k/path-for [:index])} "Back"]]]))

(r/reg-sub :widgets
           (fn [db] (get db :widgets)))

(k/reg-controller :widgets
                  {:params (fn [route]
                             (-> route :data :name (= :widgets)))
                   :start  (fn [_ctx _] [:widgets/load])})

(k/reg-chain :widgets/load
             (fn [{:keys [db]} _]
               {:db (assoc db :widgets {1 {:id 1 :name "widget-1"}
                                        2 {:id 2 :name "widget-2"}
                                        3 {:id 3 :name "widget-3"}})}))

