import os
import pandas as pd
import oracledb
from datetime import datetime

os.system("cls")

try:
    conn = oracledb.connect(user="RM556772", password="051205", dsn='oracle.fiap.com.br:1521/ORCL')
    inst_cadastro = conn.cursor()
    inst_consulta = conn.cursor()
except Exception as e:
    print("Erro ao conectar ao banco de dados: ", e)
    conexao = False
else:
    conexao = True

while conexao:
    print("------- CRUD - CADASTRO ARTISTA -------")
    print(""" 
    0 - SAIR 
    1 - Cadastrar Artista 
    2 - Listar/Exportar Artista 
    3 - Filtrar Artista por Inicial do Nome 
    4 - Filtrar Artista por Idade 
    """)

    escolha = input("Escolha -> ")

    if escolha.isdigit():
        escolha = int(escolha)
    else:
        escolha = 0
        print("Digite um número. Reinicie a Aplicação!")

    os.system('cls')  

    match escolha:
        case 0:
            break
        case 1:
            try:
                print("----- CADASTRAR -----")
                cpf = input("Digite o cpf....: ")
                nome = input("Digite o nome....: ")
                email = input("Digite o email....: ")
                tel = input("Digite o telefone....: ")
                nascimento_aux = input("Digite a data de seu nascimento(DD/MM/AAAA)...: ")

                try:
                    nascimento = datetime.strptime(nascimento_aux, "%d/%m/%Y")
                except ValueError:
                    print("Data no formato incorreto. Use o formato DD/MM/AAAA.")
                    continue  

                idade = int(input("Digite a idade...: "))
                cadastro = """INSERT INTO CADASTRO_PY (cpf, nome, email, tel, nascimento, idade) 
                              VALUES (:cpf, :nome, :email, :tel, TO_DATE(:nascimento, 'DD/MM/YYYY'), :idade)""" 
                
                inst_cadastro.execute(cadastro, {
                    'cpf': cpf,
                    'nome': nome,
                    'email': email,
                    'tel': tel,
                    'nascimento': nascimento_aux,  
                    'idade': idade
                })
                conn.commit()
                print("##### Dados GRAVADOS #####")
            except ValueError as ve:
                print("Erro: ", ve) 
            except Exception as e:
                print("Erro na transação do BD: ", e) 

        case 2:
            print("----- LISTAR ARTISTAS -----")
            lista_dados = [] 

            inst_consulta.execute('SELECT * FROM CADASTRO_PY')
            data = inst_consulta.fetchall()
 
            for dt in data:
                lista_dados.append(dt)

            dados_df = pd.DataFrame(lista_dados, columns=['Cpf', 'Nome', 'Email', 'Telefone', 'Nascimento', 'Idade'])

            if dados_df.empty:
                print("Não há um usuário cadastrado!")
            else:
                nome_arquivo = f"lista_artistas_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
                dados_df.to_excel(nome_arquivo, index=False)  
                print(f"Arquivo {nome_arquivo} gerado!")

                print(dados_df)

            print("##### LISTADOS! #####")

        case 3:
            try:
                inicial_filtro = input("Digite a inicial do nome para filtrar: ").strip()  
                if len(inicial_filtro) == 0:
                    print("Por favor, insira uma inicial válida.")
                    continue  

                inst_consulta.execute('SELECT * FROM CADASTRO_PY WHERE nome LIKE :nome', {'nome': f'{inicial_filtro}%'})
                resultados = inst_consulta.fetchall()

                if not resultados:
                    print(f"Nenhum artista encontrado com nomes iniciando com '{inicial_filtro}'.")
                else:
                    dados_filtrados_df = pd.DataFrame(resultados, columns=['Cpf', 'Nome', 'Email', 'Telefone', 'Nascimento', 'Idade'])

                    nome_arquivo = f"artistas_filtrados_{inicial_filtro}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
                    dados_filtrados_df.to_excel(nome_arquivo, index=False)  
                    print(f"Arquivo {nome_arquivo} gerado!")

                    print(dados_filtrados_df)

            except Exception as e:
                print("Erro ao filtrar artistas: ", e)

        case 4:
            try:
                idade_filtro = input("Digite a idade para filtrar: ")
                if not idade_filtro.isdigit():
                    print("Por favor, insira um número válido para a idade.")
                    continue
                
                idade_filtro = int(idade_filtro)

                inst_consulta.execute('SELECT * FROM CADASTRO_PY WHERE idade = :idade', {'idade': idade_filtro})
                resultados = inst_consulta.fetchall()

                if not resultados:
                    print(f"Nenhum artista encontrado com a idade {idade_filtro}.")
                else:
                    dados_filtrados_df = pd.DataFrame(resultados, columns=['Cpf', 'Nome', 'Email', 'Telefone', 'Nascimento', 'Idade'])

                    nome_arquivo = f"artistas_idade_{idade_filtro}_{datetime.now().strftime('%Y%m%d_%H%M%S')}.xlsx"
                    dados_filtrados_df.to_excel(nome_arquivo, index=False)  
                    print(f"Arquivo {nome_arquivo} gerado!")

                    print(dados_filtrados_df)

            except Exception as e:
                print("Erro ao filtrar artistas por idade: ", e)

inst_cadastro.close()
inst_consulta.close()
conn.close()
