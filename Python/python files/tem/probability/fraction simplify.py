import numpy as np
from fractions import Fraction
# np.math.factorial(#)
# Fraction(top,bot)
top=4*np.math.factorial(5)
bot=np.math.factorial(11)
print(top)
print(bot)
print(top/bot)
print(bot/top)
print(Fraction(top,bot))
