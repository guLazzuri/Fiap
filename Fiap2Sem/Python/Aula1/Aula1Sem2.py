import os
os.system("cls")

dic1 = {
    "nome": "Gustavo",
    "idade": 18
}

print(dic1)

dic2 = dict()

dic2["Endereco"] =  "kkkkkkkkkkkkkkk kkkkk kkkk kk kkkkkkkk"
dic2["Cep"] = "0320294-9920"

del dic2["Cep"] #DELETANDO O CEP

print(dic2)

if dic2.get("nome"):
    print("Esta chave existe")
else: 
    print("Essa chave não existe")
