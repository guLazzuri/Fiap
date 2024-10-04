import math 

def aNulo(a):
    if a == 0:
        print("Esta equação não é do segundo grau, sim do primeiro.")
        return True
    return False

def incompleta(n):
    if n == 0:
        print("Equação do segundo grau INCOMPLETA.")
        return True
    return False

def deltaNegativo(delta):
    if delta < 0:
        print("Não é possível calcular x1 e x2 porque o delta é negativo.")
        return True  
    return False

def deltaIgualaUm(delta):
    if delta == 1:
        print("As raízes x1 e x2 têm o mesmo valor.")

def BCzero(x1, x2, delta):
    print(f"X1: {x1}")
    print(f"X2: {x2}")
    print(f"DELTA: {delta}")
    print("Equação do segundo grau COMPLETA.")

def numeros():
    a = int(input("Qual valor de A: "))
    if aNulo(a):
        return None, None, None, None
    
    b = int(input("Qual valor de B: "))
    if incompleta(b):
        return None, None, None, None
    
    c = int(input("Qual valor de C: "))
    if incompleta(c):
        return None, None, None, None

    delta = (b * b) - (4 * a * c)
    return delta, a, b, c

def deltaPositivo(delta, x1, x2):
    if delta > 0:
        print(f"X1: {x1}")
        print(f"X2: {x2}")
        print(f"DELTA: {delta}")
        print("As raízes x1 e x2 têm valores distintos.")

def raizes(delta, a, b):
    if delta > 0:
        x1 = (-b + math.sqrt(delta)) / (2 * a)
        x2 = (-b - math.sqrt(delta)) / (2 * a)
        return x1, x2
    elif delta == 0:
        x1 = -b / (2 * a)
        return x1, x1  
    else:
        real_parte = -b / (2 * a)
        parte_imaginaria = math.sqrt(-delta) / (2 * a)
        return real_parte, parte_imaginaria

def main():
    delta, a, b, c = numeros()
    if delta is None:
        return  

  
    if deltaNegativo(delta):
        return  

    x1, x2 = raizes(delta, a, b)

    deltaIgualaUm(delta)  


    if delta >= 0:
        BCzero(x1, x2, delta) 
        deltaPositivo(delta, x1, x2)  


if __name__ == "__main__":
    main()
