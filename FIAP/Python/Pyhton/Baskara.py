import os
os.system("cls")


def CalcularDelta(a, b,c ):
    resp =  b**2 -4*a*c
    return resp


def CalcularX1(a, b,c):
    delta = CalcularDelta(a, b, c)
    resp = ((-b +delta**(1/2)) / (2*a))
    return resp

def CalcularX2(a, b,c):
    delta = CalcularDelta(a, b, c)
    resp = ((-b -delta**(1/2)) / (2*a))
    return resp


# INICIO
i= 1
while i < 3:
    n1 =  float(input("Primeiro :"))
    n2 =  float(input("Segunda :"))
    n3 =  float(input("Terceiro :"))

    delta = CalcularDelta(n1, n2,n3 )

    if delta < 0:
        print("NAO E POSSIVEL CALCULAR AS RAIZES")
    else:
        x1 = CalcularX1(n1, n2, n3)
        x2 = CalcularX2(n1, n2, n3)
        print(f"""
Delta: {delta}
x1 = {x1}
x2 = {x2} 
""")
        i += 1