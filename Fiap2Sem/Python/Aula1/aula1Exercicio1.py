def menu():

    print("""
    0 - SAIR
    1 - Adicionar ALUNO
    2 - Editar Aluno | Nota
    3 - Listar alunos 
    4 - Excluir alunos 
    5 - Calcular media da turma 
    6 - Consultar os alunos 
    7 - Apagar todos os alunos
""")
    
def AdcAluno(dic1):
    nome = input("Nome: ")
    continuar2 = True
    while continuar2:
        nota = float(input("Nota: "))
        if nota > 10 or nota < 0:
            print("Nota invalida, tente novamente.")
        else:
            dic1.append({"nome": nome, "nota": nota})
            continuar2 = False

def EditAluno(dic1):
    nome = input("Nome do aluno que dejesa editar: ") 
    encontrado = False
    for aluno in dic1:
        if aluno["nome"] == nome:
            aluno["nota"] = float(input("Nova nota: "))
            encontrado = True
            break
    if not encontrado:
        print("Aluno não encontrado")
            

def ListAlunos(dic1):
    for aluno in dic1:
        print(f"Nome: {aluno['nome']}, Nota {aluno['nota']}")

def RemAlunos(dic1):
    nome = input("Nome do aluno que deseja excluir: ")
    encontrado = False
    for aluno in dic1:
        if aluno['nome'] == nome:
            dic1.remove(aluno)
            print("Aluno removido com sucesso!")
            encontrado = True
            break
    if not encontrado:
        print("Aluno não encontrado")
            

def CalAlunosMedia(dic1):
    if dic1:
        media = sum(aluno['nota'] for aluno in dic1) / len(dic1)
        print(f"Media da turma: {media:.2f}")
    else:
        print("Não há alunos para calcular a media")

def ConsultAlunos(dic1):
    nome =input("Nome do aluno que deseja consultar: ")
    encontrado = False
    for aluno in dic1:
        if aluno["nome"]== nome:
            print(f"Aluno: {aluno['nome']}, Nota:{aluno['nota']}")
            encontrado = True
            break
    if not encontrado:
        print("Aluno não encontrado")
            

def Apagaralunos(dic1):
    dic1.clear()
    print("Todos os alunos foram apagados.")

############################################################################################################


dic1 = []

continuar = True
while continuar:
    menu()
    num = int(input("Escolha uma opicao: "))
    match num:
        case 0:
            continuar = False
        case 1:
            AdcAluno(dic1)
        case 2:
            EditAluno(dic1)  
        case 3: 
            ListAlunos(dic1)
        case 4: 
            RemAlunos(dic1)
        case 5:
            CalAlunosMedia(dic1)
        case 6:
            ConsultAlunos(dic1)
        case 7:
            Apagaralunos(dic1)
        case _:
            print("Opção inválida. Tente novamente.")


    





        