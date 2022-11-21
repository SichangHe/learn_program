println(1 ≠ 2)
println(1 ≤ 2)
println(NaN == NaN)
println(isequal(NaN, NaN))
println(1 < 2 <= 2 < 3 == 3 > 2 >= 1 == 1 < 3 != 5) # arbitrary comparison chaining

v(x) = (println(x); x)
println(v(1) < v(2) ≤ v(3))
println(v(1) > v(2) ≤ v(3)) # v(3) does not get evaluated because the result is already `false`