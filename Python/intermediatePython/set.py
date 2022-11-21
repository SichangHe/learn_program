s = {2, 5, 1, 2}
print(s)

s = set("laeaef")
print(s)

s.add("k")
print(s)

s.remove("a")
print(s)

s.discard("a")

temp = s.pop()
print(temp)
print(s)

for i in s:
    print(i)

if "e" in s:
    print('"e" is in s')

s1 = {"p", "e"}
temp = s.union(s1)
print(temp)

temp = s.intersection(s1)
print(temp)

temp = s.difference(s1)
print(temp)

temp = s.symmetric_difference(s1)
print(temp)

s2 = s.copy()
s2.update(s1)
print(s2)

s2 = s.copy()
s2.intersection_update(s1)
print(s2)

s2 = s.copy()
s2.difference_update(s1)
print(s2)

temp = s.issubset(s1)
print(temp)

temp = s.issuperset(s1)
print(temp)

temp = s.isdisjoint(s1)
print(temp)

s = frozenset((2, 4, 1))
print(s)
