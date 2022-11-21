t = ("a",)
print(t)

t = tuple(["a", 3, True])
print(t)

print(t[-1])

if "a" in t:
    print('"a" is in t')

temp = t.count(3)
print(temp)

temp = t.index("a")
print(temp)

t = list(t)
print(t)

t = tuple(t)
print(t)

t1 = t[1:3]
print(t1)

t1 = t[::-1]
print(t1)

a, b, c = t
print(a, b, c)

a, *b = t
print(a, b)
