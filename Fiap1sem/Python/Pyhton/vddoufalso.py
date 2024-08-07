import os 
os.system("clear")

idade = int(input("idade: "))
if  idade >= 18:
    print (f"VOCE É MAIOR DE IDADE E TEM {idade} ANOS")
else:
    print (f"VOCE É MENOR DE IDADE E TEM {idade} ANOS")