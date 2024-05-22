# create a variable
import os
import pathlib

a = 20
b = 1.1
c = 1 < 2
d = "bla"
# identity
print("id: ", id(a), id(b), id(c), id(d))
# type (int, float, bool, str)
print("type: ", type(a), type(b), type(c), type(d))
# int: integer
"""二进制 0b, 八进制 0o, 十六进制 0x"""
# float: float decimal number, with uncertainty
# bool: boolean. True (1, when doing calculations) or False (0)
# str: string, anything else. With '' or "", use '''''' or """""" to include things over multiple lines.
#    Take one letter out from string: _[No.].
#    Length of string: len.
#    Get part of string: [start:stop]. Start/stop reach the end if blank.
#    find part of the string: .find(part)
#    search and replace: .replace(old, new)
#    strip whitespace: lstrip(), rstrip(), strip()
print(d[1], len(d), d[1:3], d.find("bl"), d.replace("l", "r"))
# change the type: use int() or float() or str()
# value
print(a, b, c, d)
