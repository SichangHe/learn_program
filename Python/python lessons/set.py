# make set: {_, ...} or set(_)
a = {'efe', 'ioi', 'kk'}  # no repeating
print(a, type(a))
print(set(range(0, 5)), set((34, 4, 5, 5)), set([86, 8, 4]), set('bbbls'))

# get empty set: set()
b = set()
print(b)

# add element: .add(_) or .update(set/list/tuple)
b.add(8)
print(b)
b.update((9, 5, 8))
print(b)

# delete element: .remove(_) or .discard(_)
b.remove(8)  # error if not exit
print(b)
b.discard(10)  # ok if not exit
print(b)

# delete and get a random element: .pop()
print(b.pop(), b)

# decide whether subset/superset or not: .issubset(_) or .issuperset(_)
print(a.issubset(b), {'efe'}.issubset(a), a.issuperset(b), a.issuperset({'efe'}))

# no intersection: .isdisjoint(_)
print(a.isdisjoint(b))

# intersection: .intersection(_) or _&_
c = {'o', 'ioi'}
print(a.intersection(c), a & c)

# union: .union(_)
print(a.union(c))

# symmetric difference: .symmetric_difference(_)
print(a.symmetric_difference(c))
