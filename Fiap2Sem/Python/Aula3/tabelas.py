import os
os.system("cls")


def lista_tabela(t: list) -> None:
    for i in range(0, len(t), 1):
        print(f"Registro: {i+1}")
        print(f"Nome........: {t[i]['nome']}")
        print(f"Idade........: {t[i]['idade']}")
 
import os
os.system("cls")

tabela = []
dicionario = {
    'nome': 'Edson',
    'idade': 50
}
tabela.append(agenda.copy())
 
agenda['nome'] = input("Nome: ")
agenda['idade'] = input("idade: ")
 
tabela.append(agenda.copy())
 
agenda['nome'] = input("Nome: ")
agenda['idade'] = input("idade: ")
 
tabela.append(agenda.copy())
 
for i in range(0, len(tabela), 1):
    print(f"Registro: {i+1}")
    print(f"Nome........: {tabela[i]['nome']}")
    print(f"Idade........: {tabela[i]['idade']}")
 
 
 
lista_tabela(tabela)