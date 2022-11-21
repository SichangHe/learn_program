# use [_,_,...,_] to make a list
a = [10, 0.43, 'aa']
print(a, id(a), type(a))

# use list() to make a list
a = list([10, 0.43, 'aa'])
print(a, id(a), type(a))

# get single element in a list: [No.]
print(a[0], a[1], a[2], a[-1], a[-2], a[-3])

# search the No. of a certain element: .index(value, start, stop)
print(a.index(0.43, 1, 3))

# get part of list: [start: stop: step]
print(a[1: 3: 1])

# change element of list
a[2] = -1
print(a)

# range(start, stop, step). first stop, then start, last step
b = range(10)
c = range(1, 10)
d = range(1, 10, 2)
print(list(b), list(c), list(d))

# expand list: .append(element) or .extend(list)
a.append(52)
print(a)
a.extend([0, 97])
print(a)

# add element anywhere: .insert(No., element)
a.insert(1, 908)
print(a)

# remove element: .remove(element)
a.remove(0.43)
print(a)

# remove and get element: .pop(No.)
print(a.pop(), a)

# change order automatically: .sort() or sorted()   increase if None, descend if reverse=True
e = [78, 3, 56]
e.sort()
print(e)
e.sort(reverse=True)
print(e)
print(sorted(e), sorted(e, reverse=True))

# turn string into list: .split(where to split)
f = 'I ate my head'
g = f.split()
print(g)

# form list with function: [f(i) for i in _]
print([i**i for i in range(1,11)])