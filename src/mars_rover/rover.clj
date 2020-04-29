(ns mars-rover.rover
  (:gen-class)
  (:require [clojure.string :refer :all :as str]
            [mars-rover.rover-generator :refer :all :as rg]))

(defn- move-forward
  [rover-to-move]
  (condp = (get rover-to-move :orientation)
    :north (update-in rover-to-move [:position :y] inc)
    :east (update-in rover-to-move [:position :x] inc)
    :south (update-in rover-to-move [:position :y] dec)
    :west (update-in rover-to-move [:position :x] dec)))

(defn- turn-right
  [rover-to-turn]
  (condp = (get rover-to-turn :orientation)
    :north (assoc rover-to-turn :orientation :east)
    :east (assoc rover-to-turn :orientation :south)
    :south (assoc rover-to-turn :orientation :west)
    :west (assoc rover-to-turn :orientation :north)))

(defn- turn-left
  [rover-to-turn]
  (condp = (get rover-to-turn :orientation)
    :north (assoc rover-to-turn :orientation :west)
    :east (assoc rover-to-turn :orientation :north)
    :south (assoc rover-to-turn :orientation :east)
    :west (assoc rover-to-turn :orientation :south)))

(defn- execute-single-command
  [rover command]
  (condp = command
    "M" (move-forward rover)
    "R" (turn-right rover)
    "L" (turn-left rover)
    rover))

(defn execute
  ([command]
    (execute (generate-rover 0 0 :north) command))
  ([rover commands]
   (reduce execute-single-command rover (str/split commands #""))))