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
            print(f"Nome: " + {pessoa['nome']})
            print(f"cpf: " + {pessoa['cpf']})
            print(f"Idade: " + {pessoa['idade']})

def listarRegistros(tabela):
    if not tabela:
        print("Nenhum registro encontrado!")
    
    for cpf in tabela:
        print(f"NOME: {pessoa['nome']}, CPF: {pessoa['cpf']}, Idade: {pessoa['idade']} ")


def EditarRegistros(tabela):
    cpfConsultar = input("Qual CPF deseja editar: ")
    for pessoa in tabela:
        if pessoa['cpf'] == cpfConsultar:
            print("Registro encontrado.")
            print("O que deseja modificar:")
            print("1 - Nome")
            print("2 - CPF")
            print("3 - Idade")
            opcao = int(input("Escolha uma opção: "))
            if opcao == 1:
                pessoa['nome'] = input("Novo nome: ")
            elif opcao == 2:
                pessoa['cpf'] = input("Novo CPF: ")
            elif opcao == 3:
                pessoa['idade'] = int(input("Nova idade: "))
            else:
                print("Opção inválida.")
            print("Registro atualizado com sucesso.")
            return
    print("Registro não encontrado.")

def Excluir(tabela):
    cpfExcluir = input("Qual CPF deseja excluir: ")
    for pessoa in tabela:
        if pessoa['cpf'] == cpfExcluir:
            tabela.pop(pessoa)
            print("Registro excluído com sucesso.")
            return
    print("Registro não encontrado.")


#################################################################################################################################################

tabela = []

continuar = True
while continuar:
    menu()
    escolha = int(input("Escolha: "))
    match escolha:
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
        
