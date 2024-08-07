
import os
os.system("clear")
# 2. Dadas duas notas, calcular a média 
# e exibir se está "aprovado" (a partir de 6), "reprovado" 
# (menor do que 4) ou em "exame" (entre 4 e 5.9)
"""
nota1 = float(input("Nota 1: "))
nota2 = float(input("Nota 2: "))
media = (nota1 + nota2) / 2
if media >= 6:
    print(f"Aprovado {media}")
else:
    if media < 4:
        print(f"Reprovado {media}")
    else:
        print(f"Exame {media}")
"""

nota1 = float(input("Nota 1: "))
nota2 = float(input("Nota 2: "))
media = (nota1 + nota2) / 2
if media >= 6:
    print(f"Aprovado {media}")
elif media >= 4 and media < 6:
    print(f"Exame {media}")
else:
    print(f"Reprovado {media}")
    
