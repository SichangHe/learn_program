from random import seed
from random import randint


cpdef double trail(int trails):
    seed()
    cdef int total,a,b,c,count
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

    return (total/float(trails))
