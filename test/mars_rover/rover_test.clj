(ns mars-rover.rover-test
  (:require
    [clojure.test :refer :all]
    [mars-rover.rover :refer :all]))

(deftest rover-tests
  (testing "that the position is returned"
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute 0 0 :north)))))