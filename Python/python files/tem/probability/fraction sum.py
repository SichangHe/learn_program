#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Apr 12 17:17:49 2021

@author: sichanghe
"""

import numpy as np
from fractions import Fraction
# np.math.factorial(#)
# Fraction(top,bot)
s=0
for x in range(9):
    term=(6-((x-7)**2)**(1/2))*Fraction(np.math.factorial(12),np.math.factorial(x)*np.math.factorial(12-x))
    print(term)
    s=Fraction(s+term)
print(s)
print(Fraction(s,6**2*2**12))
