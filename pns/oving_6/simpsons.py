import numpy as np

def f(x):
    return (2+(x**2))



def simpsons(f,a,b,n):
    if(n%2 != 0):
        print("n må være et partall")
        return
    dx = (b-a)/n

    s = f(a) + f(b)

    for i in range(1,n):
        if(i%2 == 0):
            s += 2*f(a + i*dx)
        else:
            s += 4*f(a + i*dx)

    return (dx/3)*s


print(simpsons(f,0,1,2))


