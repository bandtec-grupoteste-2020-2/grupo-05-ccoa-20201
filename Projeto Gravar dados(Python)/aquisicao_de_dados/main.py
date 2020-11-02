from services.mysql import Mysql
from services.component import Cpu
from services.dataGenerator import get_data_cpu
from services.dataGenerator import get_data_ram
from services.dataGenerator import get_data_disco
from services.dataGenerator import geranumeroaleatorio
from services.slackBot import verificarMaquina
from services.slackBot import enviar

import time
from random import randint

from datetime import datetime

#Inserir user, password, host, database
mysql = Mysql('urubu100', 'urubu100', 'localhost', 'MAQUINAS')

# component_cpu = Cpu(75.45, 'ALERTA')

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
    fk_maquina = randint(0, 2)*8
    dataset_componentes = [
        [6 + fk_maquina, values_ram[0], values_ram[-1], 'ram_por'],
        [7 + fk_maquina, values_ram[1], values_ram[-1], 'ram_gb']
    ]
    
    for cpu in values_cpu[0]:
        cada_cpu = [1 + fk_maquina, values_cpu[0][cpu], values_cpu[-1], cpu]
        dataset_componentes.append(cada_cpu)

    for disco in values_disco[0]:

        cada_disco = [4 + fk_maquina, values_disco[0][disco], values_disco[-1], disco]    
        dataset_componentes.append(cada_disco)


    # print(dataset_componentes)

    # for elemento in dataset_componentes:
    #     verificarMaquina(elemento)

    # dataset_componentes = verificarMaquina(dataset_componentes)

    select_maquina_componente_result = mysql.verificar_ativado_componente()

    print("\033[034m","-"*20 ,"INSERT", "-"*20, "\033[0;0m")
    for componente in dataset_componentes:      
        print(componente)

        for registro in select_maquina_componente_result:

            if registro[0] == componente[0] and registro[-1] == 1 :
                mysql.insert_comp(componente)
                print("O componente", registro[1], 'esta \033[032m ATIVADO \033[0;0m para a maquina', registro[-2])
                break
            
            elif registro[0] == componente[0] and registro[-1] == 0:
                print("O componente", registro[1], 'esta \033[031m DESATIVADO \033[0;0m para a maquina', registro[-2])
                    
        print()        




    # enviar(dataset_componentes)



    # print(component_cpu.template_phrase)
    # print(component_cpu.value)
    # print(component_cpu.status, "\n")

    # # print(cpu)
    # print(component_cpu.createString())
    # print(component_cpu.chinelo)

    # print(component_cpu.mostra_chinelo())

    # print(component_cpu.chinelo)
    
    time.sleep(5)
