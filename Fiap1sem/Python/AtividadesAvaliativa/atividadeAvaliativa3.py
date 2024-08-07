import os
os.system("cls")

def isfloat(s: str) -> bool:
    digito = "0123456789."
    valido = True
    if s[0] == "-" or s[0] == "+" or s[0] == "." or s[0] in digito:
        for i in range(1, len(s)):
            if s[i] in digito:
                valido = True
                break
    else:
        valido = False
    
    if s.count(".") > 1:
        valido = False


    return valido
    

print(isfloat("Edson"))
print(isfloat("45.78"))
print(isfloat("78"))
print(isfloat("234."))
print(isfloat("234,67"))
print(isfloat("12.567.34"))
print(isfloat("-12.5"))