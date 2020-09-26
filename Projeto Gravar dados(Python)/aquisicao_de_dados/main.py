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
        [fk_maquina, 1, values_cpu[0], datetime.now()],
        [fk_maquina, 3, values_ram[0], datetime.now()],
        [fk_maquina, 4, values_ram[1], datetime.now()]         
    ]

   

    for componente in dataset_componentes:
        # print(componente)        
        mysql.insert_comp(componente)
        # time.sleep(10)

        # mysql.insert(componente)
        

    # dataset_insert = [fk_maquina, values_cpu, values_ram[0], values_ram[1]]
    # mysql.insert(dataset_insert)

    # enviar(fk_maquina,values_ram,values_cpu,values_disco)
    
    time.sleep(5)
