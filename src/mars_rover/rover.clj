(ns mars-rover.rover
  (:gen-class))

(defn execute
  ([]
   (execute 0 0 :north))
  ([x y orientation]
   (hash-map :position (hash-map :x x :y y) :orientation orientation)))