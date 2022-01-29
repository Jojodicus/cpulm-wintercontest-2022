def getsum(list, linelength):
    line = 1
    curline = list[0]
    for j in list[1:]:
        newli = curline + j + 1
        if newli > linelength:
            line += 1
            curline = j
        else:
            curline = newli
    return line + linelength


n = int(input())
essay = input()
essaylen = len(essay)
lenthes = [len(a) for a in essay.split()]
maxlen = max(lenthes)

minsum = essaylen
for i in range(maxlen, essaylen):
    minsum = min(minsum, getsum(lenthes, i))

print(minsum)