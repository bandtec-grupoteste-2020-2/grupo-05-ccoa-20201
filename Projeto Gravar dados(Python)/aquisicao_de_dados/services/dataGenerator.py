import psutil
from datetime import datetime
from random import randint
import requests
import json
URL = 'https://hooks.slack.com/services/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'
dici={'text':''}
def geranumeroaleatorio():
    tipomaquina=randint(1, 3)
    return tipomaquina

def get_data_cpu():
    datetime_now = datetime.now()
    # print("\nColetando dados por nucleo...")
    # print("Data e hora da leitura:", datetime_now)

    # number_cpu = 0
    # mediacpu = psutil.cpu_percent()
    # cpu_geral = psutil.cpu_percent()
    per_cpu = psutil.cpu_percent(interval=1, percpu=True)
    # for i in per_cpu:
    #     print("CPU",number_cpu,":", i, "%")
    #     number_cpu += 1
   
    dict_per_cpu = {}

    for cpu in range(psutil.cpu_count()):
        dict_per_cpu["CPU_{}".format(cpu)] = per_cpu[cpu] 
                
    data_cpu = (dict_per_cpu, datetime_now)
    return data_cpu

def get_data_ram():

    datetime_now = datetime.now()
    # print("\nColetando dados por RAM...")
    # print("Data e hora da leitura:", datetime_now)
# OBS: Ta mostrando a qtd USADA, pode trocar para LIVRE
    ram_por = psutil.virtual_memory()[2]
    ram_gb = round(psutil.virtual_memory()[1]/1024/1024/1024, 2)
    # print("RAM usada %: ", per_ram, "%")
    # print("RAM usada GB: ", ram_usada_Gb, "GB")

    data_ram = (ram_por, ram_gb, datetime_now)
    return data_ram


def get_data_disco():
    datetime_now = datetime.now()
    # print("\nColetando dados dos Disco...")
    # print("Data e hora da leitura:", datetime_now) 
    # #Apresenta os dados
    todos_os_discos= psutil.disk_partitions('/mnt/')
    # print("Quantidade de partições de disco identificados:", len(todos_os_discos))

    dict_per_disco = {}

    for disco in todos_os_discos:
        if(disco[3]!="cdrom" and  disco[2]=="drvfs" or disco[3]=="rw,fixed"):
            dict_per_disco[disco[1]] = psutil.disk_usage(disco[1])[3]
            # list_per_disco.append(psutil.disk_usage(disco[1])[3])
            # print(disco[1], psutil.disk_usage(disco[1])[3], "%")
    
    # print(list_per_disco)
    # list_per_disco.append(datetime_now)
    data_disco = (dict_per_disco, datetime_now)
    # print(data_disco)
    return data_disco

def enviar(dataset_leituras):
    verificarMaquina(dataset_leituras)
    response = requests.post(URL,json = dici)#link para conectar o bot, o url tem q na linha 6
    print(dici, response)
    dici['text']=''
    return response

def verificarMaquina(componente_maquina):
    #MAQUINA 1 IOT

    novo_dataset_com_status= componente_maquina

    for i in novo_dataset_com_status:

        erro=0
        if i[0]==1:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de IOT está utilizando:\n"
            if i[1]==3:
                if i[2] <= 25.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 50.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1


            # VALORES DA MEMORIA RAM   4=ramGb
                    
            
            elif i[1]==4:
                if i[2] <= 25.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 50.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1


            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=30.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=60.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DO DISCO    disco=2
            
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=40.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=65.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1
        

    # MAQUINA 2 Usuario
        if i[0]==2:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de Usuario está utilizando:\n"
            if i[1]==3:
                if i[2] <= 50.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 60.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA MEMORIA RAM   4=ramGb
            elif i[1]==4:
                if i[2] <= 50.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 60.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=50.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=65.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES do disco    disco=2
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=50.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=75.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1

    #MAQUINA 3 Servidor
        if i[0]==3:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de Servidor está utilizando:\n"
            if i[1]==3:
                if i[2] <= 75.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 80.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA MEMORIA RAM   4=ramGb
            elif i[1]==4:
                if i[2] <= 75.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 80.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=75.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=90.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES do disco    disco=2
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=70.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=90.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1
        if erro==0:
            dici['text']=''

    return novo_dataset_com_status
