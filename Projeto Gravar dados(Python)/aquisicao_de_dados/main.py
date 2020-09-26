from services.mysql import Mysql
from services.dataGenerator import get_data_cpu
from services.dataGenerator import get_data_ram
# from services.dataGenerator import get_data_disco
# from services.dataGenerator import enviar
from services.dataGenerator import geranumeroaleatorio
import time

from datetime import datetime

#Inserir user, password, host, database
mysql = Mysql('urubu100', 'urubu100', 'localhost', 'MAQUINAS')

mysql.connect()

while True:

    fk_maquina = geranumeroaleatorio()

    values_ram = get_data_ram()
    # mysql.insert_ram(values_ram)

    values_cpu = get_data_cpu()
    # mysql.insert_ram(values_ram)

    # values_disco = get_data_disco(fk_maquina)
    # mysql.insert_disco(values_disco)

    dataset_componentes = [
        [fk_maquina, 1, values_cpu[0], values_cpu[1]],
        [fk_maquina, 3, values_ram[0], values_ram[2]],
        [fk_maquina, 4, values_ram[1], values_ram[2]]         
    ]

    print("-"*20 ,"INSERT", "-"*20)
    for componente in dataset_componentes:        
        print(componente)
        mysql.insert_comp(componente)
        print()        

    # enviar(fk_maquina,values_ram,values_cpu,values_disco)
    
    time.sleep(5)
