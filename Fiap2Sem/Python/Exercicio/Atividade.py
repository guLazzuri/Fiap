#GUSTAVO RAMIRES LAZZURI | RM556772
import json

# Criação do arquivo dados.txt
with open('dados.txt', 'w', encoding='utf-8') as arq:
    arq.write('12345t, edson@fiap.com.br\n')
    arq.write('01020d, maria@hotmail.com\n')
    arq.write('1abcde, estela@ig.com.br\n')
    arq.write('123abd, vania@terra.com.br\n')
    arq.write('1abcde, estela@ig.com.br\n')

def dividir_arquivo(arquivo_):
    with open(arquivo_, 'r', encoding='utf-8') as f:
        linhas = f.readlines()

    logins = []
    emails = []

    for linha in linhas:
        linha = linha.strip()
        if linha:  
            partes = linha.split(', ')
            logins.append(partes[0])  
            emails.append(partes[1])
            
            with open('login.txt', 'w', encoding='utf-8') as f1:
                f1.writelines("\n".join(logins) + "\n") 

            with open('emails.txt', 'w', encoding='utf-8') as f2:
                f2.writelines("\n".join(emails) + "\n")  

    dados_dict = {
        "logins": logins,
        "emails": emails
    }

   
    with open('dados.json', 'w', encoding='utf-8') as f:
        json.dump(dados_dict, f, indent=4)

    return dados_dict

dados_dict = dividir_arquivo('dados.txt')

with open('dados.json', 'r', encoding='utf-8') as f:
    print("dados.json")
    print(f.read())
