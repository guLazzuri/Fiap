# ======================== SUBALGORITMOS
# ---- Procedimento ==> Subalgoritmo que não retorna valor ao programa chamador
# ==> Sem passagem de parâmetros
def saudacao1() -> None:
    print("Bom dia, usuário")

def saudacao2(nome: str) -> None:
    print(f"Bom dia, {nome}")

def saudacao3(nome: str, hora: int) -> None:
    if hora < 12:
        msg = "Bom dia"
    elif hora < 18:
        msg = "Boa tarde"
    else:
        msg = "Boa noite" 
    print(f"{msg}, {nome}")

# ---- Função ==> Subalgoritmo que retorna valor ao programa chamador
def raiz2(num: float) -> float:
    resp = num ** (1/2)
    return resp

def raizn(num: float, raiz: int) -> float:
    return num ** (1/raiz)

def pi() -> float:
    return 3.1415
