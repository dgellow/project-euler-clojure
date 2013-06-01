(ns euler-clojure.core-test
  (:require [clojure.test :refer :all]
            [euler-clojure.core :refer :all]))

(deftest sum-of-multiples-test
  (testing "sum of multiple of 3 and 5 below 1000"
    (is (== (sum-of-multiples 1000 3 5) 233168))))

(deftest sum-of-fib-test
  (testing "sum of even fibonacci's numbers below 4mio"
    (is (== (sum-of-fib 4000000) 4613732))))

(deftest prime-factors-test
  (testing "prime factors of 600851475143"
    (is (= (prime-factors 600851475143) '(6857 1471 839 71)))))