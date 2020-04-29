(ns mars-rover.rover-test
  (:require
    [clojure.test :refer :all]
    [mars-rover.rover :refer :all]))

(deftest rover-tests
  (testing "returns the rover final position when execute the move string command"
           (is (= {:position {:x 0 :y 1} :orientation :north} (execute "M")))
           (is (= {:position {:x 0 :y 2} :orientation :north} (execute "MM")))
           (is (= {:position {:x 0 :y 6} :orientation :north} (execute "MMMMMM"))))

  (testing "returns the rover new orientation when execute the rotate right string command"
           (is (= {:position {:x 0 :y 0} :orientation :east} (execute "R")))
           (is (= {:position {:x 0 :y 0} :orientation :south} (execute "RR")))
           (is (= {:position {:x 0 :y 0} :orientation :west} (execute "RRR")))
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute "RRRR"))))

  (testing "returns the rover new orientation when execute the rotate right string command"
           (is (= {:position {:x 0 :y 0} :orientation :west} (execute "L")))
           (is (= {:position {:x 0 :y 0} :orientation :south} (execute "LL")))
           (is (= {:position {:x 0 :y 0} :orientation :east} (execute "LLL")))
           (is (= {:position {:x 0 :y 0} :orientation :north} (execute "LLLL"))))

  (testing "returns the rover final position when given a mixed command string command"
           (is (= {:position {:x 2 :y 3} :orientation :north} (execute "MMRMMLM")))))
