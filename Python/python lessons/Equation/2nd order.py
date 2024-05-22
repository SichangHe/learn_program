print("write the equation like ax^2+bx+c=0")
while True:
    try:
        a = float(input("a = "))
        break
    except:
        print("please put in numbers!")  # get a
while True:
    try:
        b = float(input("b = "))
        break
    except:
        print("please put in numbers!")  # get b
while True:
    try:
        c = float(input("c = "))
        break
    except:
        print("please put in numbers!")  # get c
delta = b**2 - 4 * a * c
print("delta =", delta)
if delta < 0:
    print("no solution")
elif delta == 0:
    x = (-b) / (2 * a)
    print("x1 = x2 =", x)
else:
    x1 = (-b - delta**0.5) / (2 * a)
    x2 = (-b + delta**0.5) / (2 * a)
    print("x1 =", x1)
    print("x2 =", x2)
