import os
import datetime

# Limpar o console
os.system("cls" if os.name == "nt" else "clear")

# Data e hora atuais
agora = datetime.datetime.now()
print(f"Agora = {agora}")
# Formato DD/MM/YYYY
print(f"Formato Brasil = {agora:%d/%m/%Y}")
# Representação em texto
print(f"Texto: {agora.ctime()}")

# Data definida
data = datetime.datetime(2006, 2, 10, 10, 10, 10, 1010)
print(data)

# Fatiando uma data
dia = data.day
mes = data.month  # Corrigido
ano = data.year - 1  # Corrigido
print(dia)
print(mes)
print(ano)

# Criando objetos datetime para as datas fornecidas
data1 = datetime.datetime(2022, 12, 31)
data2 = datetime.datetime(2022, 12, 1)

# Calculando a diferença entre as duas datas
diferenca_data = data1 - data2
print(diferenca_data)
