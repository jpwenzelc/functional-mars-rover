(ns mars-rover.rover-test
  (:require
    [clojure.test :refer :all]
    [mars-rover.rover :refer :all]))

(deftest rover-tests
  (testing "returns the rover position upon execution with an empty string command"
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute)))
           (is (= {:position {:x 3 :y 5} :orientation :east} (execute 3 5 :east)))
           (is (= {:position {:x 6 :y 2} :orientation :west} (execute 6 2 :west)))
           (is (= {:position {:x 1 :y 2} :orientation :south} (execute 1 2 :south))))

  (testing "returns the rover final position when execute the move string command"
           (is (= {:position {:x 0 :y 1} :orientation :north} (execute "M")))
           (is (= {:position {:x 0 :y 2} :orientation :north} (execute "MM")))
           (is (= {:position {:x 0 :y 6} :orientation :north} (execute "MMMMMM")))
           (is (= {:position {:x 3 :y 6} :orientation :north} (execute 3 0 :north "MMMMMM")))
           (is (= {:position {:x 1 :y 0} :orientation :east} (execute 0 0 :east "M")))
           (is (= {:position {:x -1 :y 0} :orientation :west} (execute 0 0 :west "M")))
           (is (= {:position {:x 0 :y -1} :orientation :south} (execute 0 0 :south "M"))))

  (testing "returns the rover new orientation when execute the rotate right string command"
           (is (= {:position {:x 0 :y 0} :orientation :east} (execute "R")))
           ))
