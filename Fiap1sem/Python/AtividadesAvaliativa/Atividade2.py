def tiver_letra(s: str) -> bool:
    letras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    for n in s:
        if n in letras:
            return True
    return False

def mais(numero: str) -> bool:
    caractere_especifico = "+"
    return numero.startswith(caractere_especifico)
    
def menos(numero: str) -> bool:
    caractere_especifico = "-"
    return numero.startswith(caractere_especifico)

def numero(numero: str) -> bool:
    caracteres_numericos = "1234567890"
    if numero in caracteres_numericos:
        return True
    return False

def x_isdigit(n : str) -> bool:
    return (numero(n) or menos(n) or mais(n)) and not tiver_letra(n)

x = "+123"
print(x_isdigit(x))
x = "1A23"
print(x_isdigit(x))
x = "-1A3"
print(x_isdigit(x))
x = "-453"
print(x_isdigit(x))
