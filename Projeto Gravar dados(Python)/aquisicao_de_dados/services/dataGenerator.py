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

def enviar(numerogerado,values_ram,values_cpu,values_disco):
    verificarMaquina(numerogerado,values_ram,values_cpu,values_disco)
    response = requests.post(URL,json = dici)#link para conectar o bot, o url tem q na linha 6
    print(dici,response)
    dici['text']=''
    return response

def verificarMaquina(numerogerado,values_ram,values_cpu,values_disco):
    #MAQUINA 1 IOT
    erro=0
    if numerogerado==1:
        # VALORES DA MEMORIA RAM
        dici['text']+="A máquina de IOT está utilizando:\n"
        if values_ram[0] <= 25.0:
            pass
        elif values_ram[0] <= 50.0:
            dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(values_ram[0], values_ram[1]))
            erro+=1
        else:
            dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(values_ram[0], values_ram[1]))
            erro+=1
        # VALORES DA CPU
        if values_cpu[3]<=30.0:
            pass
        elif values_cpu[3]<=60.0:
            dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(values_cpu[3]))
            erro+=1
        else:
            dici['text']+=("Processador {}% . Está em emergência.\n".format(values_cpu[3]))
            erro+=1
        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=40.0:
                pass
            elif values_disco[0][z]<=65.0:
                dici['text']+=("O disco {} -- {}% . Melhor ficar alerta.\n".format(z, values_disco[0][z]))
                erro+=1
            else:
                dici['text']+=("O disco {} -- {}% . Está em emergência.\n".format(z, values_disco[0][z]))
                erro+=1
       

 #MAQUINA 2 Usuario
    if numerogerado==2:
        dici['text']+="A máquina do Usuário está utilizando:\n"
        # VALORES RAM
        if values_ram[0] <= 40.0:
            pass
        elif values_ram[0] <= 70.0:
            dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta\n".format(values_ram[0], values_ram[1]))
            erro+=1
        else:
            dici['text']+=("Memória {}% -- {} GB. Está em emergência\n".format(values_ram[0], values_ram[1]))
            erro+=1
        # VALORES DA CPU
        if values_cpu[3]<=45.0:
            pass
        elif values_cpu[3]<=65.0:
            dici['text']+=("Processador{}% . Melhor ficar alerta.\n".format(values_cpu[3]))
            erro+=1
        else:
            dici['text']+=("Processador{}% . Está em emergência.\n".format(values_cpu[3]))
            erro+=1
        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=50.0:
                pass
            elif values_disco[0][z]<=70.0:
                dici['text']+=("O disco {} -- {}% . Melhor ficar alerta.\n".format(z, values_disco[0][z]))
                erro+=1
            else:
                dici['text']+=("O disco {} -- {}% . Está em emergência.\n".format(z, values_disco[0][z]))
                erro+=1


 #MAQUINA 3 Servidor
    if numerogerado==3:
        # VALORES RAM
        dici['text']+="A máquina do Servidor está utilizando:\n"
        if values_ram[0] <= 70.0:
            pass
        elif values_ram[0] <= 85.0:
            dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta\n".format(values_ram[0], values_ram[1]))
            erro+=1
        else:
            dici['text']+=("Memória {}% -- {} GB. Está em emergência\n".format(values_ram[0], values_ram[1]))
            erro+=1
        # VALORES DA CPU
        if values_cpu[3]<=60.0:
            pass
        elif values_cpu[3]<=85.0:
            dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(values_cpu[3]))
            erro+=1
        else:
            dici['text']+=("Processador {}% . Está em emergência.\n".format(values_cpu[3]))
            erro+=1
        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=65.0:
                pass
            elif values_disco[0][z]<=85.0:
                dici['text']+=("O disco {} -- {}% . Melhor ficar alerta.\n".format(z, values_disco[0][z]))
                erro+=1
            else:
                dici['text']+=("O disco {} -- {}% . Está em emergência.\n".format(z, values_disco[0][z]))
                erro+=1
    if erro==0:
        dici['text']=''
