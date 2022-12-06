function has_appear_thrice(arr)
    d = Dict()
    for a in arr
        d[a] = get(d, a, 0) + 1
    end
    for v in values(d)
        if v ≥ 3
            return true
        end
    end
    return false
end
num = 0xFFFF
count = 0
for i in 1:num
    global count
    if has_appear_thrice(rand(1:9, 5))
        count += 1
    end
end
println(1 - count / num)