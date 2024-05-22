# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

x1 = float(input("x1 = "))
y1 = float(input("y1 = "))
x2 = float(input("x2 = "))
y2 = float(input("y2 = "))
x3 = float(input("x3 = "))
y3 = float(input("y3 = "))
x4 = float(input("x4 = "))
y4 = float(input("y4 = "))
k1 = (y1 - y2) / (x1 - x2)
k2 = (y3 - y4) / (x3 - x4)
b1 = y2 - k1 * x2
b2 = y4 - k2 * x4
x = (b2 - b1) / (k1 - k2)
y = k1 * x + b1
print("x: ", x, "y: ", y)
