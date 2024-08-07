import os 
os.system("cls") 

print (f"""
     1- cadastrar
     2- consultar
     3- alterar
     4- Excluir
""")
opycal = int(input("Escolha"))

match opycal:
    case 1:
        print ("Cadastrando...")        
    case 2:
        print ("Conultando...")
    case 3:
        print ("Alterando...")
    case 4:
        print ("Exluindo...")
    case 5:
        print("Invalida...")
    
