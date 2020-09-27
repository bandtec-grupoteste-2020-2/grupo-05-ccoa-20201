from services.mysql import Mysql
from services.dataGenerator import get_data_cpu
from services.dataGenerator import get_data_ram
from services.dataGenerator import get_data_disco
from services.dataGenerator import enviar
from services.dataGenerator import geranumeroaleatorio
from services.dataGenerator import verificarMaquina
import time

from datetime import datetime

#Inserir user, password, host, database
mysql = Mysql('urubu100', 'urubu100', 'localhost', 'MAQUINAS')

mysql.connect()
 
while True:
    fk_maquina = geranumeroaleatorio()

    # dataset_componentes = []

    values_ram = get_data_ram()
    values_cpu = get_data_cpu()
    values_disco = get_data_disco()

    # print(values_ram)
    # print(values_cpu)
    # print(values_disco)

    dataset_componentes = [
        [fk_maquina, 3, values_ram[0], values_ram[-1], 'ram_por'],
        [fk_maquina, 4, values_ram[1], values_ram[-1], 'ram_gb']
    ]
    
    for cpu in values_cpu[0]:
        cada_cpu = [fk_maquina, 1, values_cpu[0][cpu], values_cpu[-1], cpu]
        dataset_componentes.append(cada_cpu)

    for disco in values_disco[0]:
        cada_disco = [fk_maquina, 2, values_disco[0][disco], values_disco[-1], disco]
        dataset_componentes.append(cada_disco)

    # print(dataset_componentes)

    # for elemento in dataset_componentes:
        # verificarMaquina(elemento)
    dataset_componentes = verificarMaquina(dataset_componentes)

    print("-"*20 ,"INSERT", "-"*20)
    for componente in dataset_componentes:        
        print(componente)
        mysql.insert_comp(componente)
        print()        

    enviar(dataset_componentes)
    
    time.sleep(5)
