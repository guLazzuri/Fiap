import os
os.system("cls")

print("Iniciando o App...")

while True:
    while True:
        print("""
Digite uma das opções abaixo e prossiga!
    1- Criar um cadastro 
    2- Logar um cadastro 
    3- Diagnosticar um problema ou falar com ChatBot
    4- Sair 
    """)
        opcao = input("Opção: ")    
        if (opcao.isdigit() and int(opcao) > 0 and int(opcao) <= 4 ):
            opcao = int(opcao)
            break;
        
        else:
            print("Digite um numero valido ! (1 a 4)")
            
    # Opção 1: Criando um cadastro
    if opcao == 1:
        print("Criando Login...")

        # Coletando o nome completo
        while True:
            nomeCompleto = input("Nome completo: ")
            if nomeCompleto.strip():
                break
            else:
                print("O nome completo não pode estar vazio. Por favor, tente novamente.")

        # Coletando o e-mail
        while True:
            email = input("E-mail: ")
            if email.strip():
                break
            else:
                print("O e-mail não pode estar vazio. Por favor, tente novamente.")

        # Coletando a senha
        while True:
            senha = input("Senha: ")
            if senha.strip():
                break
            else:
                print("A senha não pode estar vazia. Por favor, tente novamente.")

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
                    print("Fevereiro nao tem dia 30 e 31.")
                elif 1 <= data_nascimento_mes <= 12:
                    break
                else:
                    print("Digite um mês de nascimento válido (1-12).")
            except ValueError:
                print("Por favor, insira um número válido para o mês.")
            

        while True:
            try:
                data_nascimento_ano = int(input("Ano de seu nascimento: "))
                if 0 < data_nascimento_ano <= 2024:
                    break
                else:
                    print("Digite um ano de nascimento válido.")
            except ValueError:
                print("Por favor, insira um número válido para o ano.")

        # Conferindo o cadastro
        print(f"""
        Nome Completo: {nomeCompleto}
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
                    nomeCompleto = input("Nome completo: ")
                    if nomeCompleto.strip():
                        break
                    else:
                        print("O nome completo não pode estar vazio. Por favor, tente novamente.")
            elif sub_opcao == 2:
                while True:
                    email = input("E-mail: ")
                    if email.strip():
                        break
                    else:
                        print("O e-mail não pode estar vazio. Por favor, tente novamente.")
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
                        data_nascimento_mes = int(input("Mês de nascimento (1-12): "))
                        if 1 <= data_nascimento_mes <= 12:
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
    Nome: {nomeCompleto}
    Email: {email}
    Data de Nascimento: {data_nascimento_dia}/{data_nascimento_mes}/{data_nascimento_ano}
            """)
            resposta = input("Está correto? (S/N): ").upper()
        
        print("Cadastro criado com sucesso!")

        
        print("Cadastro criado com sucesso!")


    # Opção 2: Logar um cadastro
    elif opcao == 2:
        print("Logar um cadastro...")

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
        if (usuario == nomeCompleto or usuario == email) and senha_cliente == senha:
            print("Login realizado com sucesso!")
        else:
            print("Usuário ou senha incorretos.")

    # Opção 3: Diagnosticar um problema ou falar com ChatBot
    
    elif opcao == 3:

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

    # Opção 4: Sair
    elif opcao == 4:
        print("Saindo do aplicativo...")
        break
    else:
        print("Opção inválida! Por favor, escolha uma opção válida.")