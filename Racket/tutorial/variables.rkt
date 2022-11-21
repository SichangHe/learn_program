#lang racket

(define pie 3)
(println pie)

;define a function
(define (first3 str)
  (substring str 0 pie))
(println (first3 "abcdef"))

(define (concate/w_side_effect a b)
  (println a) ;side effect #1
  (println b) ;side effect #2
  a ;unused expression
  (string-append a b) ;the expression as output
  )
(define concatenation (concate/w_side_effect "hey" " you"))
(println concatenation)
