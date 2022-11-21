# use if
# if _ :
#     _
# elif _ :
#     _
# else:
#     _
a = input('type 1')
if a == 1:
    print('yes')
else:
    print('no')

# shorter version:
print('yes' if a == 1 else 'no')

# hold the place: pass
pass

# deal with error: try, except (when there's error running 'try')
# try:
#     _
# except:
#     _
try:
    gg = int('gg')
except:
    gg = 'gg'
print(type(gg))
