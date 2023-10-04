

def f(x):
    return x**3-9


def halvering(funk, r, tol = 1E-10):
    a,b = r
    c = (a+b)/2
    i = 0

    while abs(funk(c)) > tol:
        if funk(a)*funk(c) < 0:
            b = c
        else:
            a = c
        c = (a+b)/2
        i += 1
        print(c)
    return c,i


r = 1.5,2.5

print(halvering(f,r))


