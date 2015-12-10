; 1 부터 10까지 더하는 예제
; 순수 함수 4개로 풀었음
; SICP 1권 75페이지에 나오는 예제입니다.

(ns test)
(remove-ns 'test)
(ns test)

(defn sum [term a next b]
  (if (> a b)
    0
    (+ (term a) (sum term (next a) next b))))

(defn inc [n] (+ n 1))

(defn identity [x] x)

(defn sum-integers [a b]
  (sum identity a inc b))

(sum-integers 1 10)



; 초간단 버젼 by @ahastudio

(apply + (range 1 11))

(reduce + (range 1 11))
