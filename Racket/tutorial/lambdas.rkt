#lang racket

; The paranthesis around the args is nessary
(define times_two (lambda (x) (* x 2)))
(println (times_two 3))

; This args are evaluated as list if no paranthesis
(define takes_list (lambda x (println x)))
(takes_list 1)
(takes_list 1 2 3)

; Returning lambda is fine
(define (times_n n)
  (lambda (x) (* n x)))
(println ((times_n 3) 8)) ; The `n` here is remembered by the lambda
