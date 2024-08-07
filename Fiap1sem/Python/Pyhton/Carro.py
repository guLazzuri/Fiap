km = float(input("Digite Km: "))
Li = float(input("Digite LITROS: "))
kml = km / Li
print(f"autonomia {kml }")
print(f"""
 Quilomeragem : {km}
 Litros : {Li:11.1f}
 Economia {kml:8.1f}
      """)