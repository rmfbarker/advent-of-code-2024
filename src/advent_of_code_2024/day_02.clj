(ns advent-of-code-2024.day-02
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def example-input "7 6 4 2 1\n1 2 7 8 9\n9 7 6 2 1\n1 3 2 4 5\n8 6 4 4 1\n1 3 6 7 9")
(def challenge-input (slurp (io/resource "input-day-02")))

(def input (str/split-lines example-input))

(defn numerals->ints [line]
  (map
    (fn [s] (Integer/parseInt s))
    (re-seq #"\d+" line)))

(defn parse-input [raw-input]
  (map numerals->ints (str/split-lines raw-input)))

(defn valid-ordering? [report]
  (or (apply < report)
      (apply > report)))

(defn valid-steps? [report-line]
  (every?
    (fn [[a b]]
      (< (abs (- a b)) 4))
    (partition 2 1 report-line)))

(defn valid-report? [report]
  (and (valid-ordering? report)
       (valid-steps? report)))


(defn solve-part-1 [input]
  (count
    (filter
      valid-report?
      (map numerals->ints input))))

(defn -main []
  (solve-part-1 (str/split-lines example-input))
  (solve-part-1 (str/split-lines challenge-input))

  )