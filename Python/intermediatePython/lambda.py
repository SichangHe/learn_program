inc = lambda x: x + 1
print(inc(1))

mul = lambda x, y: x * y
print(mul(1, 2))

l = [(1, 2), (23, 75), (90, 1)]
l1 = sorted(l)
print(l1)

l1 = sorted(l, key=lambda x: x[1])
print(l1)

l1 = sorted(l, key=lambda x: x[0] + x[1])
print(l1)
