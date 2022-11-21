from itertools import product

a = [1, 2]
b = [3, 4]
p = product(a, b)
print(list(p))

p = product(a, b, repeat=2)
print(list(p))


from itertools import permutations

p = permutations(a)
print(list(p))

p = permutations(a, 1)
print(list(p))


from itertools import combinations

c = combinations(a, 2)
print(list(c))


from itertools import combinations_with_replacement

c = combinations_with_replacement(a, 2)
print(list(c))


from itertools import accumulate

c = accumulate(a)
print(list(c))

c = accumulate(a, func=lambda x, y: x - y)
print(list(c))

from itertools import groupby

g = groupby(a, key=lambda x: x > 1)
for k, v in g:
    print(f"{k}: {list(v)}")


from itertools import count

for i in count(3):
    print(i)

# from itertools import cycle

# for i in cycle([1, 2, 3]):
#     print(i) # will run forever

from itertools import repeat

for i in repeat(1, 3):
    print(i)
