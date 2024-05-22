from random import seed
from random import randint
from sys import argv

"""
generate random number between 0~9 until getting three successive "0"s
return the number of numbers generated
"""

# take a command line argument to decide how many trials
trails = int(argv[1])
seed()

count = 0  # initialize `count`
for trial in range(trails):
    no_skip1 = True
    while no_skip1:
        # no "0"
        count += 1
        if randint(0, 9) == 0:
            # got a new "0", need two more
            while True:
                count += 1
                if randint(0, 9) == 0:
                    # got another new "0", need one more
                    count += 1
                    if randint(0, 9) == 0:
                        # got three "0", next trial
                        no_skip1 = False
                        # break
                    # else break to start from scratch
                # else break to start from scratch
                # therefor break anyways
                break


print(float(count) / trails)
