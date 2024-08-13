import os
def LimaprTela():
    os.system('cls')

LimaprTela()
try:
    valor1 = float(input("Digite o 1 numero: "))
    valor2 = float(input("Digite o 2 numero: "))
    div = valor1 / valor2
    print(f"O resultado da divisão é: {div}")
except ZeroDivisionError:
    LimaprTela()
    print("Não é possível dividir por zero!")
except ValueError:
    LimaprTela()
    print("Digite um numero!")
except:
    LimaprTela()
    print("Erro ao digitar os valores")
else:
    print("Resultado exibido!!")
finally:
    print("Fim do programa!!")