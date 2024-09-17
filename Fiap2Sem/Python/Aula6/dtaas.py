#OPERADOR TERNARIO

# SIMILAR A UM IF MAS COM A DIFERENCA DE QUE SOMENTE TEM UM COMANDO VERDADEIRO OU FALSO

import os
os.system("cls" if os.name == "nt" else "clear")


#FORMA 1

#SINTAXE:
# [<VAR> = ] <COMANDO VERDADEIRO> IF <CONDICAO> ELSE <COMANDO FALSO>

idade = 10
print("Maior de idade") if idade >= 18 else print("Menor de idade")


#FORMA 2

#SINTAXE:
# [<VAR> = ] <COMANDO VERDADEIRO> IF <CONDICAO> ELSE <COMANDO FALSO>

venda = 999
bonus = 50 if venda > 100 else 30

#FORMA 2

#SINTAXE:
# [<VAR> = ] <COMANDO VERDADEIRO> IF <CONDICAO> ELSE <COMANDO FALSO>

venda = 700
desconto = venda - (venda *0.1 if venda>500 else venda*0.05)

################################################################################################################

salario = float(input("DIGITE SUE SALARIO: "))
inss = salario*0.075 if salario <= 1412 else salario*0.09
salario_liq = salario - (salario*0.075 if salario <= 1412 else salario*0.09)
print("O valor do INSS é: ", inss)
print("O valor do salario liquido é: ", salario_liq)