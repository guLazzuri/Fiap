import os 
os.system("cls") 

placa = str(input("Qual sua placa? "))
numero = placa
ultimo_numero = str(numero)[-1]

match ultimo_numero:
    case "1":
        print ("Segunda")        
    case "2":
        print ("Segunda...")
    case "3":
        print ("Terca...")
    case "4":
        print ("Terca...")
    case "5":
        print ("quarta...")
    case "6": 
        print ("Quarta...")
    case "7":
        print ("Quinta")
    case "8":
        print ("Sexta")
    case "9":
        print ("sabado")
    case "0":
        print ("sabado")

    
