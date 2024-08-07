import os
import re

# Função para limpar a tela
def limpar_tela():
    os.system("cls" if os.name == "nt" else "clear")

# Função para exibir o menu principal
def exibir_menu():
    print("""
    Menu Principal:
    1- Criar um cadastro 
    2- Logar com um cadastro 
    3- Diagnosticar um problema ou falar com ChatBot
    4- Sair 
    """)

# Função para validar a opção do menu
def validar_opcao(opcao):
    if opcao.isdigit() and 1 <= int(opcao) <= 4:
        return True
    else:
        return False

# Função para validar nome completo com regex
def validar_nome(nome):
    # Regex para validar nome completo
    return bool(re.match(r'^[a-zA-ZÀ-ÿ\u00C0-\u017F]+([-\'\s]?[a-zA-ZÀ-ÿ\u00C0-\u017F]+)*$', nome.strip()))

# Função para validar e-mail com regex
def validar_email(email):
    # Regex para validar e-mail
    return bool(re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', email.strip()))

# Função para validar senha com regex
def validar_senha(senha):
    # Regex para validar senha
    return bool(re.match(r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$', senha.strip()))

# Função para criar um cadastro
def criar_cadastro():
    print("Criando Login...")
    # Coletando o nome completo
    while True:
        nome_completo = input("Nome completo: ")
        if validar_nome(nome_completo):
            break
        else:
            print("O nome completo não está no formato válido. Por favor, tente novamente.")

    # Coletando o e-mail
    while True:
        email = input("E-mail: ")
        if validar_email(email):
            break
        else:
            print("O e-mail não está no formato válido. Por favor, tente novamente.")

    # Coletando a senha
    while True:
        senha = input("Senha: ")
        if validar_senha(senha):
            break
        else:
            print("A senha não está no formato válido. Por favor, tente novamente.")

    # Coletando a data de nascimento
    while True:
        try:
            data_nascimento_dia = int(input("Dia de seu nascimento (1-31): "))
            if 1 <= data_nascimento_dia <= 31:
                break
            else:
                print("Digite um dia de nascimento válido (1-31).")
        except ValueError:
            print("Por favor, insira um número válido para o dia.")

    while True:
        try:
            data_nascimento_mes = int(input("Mês de seu nascimento (1-12): "))
            if data_nascimento_dia > 29 and data_nascimento_mes == 2:
                print("Fevereiro não tem dia 30 e 31.")
            elif 1 <= data_nascimento_mes <= 12:
                break
            else:
                print("Digite um mês de nascimento válido (1-12).")
        except ValueError:
            print("Por favor, insira um número válido para o mês.")

    while True:
        try:
            data_nascimento_ano = int(input("Ano de seu nascimento: "))
            if 1906 < data_nascimento_ano <= 2024:
                break
            else:
                print("Digite um ano de nascimento válido.")
        except ValueError:
            print("Por favor, insira um número válido para o ano.")

    # Conferindo o cadastro
    print(f"""
    Nome Completo: {nome_completo}
    Email: {email}
    Data de Nascimento: {data_nascimento_dia}/{data_nascimento_mes}/{data_nascimento_ano}
    """)
    resposta = input("Está correto? (S/N): ").upper()
    while resposta == 'N':
        print("""
        Qual das opções abaixo está errada? 
        1- Nome Completo
        2- E-mail
        3- Data de Nascimento
        """)
        sub_opcao = int(input("Escolha uma opção: "))

        if sub_opcao == 1:
            while True:
                nome_completo = input("Nome completo: ")
                if validar_nome(nome_completo):
                    break
                else:
                    print("O nome completo não está no formato válido. Por favor, tente novamente.")
        elif sub_opcao == 2:
            while True:
                email = input("E-mail: ")
                if validar_email(email):
                    break
                else:
                    print("O e-mail não está no formato válido. Por favor, tente novamente.")
        elif sub_opcao == 3:
            while True:
                try:
                    data_nascimento_dia = int(input("Dia de nascimento (1-31): "))
                    if 1 <= data_nascimento_dia <= 31:
                        break
                    else:
                        print("Digite um dia de nascimento válido (1-31).")
                except ValueError:
                    print("Por favor, insira um número válido para o dia.")

            while True:
                try:
                    data_nascimento_mes = int(input("Mês de seu nascimento (1-12): "))
                    if data_nascimento_dia > 29 and data_nascimento_mes == 2:
                        print("Fevereiro não tem dia 30 e 31.")
                    elif 1 <= data_nascimento_mes <= 12:
                        break
                    else:
                        print("Digite um mês de nascimento válido (1-12).")
                except ValueError:
                    print("Por favor, insira um número válido para o mês.")

            while True:
                try:
                    data_nascimento_ano = int(input("Ano de nascimento: "))
                    if 1906 < data_nascimento_ano <= 2024:
                        break
                    else:
                        print("Digite seu verdadeiro ano de nascimento.")
                except ValueError:
                    print("Por favor, insira um número válido para o ano.")

        print(f"""
    Nome: {nome_completo}
    Email: {email}
    Data de Nascimento: {data_nascimento_dia}/{data_nascimento_mes}/{data_nascimento_ano}
        """)
        resposta = input("Está correto? (S/N): ").upper()

    print("Cadastro criado com sucesso!")
    return nome_completo, email, senha

# Função para logar com um cadastro
def logar_cadastro(nome_completo, email, senha):
    print("Logar com um cadastro...")
    if not (nome_completo or email or senha):
        print("Faça um cadastro antes de logar na sua")

    # Verificando se o usuário inseriu nome completo ou e-mail
    while True:
        usuario = input("Usuário (Nome Completo ou E-mail): ")
        if usuario.strip():
            break
        else:
            print("O usuário (nome completo ou e-mail) não pode estar vazio. Por favor, tente novamente.")

    # Verificando se o usuário inseriu a senha
    while True:
        senha_cliente = input("Senha: ")
        if senha_cliente.strip():
            break
        else:
            print("A senha não pode estar vazia. Por favor, tente novamente.")

    # Verificar se o usuário e senha estão corretos
    if (usuario == nome_completo or usuario == email) and senha_cliente == senha:
        print("Login realizado com sucesso!")
    else:
        print("Usuário ou senha incorretos.")

# Função para diagnosticar um problema ou falar com ChatBot
def diagnosticar_problema_chatbot():
    print("Diagnosticar um problema ou falar com o ChatBot...")
    while True:
        print("""
    Escolha uma das opções abaixo:
    1- Diagnóstico de problema
    2- Falar com ChatBot
    3- Voltar ao menu principal!
        """)
        sub_opcao_3 = int(input("Opção: "))

        # Diagnóstico de problema
        if sub_opcao_3 == 1:
            print("Descreva o problema que está enfrentando:")
            problema = input()
            print("Obrigado por descrever o problema! Vamos analisar e entrar em contato em breve.")

        # Falar com ChatBot
        elif sub_opcao_3 == 2:
            print("Você pode fazer uma pergunta ou conversar com o ChatBot.")
            pergunta = input("Pergunta: ")
            print(f"ChatBot: Você perguntou '{pergunta}', mas o ChatBot ainda não foi implementado!")

        # Voltar ao menu principal
        elif sub_opcao_3 == 3:
            print("Voltando ao menu principal...")
            break

        else:
            print("Opção inválida! Por favor, escolha uma opção válida.")

# Início do programa
print("Iniciando o App...")

while True:
    exibir_menu()
    opcao = input("Opção: ")
    if validar_opcao(opcao):
        opcao = int(opcao)
        if opcao == 1:
            nome_completo, email, senha = criar_cadastro()
        elif opcao == 2:
            logar_cadastro(nome_completo, email, senha)
        elif opcao == 3:
            diagnosticar_problema_chatbot()
        elif opcao == 4:
            print("Saindo do aplicativo...")
            break
    else:
        print("Digite um número válido! (1 a 4)")
