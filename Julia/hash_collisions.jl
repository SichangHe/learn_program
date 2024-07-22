function p_collision(n_possibility, n_trial)
    p = 1.0 # Probability the first element has a certain value
    n_possibility_left = BigFloat(n_possibility)
    for _ = 1:n_trial
        n_possibility_left -= 1
        p_different_than_any_of_prev = n_possibility_left / n_possibility
        p *= p_different_than_any_of_prev
    end
    return 1 - p
end