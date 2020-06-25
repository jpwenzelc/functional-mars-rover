(ns mars-rover.rover-generator
  (:gen-class)
  (:require [clojure.core]))

(defn generate-rover
  ([]
    (generate-rover 0 0 :north))
  ([x y orientation]
    {:position {:x x :y y} :orientation orientation}))