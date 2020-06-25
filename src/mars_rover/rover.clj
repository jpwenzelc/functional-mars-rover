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
   (assoc rover :orientation (case (rover :orientation)
                               :north :east
                               :east :south
                               :south :west
                               :west :north)))

(defn- turn-left
  [rover]
  (assoc rover :orientation (case (rover :orientation)
                              :north :west
                              :west :south
                              :south :east
                              :east :north)))

(defn- execute-single-command
  [rover command]
  (case command
    :M (move-forward rover)
    :R (turn-right rover)
    :L (turn-left rover)
    rover))

(defn execute
  ([command]
    (execute (generate-rover 0 0 :north) command))
  ([rover commands]
   (reduce execute-single-command rover (map keyword (str/split commands #"")))))