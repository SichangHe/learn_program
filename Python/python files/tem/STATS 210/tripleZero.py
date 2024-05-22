from random import seed
from random import randint

seed()
total = 0
for i in range(1000):
    a = 1
    b = 1
    c = 1
    count = 0
    while a != 0 or b != 0 or c != 0:
        a = b
        b = c
        c = randint(0, 9)
        count += 1
    print(count)
    total += count

print(total / 1000.0)
