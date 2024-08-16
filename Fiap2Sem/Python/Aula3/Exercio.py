def menu():
    print("""
    0 - SAIR
    1 - Consultar
    2 - Listar registro  
    3 - Cadastrar
    4 - Editar
    5 - Excluir
    
""")
    

def CadastrarCadastros(tabela):
    pessoa = {
        'Nome': input("Nome:"),
        'cpf': input("cpf:"),
        'idade': int(input("idade:"))
    }
    tabela.append(pessoa)
    print("Cadastro realizado com sucesso!")
   

def ConsultarRegistros(tabela):
    cpfConsultar = input("Qual cpf da consulta: ")
    for pessoa in tabela:
        if pessoa['cpf'] == cpfConsultar:
            print(f"Nome: " + tabela[pessoa['nome']])
            print(f"cpf: " + tabela[pessoa['cpf']])
            print(f"idade: " + tabela[pessoa['idade']])

def listarRegistros(tabela):
    for cpf in tabela:
        print(f"NOME: {pessoa['nome']}, CPF: {pessoa['cpf']}, Idade: {pessoa['idade']} ")

def EditarRegistros(tabela):
    num = int(print("""
    Como voce deseja fazer a busca:
    1 - Nome
    2 - CPF
    """))
    if num == 2: 
        Consultar = input("Qual cpf da consulta: ")
        for pessoa in tabela:
            if tabela[pessoa['cpf']] == Consultar:
                num1 = int(print("""
Qual voce deseja modficar:
1 - Nome
2 - CPF
3 - Idade"""))
                if num1 == 1:
                    pessoa['nome'] = input("Novo Nome: ")
                if num1 == 2:
                    pessoa['cpf'] = input("Novo CPF: ")
                if num1 == 1:
                    pessoa['idade'] = input("Nova Idade: ")
    if num == 1: 
        Consultar = input("Qual nome da consulta: ")
        for pessoa in tabela:
            if tabela[pessoa['nome']] == Consultar:
                num1 = int(print("""
Qual voce deseja modficar:
1 - Nome
2 - CPF
3 - Idade """))
                if num1 == 1:
                    pessoa['nome'] = input("Novo Nome: ")
                if num1 == 2:
                    pessoa['cpf'] = input("Novo CPF: ")
                if num1 == 1:
                    pessoa['idade'] = input("Nova Idade: ")

def Excluir(tabela):
    if num == 2: 
        Consultar = input("Qual cpf da consulta: ")
        for pessoa in tabela:
            if tabela[pessoa['cpf']] == Consultar:
                tabela.remove(tabela)
                print("Pessoa apagada com sucesso")


#################################################################################################################################################

tabela = []

continuar = True
while continuar:
    menu()
    escolha = int(input("Escolha: "))
    match num:
        case 0:
            continuar = False
        case 1: 
            ConsultarRegistros(tabela)
        case 2: 
            listarRegistros(tabela)
        case 3 :
            CadastrarCadastros(tabela)
        case 4:
            EditarRegistros(tabela)
        case 5:
            Excluir(tabela)
        case _:
            print("Opcao Invalidar")
