import numpy as np

def gaussSeidel(A,b,x0,tol):
    x = np.copy(x0)
    r = b-A@x
    n = x.size
    err = np.linalg.norm(r)
    a = 0


    while err > tol and a < 1000:
        for i,j in enumerate(A):
            x[i] = b[i]
            for k,l in enumerate(j):
                if k != i:
                    x[i] -= l*x[k]
            x[i] /= A[i][i]
            print(x)
        r = b-A@x
        err = np.linalg.norm(r)
        a+=1
    return x

def lagA():
    size = 6,6
    A = np.zeros(size)
    D = [3,-1,0,0,0,-1]

    #lager den diagonale delen av matrisen
    for i,a in enumerate(A[0]): #for alle rader
        for j,b in enumerate(A[1]): #for alle kolonner
            A[i][j] = D[j-i]

    A[0][5] = 1/2
    A[1][4] = 1/2
    A[4][1] = 1/2
    A[5][0] = 1/2

    return A
        
A = lagA()
b = np.array([5/2, 3/2, 1, 1, 3/2, 5/2])

A = A.astype(float)
b = b.astype(float)

print(A)

tol = 1E-3  
x0 = np.zeros(len(b))
#x0 = np.array([1,0,1])
x0 = x0.astype(float)

print(gaussSeidel(A,b,x0,tol))
print(np.linalg.norm(gaussSeidel(A,b,x0,tol)))

def test_GaussSeidel():
    A = np.array([[10, 2, 1], [1, 5, 1], [2, 3, 10]])
    b = np.array([7, -8, 6])
    x = gaussSeidel(A, b)
    assert np.allclose(A @ x, b)
    
    A = np.array([[4, 1], [1, 3]])
    b = np.array([1, 2])
    x = gaussSeidel(A, b)
    assert np.allclose(A @ x, b)
    
    A = np.array([[4, 1, 2], [3, 5, 1], [1, 1, 6]])
    b = np.array([4, 7, 3])
    x = gaussSeidel(A, b)
    assert np.allclose(A @ x, b)
    
    A = np.array([[4, 1], [1, 3]])
    b = np.array([1, 2])
    x = gaussSeidel(A, b, tol=1e-10)
    assert np.allclose(A @ x, b)
    
    A = np.array([[4, 1], [1, 3]])
    b = np.array([1, 2])
    x = gaussSeidel(A, b, max_iter=100)
    assert np.allclose(A @ x, b)

test_GaussSeidel()