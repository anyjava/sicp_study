(ns test)
(remove-ns test)

; 17page define square
(defn square [x] (* x x))

(square 2)

; 18page define sum_of_square
(defn sum-of-square [x y]
 	(+ (square x) (square y)))

(sum-of-square 3 4)



; excercise 1.1
10

(+ 5 3 4)
(- 9 1)
(/ 6 2)
(+ (* 2 4) (- 4 6))

(def a 3)

(def b (+ a 1))

(+ a b (* a b))

(= a b)

(if (and (> b a) (< b (* a b)))
 	b
	a)

(cond (= a 4) 6
 	  (= b 4) (+ 6 7 a)
	  :else 25)

(+ 2 (if (> b a) b a))

(* (cond (> a b) a
 		 (< a b) b
		 :else -1)
   (+ a 1))


; excercise 1.2
(/ (+
    (+ 5 4)
    (- 2
       (- 3
          (+ 6
             (/ 4 5)))))
   (* (* 3
         (- 6 2))
      (- 2 7)))


; excercise 1.3
(defn excercise1_3 [x y z]
  (cond (> x y)
        (cond (> y z) (sum-of-square x y)
              :else (sum-of-square x z))
    (> y x)
        (cond (> x z) (sum-of-square y x)
              :else (sum-of-square y z))
    (> z x)
        (cond (> x y) (sum-of-square z x)
              :else (sum-of-square z y))
        ))



(excercise1_3 1 2 3)

(excercise1_3 2 1 3)

(excercise1_3 3 2 1)

1 2 3

(- 3 (+ 2 1))
(- 2 (+ 3 1))
(- 1 (+ 2 1))


; factorial n
(defn factorial [n]
  (if (= n 1)
    1
    (* n (factorial (- n 1)))))

(factorial 6)



; excercise 1.4
(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(a-plus-abs-b 1 -1)

; excercise 1.5
; 무한루프에 빠짐.. 인자 먼저 계산번이라서..
(defn p [] (p))

(defn test  [x y]
  (if (= x 0)
    0
    y))

(test 0 (p))


; 31page 뉴튼법으로 제곱근 찾기
(defn abs [x]
  (if (< x 0)
    (* -1 x)
    x))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn sqrt [x]
  (sqrt-iter 1.0 x))

(sqrt 9)
(sqrt (+ 100 37))
(sqrt (+ (sqrt 2) (sqrt 3)))
(square (sqrt 10000))

(square (sqrt 23205029572))

; count-change
(defn count-change [amount]
  (cc amount 5))



; 연습문제 1.6 - new-if 검증
(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(new-if (= 2 3) 0 5)

(new-if (= 1 1) 0 5)


; 요렇게 작성하면 인자먼저 계산법이 적용되어서 StackOverflowError 가 발생함.
(defn sqrt-iter2 [guess x]
  (new-if (good-enough? guess x)
    guess
    (sqrt-iter2 (improve guess x)
               x)))

(defn sqrt2 [x]
  (sqrt-iter2 1.0 x))

(sqrt2 9)

(/ 1 3)



; 연습문제 1.7
(defn new-good-enough? [guess x old_guess]
  (and (< (abs (- (square guess) x)) 0.001)
    (< (abs (/ guess old_guess)) 0.01)))


(defn new-sqrt-iter [guess x old_guess]
  (if (new-good-enough? guess x old_guess)
    guess
    (new-sqrt-iter (improve guess x)
               x guess)))

(defn new-sqrt [x]
  (new-sqrt-iter 1.0 x 1.0))


(new-sqrt 9)


  ; 연습문제 1.8



(defn even? [n]
  (= (mod n 2) 0))

; Prime Number 소수찾기
(defn smallest-divisor [n]
  (find-divisor n 2))

(defn find-divisor [n test-divisor]
  (cond (> (square test-divisor) n) n
        (divides? test-divisor n) test-divisor
        :else (find-divisor n (+ test-divisor 1))))

(defn divides? [a b]
  (== (mod b a) 0))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn expmod [base exp m]
  (cond (= exp 0 ) 1
        ((even? exp)
         (mod (square (expmod base (/ exp 2) m))
               m))
        :else (* base (expmod base (- exp 1) m))
              m))


(defn fermat-test [n]
  (defn try-it [a]
    (= (expmod a n n) a))
  (try-it (+ 1 (rand-int (- n 1)))))

(defn fast-prime? [n times]
  (cond ((= times 0) true)
        ((fermat-test n) (fast-prime? n (- times 1))
         :else false)))


(smallest-divisor 199)

