(ns reload.core)

; 17page define square
(defn square [x] (* x x))

(square 2)

; 18page define sum_of_square
(defn sum-of-square [x y]
 	(+ (square x) (square y)))

(sum-of-square 3 4)
