p = println # assign function to variable
fib(n::Integer) = n ≤ 2 ? one(n) : fib(n - 1) + fib(n - 2) # assignment form function declaration
fib(n::Number) = (((1 + √5) / 2)^n - ((1 - √5 + 0im) / 2)^n) / (√5) # No conflict because of dispatch
p(fib(10))
p(fib(2.7))
# Traditional syntax
function hypot(x::Number, y::Number)
    x = abs(x)
    y = abs(y)
    if x > y
        r = y / x
        return x * √(1 + r * r)
    end
    if y == 0
        return zero(x)
    end
    r = x / y
    y * √(1 + r * r)
end
p(hypot(3, 4))
p(+(1, 5, 2)) # operators are functions
quad = n::Number -> n * 4 # anonymous function short syntax
p(quad(3))
# Anonymous function short syntax with multiple expressions
hypot2 = (x::Number, y::Number) -> (
    x = abs(x);
    y = abs(y);
    if x > y
        r = y / x
        return x * √(1 + r * r)
    end;
    if y == 0
        return zero(x)
    end;
    r = x / y;
    y * √(1 + r * r))
p(hypot2(3, 4))