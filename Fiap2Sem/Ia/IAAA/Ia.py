import streamlit as st
import requests

# Título da aplicação
st.title("Análise de Drogas com AI - Via API")

# Formulário de entrada de dados
st.header("Insira os dados do paciente para análise")

# Campos do formulário
idade = st.number_input("Idade", min_value=1, max_value=120, value=30, step=1)
genero = st.selectbox("Gênero", options=["M", "F"])
pressao_sanguinea = st.selectbox("Nível de Pressão Sanguínea", options=["LOW", "NORMAL", "HIGH"])
colesterol = st.selectbox("Nível de Colesterol", options=["NORMAL", "HIGH"])
nivel_sodio = st.number_input("Nível de Sódio para Potássio (Na/K)", min_value=0.0, max_value=100.0, value=15.0)

# Botão de submissão
if st.button("Analisar"):
    # Dados que serão enviados para a API
    dados = {
        "Age": idade,
        "Sex": genero,
        "BP": pressao_sanguinea,
        "Cholesterol": colesterol,
        "Na_to_K": nivel_sodio
    }
    
    with st.spinner("Analisando..."):
        # Chamada para a API Flask
        resposta = requests.post("http://127.0.0.1:5000/analisar", json=dados)
        
    # Exibir a resposta da API
    if resposta.status_code == 200:
        previsao = resposta.json()['previsao']
        st.success(f"A droga sugerida para o paciente é: {previsao[0]}")
    else:
        erro_msg = resposta.json().get('erro', 'Erro desconhecido')
        st.error(f"Erro ao chamar a API Flask. Status: {resposta.status_code}. Mensagem: {erro_msg}")
