import os
os.system("clr")

def vogal_maiuscola(text) -> str:
    
    #new_texto1  = text.replace('a', 'A')
    #new_texto2 =  new_texto1.replace('e', 'E')
    #new_texto3  = new_texto2.replace('i', 'I')
    #new_texto4  = new_texto3.replace('o', 'O')
    #new_texto5  = new_texto4.replace('u', 'U')

    #return new_texto5

#PROFESORR ====================================================
    vogal = "aeiou"
    for i in range (len(s)):
        if s[i] in vogal:
            s = s.replace(s[i], s[i].upper())

    return s


    

#================================================

os.system("clr")

texto = "Edson de Oliveira"
new_texto = vogal_maiuscola(texto)
print(new_texto)