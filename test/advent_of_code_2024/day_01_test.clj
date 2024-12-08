(ns advent-of-code-2024.day-01-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2024.day-01 :refer :all]))



(deftest test-numerals->ints
  (testing "Parsing numerals into integers"
    (is (= (numerals->ints "3 4") [3 4]))
    (is (= (numerals->ints "1 2 3") [1 2 3]))
    (is (= (numerals->ints "  ") []))
    (is (= (numerals->ints "0 10") [0 10]))))


(deftest test-sort-cols
  (testing "Sorting columns from pairs"
    (is (= (sort-cols [[3 4] [4 3] [2 5]])
           {2 3, 3 4, 4 5}))
    (is (= (sort-cols [[1 10] [3 8] [2 9]])
           {1 8, 2 9, 3 10}))
    (is (= (sort-cols [[5 5]]) {5 5}))
    (is (= (sort-cols []) {}))))


(deftest test-count-distance-2
  (testing "Counting weighted distances between columns"
    (is (= (count-distance-2 [[3 4] [4 3] [2 5] [1 3] [3 9] [3 3]]) 31))
    (is (= (count-distance-2 [[1 1] [2 2] [3 3]]) 6))
    (is (= (count-distance-2 [[1 1]]) 1))
    (is (= (count-distance-2 []) 0))))



