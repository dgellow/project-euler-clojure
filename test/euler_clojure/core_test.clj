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


;; problem 8
(deftest largest-product-series-test-1
  (testing "largest product of five digits in a 1000-digit number"
    (is (== (largest-product-series
             5
             "73167176531330624919225119674426574742355349194934
             96983520312774506326239578318016984801869478851843
             85861560789112949495459501737958331952853208805511
             12540698747158523863050715693290963295227443043557
             66896648950445244523161731856403098711121722383113
             62229893423380308135336276614282806444486645238749
             30358907296290491560440772390713810515859307960866
             70172427121883998797908792274921901699720888093776
             65727333001053367881220235421809751254540594752243
             52584907711670556013604839586446706324415722155397
             53697817977846174064955149290862569321978468622482
             83972241375657056057490261407972968652414535100474
             82166370484403199890008895243450658541227588666881
             16427171479924442928230863465674813919123162824586
             17866458359124566529476545682848912883142607690042
             24219022671055626321111109370544217506941658960408
             07198403850962455444362981230987879927244284909188
             84580156166097919133875499200524063689912560717606
             05886116467109405077541002256983155200055935729725
             71636269561882670428252483600823257530420752963450")

            40824))))


;; problem 10
(deftest sum-prime-test-1
  (testing "sum of all the primes below ten."
    (is (== (sum-prime 10) 17))))

(deftest sum-prime-test-2
  (testing "sum of all the primes below two million."
    (is (== (sum-prime 2000000) 142913828922))))