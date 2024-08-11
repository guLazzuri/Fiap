
print("""
    0 - SAIR
    1 - Adcionar ALUNO
    2 - Editar Aluno | Nota
    3 - Listar alunos 
    4 - Excluir alunos 
    5 - Calcular media da turma 
    6 - Consultar os alunos 
    7 - Apagar todos os alunos
""")
num = float(input("Escolha: "))

dic1 = {
    "nome": "",
    "nota": 0
}

dic1 = dict() 

continuar = True
while (continuar == True):
    match num:
        case 1:
            dic1["nome"] = input("Nome: ")
            dic1["nota"] = input("Nota: ")
            break
        case 2:
            print(dic1)
    





        