import numpy as np


def f(x):
    return np.sqrt(1+(64*(x**2)))

def trapes(f, a, b, n):
    h = (b-a)/n
    s = 0
    for i in range(1,n):
        s += f(a + i*h)
    return h/2*(f(a) + 2*s + f(b))


print(trapes(f,-1/2,2,100))