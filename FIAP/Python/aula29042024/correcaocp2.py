import os
os.system("clear")

# Cadastro dos candidatos
#             0   1   2
candidatos = ["", "", ""]
print("Digite os nomes dos candidatos:")
for i in range(3):
    candidatos[i] = input(f"{i + 1}: ")

# Votação
# ----------------- inicio do laço
cand1 = cand2 = cand3 = nulo = 0
while True:
    os.system("clear")
    print(f"""
    CANDIDATOS

    1 - {candidatos[0]}
    2 – {candidatos[1]}
    3 – {candidatos[2]}
    0 – FIM DA VOTAÇÃO 
    """)

    voto = int(input("VOTO: "))

    match voto:
        case 0:
            break
        case 1:
            cand1 += 1 # cand1 = cand1 + 1
        case 2:
            cand2 += 1
        case 3:
            cand3 += 1
        case _:
            nulo += 1
# ----------------- final do laço
    
# Apuração
total_votos = cand1 + cand2 + cand3 + nulo
perc1 = cand1 / total_votos * 100
perc2 = cand2 / total_votos * 100
perc3 = cand3 / total_votos * 100
perc_nulos = nulo / total_votos * 100

print(f""" 
    CANDIDATOS
    TOTAS DE VOTOS: {total_votos}
    1 – {candidatos[0]:15} -> {cand1:3d} votos -> {perc1:5.1f}%
    2 – {candidatos[1]:15} -> {cand2:3d} votos -> {perc2:5.1f}%
    3 – {candidatos[2]:15} -> {cand3:3d} votos -> {perc3:5.1f}%
        {"NULOS":15} -> {nulo:3d} votos -> {perc_nulos:5.1f}% 
      """)