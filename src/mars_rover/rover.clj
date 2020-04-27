(ns mars-rover.rover
  (:gen-class))

(defn execute
  ([]
   "executes no command which will always return the initial default value"
   (execute ""))
  ([command]
   "executes the command on the default rover (0 0 North)"
   (execute 0 0 :north command))
  ([x y orientation]
   "executes no command on a defined rover"
   (execute x y orientation ""))
  ([x y orientation command]
   "executes a command on a defined rover and returns its last position"
   (let [rover (hash-map :position (hash-map :x x :y y) :orientation orientation)]
     (if (= "M" command)
       (assoc-in rover [:position :y] (inc (get-in rover [:position :y])))
       rover))))