def verificar_Aprovados(l: list) -> list:
    la = list()
    for i in range(len(l)):
        if l[i] >= 6:
            la.append(l[i])

    return la

#==================================
lista = [1,2,3,4,5,6,7,8,9,10]
listaAprovados = verificar_Aprovados(lista)
print(listaAprovados)