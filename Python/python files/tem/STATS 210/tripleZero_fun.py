from random import seed
from random import randint


def trail(trails):
    seed()
    total = 0
    for i in range(trails):
        a = 1
        b = 1
        c = 1
        count = 0
        while a != 0 or b != 0 or c != 0:
            a = b
            b = c
            c = randint(0, 9)
            count += 1
        total += count

    return total / float(trails)


if __name__ == "__main__":
    from time import time

    start = time()
    r = trail(10_000)
    print(time() - start)
    print(r)
