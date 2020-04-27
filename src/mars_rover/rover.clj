(ns mars-rover.rover
  (:gen-class))

(defn execute [x y orientation]
  (hash-map :position (hash-map :x x :y y) :orientation orientation))