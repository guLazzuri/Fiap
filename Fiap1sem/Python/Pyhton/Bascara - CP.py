import os
os.system("cls")

# SUB ALGORITIMOS
# Procediento <- NAO retorna valor

# Funcao <- retorna valor
def calcularDelta(aa, bb, cc):
    resp = bb ** 2 - 4 * aa * cc
    return resp

def calcularX1(aa, bb, cc):
    delta = calcularDelta(aa, bb, cc)
    resp = ((-bb + delta ** (1/2)) / (2 * aa))
    return resp

def calcularX2(aa, bb, cc):
    delta = calcularDelta(aa, bb, cc)
    resp = ((-bb - delta ** (1/2)) / (2 * aa))
    return resp

# INICIO
a = float(input("A: "))
b = float(input("B: "))
c = float(input("C: "))

delta = calcularDelta(a, b, c)

if delta < 0:
    print("NAO E POSSIVEL CALCULAR AS RAIZES")
else:
    x1 = calcularX1(a, b, c)
    x2 = calcularX2(a, b, c)
    print(f"""
Delta: {delta}
x1 = {x1}
x2 = {x2} 
""")
