import requests
import json

# URL da API ViaCEP
VIA_CEP_URL = "http://www.viacep.com.br/ws/{}/json"

def consulta_cep(cep):
    # Realiza a requisição para a API do ViaCEP
    resposta = requests.get(VIA_CEP_URL.format(cep))

    # Verifica se a resposta é bem-sucedida
    if resposta.ok:
        endereco = json.loads(resposta.text)

        # Checa se o CEP é inválido
        if 'erro' in endereco:
            raise ValueError("CEP inválido")

        # Atribui cada campo a uma variável
        bairro = endereco.get("bairro", "")
        cep_formatado = endereco.get("cep", "")
        cidade = endereco.get("localidade", "")
        logradouro = endereco.get("logradouro", "")
        uf = endereco.get("uf", "")

        # Solicita o complemento adicional do usuário
        complemento_usuario = input("Digite o complemento do endereço (se houver): ")
        complemento = endereco.get("complemento", "") or complemento_usuario

        # Retorna os dados do endereço como um dicionário
        return {
            "bairro": bairro,
            "cep": cep_formatado,
            "cidade": cidade,
            "logradouro": logradouro,
            "uf": uf,
            "complemento": complemento
        }

    # Trata o caso de erro na requisição
    else:
        raise ValueError("Erro na chamada da API")

# Entrada de dados e exibição
try:
    cep = input("Digite o CEP (apenas números): ")
    resultado = consulta_cep(cep)
    print("Endereço encontrado:")
    print(f"Bairro: {resultado['bairro']}")
    print(f"CEP: {resultado['cep']}")
    print(f"Cidade: {resultado['cidade']}")
    print(f"Logradouro: {resultado['logradouro']}")
    print(f"UF: {resultado['uf']}")
    print(f"Complemento: {resultado['complemento']}")
except ValueError as e:
    print(e)
