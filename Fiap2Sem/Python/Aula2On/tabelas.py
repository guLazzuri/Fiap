import os
def LimaprTela():
    os.system('cls')


#Tabela de memoria é uma lsita de dicionariso

def Preenche_registro(t: list, reg: dict) -> None:
    print("Preenchendo registro")
    reg['nome'] = input("Nome: ")
    reg['idade'] = int(input("Idade: "))
    t.append(reg.copy())

#preencehndo registro

tabela = list()


contato = {
    "Nome": "",
    "idade": 0,
}

LimaprTela()
Preenche_registro(tabela, contato)
Preenche_registro(tabela, contato)
print(tabela)