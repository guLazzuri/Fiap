perguntas = {
    "Pergunta1": {
        "pergunta": "Quanto é 5+5",
        "resposta": {
            'a': '5',
            'b': '10',
            'c': '15'
        },
        'resposta_certa': 'b',
    },
    "Pergunta2": {
        "pergunta": "Quanto é 3+5",
        "resposta": {
            'a': 8,
            'b': 13,
            'c': 20
        },
        'resposta_certa': 'a',
    },
    "Pergunta3": {
        "pergunta": "Quanto é 5x5",
        "resposta": {
            'a': 35,
            'b': 30,
            'c': 25
        },
        'resposta_certa': 'c',
    },
    "Pergunta4": {
        "pergunta": "Quanto é 10+7",
        "resposta": {
            'a': 3,
            'b': 17,
            'c': 24
        },
        'resposta_certa': 'b',
    },
    "Pergunta5": {
        "pergunta": "Quanto é 1+1",
        "resposta": {
            'a': 0,
            'b': 1,
            'c': 2
        },
        'resposta_certa': 'c',
    }
}

porcentagem = 0
respCerta = 0

for i in perguntas:
    print(perguntas[i]['pergunta'])
    for i in perguntas[i]['resposta'].items():
        print(i)
 
    x = input("Digite sua resposta:")
    correta = perguntas['Pergunta1']['resposta_certa']
 
    if x == correta:
        print("Resposta Certa")
        porcentagem =+ 20
        respCerta =+ 1
    else:
        print("resposta Errada")

print(f"Sua porcentagem de acerto foi de {respCerta}% ")
