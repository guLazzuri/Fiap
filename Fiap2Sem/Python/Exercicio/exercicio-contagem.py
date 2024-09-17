import os
def LimaprTela():
    os.system('cls')

def menu ():
    LimaprTela()
    print("1. Add a new text")
    print("2. Show the word most used")
    print("3. Exit")

    try:
        escolha = int(input("Choose an option: "))
    except ValueError:
        print("Invalid input. Please enter a number.")
    
    match opcao:
        case 1:
            add_text()
        case 2:
            show_word()
        case 3:
            print("Exiting")
            break
        case _:
            print("Inavlid option, plese enter with 1 , 2 or 3 ")
            


def addText ():
    while True:
        text = input("Enter your text: ")
        texts.append(text)
        return
        
        cont = input("Do you want continue?  (Y) | (N)").strip.lower
        if cont == "N":
            break
        elif cont == "Yes":
            continue
        else:
            print("Invalid input. Please enter Y or N.")

def show_word():
    if not text:
        print("No Texts , plese enter a new text")
    
    allText = ''.join(texts)
    words = allText.lower().replace(",","").replace(".", "").s
    cont = Counter(words)
    mostUsed = cont.most_common(1)

    print(F"the word most used is {mostUsed} used {cont} times")

texta = []
menu()






#############################################################################################
menu()