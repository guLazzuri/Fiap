import os
import re
import oracledb
import requests
import json
import pandas as pd
from datetime import datetime
import random
import string

os.system("cls" if os.name == "nt" else "clear")

VIA_CEP_URL = "http://www.viacep.com.br/ws/{}/json"

nome_usuario_logado = ""
id_usuario_logado = ""

def consulta_cep(cep):
    """Realiza a consulta do CEP usando a API do ViaCEP."""
    resposta = requests.get(VIA_CEP_URL.format(cep))

    if resposta.ok:
        endereco = json.loads(resposta.text)

        if 'erro' in endereco:
            raise ValueError("CEP inválido")

        
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
    print("\n=== MENU PRINCIPAL ===")
    print("1. Criar Cadastro")
    print("2. Logar")
    print("3. Gerar Relatórios")
    print("4. Listar Usuários")
    print("5. Listar Produtos")
    print("6. Sair")

def exibir_menu_secundario():
    print("\n=== MENU SECUNDÁRIO ===")
    print("1. Atualizar usuário")
    print("2. Excluir usuário")
    print("3. Consultar usuário")
    print("4. Buscar Token por Nome")
    print("5. Cadastrar/Previsão de um produto")
    print("6. Voltar ao menu principal")

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

def gerar_token_unico():
    comprimento = random.randint(5, 7)  # Define o comprimento aleatório entre 5 e 7
    caracteres = string.ascii_uppercase + string.digits  # Letras maiúsculas e números
    token = ''.join(random.choice(caracteres) for _ in range(comprimento))  # Gera o token
    return token

def calcular_idade(data_nascimento: str) -> int:
    """Calcula a idade com base na data de nascimento no formato 'DD/MM/YYYY'."""
    hoje = datetime.today()
    nascimento = datetime.strptime(data_nascimento, "%d/%m/%Y")
    idade = hoje.year - nascimento.year
    if (hoje.month, hoje.day) < (nascimento.month, nascimento.day):
        idade -= 1
    return idade

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
    
    idade = calcular_idade(data_nascimento)

    telefone = input("Telefone (formato: DDXXXXXXXXX) ")
    while not validar_telefone(telefone):
        print("O telefone deve estar no formato 'ex: 11999993333'")
        telefone = input("Telefone: ")

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
    
    token = gerar_token_unico()

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
        "idade": idade,  
        "telefone": telefone,
        "token": token
    }


    cadastro = '''INSERT INTO USUARIO_ELECTRY (nome_completo, email, senha, cpf, data_nascimento, idade, telefone, cidade, bairro, logradouro, uf, complemento, token) 
                  VALUES (:nome_completo, :email, :senha, :cpf, :data_nascimento, :idade, :telefone, :cidade, :bairro, :logradouro, :uf, :complemento, :token)'''

    cursor.execute(cadastro, dado_usuario)
    conexao.commit()
    print("Cadastro criado com sucesso!")

def cadastrar_produto(cursor, conexao):
    """Cria um novo cadastro de produto."""
    print("Criando produto...")

    nome_produto = input("Nome do produto: ")
    while not nome_produto:  
        print("O nome do produto não pode estar vazio. Por favor, tente novamente.")
        nome_produto = input("Nome do produto: ")

    categoria_produto = input("Categoria do produto (Ex: Televisão, monitor, geladeira): ")
    while not categoria_produto:  
        print("A categoria do produto não pode estar vazia. Por favor, tente novamente.")
        categoria_produto = input("Categoria do produto: ")

    while True:
        print("Agora responda as seguintes perguntas: ")
        print("""Qual a qualidade do  produto?
    1 -  EXCELENTE
    2 -  BOM 
    3 -  NORMAL
    4 -  RUIM
    5 -  PÉSSIMO""")
    
        op1 = int(input())
        if op1 == 1:
            qualidade = 8
            break
        elif op1 == 2:
            qualidade = 6
            break
        elif op1 == 3:
            qualidade = 4
            break
        elif op1 == 4:
            qualidade = 3
            break
        elif op1 == 5:
            qualidade = 2
            break
        else: 
            print("Opção inválida, por favor, tente novamente")
    
    while True:
        print("""De qual material seu produto é feito:
    1 - Metal 
    2 - Ferro 
    3 - Plástico 
    4 - Outros""")

        op2 = int(input())
        if op2 == 1:
            material = 8
            break  
        elif op2 == 2:
            material = 6
            break
        elif op2 == 3:
            material = 4    
            break
        elif op2 == 4:
            material = 2
            break
        else:
            print("Opção inválida, por favor, tente novamente")
    
    while True:
        print("Qual o peso do produto (KG) ?")
        peso = input()
        if not peso.isdigit():
            print("Insira somente números.")
        else:
            peso = float(peso)
            break

    pontuacao_produto = ((qualidade + material) * peso)

    id_descarte = 0
    nome_completo = nome_usuario_logado
    id_usuario = buscar_id_por_nome(cursor, nome_completo)  

    dado_produto = {
    "nome_produto": nome_produto,
    "categoria_produto": categoria_produto,
    "pontuacao_produto": pontuacao_produto,
    "id_usuario": id_usuario
    }

    cadastro_produto = '''
    INSERT INTO T_DESCARTE (nome_produto, categoria_produto, pontuacao_produto, id_usuario)
    VALUES (:nome_produto, :categoria_produto, :pontuacao_produto, :id_usuario)'''


    cursor.execute(cadastro_produto, dado_produto)
    conexao.commit()
    print("Produto cadastrado com sucesso!")
 
def buscar_estimativa_pontos(cursor, id_usuario):
    try:
        # Consulta para buscar a soma da pontuação dos produtos do usuário
        cursor.execute('''
            SELECT SUM(PONTUACAO_PRODUTO)
            FROM T_DESCARTE
            WHERE ID_USUARIO = :id_usuario
        ''', {'id_usuario': id_usuario})

        # Obtendo o resultado da consulta
        resultado = cursor.fetchone()

        # Verificando se a soma da pontuação é válida
        if resultado and resultado[0] is not None:
            soma_pontos = resultado[0]
            print(f"Estimativa de pontos para o usuário {id_usuario}: {soma_pontos}")
        else:
            print(f"Não há produtos registrados ou pontos para o usuário {id_usuario}.")
    
    except Exception as e:
        print("Erro ao buscar a estimativa de pontos:", e)

def buscar_id_por_nome(cursor, nome_completo):
    try:
        # Consulta para selecionar o ID com base no nome completo
        cursor.execute("SELECT id_usuario FROM USUARIO_ELECTRY WHERE nome_completo = :nome_completo", {"nome_completo": nome_completo})
        
        # Busca o resultado
        resultado = cursor.fetchone()
        
        # Verifica se encontrou algum registro
        if resultado:
            id_usuario = resultado[0]
            print(f"ID do usuário: {id_usuario}")
            return id_usuario
        else:
            print("Nenhum usuário encontrado para esse nome.")
            return None

    except Exception as e:
        print("Erro ao buscar ID por nome:", e)
        return None

def buscar_nome_por_token(cursor, token):
    try:
        # Consulta para selecionar apenas o nome_completo baseado no token
        cursor.execute("SELECT nome_completo FROM USUARIO_ELECTRY WHERE token = :token", {"token": token})
        
        # Busca o resultado
        resultado = cursor.fetchone()
        
        # Verifica se encontrou algum registro
        if resultado:
            nome_completo = resultado[0]
            print(f"Nome do usuário: {nome_completo}")
            return nome_completo
        else:
            print("Nenhum usuário encontrado com esse token.")
            return None

    except Exception as e:
        print("Erro ao buscar nome por token:", e)
        return None

def buscar_token_por_nome(cursor, nome_completo):
    try:
        # Consulta para selecionar o token com base no nome completo
        cursor.execute("SELECT token FROM USUARIO_ELECTRY WHERE nome_completo = :nome_completo", {"nome_completo": nome_completo})
        
        # Busca o resultado
        resultado = cursor.fetchone()
        
        # Verifica se encontrou algum registro
        if resultado:
            token = resultado[0]
            print(f"Token do usuário: {token}")
            return token
        else:
            print("Nenhum token encontrado para esse nome.")
            return None

    except Exception as e:
        print("Erro ao buscar token por nome:", e)
        return None

def logar_cadastro(cursor):
    global nome_usuario_logado 
    global id_usuario_logado
    """Realiza o login do usuário."""
    print("Logar com um cadastro...")
    print("""
    Escolha uma das opçóes abaixo:
    1 - Logar com Nome/Senha
    2 - Entrar com TOKEN
    """)
    opcao_login = input("Opção: ")
    match opcao_login:
        case "1":
            usuario = input("Usuário (Nome Completo): ").strip()
            senha_cliente = input("Senha: ").strip()

            cursor.execute("SELECT * FROM USUARIO_ELECTRY WHERE (nome_completo = :usuario OR email = :usuario) AND senha = :senha", {
            "usuario": usuario,
            "senha": senha_cliente})

            usuario_logado = cursor.fetchone()

        case "2":
            token = input("Token: ").strip()
            cursor.execute("SELECT * FROM USUARIO_ELECTRY WHERE token = :token", {
                "token": token})
            usuario_logado = cursor.fetchone()
            usuario = buscar_nome_por_token(cursor, token)
            
        case default:
            print("Opção Invalida!")
        
    if usuario_logado:
        nome_usuario_logado = usuario 
        id_usuario_logado = buscar_id_por_nome(cursor,nome_usuario_logado)
        print(f"Bem-vindo(a), {usuario}!")  
        return True  
    else:
        print("Nome de usuário ou senha inválidos.")
        return False  

def atualizar_usuario(cursor, conexao):
    """Atualiza as informações de um usuário existente."""
    global nome_usuario_logado  
    usuario = nome_usuario_logado

    # Consulta o usuário logado
    cursor.execute("SELECT * FROM USUARIO_ELECTRY WHERE nome_completo = :usuario OR email = :usuario", {
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

        while True:
            opcao = input("Escolha o que deseja atualizar: ")
            
            if opcao == "1":
                novo_nome = input("Novo nome completo: ")
                if validar_nome(novo_nome):
                    cursor.execute("UPDATE USUARIO_ELECTRY SET nome_completo = :novo_nome WHERE id_usuario = :usuario_id", {
                        "novo_nome": novo_nome,
                        "usuario_id": usuario_atualizar[0]
                    })
                    nome_usuario_logado = novo_nome  
                    print("Nome completo atualizado com sucesso!")
                else:
                    print("Nome inválido.")

            elif opcao == "2":
                novo_email = input("Novo e-mail: ")
                if validar_email(novo_email):
                    cursor.execute("UPDATE USUARIO_ELECTRY SET email = :novo_email WHERE id_usuario = :usuario_id", {
                        "novo_email": novo_email,
                        "usuario_id": usuario_atualizar[0]
                    })
                    print("E-mail atualizado com sucesso!")
                else:
                    print("E-mail inválido.")

            elif opcao == "3":
                novo_telefone = input("Novo telefone: ")
                if validar_telefone(novo_telefone):
                    cursor.execute("UPDATE USUARIO_ELECTRY SET telefone = :novo_telefone WHERE id_usuario = :usuario_id", {
                        "novo_telefone": novo_telefone,
                        "usuario_id": usuario_atualizar[0]
                    })
                    print("Telefone atualizado com sucesso!")
                else:
                    print("Telefone inválido.")

            elif opcao == "4":
                nova_senha = input("Nova senha: ")
                if validar_senha(nova_senha):
                    cursor.execute("UPDATE USUARIO_ELECTRY SET senha = :nova_senha WHERE id_usuario = :usuario_id", {
                        "nova_senha": nova_senha,
                        "usuario_id": usuario_atualizar[0]
                    })
                    print("Senha atualizada com sucesso!")
                else:
                    print("Senha inválida.")

            elif opcao == "5":
                print("Você saiu do sistema de atualização.")
                break  # Sai do loop

            else:
                print("Opção inválida. Tente novamente.")
            
            # Confirma as alterações no banco
            conexao.commit()

    else:
        print("Usuário não encontrado.")


def excluir_usuario(cursor, conexao):
    """Exclui um usuário do banco de dados."""
    try:
        nome = nome_usuario_logado  # Usando a variável global 'nome_usuario_logado'
        
        if nome == "":
            print("Nenhum usuário logado. Não é possível excluir.")
            return

        cursor.execute("SELECT * FROM USUARIO_ELECTRY WHERE nome_completo = :usuario OR email = :usuario", {
            "usuario": nome
        })
        
        usuario_excluir = cursor.fetchone()

        if usuario_excluir:
            confirmar = input(f"Tem certeza que deseja excluir o usuário {usuario_excluir[1]}? (s/n): ").strip().lower()
            if confirmar == "s":
                cursor.execute("DELETE FROM USUARIO_ELECTRY WHERE id_usuario = :id", {
                    "id": usuario_excluir[0]
                })
                conexao.commit()
                print("Usuário excluído com sucesso!")
            else:
                print("Exclusão cancelada.")
        else:
            print("Usuário não encontrado.")
    
    except Exception as e:
        print("Erro ao excluir o usuário:", e)

def consultar_usuario(cursor):
    """Consulta as informações de um usuário específico."""
    usuario = nome_usuario_logado
    cursor.execute("SELECT * FROM USUARIO_ELECTRY WHERE nome_completo = :usuario OR email = :usuario", {
        "usuario": usuario
    })
    
    usuario_consulta = cursor.fetchone()

    if usuario_consulta:
        print(f"Nome: {usuario_consulta[1]}")
        print(f"E-mail: {usuario_consulta[2]}")
        print(f"Senha: {usuario_consulta[3]}")
        print(f"CPF: {usuario_consulta[4]}")
        print(f"Data de Nascimento: {usuario_consulta[5]}")
        print(f"Idade: {usuario_consulta[6]}")
        print(f"Telefone: {usuario_consulta[7]}")
        print(f"Cidade: {usuario_consulta[8]}")
        print(f"Bairro: {usuario_consulta[9]}")
        print(f"Logradouro: {usuario_consulta[10]}")
        print(f"UF: {usuario_consulta[11]}")
    else:
        print("Usuário não encontrado.")

def consultar_produtos(cursor):
    """Lista todos os produtos cadastrados na tabela T_DESCARTE, mostrando nome e categoria."""
    print("Listando produtos...")

    # Comando SQL para buscar todos os produtos na tabela T_DESCARTE
    query = '''SELECT nome_produto, categoria_produto FROM T_DESCARTE'''

    cursor.execute(query)
    produtos = cursor.fetchall()

    if produtos:
        print(f"{'Nome do Produto':<30} {'Categoria do Produto':<20}")
        print("-" * 50)
        for produto in produtos:
            nome_produto, categoria_produto = produto
            print(f"{nome_produto:<30} {categoria_produto:<20}")
    else:
        print("Nenhum produto encontrado.")

def listar_usuarios(cursor):
    """Lista todos os usuários cadastrados."""
    cursor.execute("SELECT * FROM USUARIO_ELECTRY")
    usuarios = cursor.fetchall()

    if usuarios:
        for usuario in usuarios:
            print(f"ID: {usuario[0]}, Nome: {usuario[1]}, E-mail: {usuario[2]}, Idade: {usuario[6]}")
    else:
        print("Nenhum usuário encontrado.")

def gerar_json_por_idade(cursor, conexao):
    try:
        
        idade_desejada = input("Digite a idade desejada: ").strip()
        
        if not idade_desejada.isdigit() or int(idade_desejada) <= 0:
            print("Por favor, insira uma idade válida (número positivo).")
            return

        
        cursor.execute('''SELECT nome_completo, email, data_nascimento, cidade, idade 
                       FROM USUARIO_ELECTRY 
                       WHERE idade = :idade_desejada''', 
                       {'idade_desejada': int(idade_desejada)})
    
        resultados = cursor.fetchall()

        if not resultados:
            print(f"Nenhum usuário encontrado com idade de {idade_desejada} anos.")
            return
    
        dados_filtrados_df = pd.DataFrame(resultados, columns=['nome_completo', 'email', 'data_nascimento', 'cidade', 'idade'])

        dados_json = dados_filtrados_df.to_json(orient='records', date_format='iso')

        nome_arquivo = f"Usuarios_por_idade_{idade_desejada}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.json"

        with open(nome_arquivo, "w", encoding="utf-8") as json_file:
            json_file.write(dados_json)

        print(f"Arquivo {nome_arquivo} gerado!")
    
    except Exception as e:
        print("Erro ao gerar JSON com filtro de idade:", e)

def gerar_excel(cursor, conexao):
    try:
        inicial_filtro = input("Digite a sigla da cidade desejada (Ex. 'SP','RJ','BH'): ").strip()  
        
        if len(inicial_filtro) != 2:
            print("Por favor, insira uma sigla válida, com exatamente 2 caracteres.")
            return  

        cursor.execute('SELECT nome_completo, email, data_nascimento, cidade FROM USUARIO_ELECTRY WHERE uf = :uf', {'uf': inicial_filtro})
        resultados = cursor.fetchall()

        if not resultados:
            print(f"Nenhuma cidade encontrada com a sigla '{inicial_filtro}'.")
            return  

        dados_filtrados_df = pd.DataFrame(resultados, columns=['nome_completo', 'email', 'data_nascimento', 'cidade'])

        nome_arquivo = f"Cidade_filtrados_{inicial_filtro}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"

        dados_filtrados_df.to_excel(nome_arquivo, index=False)  
        print(f"Arquivo {nome_arquivo} gerado!")

        print(dados_filtrados_df)

    except Exception as e:
        print("Erro ao filtrar cidades: ", e)

def gerar_json_por_categoria(cursor, conexao):
    try:
        categoria = input("Digite o nome da categoria do produto: ").strip().upper()

        if not categoria.isalpha() or len(categoria) == 0:
            print("Por favor, insira uma categoria válida.")
            return

        cursor.execute('''
            SELECT NOME_PRODUTO, CATEGORIA_PRODUTO, PONTUACAO_PRODUTO, ID_USUARIO, DATA_CADASTRO
            FROM T_DESCARTE
            WHERE UPPER(CATEGORIA_PRODUTO) = :categoria
        ''', {'categoria': categoria})

        resultados = cursor.fetchall()

        if not resultados:
            print(f"Nenhum produto encontrado na categoria '{categoria}'.")
            return

        # Converte os resultados para um DataFrame do pandas
        dados_filtrados_df = pd.DataFrame(resultados, columns=['nome_produto', 'categoria_produto', 'pontuacao_produto', 'id_usuario', 'data_cadastro'])

        # Converte o DataFrame para JSON
        dados_json = dados_filtrados_df.to_json(orient='records', date_format='iso')

        # Define o nome do arquivo com base na categoria e data/hora
        nome_arquivo = f"Produtos_por_categoria_{categoria}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.json"

        # Salva o JSON em um arquivo
        with open(nome_arquivo, "w", encoding="utf-8") as json_file:
            json_file.write(dados_json)

        print(f"Arquivo {nome_arquivo} gerado!")
        print(dados_json)

    except Exception as e:
        print("Erro ao gerar JSON com filtro de categoria: ", e)

def deletar_produto(cursor, nome_produto,id_usuario_logado):
    try:
        # Consulta para deletar o produto pelo nome
        cursor.execute('''
            DELETE FROM T_DESCARTE
            WHERE NOME_PRODUTO = :nome_produto AND ID_USUARIO = :id_usuario
        ''', {'nome_produto': nome_produto, 'id_usuario': id_usuario_logado})

        # Commit para garantir que a mudança seja aplicada no banco de dados
        cursor.connection.commit()

        # Verificando quantas linhas foram afetadas (se um produto foi deletado)
        if cursor.rowcount > 0:
            print(f"Produto '{nome_produto}' deletado com sucesso.")
        else:
            print(f"Produto '{nome_produto}' não encontrado.")
    
    except Exception as e:
        print("Erro ao deletar o produto:", e)
        cursor.connection.rollback()

def buscar_produto_por_nome(cursor, nome_produto,id_usuario_logado):
    try:
        # Consulta para buscar o produto pelo nome
        cursor.execute('''
            SELECT ID_DESCARTE, NOME_PRODUTO, CATEGORIA_PRODUTO, PONTUACAO_PRODUTO, DATA_CADASTRO
            FROM T_DESCARTE
            WHERE NOME_PRODUTO = :nome_produto AND ID_USUARIO = :id_usuario
        ''', {'nome_produto': nome_produto, 'id_usuario': id_usuario_logado})

        # Recuperando o resultado
        produto = cursor.fetchone()

        if produto:
            print(f"Produto encontrado: \n")
            print(f"ID: {produto[0]}")
            print(f"Nome: {produto[1]}")
            print(f"Categoria: {produto[2]}")
            print(f"Pontuação: {produto[3]}")
            print(f"Data de Cadastro: {produto[4]}")
        else:
            print(f"Produto '{nome_produto}' não encontrado.")
    
    except Exception as e:
        print("Erro ao buscar o produto:", e)

def alterar_produto_por_nome(cursor, conexao, nome_produto, id_usuario_logado):
    try:
        # Solicitar o novo nome e a nova categoria para o produto
        novo_nome = input("Informe o novo nome do produto: ")
        nova_categoria = input("Informe a nova categoria do produto: ")

        # Atualizar os dados do produto vinculado ao ID da pessoa
        cursor.execute('''
            UPDATE T_DESCARTE
            SET NOME_PRODUTO = :novo_nome, CATEGORIA_PRODUTO = :nova_categoria
            WHERE NOME_PRODUTO = :nome_produto AND ID_USUARIO = :id_usuario
        ''', {'novo_nome': novo_nome, 'nova_categoria': nova_categoria, 'nome_produto': nome_produto, 'id_usuario': id_usuario_logado})

        # Confirmar a atualização no banco
        conexao.commit()

        if cursor.rowcount > 0:
            print(f"Produto '{nome_produto}' atualizado com sucesso para '{novo_nome}' na categoria '{nova_categoria}'.")
        else:
            print(f"Produto '{nome_produto}' não encontrado para o ID da pessoa '{id_usuario_logado}' ou não foi alterado.")
    
    except Exception as e:
        print("Erro ao alterar o produto:", e)

def main():
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
                            match opcao_secundaria :
                                case "1" :
                                    atualizar_usuario(cursor, conexao)     
                                case "2":                           
                                    excluir_usuario(cursor, conexao)
                                case "3":
                                    consultar_usuario(cursor)   
                                case "4":
                                    buscar_token_por_nome(cursor, nome_usuario_logado)
                                case "5":
                                    print("\n=== PREVISÃO DE PRODUTO ===")
                                    print("1. Cadastrar produto")
                                    print("2. Buscar produtos ")
                                    print("3. deletar produto ")
                                    print("4. Alterar dados de um produto ")
                                    print("5. Voltar ao menu")
                                    opcao_previsao = input("Escolha uma opção: ")
                                    match opcao_previsao :
                                        case "1" :
                                            cadastrar_produto(cursor, conexao)
                                        case "2" :
                                            nome_produto = input("Nome do produto que deseja buscar: ")
                                            buscar_produto_por_nome(cursor,nome_produto,id_usuario_logado)
                                        case "3" :
                                            nome_produto = input("Nome do produto que deseja deletar: ")
                                            deletar_produto(cursor, nome_produto,id_usuario_logado)
                                        case "4":
                                            nome_produto = input("Nome do produto que deseja alterar: ")
                                            alterar_produto_por_nome(cursor, conexao, nome_produto,id_usuario_logado)
                                        case "5":
                                            break
                                        case default:
                                            print("Opção inválida")
                                case "6":
                                    break
                                case default:
                                    print("Opção inválida.")
            elif opcao == "3":
                print("1 - JSON | IDADE")
                print("2 - EXEL | CIDADES ")
                print("3 - JSON | CATEGORIAS ")

                print("4 - SAIR")
                opcao3 = input("Escolha uma opção: ")
                while True:
                    if opcao3 == "1":
                        gerar_json_por_idade(cursor,conexao)
                        break
                    elif opcao3 == "2":
                        gerar_excel(cursor, conexao)
                        break
                    elif opcao3 == "3":
                        gerar_json_por_categoria(cursor,conexao)
                        break
                    elif opcao3 == "4":
                        break
                    else:
                        print("Opção Invalida! ")
            elif opcao == "4":
                listar_usuarios(cursor)
            elif opcao == "5":
                consultar_produtos(cursor)
            elif opcao == "6":
                print("Saindo...")
                break
            else:
                print("Opção inválida.")
    except Exception as e:
        print(f"Ocorreu um erro: {e}")
    finally:
        cursor.close()
        conexao.close()

if __name__ == "__main__":
    main()
