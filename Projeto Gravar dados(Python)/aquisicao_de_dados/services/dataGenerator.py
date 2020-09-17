import psutil
from datetime import datetime
from random import randint
import requests
import json

def get_data_cpu():
    datetime_now = datetime.now()
    print("\nColetando dados por nucleo...")
    print("Data e hora da leitura:", datetime_now)

    number_cpu = 0
    per_cpu = psutil.cpu_percent(interval=1, percpu=True)
    for i in per_cpu:
        print("CPU",number_cpu,":", i, "%")
        number_cpu += 1
   
    dict_per_cpu = {}

    for cpu in range(psutil.cpu_count()):
        dict_per_cpu["CPU_{}".format(cpu)] = per_cpu[cpu] 
                
    data_cpu = (dict_per_cpu, datetime.now(), randint(1, 3))
    return data_cpu

    
def get_data_ram():

    datetime_now = datetime.now()
    print("\nColetando dados por RAM...")
    print("Data e hora da leitura:", datetime_now)
# OBS: Ta mostrando a qtd USADA, pode trocar para LIVRE
    per_ram = psutil.virtual_memory()[2]
    ram_usada_Gb = round(psutil.virtual_memory()[1]/1024/1024/1024, 1)
    print("RAM usada %: ", per_ram, "%")
    print("RAM usada GB: ", ram_usada_Gb, "GB")

    data_ram = (per_ram, round(ram_usada_Gb), datetime_now, randint(1, 3))

    return data_ram


def get_data_disco():
    datetime_now = datetime.now()
    print("\nColetando dados dos Disco...")
    print("Data e hora da leitura:", datetime_now)
    #Apresenta os dados
    todos_os_discos= psutil.disk_partitions()
    print("Quantidade de discos identificados:", len(todos_os_discos))

    dict_per_disco = {}


    for disco in todos_os_discos:
        if(disco[3]!="cdrom"):
            dict_per_disco[str(disco[1])] = psutil.disk_usage(disco[1])[3]
            print(disco[1], psutil.disk_usage(disco[1])[3], "%")

    data_disco = (dict_per_disco, datetime_now, randint(1, 3))
    # print(data_disco)
    return data_disco

def enviar():
    dici={'text':'teste'}#Informação que enviaremos
    response = requests.post('https://hooks.slack.com/services/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',json = dici)#link para conectar o bot, o url tem q colocar sempre, pois sempre q postado no git para de funcionar.
    print(dici,response)
    return response

