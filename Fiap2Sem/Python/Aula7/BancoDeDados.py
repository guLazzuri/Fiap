import oracledb
import pandas as pd
import os

os.system("cls" if os.name == "nt" else "clear")

# Conectando ao banco de dados
try:
    conn = oracledb.connect(user="rm556772", password="051205", dsn='oracle.fiap.com.br:1521/ORCL')
    # Criar objetos para operações no banco de dados
    inst_cadastro = conn.cursor()
    inst_consulta = conn.cursor()
    inst_alteracao = conn.cursor()
    inst_exclusao = conn.cursor()  # Aqui foi corrigido para 'conn'
except Exception as e:
    print("Erro: ", e)
    conexao = False
else:
    print("Efetuou a conexão")
    conexao = True

margem = ' ' * 4

while conexao:
    os.system("clear")

    # Apresenta o menu
    print("""
    CRUD - PETSHOP
    1 - Cadastrar Pet
    2 - Listar Pets
    3 - Alterar Pet
    4 - Excluir Pet
    5 - Excluir todos os Pets
    6 - SAIR
    """)
    escolha = int(input(margem + "Escolha -> "))
    os.system("clr")

    match escolha:
        case 1:
            try:
                print("------ CADASTRAR PET ------")
                # Recebe os valores para o cadastro
                tipo = input(margem + "Tipo.....: ")
                nome = input(margem + "Nome.....: ")
                idade = int(input(margem + "Idade....: "))

                # Utilizando parâmetros para evitar SQL Injection
                cadastro = """INSERT INTO petshop(tipo_pet, nome_pet, idade) VALUES (:1, :2, :3)"""
                # Executa a gravação do registro na tabela
                inst_cadastro.execute(cadastro, (tipo, nome, idade))
                conn.commit()
            except ValueError:
                print(margem + "Digite um número válido na idade.")
            except Exception as e:
                print(margem + f"Erro: {e}")
            else:
                print(margem + "DADOS GRAVADOS COM SUCESSO!")
        case _:
            print(margem + "Opção inválida!")

else:
    print("Obrigado por utilizar a nossa aplicação :)")
