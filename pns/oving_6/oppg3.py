import numpy as np

# Definer funksjonen f(x)
def f(x):
    y = x**5 - 12*x
    return y

# Lag en ny funksjon for å derivere f(x) i punkt(ene) x med senterdifferanse
def centerDiff(f, x, h):
    f_diff = (f(x + h/2) - f(x - h/2))/h 
    return f_diff


x = np.linspace(-5, 5, 101)
h = 0.01
for i in range(len(x)-1):
    if centerDiff(f, x[i], h)*centerDiff(f, x[i+1], h) <= 0 and centerDiff(f, x[i], h) > 0:
        print(f"Mellom {x[i]} og {x[i+1]}")