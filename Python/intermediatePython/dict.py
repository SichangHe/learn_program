d = {"key": "val"}
print(d)

d = dict(key="val")
print(d)

temp = d["key"]
print(temp)

d["key"] = "wa"
print(d)

d1 = d.copy()
temp = d1.pop("key")
print(temp)
print(d1)

d1 = d.copy()
del d1["key"]
print(d1)

if "key" in d:
    print(d["key"])

for key in d.keys():
    print(key)

for val in d.values():
    print(val)

for k, v in d.items():
    print(f"{k}: {v}")

d["key1"] = "val1"
d1["key"] = "val"
d.update(d1)
print(d)
