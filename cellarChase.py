import ast

def add(a, b):
    return a + b

ops = {ast.Add: max, ast.Mult: add}

def ev(node):
    if isinstance(node, ast.Num):
        return node.n
    return int(ops[type(node.op)](ev(node.left), ev(node.right)))


dungeons = input().replace("()", "1")
if dungeons == "":
    print(0)
else:
    print(ev(ast.parse(dungeons, mode='eval').body))