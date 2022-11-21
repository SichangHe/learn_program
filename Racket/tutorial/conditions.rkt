#lang racket

(if #t (println #t) 0)
(if #f 1 (println #f))

(if (> 2 3) (println "2 is greater than 3") (println "2 is smaller or equal to 3"))

(define (reply question)
  (if (and (string? question) (string-prefix? question "Hello ") (string-suffix? question "."))
      "Hi."
      "Huh?"))
(println (reply "Hello Racket."))
(println (reply "*(#@*"))

(define (flowers num)
  (cond
    [(= num 1) "Rose"]
    [(= num 2) "Voilet"]
    [else "Lily"]))
(println (flowers 1))
(println (flowers 3))
