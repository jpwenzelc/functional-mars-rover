(ns mars-rover.rover-generator-test
  (:require [clojure.test :refer :all]
            [mars-rover.rover-generator :refer :all]))

(deftest rover-generator-tests
  (testing "Will return a default rover when ask to generate one without arguments"
           (is (= {:position {:x 0 :y 0} :orientation :north} (generate-rover)))
           (is (= {:position {:x 3 :y 5} :orientation :east} (generate-rover 3 5 :east)))
           (is (= {:position {:x 6 :y 2} :orientation :west} (generate-rover 6 2 :west)))
           (is (= {:position {:x 1 :y 2} :orientation :south} (generate-rover 1 2 :south)))))