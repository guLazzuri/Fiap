import os 
os.system("cls")
 
# Contadores
total_votos = 0
votos_candidato1 = 0
votos_candidato2 = 0
votos_candidato3 = 0
 
# Função para conduzir a eleição
def conduzir_eleicao():
    global total_votos, votos_candidato1, votos_candidato2, votos_candidato3
    for _ in range(1, 11, 1):  # Controla o número máximo de eleitores
        print("MENU DE ELEIÇÃO:")
        print("1. Votar no Candidato 1")
        print("2. Votar no Candidato 2")
        print("3. Votar no Candidato 3")
        print("4. Encerrar a votação")
        escolha = input("Digite sua escolha: ")
 
        if escolha == '1':
            votos_candidato1 += 1
            total_votos += 1
            print("Voto para o Candidato 1 registrado com sucesso!")
        elif escolha == '2':
            votos_candidato2 += 1
            total_votos += 1
            print("Voto para o Candidato 2 registrado com sucesso!")
        elif escolha == '3':
            votos_candidato3 += 1
            total_votos += 1
            print("Voto para o Candidato 3 registrado com sucesso!")
        elif escolha == '4':
            os.system("cls")
            print("=== RESULTADOS DA ELEIÇÃO ===")
            print("Total de votos registrados:", total_votos)
            print("Votos para o Candidato 1:", votos_candidato1)
            print("Votos para o Candidato 2:", votos_candidato2)
            print("Votos para o Candidato 3:", votos_candidato3)
           
            # Calcular porcentagem de votos de cada candidato
            porcentagem_candidato1 = (votos_candidato1 / total_votos) * 100
            porcentagem_candidato2 = (votos_candidato2 / total_votos) * 100
            porcentagem_candidato3 = (votos_candidato3 / total_votos) * 100
           
            # Relatório
            print("\nRELATÓRIO:")
            print(f"Candidato 1 recebeu {votos_candidato1} votos, representando {porcentagem_candidato1:.2f}% do total.")
            print(f"Candidato 2 recebeu {votos_candidato2} votos, representando {porcentagem_candidato2:.2f}% do total.")
            print(f"Candidato 3 recebeu {votos_candidato3} votos, representando {porcentagem_candidato3:.2f}% do total.")
            return
        else:
            print("Escolha inválida. Por favor, digite uma opção válida.")
 
    # Se o loop terminar sem a opção de encerrar a votação ser escolhida
    os.system("cls")
    print("=== RESULTADOS DA ELEIÇÃO ===")
    print("Total de votos registrados:", total_votos)
    print("Votos para o Candidato 1:", votos_candidato1)
    print("Votos para o Candidato 2:", votos_candidato2)
    print("Votos para o Candidato 3:", votos_candidato3)
   
    # Calcular porcentagem de votos de cada candidato
    porcentagem_candidato1 = (votos_candidato1 / total_votos) * 100
    porcentagem_candidato2 = (votos_candidato2 / total_votos) * 100
    porcentagem_candidato3 = (votos_candidato3 / total_votos) * 100
   
    # Relatório
    print("\nRELATÓRIO:")
    print(f"Candidato 1 recebeu {votos_candidato1} votos, representando {porcentagem_candidato1:.2f}% do total.")
    print(f"Candidato 2 recebeu {votos_candidato2} votos, representando {porcentagem_candidato2:.2f}% do total.")
    print(f"Candidato 3 recebeu {votos_candidato3} votos, representando {porcentagem_candidato3:.2f}% do total.")
 
# Iniciar a eleição
conduzir_eleicao()