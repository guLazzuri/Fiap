import os
import re
import oracledb
import requests
import json
import pandas as pd
from datetime import datetime

#   Gustavo Ramires Lazzuri       RM556772
#   Natasha Lopes Rocha Oliveira  RM554816
#   Ricardo Rodrigues Cotovasso   RM558295

# Limpar o terminal
os.system("cls" if os.name == "nt" else "clear")

VIA_CEP_URL = "http://www.viacep.com.br/ws/{}/json"

def consulta_cep(cep):
    """Realiza a consulta do CEP usando a API do ViaCEP."""
    resposta = requests.get(VIA_CEP_URL.format(cep))

    if resposta.ok:
        endereco = json.loads(resposta.text)

        if 'erro' in endereco:
            raise ValueError("CEP inválido")

        # Solicita o complemento adicional do usuário
        complemento_usuario = input("Digite o complemento do endereço (se houver): ")
        complemento = endereco.get("complemento", "") or complemento_usuario

        return {
            "bairro": endereco.get("bairro", ""),
            "cep": endereco.get("cep", ""),
            "cidade": endereco.get("localidade", ""),
            "logradouro": endereco.get("logradouro", ""),
            "uf": endereco.get("uf", ""),
            "complemento": complemento
        }
    else:
        raise ValueError("Erro na chamada da API")

def exibir_menu_principal():
    print("""
    Menu Principal:
    1- Criar um cadastro. 
    2- Logar com um cadastro. 
    3- Gerar arquivo por ciadades.
    4- Listar usuários.
    """)

def exibir_menu_secundario():
    print("\n=== MENU CRUD ===")
    print("1. Atualizar usuário")
    print("2. Excluir usuário")
    print("3. Consultar usuário")
    print("4. Voltar ao menu principal")

def validar_opcao(opcao, limite):
    """Valida a opção escolhida no menu."""
    return opcao.isdigit() and 1 <= int(opcao) <= limite

def validar_nome(nome):
    """Valida o formato do nome completo."""
    return bool(re.match(r'^[a-zA-ZÀ-ÿ\u00C0-\u017F]+([-\'\s]?[a-zA-ZÀ-ÿ\u00C0-\u017F]+)*$', nome.strip()))

def validar_email(email):
    """Valida o formato do e-mail."""
    return bool(re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', email.strip()))

def validar_senha(senha):
    """Valida a senha de acordo com as regras definidas."""
    return bool(re.match(r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d\W]{8,}$', senha.strip()))

def validar_cpf(cpf):
    """Valida o CPF, garantindo que contenha 11 dígitos numéricos."""
    cpf = re.sub(r'[^0-9]', '', cpf)
    return len(cpf) == 11

def validar_telefone(telefone):
    """Valida o telefone, que deve ter entre 10 e 11 dígitos."""
    telefone = re.sub(r'\D', '', telefone)
    return bool(re.match(r'^\d{10,11}$', telefone))

def validar_dois_numeros_mes(numero):
    """Valida que o mês está entre 01 e 12."""
    return numero.isdigit() and 1 <= int(numero) <= 12

def validar_dois_numeros_dia(numero, mes):
    """Valida que o dia é válido para o mês informado."""
    if mes == '02':
        return numero.isdigit() and 1 <= int(numero) <= 29
    return numero.isdigit() and 1 <= int(numero) <= 31

def validar_quatro_numeros(numero):
    """Valida que um número contém exatamente quatro dígitos."""
    return len(numero) == 4 and numero.isdigit()

def validar_data_nascimento(data):
    """Valida o formato da data de nascimento."""
    return bool(re.match(r'^\d{2}/\d{2}/\d{4}$', data.strip()))

def criar_cadastro(cursor, conexao):
    """Cria um novo cadastro de usuário."""
    print("Criando Login...")

    # Coleta e valida dados do usuário
    nome_completo = input("Nome completo: ")
    while not validar_nome(nome_completo):
        print("O nome completo não está no formato válido. Por favor, tente novamente.")
        nome_completo = input("Nome completo: ")

    email = input("E-mail: ")
    while not validar_email(email):
        print("O e-mail não está no formato válido. Por favor, tente novamente.")
        email = input("E-mail: ")

    cpf = input("CPF (somente números): ")
    while not validar_cpf(cpf):
        print("O CPF deve conter 11 dígitos numéricos.")
        cpf = input("CPF (somente números): ")

    ano_nascimento = input("Ano do seu nascimento: ")
    while not validar_quatro_numeros(ano_nascimento) or not (1920 < int(ano_nascimento) < 2024):
        print("O ano de seu nascimento deve conter quatro números (Ex: 2006) e ser entre 1920 e 2024.")
        ano_nascimento = input("Ano do seu nascimento: ")

    mes_nascimento = input("Mês do seu aniversário (01-12): ")
    while not validar_dois_numeros_mes(mes_nascimento):
        print("O mês de seu nascimento deve conter dois números (01-12).")
        mes_nascimento = input("Mês do seu aniversário (01-12): ")

    dia_nascimento = input("Dia do seu aniversário (01-31): ")
    while not validar_dois_numeros_dia(dia_nascimento, mes_nascimento):
        print("O dia de seu nascimento deve conter dois números e ser válido para o mês informado.")
        dia_nascimento = input("Dia do seu aniversário (01-31): ")

    data_nascimento = f"{dia_nascimento}/{mes_nascimento}/{ano_nascimento}"

    telefone = input("Telefone (formato: DDXXXXXXXXX) ")
    while not validar_telefone(telefone):
        print("O telefone deve estar no formato 'ex: 11999993333'")
        telefone = input("Telefone: ")

    # Consulta o CEP e trata possíveis erros
    try:
        cep = input("Digite seu CEP: ")
        resultado = consulta_cep(cep)
    except ValueError as e:
        print(f"Erro ao consultar o cep: {e}")
        return 

    senha = input("Senha: ")
    while not validar_senha(senha):
        print("A senha deve conter uma letra maiúscula, uma letra minúscula, um número e no mínimo 8 caracteres.")
        senha = input("Senha: ")

    # Dicionário com dados do usuário
    dado_usuario = {
        "nome_completo": nome_completo,
        "email": email,
        "senha": senha,
        "cpf": cpf,
        "cidade": resultado['cidade'],
        "bairro": resultado['bairro'],
        "logradouro": resultado['logradouro'],
        "uf": resultado['uf'],
        "complemento": resultado['complemento'],
        "data_nascimento": data_nascimento,
        "telefone": telefone
    }

    # Inserção no banco de dados
    cadastro = '''INSERT INTO USUARIO_FW (nome_completo, email, senha, cpf, data_nascimento, telefone, cidade, bairro, logradouro, uf, complemento) 
                  VALUES (:nome_completo, :email, :senha, :cpf, TO_DATE(:data_nascimento, 'DD/MM/YYYY'), :telefone, :cidade, :bairro, :logradouro, :uf, :complemento)'''

    cursor.execute(cadastro, {
        "nome_completo": dado_usuario["nome_completo"],
        "email": dado_usuario["email"],
        "senha": dado_usuario["senha"],
        "cpf": dado_usuario["cpf"],
        "data_nascimento": dado_usuario["data_nascimento"],
        "telefone": dado_usuario["telefone"],
        "cidade": dado_usuario["cidade"],
        "bairro": dado_usuario["bairro"],
        "logradouro": dado_usuario["logradouro"],
        "uf": dado_usuario["uf"],
        "complemento": dado_usuario["complemento"]
    })
    conexao.commit()
    print("Cadastro criado com sucesso!")

def logar_cadastro(cursor):
    """Realiza o login do usuário."""
    print("Logar com um cadastro...")
    usuario = input("Usuário (Nome Completo ou E-mail): ").strip()
    senha_cliente = input("Senha: ").strip()

    cursor.execute("SELECT * FROM USUARIO_FW WHERE (nome_completo = :usuario OR email = :usuario) AND senha = :senha", {
        "usuario": usuario,
        "senha": senha_cliente
    })

    usuario_logado = cursor.fetchone()

    if usuario_logado:
        print(f"Bem-vindo(a), {usuario}!")  # Exibe o nome do usuário logado
        return True  # Indica que o login foi bem-sucedido
    else:
        print("Nome de usuário ou senha inválidos.")
        return False  # Indica que o login falhou

def atualizar_usuario(cursor, conexao):
    """Atualiza as informações de um usuário existente."""
    usuario = input("Digite o nome completo ou e-mail do usuário que deseja atualizar: ")

    cursor.execute("SELECT * FROM USUARIO_FW WHERE nome_completo = :usuario OR email = :usuario", {
        "usuario": usuario
    })

    usuario_atualizar = cursor.fetchone()

    if usuario_atualizar:
        print("Usuário encontrado!")
        print("1. Nome completo")
        print("2. E-mail")
        print("3. Telefone")
        print("4. Senha")
        print("5. Sair")

        opcao = input("Escolha o que deseja atualizar: ")
        if opcao == "1":
            novo_nome = input("Novo nome completo: ")
            if validar_nome(novo_nome):
                cursor.execute("UPDATE USUARIO_FW SET nome_completo = :novo_nome WHERE id = :id", {
                    "novo_nome": novo_nome,
                    "id": usuario_atualizar[0]
                })
                print("Nome atualizado com sucesso!")
            else:
                print("Nome inválido.")

        elif opcao == "2":
            novo_email = input("Novo e-mail: ")
            if validar_email(novo_email):
                cursor.execute("UPDATE USUARIO_FW SET email = :novo_email WHERE id = :id", {
                    "novo_email": novo_email,
                    "id": usuario_atualizar[0]
                })
                print("E-mail atualizado com sucesso!")
            else:
                print("E-mail inválido.")

        elif opcao == "3":
            novo_telefone = input("Novo telefone: ")
            if validar_telefone(novo_telefone):
                cursor.execute("UPDATE USUARIO_FW SET telefone = :novo_telefone WHERE id = :id", {
                    "novo_telefone": novo_telefone,
                    "id": usuario_atualizar[0]
                })
                print("Telefone atualizado com sucesso!")
            else:
                print("Telefone inválido.")

        elif opcao == "4":
            nova_senha = input("Nova senha: ")
            if validar_senha(nova_senha):
                cursor.execute("UPDATE USUARIO_FW SET senha = :nova_senha WHERE id = :id", {
                    "nova_senha": nova_senha,
                    "id": usuario_atualizar[0]
                })
                print("Senha atualizada com sucesso!")
            else:
                print("Senha inválida.")
        else:
            print("Opção inválida.")

        conexao.commit()
    else:
        print("Usuário não encontrado.")

def excluir_usuario(cursor, conexao):
    """Exclui um usuário do banco de dados."""
    usuario = input("Digite o nome completo ou e-mail do usuário que deseja excluir: ")
    cursor.execute("SELECT * FROM USUARIO_FW WHERE nome_completo = :usuario OR email = :usuario", {
        "usuario": usuario
    })
    
    usuario_excluir = cursor.fetchone()

    if usuario_excluir:
        cursor.execute("DELETE FROM USUARIO_FW WHERE id = :id", {
            "id": usuario_excluir[0]
        })
        conexao.commit()
        print("Usuário excluído com sucesso!")
    else:
        print("Usuário não encontrado.")

def consultar_usuario(cursor):
    """Consulta as informações de um usuário específico."""
    usuario = input("Digite o nome completo ou e-mail do usuário que deseja consultar: ")
    cursor.execute("SELECT * FROM USUARIO_FW WHERE nome_completo = :usuario OR email = :usuario", {
        "usuario": usuario
    })
    
    usuario_consulta = cursor.fetchone()

    if usuario_consulta:
        print(f"Nome: {usuario_consulta[1]}")
        print(f"E-mail: {usuario_consulta[2]}")
        print(f"Senha: {usuario_consulta[3]}")
        print(f"CPF: {usuario_consulta[4]}")
        print(f"Data de Nascimento: {usuario_consulta[5]}")
        print(f"Telefone: {usuario_consulta[6]}")
        print(f"Cidade: {usuario_consulta[7]}")
        print(f"Bairro: {usuario_consulta[8]}")
        print(f"Logradouro: {usuario_consulta[9]}")
        print(f"UF: {usuario_consulta[10]}")
        print(f"Complemento: {usuario_consulta[11]}")
    else:
        print("Usuário não encontrado.")

def listar_usuarios(cursor):
    """Lista todos os usuários cadastrados."""
    cursor.execute("SELECT * FROM USUARIO_FW")
    usuarios = cursor.fetchall()

    if usuarios:
        for usuario in usuarios:
            print(f"ID: {usuario[0]}, Nome: {usuario[1]}, E-mail: {usuario[2]}")
    else:
        print("Nenhum usuário encontrado.")

def gerar_excel(cursor, conexao):
    try:
        inicial_filtro = input("Digite a sigla da cidade desejada (Ex. 'SP','RJ','BH'): ").strip()  
        
        # Verifica se a sigla tem exatamente 2 caracteres
        if len(inicial_filtro) != 2:
            print("Por favor, insira uma sigla válida, com exatamente 2 caracteres.")
            return  

        # Seleciona apenas as colunas desejadas
        cursor.execute('SELECT nome_completo, email, data_nascimento, cidade FROM USUARIO_FW WHERE uf = :uf', {'uf': inicial_filtro})
        resultados = cursor.fetchall()

        if not resultados:
            print(f"Nenhuma cidade encontrada com a sigla '{inicial_filtro}'.")
            return  

        # Criando um DataFrame com os resultados
        dados_filtrados_df = pd.DataFrame(resultados, columns=['nome_completo', 'email', 'data_nascimento', 'cidade'])

        # Gerando o nome do arquivo com timestamp
        nome_arquivo = f"Cidade_filtrados_{inicial_filtro}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"

        # Exportando para Excel
        dados_filtrados_df.to_excel(nome_arquivo, index=False)  
        print(f"Arquivo {nome_arquivo} gerado!")

        # Exibindo os dados filtrados
        print(dados_filtrados_df)

    except Exception as e:
        print("Erro ao filtrar cidades: ", e)

def main():
    # Conexão com o banco de dados
    try:
        conexao = oracledb.connect(user="rm556772", password="051205", dsn="oracle.fiap.com.br:1521/ORCL")
        cursor = conexao.cursor()
        
        while True:
            exibir_menu_principal()
            opcao = input("Escolha uma opção: ")

            if validar_opcao(opcao, 2):
                if opcao == "1":
                    criar_cadastro(cursor, conexao)
                elif opcao == "2":
                    if logar_cadastro(cursor):
                        while True:
                            exibir_menu_secundario()
                            opcao_secundaria = input("Escolha uma opção: ")

                            if validar_opcao(opcao_secundaria, 5):
                                if opcao_secundaria == "1":
                                    atualizar_usuario(cursor, conexao)
                                elif opcao_secundaria == "2":
                                    excluir_usuario(cursor, conexao)
                                elif opcao_secundaria == "3":
                                    consultar_usuario(cursor)   
                                elif opcao_secundaria == "4":
                                    break
                                else:
                                    print("Opção inválida.")
            elif opcao == "3":
                gerar_excel(cursor,conexao)
            elif opcao == "4":
                listar_usuarios(cursor)
            else:
                print("Opção inválida.")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")
    finally:
        cursor.close()
        conexao.close()

if __name__ == "__main__":
    main()
