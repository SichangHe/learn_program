s = "He's dead"
print(s)

s = '"s" is good'
print(s)

s = """both "" and ''"""
print(s)

s1 = s[0]
print(s1)

# s[0]='p' # string immutable

s1 = s[2:]
print(s1)

for s1 in s:
    print(s1)

if "bo" in s:
    print('"bo" is in s')

s1 = s.startswith("both")
print(s1)

s1 = s.endswith("a")
print(s1)

s1 = "   ege  "
s1 = s1.strip()
print(s1)

s1 = s1.upper()
print(s1)

s1 = s1.lower()
print(s1)

s1 = s.find(" ")
print(s1)

s1 = s.count(" ")
print(s1)

s = s.replace("and", "or")
print(s)

s1 = s.split()
print(s1)

s1 = s.split("o")
print(s1)

s1 = "0".join(s1)
print(s1)

# old ways
s1 = "s is %s" % s
print(s1)
s1 = "s is {}".format(s)
print(s1)

s1 = f"s is {s}"
print(s1)
