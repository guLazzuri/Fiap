# Exemplos de aplicação do laço for
import os
os.system("clear")

# valor inicial, valor final (até um numero antes) e incremento
num = int(input("Numero: "))
for volta in range(num, num * 10 + 1 , num):
    print(f"{volta}", end = " ")

print()

for volta in range(1, 11 , 1):
    tab = num * volta
    print(f"{tab}", end = " ")



# for volta in range(1, 30, 4):
#     print(f"{volta}", end = " ")