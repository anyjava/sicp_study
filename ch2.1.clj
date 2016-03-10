; clojure 에서는 cons 에 1:1 매칭은 되지 않는다.
(def x (vector 1 2))

(first x)

(second x)


(def y (vector 3 4))

(def z (vector x y))

(first (first z))

(first (second z))



(defn make-rat [n d] (vector n d))

(defn number [x] (first x))

(defn denom [x] (second x))


(defn print-rat [x]
  (newline)
  (print (number x))
  (print "/")
  (print (denom x)))


(print-rat (make-rat 1 3))



