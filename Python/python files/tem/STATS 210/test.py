# import numpy
# from fractions import Fraction
# import random
# import os
# import thread6
# import time
# from queue import LifoQueue
# import _thread
# import threading
# import re
import tripleZero_fun
import tripleZero_fun_vanilla
import tripleZero_fun_mod
import tripleZero_fun_mod1
from time import time

print("testing python")
start = time()
a = tripleZero_fun.trail(100_000)
print(time()-start)
print(a)
print()

print("testing vanilla")
start = time()
a = tripleZero_fun_vanilla.trail(100_000)
print(time()-start)
print(a)
print()

print("testing mod")
start = time()
a = tripleZero_fun_mod.trail(100_000)
print(time()-start)
print(a)
print()

print("testing mod1")
start = time()
a = tripleZero_fun_mod1.trail(100_000)
print(time()-start)
print(a)
print()


# new = open('/Users/sichanghe/Desktop/STATS 210/presentation/new.txt', 'a')
# new.write('blah')

# matrix = [[0]*(5+1) for i in range(5)]
# temp = [1]*5
# temp.append(0)
# matrix.append(temp)
# print(matrix)

# matrix[0][0] = 1
# print(matrix)

# b = [0]*(5)
# b.append(1)
# B = numpy.array(b)
# print(B)  # debug
# a = '1/9'
# print(Fraction(a), type(a))

# l = [[] for i in range(5)]
# l[1].append(1)
# l[2].append(2)
# print(l, l[1])

# for i in range(5):
#     print(random.random())

# arrival = [0 for i in range(2)]
# arrival.append(Fraction(3, 4))
# arrival.append(Fraction(4, 4))
# arrival.append(Fraction(1, 4))
# arrival.append(Fraction(7, 4))
# print(arrival[5], type(arrival[5]))

# os.remove("/Users/sichanghe/Documents/Python/python files/tem/STATS 210/feg.eg")


# def f(a):
#     for i in range(100):
#         print(a, random.random())


# # time.sleep(2)
# q = LifoQueue()
# for i in range(64):
#     q.put(i)
# for i in range(64):
#     thread6.run_threaded(f, q.get())

# s = time.time()
# b = []
# for i in range(64):
#     x = tuple([i])
#     _thread.start_new_thread(f, x)

# while True:
#     if threading.active_count() == 0:
#         break
#     print(threading.active_count())
#     time.sleep(0.1)
# print(time.time() - s)


# s = time.time()
# for i in range(64):
#     f(i)
# print(time.time() - s)

# child = "https://dukekunshan.edu.cn/en/event-list/2021-09-27"
# blacklist_filter = ["about/about", "https://dukekunshan.edu.cn/zh/event/", "https://dukekunshan.edu.cn/en/event/", "/event-list",
#                     "career-services/event/", "/node", "node_tid",  ".pdf", ".docx"]
# for filter in blacklist_filter:
#     if child.__contains__(filter):  # filtered
#         print(filter)
#         break
