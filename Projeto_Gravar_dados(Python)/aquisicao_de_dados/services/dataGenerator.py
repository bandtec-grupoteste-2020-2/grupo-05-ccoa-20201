import psutil
from datetime import datetime
from random import randint
import requests
import json
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
        dict_per_cpu[f"Core {cpu+1}"] = per_cpu[cpu] 
                
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

   
