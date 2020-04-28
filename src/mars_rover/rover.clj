(ns mars-rover.rover
  (:gen-class)
  (:require [clojure.string :refer :all :as str]))

(defn- move-forward
  [rover-to-move]
  (condp = (get rover-to-move :orientation)
    :north (update-in rover-to-move [:position :y] inc)
    :east (update-in rover-to-move [:position :x] inc)
    :south (update-in rover-to-move [:position :y] dec)
    :west (update-in rover-to-move [:position :x] dec)))

(defn execute
  ([]
    (execute ""))
  ([command]
    (execute 0 0 :north command))
  ([x y orientation]
    (execute x y orientation ""))
  ([x y orientation commands]
    (let [rover (hash-map :position (hash-map :x x :y y) :orientation orientation)
          actions (str/split commands #"")]
      (reduce (fn [new-rover command]
                (condp = command
                  "M" (move-forward new-rover)
                  new-rover)) rover actions))))