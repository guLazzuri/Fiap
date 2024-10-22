import os
import re

import os
os.system("cls" if os.name == "nt" else "clear")

#       NOME                   |      RM     |   SALA
# Felipe Rodrigues Moreira     |    555121   |  1TDSPX
# Gustavo Ramires Lazzuri      |    556772   |  1TDSPI
# Natasha Lopes Rocha Oliveira |    554816   |  1TDSPI

# Função para exibir o menu principal

def exibir_menu_principal():
    print("""
    Menu Principal:
    1- Criar um cadastro 
    2- Logar com um cadastro 
    3- Diagnosticar um problema ou falar com ChatBot
    4- Mostrar cadastros
    5- Sair 
    """)

# Função para exibir o menu secundário (somente se logado)
def exibir_menu_secundario():
    print("""
    Menu Secundário:
    1- Adicionar carro
    2- Editar carro
    3- Excluir carro
    4- Mostrar carros
    5- Voltar ao menu principal
    """)

# Função para validar a opção do menu
def validar_opcao(opcao, limite):
    return opcao.isdigit() and 1 <= int(opcao) <= limite

# Função para validar nome completo com regex
def validar_nome(nome):
    return bool(re.match(r'^[a-zA-ZÀ-ÿ\u00C0-\u017F]+([-\'\s]?[a-zA-ZÀ-ÿ\u00C0-\u017F]+)*$', nome.strip()))

# Função para validar e-mail com regex
def validar_email(email):
    return bool(re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', email.strip()))

# Função para validar senha com regex
def validar_senha(senha):
    return bool(re.match(r'^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d\W]{8,}$', senha.strip()))

# Lista para armazenar cadastros e carros
cadastros = []
carros = []

# Função para criar um cadastro
def criar_cadastro():
    print("Criando Login...")
    while True:
        nome_completo = input("Nome completo: ")
        if validar_nome(nome_completo):
            break
        else:
            print("O nome completo não está no formato válido. Por favor, tente novamente.")

    while True:
        email = input("E-mail: ")
        if validar_email(email):
            break
        else:
            print("O e-mail não está no formato válido. Por favor, tente novamente.")

    while True:
        senha = input("Senha: ")
        if validar_senha(senha):
            break
        else:
            print("A senha não está no formato válido. Por favor, tente novamente.")
            print("A senha deve conter uma letra maiúscula, uma letra minúscula, um número e no mínimo 8 caracteres.")

    cadastro = {
        "nome_completo": nome_completo,
        "email": email,
        "senha": senha,
    }
    cadastros.append(cadastro)
    print("Cadastro criado com sucesso!")

# Função para logar com um cadastro
def logar_cadastro():
    print("Logar com um cadastro...")
    if not cadastros:
        print("Faça um cadastro antes de logar.")
        return False

    while True:
        usuario = input("Usuário (Nome Completo ou E-mail): ")
        if usuario.strip():
            break
        else:
            print("O usuário (nome completo ou e-mail) não pode estar vazio. Por favor, tente novamente.")

    while True:
        senha_cliente = input("Senha: ")
        if senha_cliente.strip():
            break
        else:
            print("A senha não pode estar vazia. Por favor, tente novamente.")

    for cadastro in cadastros:
        if (usuario == cadastro["nome_completo"] or usuario == cadastro["email"]) and senha_cliente == cadastro["senha"]:
            print("Login realizado com sucesso!")
            return True
    
    print("Usuário ou senha incorretos.")
    return False

# Função para adicionar carro
def adicionar_carro():
    print("Adicionar novo carro")
    marca = input("Marca: ")
    modelo = input("Modelo: ")
    ano = input("Ano: ")
    cor = input("Cor: ")
    placa = input("Placa: ")

    carro = {
        "marca": marca,
        "modelo": modelo,
        "ano": ano,
        "cor": cor,
        "placa": placa
    }
    carros.append(carro)
    print("Carro adicionado com sucesso!")

# Função para editar carro
def editar_carro():
    if not carros:
        print("Não há carros para editar.")
        return
    
    placa = input("Digite a placa do carro que deseja editar: ")
    for carro in carros:
        if carro["placa"] == placa:
            print(f"Editando carro {carro['marca']} {carro['modelo']}")
            print("Caso deseja manter deixe o espaco em branco")
            carro["marca"] = input("Nova marca: ") or carro["marca"]
            carro["modelo"] = input("Novo modelo: ") or carro["modelo"]
            carro["ano"] = input("Novo ano: ") or carro["ano"]
            carro["cor"] = input("Nova cor: ") or carro["cor"]
            print("Carro editado com sucesso!")
            return
    
    print("Carro não encontrado.")

# Função para excluir carro
def excluir_carro():
    if not carros:
        print("Não há carros para excluir.")
        return
    
    placa = input("Digite a placa do carro que deseja excluir: ")
    for carro in carros:
        if carro["placa"] == placa:
            carros.remove(carro)
            print("Carro excluído com sucesso!")
            return
    
    print("Carro não encontrado.")

# Função para mostrar carros
def mostrar_carros():
    if not carros:
        print("Não há carros cadastrados.")
        return
    
    print("Carros cadastrados:")
    for carro in carros:
        print(f"Marca: {carro['marca']}, Modelo: {carro['modelo']}, Ano: {carro['ano']}, Cor: {carro['cor']}, Placa: {carro['placa']}")

# Função para diagnosticar um problema ou falar com ChatBot
def diagnosticar_problema_chatbot():
    print("Diagnosticar um problema ou falar com o ChatBot...")
    while True:
        print("""
    Escolha uma das opções abaixo:
    1- Diagnóstico de problema
    2- Falar com ChatBot
    3- Voltar ao menu principal
        """)
        sub_opcao = input("Opção: ")

        if validar_opcao(sub_opcao, 3):
            sub_opcao = int(sub_opcao)

            if sub_opcao == 1:
                print("Descreva o problema que está enfrentando:")
                problema = input()
                print("Obrigado por descrever o problema! Vamos analisar e entrar em contato em breve.")
            elif sub_opcao == 2:
                print("Você pode fazer uma pergunta ou conversar com o ChatBot.")
                pergunta = input("Pergunta: ")
                print(f"ChatBot: Você perguntou '{pergunta}', mas o ChatBot ainda não foi implementado!")
            elif sub_opcao == 3:
                break
        else:
            print("Opção inválida! Por favor, escolha uma opção válida.")

# Função para mostrar todos os cadastros
def mostrar_cadastros():
    if not cadastros:
        print("Não há cadastros para mostrar.")
        return

    print("Cadastros:")
    for cadastro in cadastros:
        print(f"Nome Completo: {cadastro['nome_completo']}, Email: {cadastro['email']}")

# Início do programa
def main():
    print("Iniciando o App...")

    sessao_logada = False
    while True:
        if not sessao_logada:
            exibir_menu_principal()
            opcao = input("Opção: ")

            if validar_opcao(opcao, 5):
                opcao = int(opcao)
                if opcao == 1:
                    criar_cadastro()
                elif opcao == 2:
                    if logar_cadastro():
                        sessao_logada = True
                        while sessao_logada:
                            exibir_menu_secundario()
                            opcao_sec = input("Opção: ")
                            if validar_opcao(opcao_sec, 5):
                                opcao_sec = int(opcao_sec)
                                if opcao_sec == 1:
                                    adicionar_carro()
                                elif opcao_sec == 2:
                                    editar_carro()
                                elif opcao_sec == 3:
                                    excluir_carro()
                                elif opcao_sec == 4:
                                    mostrar_carros()
                                elif opcao_sec == 5:
                                    sessao_logada = False
                                    print("Voltando ao menu principal...")
                            else:
                                print("Digite um número válido! (1 a 5)")
                elif opcao == 3:
                    diagnosticar_problema_chatbot()
                elif opcao == 4:
                    mostrar_cadastros()
                elif opcao == 5:
                    print("Saindo do aplicativo...")
                    break
            else:
                print("Digite um número válido! (1 a 5)")


###########################################################################################################

main()
