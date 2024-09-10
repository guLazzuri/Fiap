import os
os.system("cls")

with open("arquivo.txt", "w+", encoding="utf-8") as arq:
    # Gravando várias linhas por vez via usuario
    documento = []
    while True:
        linha = input("Linha: ")
        if linha != '':
            documento.append(linha + '\n')
        else:
            break
    arq.writelines(documento)

    # Exibindo a gravacao das linhas do arquivo
    print("\nLendo linha a linha de um arquivo")
    arq.seek(0)
    documento.clear()
    documento = arq.readlines()
    for i, linha in enumerate(documento):
        print(f"{i+1}. {linha}", end = "")




    # Gravando uma linha por vez via usuario
    '''
    while True:
        linha = input("Linha: ")
        if linha != "":
            arq.write(linha + '\n')
        else:
            break
    # Exibindo o arquivo
    arq.seek(0)
    arq.read()
    '''


    # readlines() - cria uma lista com as linhas do arquivo
    '''
    arq.write("primeira linha\n")
    arq.write("segunda linha\n")
    arq.write("terceira linha\n")
    arq.seek(0)
    #lista_linhas = arq.readlines()
    #print(lista_linhas[2])
    for linha in arq.readlines():
        print(linha, end="")
    '''

    # Readline() - Carrega uma linha do arquivo
    '''
    arq.write("Primeira linha\n")
    arq.write("Segunda linha\n")
    arq.write("Terceira linha\n")
    arq.seek(16)
    print(arq.readline())
    '''

    # Exibe um trecho especifiado do arquivo
    '''
    arq.write("Paralelepipedo")
    arq.seek(4)
    print(arq.read(2))
    '''