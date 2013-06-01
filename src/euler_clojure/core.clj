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
  (cons a (lazy-seq (lazy-seq (fib-seq b (+' a b))))))

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
