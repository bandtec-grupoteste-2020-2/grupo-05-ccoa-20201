import psutil
from datetime import datetime
from random import randint

# def getData():
#     cpu_info = {
#     'cpu': 0,
#     'memory': 0,
#     'disk': 0
#     }
#     cpu = psutil.cpu_percent(interval=1, percpu=True)
#     cpu_media = sum(cpu)/len(cpu)
#     memory = (psutil.virtual_memory().used >> 30)
#     memory_percent = (psutil.virtual_memory().percent)
#     disk = psutil.disk_usage('/').percent

#     cpu_info['cpu'] = round(cpu_media,1)
#     cpu_info['memory'] = memory
#     cpu_info['memory_percent'] = memory_percent
#     cpu_info['disk'] = disk

#     #Objeto para visualização só
#     print(cpu_info)
#     #lista para envio no banco
#     data = (round(cpu_media,1), memory, memory_percent, disk)

#     return data



def get_data_cpu():
    datetime_now = datetime.now()
    print("\nColetando dados por nucleo...")
    print("Data e hora da leitura:", datetime_now)
    # print("Data:", datetime.date.today())
    # print("Hora:", datetime.datetime.now().time())
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
    # print("Data:", datetime.date.today())
    # print("Hora:", datetime.date.now().time())
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
            # porcentagem=psutil.disk_usage(disco[0])[3]
            # print("Disco {}: \t porcentagem: {}%".format(disco[0],round(porcentagem,2)))

    data_disco = (dict_per_disco, datetime_now, randint(1, 3))
    # print(data_disco)
    return data_disco



