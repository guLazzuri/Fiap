import os
os.system ("cls")

salarimin = 1302  
salario_atual = float(input("Digite o salario atual:" ))
Faltas = int(input("Quantas faltas voce tem? "))
Bonus = 1000
if salario_atual < 0:
    print("ERRO! Digite um salário positivo!")
else: 
    if salario_atual <= 2*salario_atual:
        reajuste = 0.0645
    elif salario_atual >= 2*salario_atual or salario_atual <= 5*salario_atual:
        reajuste = 0.0455
    else:
        salario_atual >= 5*salario_atual
        reajuste = 0.0289
           
novosalario =+ salario_atual*(1+reajuste)

if Faltas == 0:
    novosalario = novosalario 


if Faltas <= 0:
    print(f"""
Salario: {salario_atual}
Qtd. de Falta: {Faltas}

Salário..............: {salario_atual:.2f}
Salário Reajustado...: {novosalario:.2f}
Bonûs................: {Bonus:.2f}
         
          """) 

else:
    Faltas > 0
    print(f"""
    Salário..............: {salario_atual:.2f}
Salário Reajustado...: {novosalario}
Bonûs................: 0.00
          """)
    


    