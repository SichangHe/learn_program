# open/create a file: open('file address', 'mode')
#    mode: read: 'r' or write: 'w' or add: 'a+'
a = open('C:/Users/Administrator/Documents/try.txt', 'a+')
print(a)
# read texts: for _ in _:
#     print(_)
b = open('C:/Users/Administrator/Documents/try.txt')
for e in b:
    print(e)
# cancel all the extra new lines
b1 = open('C:/Users/Administrator/Documents/try.txt')
for e in b1:
    e = e.rstrip()
    print(e)
# count lines in a text
count = 0
b2 = open('C:/Users/Administrator/Documents/try.txt')
for e in b2:
    count += 1
print(count, 'lines')
# read whole file as one string
b3 = open('C:/Users/Administrator/Documents/try.txt')
c = b3.read()
print(c)
# find lines in a text
print('finding I in the beginning, h in the middle')
b4 = open('C:/Users/Administrator/Documents/try.txt')
for e in b4:
    e = e.rstrip()
    f = e.split('. ')
    for g in f:
        if g.startswith('I'):
            print(g)
        if g.find('h') >= 0:
            print(g.find('h'), g)
# and print texts inside: print(texts, file=_)
print('Just try.', file=a)
