n_blue = 3
n_green = 4
n_red = 9
n_ball = 16
n_trail = 0xFFFF
function put_balls_into_urns()
    urns = [Dict("b" => 0, "g" => 0, "r" => 0), Dict("b" => 0, "g" => 0, "r" => 0), Dict("b" => 0, "g" => 0, "r" => 0)]
    for _ in 1:n_blue
        urn_index = rand(1:3)
        urns[urn_index]["b"] = urns[urn_index]["b"] + 1
    end
    for _ in 1:n_green
        urn_index = rand(1:3)
        urns[urn_index]["g"] = urns[urn_index]["g"] + 1
    end
    for _ in 1:n_red
        urn_index = rand(1:3)
        urns[urn_index]["r"] = urns[urn_index]["r"] + 1
    end
    return urns
end
count_no_urn_empty = 0
count_each_urn_three_red = 0
count_each_urn_all_color = 0
for _ in 1:n_trail
    global count_no_urn_empty, count_each_urn_three_red, count_each_urn_all_color
    urns = put_balls_into_urns()

    no_urn_empty = true
    each_urn_three_red = true
    each_urn_all_color = true
    for urn in urns
        if urn["b"] == 0 && urn["g"] == 0 && urn["r"] == 0
            no_urn_empty = false
        end
        if urn["r"] != 3
            each_urn_three_red = false
        end
        if urn["b"] == 0 || urn["g"] == 0 || urn["r"] == 0
            each_urn_all_color = false
        end
    end
    if no_urn_empty
        count_no_urn_empty += 1
    end
    if each_urn_three_red
        count_each_urn_three_red += 1
    end
    if each_urn_all_color
        count_each_urn_all_color += 1
    end
end

rate_no_urn_empty = count_no_urn_empty / n_trail
rate_each_urn_three_red = count_each_urn_three_red / n_trail
rate_each_urn_all_color = count_each_urn_all_color / n_trail

println("No urn empty: $rate_no_urn_empty.")
println("Each urn 3 red: $rate_each_urn_three_red.")
println("Each urn all color: $rate_each_urn_all_color.")