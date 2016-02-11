(ns test)
(remove-ns test)

(defn abs [x]
  (if (< x 0)
    (* -1 x)
    x))

(defn average [x y]
  (/ (+ x y) 2))

(defn close-enough? [x y]
  (< (abs (- x y)) 0.001))

(defn positive? [x]
  (> x 0))

(defn negative? [x]
  (< x 0))


; 이분법으로 방정식의 근을 찾기
(defn search [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond
          (positive? test-value) (search f neg-point midpoint)
          (negative? test-value) (search f midpoint pos-point)
          :else midpoint)))))

(defn half-interval-method [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond
      (and (negative? a-value) (positive? b-value)) (search f a b)
      (and (negative? b-value) (positive? a-value)) (search f b a)
      :else (println "Values are not of opposite sign" a b))))

(half-interval-method (fn [x] (- (* x x x) (* 2 x) 3))
                      1.0
                      2.0)



; 함수의 고정점 찾기
(def tolerance 0.00001)

(defn fixed-point [f first-quess]
  (defn close-enough? [v1 v2]
    (< (abs (- v1 v2)) tolerance))
  (defn try [guess]
    (let [next (f guess)]
         (if (close-enough? guess next)
           next
           (try next))))
  (try first-quess))

(defn sqrt [x]
  (fixed-point (fn [y] (average y (/ x y)))
               1.0))

(sqrt 4)

