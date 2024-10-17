from flask import Flask, request, jsonify
import pandas as pd
import joblib

app = Flask(__name__)

# Carregar o modelo
modelo = joblib.load('pipelineModel.pkl')

@app.route("/")
def hello():
    return "API de previsão de drogas está funcionando!"

# Rota para previsão com dados recebidos via POST
@app.route("/analisar", methods=['POST'])
def prever():
    try:
        # Recebendo os dados via POST (JSON)
        dados = request.get_json()

        # Criando um dicionário com os parâmetros recebidos
        data = {
            'Age': [dados['Age']],
            'Sex': [dados['Sex']],  # Espera M ou F
            'BP': [dados['BP']],  # Espera LOW, NORMAL, HIGH
            'Cholesterol': [dados['Cholesterol']],  # Espera NORMAL, HIGH
            'Na_to_K': [dados['Na_to_K']]
        }

        # Convertendo o dicionário em um DataFrame
        entrada = pd.DataFrame(data)

        # Fazendo a previsão com o modelo
        result = modelo.predict(entrada)

        return jsonify({'previsao': result.tolist()})

    except Exception as e:
        return jsonify({'erro': str(e)}), 500

if __name__ == "__main__":
    app.run(debug=True)
