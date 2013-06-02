(ns euler-clojure.core)

;; problem 1 - Multiples of 3 and 5
(defn multiples
  "Returns all multiples of given numbers within (range 1 limit)"
  [limit & numbers]
  (filter
   (fn [x] (reduce #(or %1 %2) (map (fn [n] (= (rem x n) 0)) numbers)))
   (range 1 limit)))

(defn sum-of-multiples
  "Returns the sum of all the multiples of a given number"
  [limit & numbers]
  (reduce + (apply multiples limit numbers)))


;; problem 2 - Even Fibonacci numbers
(defn fib-seq
  "Generates a lazy sequence of all Fibonacci numbers."
  [a b]
  (cons a (lazy-seq (fib-seq b (+' a b)))))

(defn sum-of-fib
  [max-value]
  (reduce + (filter even? (take-while #(< % max-value) (fib-seq 1 1)))))


;; problem 3 - Largest prime factor
(defn prime-seq
  "Generates a lazy sequence of all prime numbers."
  [numbers]
  (cons (first numbers)
        (lazy-seq (prime-seq (filter #(not= (mod % (first numbers)) 0) (rest numbers))))))

(defn prime-factors
  "Returns an ordered list of prime factors of n."
  [n]
  (loop [i 2
         n n
         acc '()]
    (if (<= i n)
      (if (zero? (rem n i))
        (recur (inc i) (/ n i) (conj acc i))
        (recur (inc i) n acc))
      acc)))


;; problem 4 - Largest palindrome product
(defn palindrome? [x y]
  (if (= (str (* x y)) (apply str (reverse (str (* x y)))))
    true
    false))

(defn ->x-y [x y]
  (if (= 1 x)
    {:x y :y (dec y)}
    {:x (dec x) :y y}))

(defn palindrome-products [n]
  (loop [x n
         y n
         acc []]
    (if (and (= 1 x) (= 1 y))
      acc
      (if (palindrome? x y)
        (recur (:x (->x-y x y)) (:y (->x-y x y)) (conj acc (* x y)))
        (recur (:x (->x-y x y)) (:y (->x-y x y)) acc)))))

(defn largest-palindrome-product [n]
  (apply max (palindrome-products n)))


;; problem 5 - Smallest multiple
(defn multiple-of-all?
  "Check if n is a multiple of all given numbers"
  [n numbers]
  (loop [n n
         numbers numbers]
    (if (empty? numbers)
      true
      (if (not (zero? (mod n (first numbers))))
        false
        (recur n (rest numbers))))))

(defn smallest-multiple
  [numbers]
  (take 1 (filter #(multiple-of-all? % numbers) (iterate inc 1))))


;; problem 6 - Sum square difference
(defn sum-square-diff
  [limit]
  (Math/abs (- (Math/pow (reduce + (range 1 limit)) 2)
               (reduce + (map #(Math/pow % 2) (range 1 limit))))))


;; problem 7 - 10001st prime
;; credits to Ted Pennings http://stackoverflow.com/a/7941430
(defn prime?
  [n certainty]
      (.isProbablePrime (BigInteger/valueOf n) certainty))

(defn prime-nth
  [nth]
  (last (take (dec nth) ;; we don't consider number 2
              (filter #(prime? % 10)
                (take-nth 2 (iterate inc 1))))))


;; problem 8 - Largest product in a series
(defn ->str-of-numbers [s]
  "Return a number which is the concat of all digits in a string."
  (apply str (re-seq #"[0-9]+" s)))

(defn largest-product-series
  [length s]
  (apply max (map #(apply * %)
        (partition length 1 (map #(Character/getNumericValue %) (->str-of-numbers s))))))


;; problem 10 - Sum of primes
(defn sum-prime
  [limit]
  (reduce + (take-while #(< % limit) (filter #(prime? % 40) (iterate inc 1)))))


;; problem 13 - Large sum
(defn large-sum
  [s]
  (apply + (map #(BigInteger. %) (re-seq #"[0-9]+" s))))

