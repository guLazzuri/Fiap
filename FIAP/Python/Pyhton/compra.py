import os 
os.system("cls") 

num1 = float(input("Numero 1 "))
if num1 <= 1200:
       ifa = (num1 * 0.08)
elif num1 >= 1200.01 or num1 <= 2070:
      ifa = (num1 * 0.09) 
elif num1 >= 2070.01 or num1 <= 4200:
      ifa = (num1 * 0.011) 
elif num1 > 4200.01:
       ifa = 468
print(ifa) 
 