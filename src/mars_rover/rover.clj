(ns mars-rover.rover
  (:gen-class)
  (:require [clojure.string :refer :all :as str]))

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
                (cond
                  (= "M" command) (assoc-in new-rover [:position :y] (inc (get-in new-rover [:position :y])))
                  :else new-rover)) rover actions))))