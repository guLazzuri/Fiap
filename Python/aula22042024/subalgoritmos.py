# Calcular a equação do 2.o grau por Baskara
# SUBALGORITMOS - FUNÇÕES E PROCEDIMENTOS ====> MÉTODOS
from sub import * # * ==> todos
import os
os.system("clear")

# ======================== PROGRAMA PRINCIPAL
from sub import saudacao1, saudacao2, saudacao3, raiz2, raizn, pi
saudacao1()
saudacao2("Maria")
saudacao3("Fernanda", 17)


print(raiz2(16))
print(raizn(27, 5))
print(pi())
r = 2
c = 2 * pi() * r
print(r, c)


"""
from sub import saudacao1, saudacao2, saudacao3, raiz2, raizn, pi
saudacao1()
saudacao2("Maria")
saudacao3("Fernanda", 17)


print(raiz2(16))
print(raizn(27, 5))
print(pi())
r = 2
c = 2 * pi() * r
print(r, c)
"""
"""
import sub

sub.saudacao1()
sub.saudacao2("Maria")
sub.saudacao3("Fernanda", 17)


print(sub.raiz2(16))
print(sub.raizn(27, 5))
print(sub.pi())
r = 2
c = 2 * sub.pi() * r
print(r, c)
"""