(ns mars-rover.rover-generator
  (:gen-class)
  (:require [clojure.core]))

(defn generate-rover
  [x y orientation]
  (hash-map :position (hash-map :x x :y y) :orientation orientation))