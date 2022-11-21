# define a function: def
def f(x):
    try:
        f = float(x) + 1
        return f
    except:
        return False
print('f(x)')
r = f(input('what is x?'))
print(r, id(r), type(r))
