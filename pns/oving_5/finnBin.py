


def finnBin(tall, bits = 64):
    if "." in str(tall):
        f,e = str(tall).split(".")

        return finnInt(f, bits) + "." +  finnFloat(e, bits)

    return 0


def finnInt(t, bits):
    tall = int(t)
    if tall == 0:
        return ""
    
    res = ""

    for i in range(bits,-1,-1):
        if tall - 2**i >= 0:
            res += "1"
            tall -= 2**i
        else:
            if res != "":
                res += "0"
    return res
    

def finnFloat(t, bits):
    t = "0." + t
    tall = float(t)

    if tall == 0:
        return ""
    
    res = ""
    tiln = 0
    c = 1/2

    for i in range(bits):
        if tiln + c <= tall:
            res += "1"
            tiln += c
        else:
            res += "0"
        c /= 2
    return res

print(finnBin(-43.0))
