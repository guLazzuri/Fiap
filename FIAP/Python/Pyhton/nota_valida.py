# 1. Dada uma nota, exibir se ela é "válida" ou "inválida".
"""
import os
os.system("clear")

nota = float(input("Nota: "))
if nota >= 0 and nota <= 10:
    print(f"A nota '{nota}' é válida")
else:
    print(f"A nota '{nota}' é inválida")
"""
import os
os.system("clear")

nota = float(input("Nota: ")) # -67
if nota >= 0:
    # verdade do primeiro IF
    if nota <= 10:
        # verdade do segundo if
        print(f"A nota '{nota}' é válida")
    else:
        # falso do segundo if
        print(f"A nota '{nota}' é inválida")
else:
    # falso do primeiro if
    print(f"A nota '{nota}' é inválida")

