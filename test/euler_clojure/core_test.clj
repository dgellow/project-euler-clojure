(ns euler-clojure.core-test
  (:require [clojure.test :refer :all]
            [euler-clojure.core :refer :all]))

(deftest sumsofsmultiples-test
  (testing "sum of multiple of 3 and 5 below 1000"
    (is (== (sumofmultiple-test 1000 3 5) 233168))))

(deftest sum-of-fib-test
  (testing "sum of even fibonacci's numbers below 4mio"
    (is (== (sum-of-fib 4000000) 4613732))))