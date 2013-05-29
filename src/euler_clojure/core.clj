(ns euler-clojure.core)

;; problem 1
(defn multiples
  "Returns all multiples of given numbers within (range 1 limit)"
  [limit & numbers]
  (filter
   (fn [x] (reduce #(or %1 %2) (map (fn [n] (= (rem x n) 0)) numbers)))
   (range 1 limit)))

(defn sum-of-multiples
  "Returns the sum of all the multiples of a given number"
  [limit & numbers]
  (reduce + (multiples limit numbers)))


(defn fib-seq
  "Generates a lazy sequence of all Fibonacci numbers."
  [a b]
  (cons a (lazy-seq (lazy-seq (fib-seq b (+' a b))))))

(defn sum-of-fib
  [max-value]
  (reduce + (filter even? (take-while #(< % max-value) (fib-seq 1 1)))))
