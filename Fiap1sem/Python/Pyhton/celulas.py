import os
os.system("cls")
"""
Pedir a quantia
atualizar a quantidade
calcular a qunatidade que da 50
atualizar a quantidade
quantiadde de 20
atualizar 
calcular aquantiadde de 10
atualizar as quantiadde
"""

quantia1 = int(input("quantia...R$ "))
cel50 = quantia1 // 50
quantia = quantia1 % 50
cel20 = quantia // 20
quantia = quantia % 20
cel10 = quantia // 10
quantia = quantia % 10
print(f"""
O troco de {quantia1} é
    A quantia de notas de 50 foi de : {cel50} 
    A quantida de notas de 20 foi de : {cel20}
    A quantida de notas de 10 foi de : {cel10} 
"""
     )