(ns mars-rover.rover
  (:require [clojure.string :as str]
            [mars-rover.rover-generator :refer [generate-rover]]))

(defn- move-forward
  [rover]
  (case (rover :orientation)
    :north (update-in rover [:position :y] inc)
    :east (update-in rover [:position :x] inc)
    :south (update-in rover [:position :y] dec)
    :west (update-in rover [:position :x] dec)))

(defn- turn-right
  [rover]
  (case (rover :orientation)
    :north (assoc rover :orientation :east)
    :east (assoc rover :orientation :south)
    :south (assoc rover :orientation :west)
    :west (assoc rover :orientation :north)))

(defn- turn-left
  [rover]
  (case (rover :orientation)
    :north (assoc rover :orientation :west)
    :east (assoc rover :orientation :north)
    :south (assoc rover :orientation :east)
    :west (assoc rover :orientation :south)))

(defn- execute-single-command
  [rover command]
  (case command
    "M" (move-forward rover)
    "R" (turn-right rover)
    "L" (turn-left rover)
    rover))

(defn execute
  ([command]
    (execute (generate-rover 0 0 :north) command))
  ([rover commands]
   (reduce execute-single-command rover (str/split commands #""))))