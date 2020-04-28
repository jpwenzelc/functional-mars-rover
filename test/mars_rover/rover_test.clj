(ns mars-rover.rover-test
  (:require
    [clojure.test :refer :all]
    [mars-rover.rover :refer :all]))

(deftest rover-tests
  (testing "that it has 0 0 :north as the default position"
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute))))

  (testing "that the position is returned"
           (is (= {:position {:x 3 :y 5} :orientation :east} (execute 3 5 :east))))

  (testing "that returns the position when the execute is the command"
           (is (= {:position {:x 0 :y 1} :orientation :north} (execute "M")))
           (is (= {:position {:x 0 :y 2} :orientation :north} (execute "MM")))
           (is (= {:position {:x 0 :y 6} :orientation :north} (execute "MMMMMM")))
           (is (= {:position {:x 3 :y 6} :orientation :north} (execute 3 0 :north "MMMMMM")))
           (is (= {:position {:x 1 :y 0} :orientation :east} (execute 0 0 :east "M")))
           (is (= {:position {:x -1 :y 0} :orientation :west} (execute 0 0 :west "M")))
           (is (= {:position {:x 0 :y -1} :orientation :south} (execute 0 0 :south "M")))
  ))
