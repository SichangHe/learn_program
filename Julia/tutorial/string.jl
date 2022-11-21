# f() = (local s::String;
# println(s))
# f() # error because s is not defined
s = "Hello, world.\n"
println(s)
println("""Contains "quote" characters""")

println(s[begin])
println(s[end])
println(s[1])
println(s[2:4])
println(string("yes", " ", "no"))
println("yes" * " " * "no")
println("$(s)and whatnot")
println(findfirst(isequal('o'), "xylophone"))
println(findlast(isequal('o'), "xylophone"))