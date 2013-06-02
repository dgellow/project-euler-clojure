(ns euler-clojure.core-test
  (:require [clojure.test :refer :all]
            [euler-clojure.core :refer :all]))

;; problem 1
(deftest sum-of-multiples-test-1
  (testing "sum of multiple of 3 and 5 below 1000"
    (is (== (sum-of-multiples 1000 3 5) 233168))))

;; problem 2
(deftest sum-of-fib-test-1
  (testing "sum of even fibonacci's numbers below 4mio"
    (is (== (sum-of-fib 4000000) 4613732))))

;; problem 3
(deftest prime-factors-test-1
  (testing "prime factors of 600851475143"
    (is (= (prime-factors 600851475143) '(6857 1471 839 71)))))

;; problem 4
(deftest palindrome-product-test-1
  (testing "largest palindrome factor of two 2-digit numbers"
    (is (= (largest-palindrome-product 99) 9009))))

(deftest palindrome-product-test-2
  (testing "largest palindrome factor of two 3-digit numbers"
    (is (= (largest-palindrome-product 999) 906609))))

;; problem 5
(deftest smallest-multiple-test-1
  (testing "list of smallest numbers that can be divided by numbers from [1 to 18[ w/o reminder."
    (is (= (map #(smallest-multiple (range 1 %)) (range 1 18))
           '((1) (1) (2) (6) (12) (60) (60) (420) (840) (2520) (2520)
             (27720) (27720) (360360) (360360) (360360) (720720))))))

;; problem 6
(deftest sum-square-diff-test-1
  (testing "difference 1^2 + 2^2 + ... + 10^2 = 385 and (1 + 2 + ... + 10)^2 = 55^2 = 3025"
    (is (== (sum-square-diff 11) 2640))))

(deftest sum-square-diff-test-2
  (testing "difference 1^2 + 2^2 + ... + 100^2 and (1 + 2 + ... + 100)^2"
    (is (== (sum-square-diff 101) 25164150))))


;; problem 7
(deftest prime-nth-test-1
  (testing "10001st prime number"
    (is (== (prime-nth 10001) 104743))))


;; problem 10
(deftest sum-prime-test-1
  (testing "sum of all the primes below ten."
    (is (== (sum-prime 10) 17))))

(deftest sum-prime-test-2
  (testing "sum of all the primes below two million."
    (is (== (sum-prime 2000000) 142913828922))))