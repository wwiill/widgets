(ns widgets.app-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [widgets.app :as app]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
