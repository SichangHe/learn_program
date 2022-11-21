x = setrounding(BigFloat, RoundUp) do
    BigFloat(1) + parse(BigFloat, "0.1")
end
println(x)


y = setrounding(BigFloat, RoundDown) do
    BigFloat(1) + parse(BigFloat, "0.1")
end
println(y)

z = setprecision(40) do
    BigFloat(1) + parse(BigFloat, "0.1")
end
println(z)
