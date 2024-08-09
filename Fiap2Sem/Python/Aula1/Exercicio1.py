
def menu():
    print(
""" 
    0 - SAIR
    1 - Adcionar ALUNO
    2 - Editar Aluno | Nota
    3 - Listar alunos 
    4 - Excluir alunos 
    5 - Calcular media da turma 
    6 - Consultar os alunos 
    7 - Apagar todos os alunos 
    """)
    num1 = input("Escolha:")

def escolha():
    num1 = int
    menu()
    match num1:
        case 1:
            AdcionarAluno()

dic1 = {
    "nome": "",
    "idade": 0
}

dic1 = dict()

def AdcionarAluno(d : dict):
    alunos = dic1(input("Nome: "))
    notas = dic1(input("Nota: "))


############################################################

escolha()