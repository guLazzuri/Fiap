import os 
os.system("cls")

i = 1
print("digite: ")
num = int(input())
maior = num


while  i < 3:
    
    num = int(input())
    if num > maior:
        maior = num 
    
    i = i + 1

print(f"Maior = {maior}")