# 3. Dadas 3 notas, calcular a média simples das duas maiores.
import os
os.system("clear")

# nota1 = float(input("Nota 1: ")) # 
# nota2 = float(input("Nota 2: ")) # 
# nota3 = float(input("Nota 3: ")) # 

# if nota1 < nota2 and nota1 < nota3:
#     media = (nota2 + nota3) / 2 
# elif nota2 < nota1 and nota2 < nota3:
#     media = (nota1 + nota3) / 2
# else:
#     media = (nota1 + nota2) / 2

# print(f"A média é {media}")

nota1 = float(input("Nota 1: ")) # 10
nota2 = float(input("Nota 2: ")) # 6
nota3 = float(input("Nota 3: ")) # 5

# Verifica a menor nota
menor = nota1 

if nota2 < menor:
    menor = nota2 # 

if nota3 < menor:
    menor = nota3 # 5

# Calculo da media tirando a menor nota
media = (nota1 + nota2 + nota3 - menor) / 2

print(menor)


#print(f"A média é {media}")