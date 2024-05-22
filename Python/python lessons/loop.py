# use while
# while _ :
#     _
i = 0
while i < 3:
    print(i)
    i += 1
print("-------------------------------------------")
# use for
# for _ in _:
#     _
for a in "space":
    print(a)
print("--------------------------------------------")
i = 0
for a in range(3):
    print(i)
    i += 1
# stop circle: break
print("--------------------------------------------")
i = 0
for a in range(8):
    print(i)
    if i > 2:
        break
    i += 1
# go back to the beginning of circle: continue
print("--------------------------------------------")
i = 0
for a in range(6):
    print(i)
    if i > 2:
        continue
    i += 1
