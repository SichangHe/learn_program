from collections import Counter

a = "aaaaaabbbbccc"
c = Counter(a)
print(c)
print(c.most_common())
print(c.most_common(1))
print(c.most_common(1)[0])
print(c.most_common(1)[0][0])

print(list(c.elements()))


from collections import namedtuple

P = namedtuple("P", "a,b")
p1 = P(1, 2)
print(p1.a, p1.b)


# from collections import OrderedDict # deprecated

# o=OrderedDict()
# o["a"]=1
# o["b"]=2
# print(o)


from collections import defaultdict

d = defaultdict(int)
d["a"] = 1
print(d["a"])
print(d["b"])  # the default

from collections import deque

d = deque()
d.append(1)
d.append(2)
print(d)
d.appendleft(3)
print(d)
print(d.pop())
print(d)
print(d.popleft())
print(d)
d.extend([4, 5, 6])
print(d)
d.extendleft([7, 8, 9])
print(d)
d.rotate(1)
print(d)
