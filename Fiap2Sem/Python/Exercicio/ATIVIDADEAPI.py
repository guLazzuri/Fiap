import requests
import os

os.system("cls")

API_URL = "https://www.omdbapi.com/"
API_KEY = "bf8d62ac"

comentarios = {}

def buscar_filme(titulo):
    response = requests.get(API_URL, params={"t": titulo, "apikey": API_KEY})
    
    if response.status_code == 200:  
        filme = response.json()  
        if filme.get('Response') == "True":  
            print(f"\nTítulo: {filme['Title']}")
            print(f"Ano: {filme['Year']}")
            print(f"Gênero: {filme['Genre']}")
            return filme['Title'] 
    print("\nFilme não encontrado ou erro ao buscar.")
    return None  

def adicionar_comentario(titulo):
    comentario = input("Digite seu comentário: ") 
    if titulo in comentarios:  
        comentarios[titulo].append(comentario)  
    else:
        comentarios[titulo] = [comentario] 
    print("Comentário adicionado!")

def mostrar_comentarios(titulo):
    if titulo in comentarios:  
        print("\nComentários:")
        for comentario in comentarios[titulo]:  
            print(f"- {comentario}") 
    else:
        print("\nNenhum comentário disponível.")  

def main():
    while True:
        print("\n--- Menu ---")
        escolha = input("1. Buscar Filme\n2. Adicionar Comentário\n3. Mostrar Comentários\n4. Sair\nEscolha: ")
        
        if escolha == "1":
            titulo = input("Digite o título do filme: ")
            buscar_filme(titulo)  
        elif escolha == "2":
            titulo = input("Digite o título do filme: ")
            if buscar_filme(titulo):  
                adicionar_comentario(titulo)  
        elif escolha == "3":
            titulo = input("Digite o título do filme: ")
            mostrar_comentarios(titulo)  
        elif escolha == "4":
            print("Saindo do programa.")
            break  
        else:
            print("Opção inválida.")  

main()
