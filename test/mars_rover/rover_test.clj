(ns mars-rover.rover-test
  (:require
    [clojure.test :refer :all]
    [mars-rover.rover :refer :all]))

(deftest rover-tests
  (testing "that it has 0 0 :north as the default position"
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute))))

  (testing "that the position is returned"
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute 0 0 :north))))

  (testing "that returns the position when the execute is the command"
           (is (= {:position {:x 0 :y 1} :orientation :north} (execute "M")))
           (is (= {:position {:x 0 :y 2} :orientation :north} (execute "MM")))
  ))
