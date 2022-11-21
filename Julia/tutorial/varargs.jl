two_or_more(a, b, x...) = a, b, x # `x...` makes `x` treated as a tuple`
println(two_or_more(1, 2))
println(two_or_more(1, 2, 3))
println(two_or_more(1, 2, 3, 4))

# Splat tuple
a_tuple = (1, 2, 3, 4, 5)
println(two_or_more(a_tuple...))

# Splat list
a_list = [2, 4, 5, 6]
println(two_or_more(a_list...))

# Destruct tuple with assignment
first, second, rest... = a_tuple
println(first)
println(second)
println(rest)