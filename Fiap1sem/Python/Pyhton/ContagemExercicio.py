import os 
os.system("cls")

n1 = int(input("Primeiro numero: "))
n2 = int(input("Primeiro numero: "))

if n1 > n2:
    while n1 >= n2:
        print(n1)
        n1 = n1 - 1 
else:
    while n2 >= n1:
        print(n2)
        n2 = n2 - 1  

