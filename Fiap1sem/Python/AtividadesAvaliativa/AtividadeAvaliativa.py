import os 
os.system("cls")

def verifica_lista_inteiros(lista) -> bool:
    for i in range (len(lista)):
        l1 = str(l1[i])
    return lista
    
def confirm_list(lista) -> bool:
    for i in range (len(lista)):
        if str(len(lista)).isnumeric():
            return True
        else:
            return False

       

#Porgrama Principal ----------------------------------   
lista = [5, 8, 4, "edson",12,44] 
if verifica_lista_inteiros(lista):
    print("Nem todos os elementos contidos são inteiros")
else:
    print("Todos os elementos contidos são inteiros")

lista = [ 5,8,4,12]
if verifica_lista_inteiros(lista):
    print("Todos os elementos contidos são inteiros")
else:
    print("Nem todos os elementos contidos são inteiros")