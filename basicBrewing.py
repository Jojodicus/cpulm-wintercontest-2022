



n, p = input().split()

root = float(0)
for i in range(int(n)):
    liter, perc = input().split()
    root += (float(perc)/100) * int(liter)

print(int(root / float(p)))
