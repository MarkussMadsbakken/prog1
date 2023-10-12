import numpy as np

#def f(x,y): #oppgave 1-3
#    return (y**2)*np.sin(x)

#def f(x, y): #oppgave 4-6
#    return x+np.sqrt(y)

def f(x, y): #oppgave 7-8
    return 2*x*y

def euler(h):
    x0 = 1
    y0 = 1
    stopp = 1.5

    while x0 < stopp: 
        y0 = y0 + (h*f(x0, y0))
        x0 = x0 + h
    return round(y0, 5)

def eulerForbedret(n, h, x0, y0):
    for i in range(n):
        xn1 = x0 + h
        ypred = y0 + (h*f(x0, y0))
        y0 = y0 + (h*((f(x0, y0) + f(xn1, ypred))/2))
        
        x0 = xn1
    return round(y0, 5)

print(euler(0.1))
print(eulerForbedret(5, 0.1, 1, 1))