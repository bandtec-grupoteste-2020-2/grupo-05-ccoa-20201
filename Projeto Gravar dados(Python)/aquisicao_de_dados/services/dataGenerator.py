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

def get_data_cpu(numerogerado):
    datetime_now = datetime.now()
    print("\nColetando dados por nucleo...")
    print("Data e hora da leitura:", datetime_now)

    number_cpu = 0
    mediacpu= psutil.cpu_percent()
    per_cpu = psutil.cpu_percent(interval=1, percpu=True)
    for i in per_cpu:
        print("CPU",number_cpu,":", i, "%")
        number_cpu += 1
   
    dict_per_cpu = {}

    for cpu in range(psutil.cpu_count()):
        dict_per_cpu["CPU_{}".format(cpu)] = per_cpu[cpu] 
                
    data_cpu = (dict_per_cpu, datetime.now(),numerogerado,mediacpu)
    return data_cpu

    

def get_data_ram(numerogerado):

    datetime_now = datetime.now()
    print("\nColetando dados por RAM...")
    print("Data e hora da leitura:", datetime_now)
# OBS: Ta mostrando a qtd USADA, pode trocar para LIVRE
    per_ram = psutil.virtual_memory()[2]
    ram_usada_Gb = round(psutil.virtual_memory()[1]/1024/1024/1024, 1)
    print("RAM usada %: ", per_ram, "%")
    print("RAM usada GB: ", ram_usada_Gb, "GB")

    data_ram = (per_ram, round(ram_usada_Gb), datetime_now,numerogerado)

    return data_ram



def get_data_disco(numerogerado):
    datetime_now = datetime.now()
    print("\nColetando dados dos Disco...")
    print("Data e hora da leitura:", datetime_now)
    #Apresenta os dados
    todos_os_discos= psutil.disk_partitions('/mnt/')
    print("Quantidade de partições de disco identificados:", len(todos_os_discos))

    dict_per_disco = {}

# disco[3]!="iso9660" and
    for disco in todos_os_discos:
        if(disco[3]!="cdrom" and  disco[2]=="drvfs" or disco[3]=="rw,fixed"):
            dict_per_disco[str(disco[1])] = psutil.disk_usage(disco[1])[3]
            print(disco[1], psutil.disk_usage(disco[1])[3], "%")

    data_disco = (dict_per_disco, datetime_now, numerogerado)
    # print(data_disco)
    return data_disco

def enviar(numerogerado,values_ram,values_cpu,values_disco):
    verficarMaquina(numerogerado,values_ram,values_cpu,values_disco)
    response = requests.post(URL,json = dici)#link para conectar o bot, o url tem q colocar sempre, pois sempre q postado no git para de funcionar.
    print(dici,response)
    dici['text']=''
    return response

def verficarMaquina(numerogerado,values_ram,values_cpu,values_disco):
    #MAQUINA 1 IOT
    if numerogerado==1:
        # VALORES DA MEMORIA RAM
        if values_ram[0] <= 25.0:
            dici['text']+=("A memória da máquina de IOT está utilizando {}% {} GB. Está tudo certo.".format(values_ram[0], values_ram[1]))
        elif values_ram[0] <= 50.0:
            dici['text']+=("A memória da máquina de IOT está utilizando {}% {} GB. Melhor ficar alerta.".format(values_ram[0], values_ram[1]))
        else:
            dici['text']+=("A memória da máquina de IOT está utilizando {}% {} GB. Está em emergência.".format(values_ram[0], values_ram[1]))

        # VALORES DA CPU
        if values_cpu[3]<=30.0:
            dici['text']+=("O processador do IOT está utilizando {}% . Está tudo certo.".format(values_cpu[3]))
        elif values_cpu[3]<=60.0:
            dici['text']+=("O processador do IOT está utilizando {}% . Melhor ficar alerta.".format(values_cpu[3]))
        else:
            dici['text']+=("O processador do IOT está utilizando {}% . Está em emergência.".format(values_cpu[3]))

        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=40.0:
                dici['text']+=("O disco{} do IOT está sendo utilizado {} %. Está tudo certo".format(z, values_disco[0][z]))
            elif values_disco[0][z]<=65.0:
                dici['text']+=("O disco{} do IOT está utilizando {}% . Melhor ficar alerta.".format(z, values_disco[0][z]))
            else:
                dici['text']+=("O disco{} do IOT está utilizando {}% . Está em emergência.".format(z, values_disco[0][z]))
       

 #MAQUINA 2 Usuario
    if numerogerado==2:
        # VALORES RAM
        if values_ram[0] <= 40.0:
            dici['text']+=("A memória da máquina do Usuário está utilizando {}% {} GB. Está tudo certo".format(values_ram[0], values_ram[1]))
        elif values_ram[0] <= 70.0:
            dici['text']+=("A memória da máquina do Usuário está utilizando {}% {} GB. Melhor ficar alerta".format(values_ram[0], values_ram[1]))
        else:
            dici['text']+=("A memória da máquina do Usuário está utilizando {}% {} GB. Está em emergência".format(values_ram[0], values_ram[1]))
        
        # VALORES DA CPU
        if values_cpu[3]<=45.0:
            dici['text']+=("O processador do Usuário está utilizando {}% . Está tudo certo.".format(values_cpu[3]))
        elif values_cpu[3]<=65.0:
            dici['text']+=("O processador do Usuário está utilizando {}% . Melhor ficar alerta.".format(values_cpu[3]))
        else:
            dici['text']+=("O processador do Usuário está utilizando {}% . Está em emergência.".format(values_cpu[3]))

        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=50.0:
                dici['text']+=("O disco{} do Usuário está sendo utilizado {} %. Está tudo certo".format(z, values_disco[0][z]))
            elif values_disco[0][z]<=70.0:
                dici['text']+=("O disco{} do Usuário está utilizando {}% . Melhor ficar alerta.".format(z, values_disco[0][z]))
            else:
                dici['text']+=("O disco{} do Usuário está utilizando {}% . Está em emergência.".format(z, values_disco[0][z]))



 #MAQUINA 3 Servidor
    if numerogerado==3:
        # VALORES RAM
        if values_ram[0] <= 70.0:
            dici['text']+=("A memória da máquina do Servidor está utilizando {}% {} GB. Está tudo certo".format(values_ram[0], values_ram[1]))
        elif values_ram[0] <= 85.0:
            dici['text']+=("A memória da máquina do Servidor está utilizando {}% {} GB. Melhor ficar alerta".format(values_ram[0], values_ram[1]))
        else:
            dici['text']+=("A memória da máquina do Servidor está utilizando {}% {} GB. Está em emergência".format(values_ram[0], values_ram[1]))
        
        # VALORES DA CPU
        if values_cpu[3]<=60.0:
            dici['text']+=("O processador do Servidor está utilizando {}% . Está tudo certo.".format(values_cpu[3]))
        elif values_cpu[3]<=85.0:
            dici['text']+=("O processador do Servidor está utilizando {}% . Melhor ficar alerta.".format(values_cpu[3]))
        else:
            dici['text']+=("O processador do Servidor está utilizando {}% . Está em emergência.".format(values_cpu[3]))
        
        # VALORES DO DISCO
        for z in values_disco[0]:
            if values_disco[0][z]<=65.0:
                dici['text']+=("O disco{} do Servidor está sendo utilizado {} %. Está tudo certo".format(z, values_disco[0][z]))
            elif values_disco[0][z]<=85.0:
                dici['text']+=("O disco{} do Servidor está utilizando {}% . Melhor ficar alerta.".format(z, values_disco[0][z]))
            else:
                dici['text']+=("O disco{} do Servidor está utilizando {}% . Está em emergência.".format(z, values_disco[0][z]))


