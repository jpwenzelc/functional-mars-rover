(ns mars-rover.rover
  (:gen-class)
  (:require [clojure.string :refer :all :as str]))

(defn- move-forward
  [rover-to-move]
  (update-in rover-to-move [:position :y] inc))
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