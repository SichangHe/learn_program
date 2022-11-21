# first import library: import re
import re

# find things in text: re.search('_', _)
print('finding I in the beginning, how, y. in the end')
b4 = open('C:/Users/Administrator/Documents/try.txt')
for e in b4:
    e = e.rstrip()
    f = e.split('. ')
    for g in f:
        if re.search('^I', g):
            print('begin with I:', g)
        if re.search('how', g):
            print('with how:', g)
        if re.search('y.$', g):
            print('end with y.:', g)

# find and get list of things in text: re.findall
print('finding words with a')
b5 = open('C:/Users/Administrator/Documents/try.txt')
c = []
for e in b5:
    f = re.findall('[a-z]*a[a-z]*', e)
    if len(f) > 0:
        c.extend(f)
print(c)
