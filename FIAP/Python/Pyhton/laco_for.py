# Fazer um programa que some numeros até que seja digitado zero
import os
os.system("clear")


soma = 0

for volta in range(1, 10, 1):
    num = float(input(f"{volta}.o Numero: "))
    soma += num # soma = soma + num

print(f"Somatória: {soma}")


# volta = 1
# soma = 0

# while volta <= 10:
#     num = float(input(f"{volta}.o Numero: "))
#     soma += num # soma = soma + num
#     volta += 1

# print(f"Somatória: {soma}")



# soma = 0

# while True:
#     num = float(input("Numero ou 0 para finalizar: "))
#     if num == 0:
#         break
#     soma += num # soma = soma + num

# print(f"Somatória: {soma}")