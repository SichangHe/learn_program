# make a dictionary: dict(key=value, ...) or {key: value, ...}
a = dict(hen=7)
b = {"pig": 1, "pog": 2, "peg": 3}

# put things into: _[key] = value
a["pig"] = 35
print(a)

# value of certain key: _[key]
print(a["pig"])

# get value of certain key, return something if key do not exist: .get(key, something returned)
print(a.get("pig"), a.get("cow", 0))

# get list from dictionary
print(list(b), b.keys(), b.values(), b.items())

# 2 iteration variables in dictionary.items()
for p, q in b.items():
    print(p, q)

# form dictionary with 2 list: {key: value for key, value in zip(keys, values)}
m = ["ble", "blu", "bla"]
n = ["ar", "lla", "fa", "ga"]
print({key: value for key, value in zip(m, n)})

# sort and get list of key: sorted()
print(sorted(b))

# sort and get list of tuple: sorted(_.items())
print(sorted(b.items()))

# inverse key & value in list of tuple
inv = list()
for x, y in b.items():
    inv.append((y, x))
print(inv)

# count words
fhand = input("the text")  # or open file
counts = {}
for line in fhand:
    words = line.split()
    for word in words:
        counts[word] = counts.get(word, 0) + 1
print(counts)
