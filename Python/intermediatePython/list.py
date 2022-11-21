l = ["b", 4, True, 4]
print(l)

if "b" in l:
    print('"b" is in l')

if 0 not in l:
    print("0 is not in l")

l.append("a")
print(l)

l.insert(1, 1)
print(l)

print(l.pop())
print(l)

l.remove(4)
print(l)

l.reverse()
print(l)


l = [1, 5, 3, 7]
print(l)
l.sort()
print(l)

l = [1, 5, 3, 7]
print(l)
l1 = sorted(l)
print(l)  # unsorted
print(l1)

l = [i * i for i in l]
print(l)

l1 = l1[1:4]
print(l1)

l1 = l1[1:]
print(l1)

l1 = l1[:]
print(l1)

l = [3, 5, 1, 6, 7, 2]
print(l)
l2 = l[::2]
print(l2)
l2 = l[::-1]
print(l2)

l = [0] * 5
print(l)

l1 = l + l1
print(l1)
