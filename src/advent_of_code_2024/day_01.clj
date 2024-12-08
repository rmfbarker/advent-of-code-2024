(ns advent-of-code-2024.day-01
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))


(def input (str/split-lines (slurp (io/resource "input-day-01"))))

(defn numerals->ints [line]
  (map
    (fn [s] (Integer/parseInt s))
    (re-seq #"\d+" line)))

(def input-pairs (map
                   numerals->ints
                   input))

;; Sort the inner lists and then the main list
(defn sort-cols [pairs]
  (zipmap (sort (map first pairs))
          (sort (map second pairs))))

(def sum-distance
  (reduce
    (fn [sum [a b]]
      (+ sum (Math/abs (- a b))))
    0
    (sort-cols input-pairs)))

;; Part 1 answer
(println sum-distance)

;; Part 2

(def test-input "3   4\n4   3\n2   5\n1   3\n3   9\n3   3")

(def parsed-test-input (map numerals->ints
                            (str/split-lines test-input)))

(defn count-distance-2 [pairs]
  (let [col-2-counts (frequencies (map second pairs))]
    (reduce
      (fn [sum x]
        (let [appears (get col-2-counts x 0)]
          (+ sum (* x appears))))
      0
      (map first pairs))))


(count-distance-2 parsed-test-input)

;; Part 2 answer
(count-distance-2 input-pairs)
