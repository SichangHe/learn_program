from setuptools import setup
from Cython.Build import cythonize

setup(
    name="tripleZero function mod1",
    ext_modules=cythonize("tripleZero_fun_mod1.pyx"),
    zip_safe=False,
)
