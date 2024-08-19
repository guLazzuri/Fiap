listaPar = [0,1,2,4,6]
listaImpar = [1,3,5,7]

def nova_lista(nova):
    nova = [list]
    numerosRepetidos = []
    listaDeRetorno = []
    for i in range(len(nova)):
        if i == len(nova):
            numerosRepetidos.append(i)
        else:
            listaDeRetorno.append(i)
    print(listaDeRetorno)
    print(numerosRepetidos)

###############################################################################################

listaPrincipal = []

listaPrincipal.append(listaImpar)
listaPrincipal.append(listaPar)

nova_lista(listaPrincipal)
            
