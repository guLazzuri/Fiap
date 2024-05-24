# ========================== SUBALGORITMOS
def cadastrar_candidatos(c: list) -> None: # None -> indica um procedimento (não retorna valor)
    print("Digite os nomes dos candidatos:")
    for i in range(3):
        c[i] = input(f"{i + 1}: ")

def exibir_menu(c: list):
    print(f"""
    CANDIDATOS

    1 - {c[0]}
    2 – {c[1]}
    3 – {c[2]}
    0 – FIM DA VOTAÇÃO 
    """)

def contagem_candidato(candidato: int) -> int: # candidato = 1
    return candidato + 1


def calcular_total_votos(c1: int, c2: int, c3: int, c4: int) -> int:
    return c1 + c2 + c3 + c4

def calcular_porcentagem(c1: int, tv: int) -> int:  # c1 = 1     tv = 4 <====== parametros
    return c1 / tv * 100 # 50

def exibir_apuracao(n1: list, n2: list, n3:list, c1: int, c2: int, c3: int, cn: int, p1: float, p2: float, p3: float, pn: float) -> None:
    print(f""" 
    CANDIDATOS
    TOTAS DE VOTOS: {total_votos}
    1 – {n1:15} -> {c1:3d} votos -> {p1:5.1f}%
    2 – {n2:15} -> {c2:3d} votos -> {p1:5.1f}%
    3 – {n3:15} -> {c3:3d} votos -> {p3:5.1f}%
        {"NULOS":15} -> {cn:3d} votos -> {pn:5.1f}% 
      """)

# ========================== PROGRAMA PRINCIPAL
import os
os.system("clear")

# Cadastro dos candidatos
#             0   1   2
candidatos = ["", "", ""]
cadastrar_candidatos(candidatos)

# Votação
# ----------------- inicio do laço
cand1 = cand2 = cand3 = nulo = 0
while True:
    os.system("clear")

    exibir_menu(candidatos)

    voto = int(input("VOTO: ")) # 2

    match voto:
        case 0:
            break
        case 1:
            cand1 = contagem_candidato(cand1) # 10
        case 2:
            cand2 = contagem_candidato(cand2) # 2
        case 3:
            cand3 = contagem_candidato(cand3)
        case _:
            nulo = contagem_candidato(nulo)
# ----------------- final do laço
    
# Apuração
total_votos = calcular_total_votos(cand1, cand2, cand3, nulo)

# cand1 = 2     total_votos = 4       <====== variáveis globais

perc1 = calcular_porcentagem(cand1, total_votos)
perc2 = calcular_porcentagem(cand2, total_votos)
perc3 = calcular_porcentagem(cand3, total_votos)
perc_nulos = calcular_porcentagem(nulo, total_votos)

exibir_apuracao(candidatos[0], candidatos[1], candidatos[2], cand1, cand2, cand3, nulo, perc1, perc2, perc3, perc_nulos)