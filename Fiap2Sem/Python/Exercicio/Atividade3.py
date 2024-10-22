#GUSTAVO RAMIRES LAZZURI RM556772
#NATASHA OLIVEIRA RM554816
# MATEUS HENRIQUE  RM558424

import oracledb
import os

def LimaprTela():
    os.system('cls' if os.name == 'nt' else 'clear')

try:
    conn = oracledb.connect(user='rm556772', password='051205', dsn='oracle.fiap.com.br:1521/ORCL')
    inst_cadastro = conn.cursor()
    inst_consulta = conn.cursor()
except Exception as e:
    print("Erro ao conectar com o banco de dados: ", e)

def criarCadastro():
    try:
        cpf = input("Digite seu CPF: ")
        consulta = """SELECT * FROM CADASTRO WHERE CPF = :cpf"""
        inst_consulta.execute(consulta, {'cpf': cpf})
        data = inst_consulta.fetchall()

        if len(data) == 0: 
            nome = input("Digite seu nome: ")
            email = input("Digite seu email: ")
            idade = input("Digite sua idade: ")
            telefone = input("Digite seu telefone: ")
            opcao = input("Digite o status do cadastro (1 - Ativo, 2 - Inativo): ")
            ativo = "Ativo" if opcao == '1' else "Inativo"

            cadastro = """INSERT INTO CADASTRO (cpf, nome, tel, email, idade, ativo) 
                          VALUES (:cpf, :nome, :telefone, :email, :idade, :ativo)"""
            inst_cadastro.execute(cadastro, {'cpf': cpf, 'nome': nome, 'telefone': telefone, 
                                             'email': email, 'idade': idade, 'ativo': ativo})
            conn.commit()
            print("Cadastro realizado com sucesso!")
        else:
            print("Erro: CPF já existe!")
    except Exception as e:
        print("Erro: ", e)

def Listar():
    opcao = int(input("""
1 - Listar TODOS    
2 - Listar ATIVOS
3 - Listar INATIVOS
    """))
    
    if opcao == 1:
        consulta = "SELECT * FROM CADASTRO"
    elif opcao == 2:
        consulta = "SELECT * FROM CADASTRO WHERE ativo = 'Ativo'"
    elif opcao == 3:
        consulta = "SELECT * FROM CADASTRO WHERE ativo = 'Inativo'"
    else:
        print("Opção Inválida!")
        return

    try:
        inst_consulta.execute(consulta)
        data = inst_consulta.fetchall()

        if len(data) == 0:
            print("Nenhum usuário cadastrado.")
        else:
            for registro in data:
                print(f"CPF: {registro[0]}, Nome: {registro[1]}, Telefone: {registro[2]}, Email: {registro[3]}, Idade: {registro[4]}, Ativo: {registro[5]}")
    except Exception as e:
        print("Erro: ", e)

def main():
    while True:
        print("""
1 - Cadastrar novo usuário
2 - Listar (TODOS/ATIVOS/INATIVOS)
3 - Sair""")
        
        try:
            opcao = int(input("Escolha uma opção: "))
            if opcao == 1:
                criarCadastro()
            elif opcao == 2:
                Listar()
            elif opcao == 3:
                print("Saindo do programa...")
                break
            else:
                print("Opção Inválida!")
        except ValueError:
            print("Por favor, digite um número válido.")

LimaprTela()
main()


try:
    inst_cadastro.close()
    inst_consulta.close()
    conn.close()
except Exception as e:
    print("Erro ao fechar as conexões: ", e)
