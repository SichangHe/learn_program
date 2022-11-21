# make a tuple: (_, ...) or tuple((_, ...))
a = (87, 9, 68)
b = (0,)
print(a, id(a), type(a), a[2], max(a))
print(b)

# use tuple to assign variable: (_, ...) = (_, ...)
(x, y, z) = a
print(x, y, z)

# get list of tuples with .items()
b = {'a': 1, 'b': 2, 'c': 3}
print(b.items())

# compare tuples - one by one
print((0, 1) < (1, -100))
print((0, 1, 1000) < (0, 10, 0))
