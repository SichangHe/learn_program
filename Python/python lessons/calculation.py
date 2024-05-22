# divide and get an integer: //
# mod: %
# ^: **
a = b = c = 1
print(a, b, c)
a += 1  # a = a + 1
b -= 1  # b = b - 1

# *=, /=, //=, %=, **=, etc.
print(a, b)

# log function
import numpy

numpy.log(a)

# unpack values
a, b, c = 1, 2, 3
print(a, b, c)

# swap values
a, b = b, a
print(a, b)

# compare values: ==, !=, etc.
print(a == b, a != b)

# compare identities: is or is not
print(a is b, a is not b)

# boolean: and, or, not, in, not in
print(a == b and a != b, a == b or a != b, not a == b)
x, y = "abc", "bc"
print(y in x, y not in x)

# 按位: &, |; 移位: <<, >>
