from math import sqrt
from math import sin
from math import radians

def aoctagon(n):
    return 2 * (1 + sqrt(2)) * n * n

def findbase(area, x):
    x2 = x * x
    x4 = x2 * x2

    if 4 * area * area > x4:
        return 2 * sin(radians(22.5)) * x

    disc = sqrt(x4 - 4 * area * area)
    twostwo = 2 * sqrt(2)

    return min(twostwo * area / sqrt(x2 - disc) , twostwo * area / sqrt(x2 + disc))

a, x = input().split()
a, x = float(a), float(x)

aperside = a / 8

candis = findbase(aperside, x)

print(aoctagon(candis))