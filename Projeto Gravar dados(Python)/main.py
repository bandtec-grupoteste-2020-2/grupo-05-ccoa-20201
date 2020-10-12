import psutil
import time
import datetime

# print()
# cpucount = psutil.cpu_count()
# print("Numero de nucleos:",cpucount)
# frequencia = psutil.cpu_freq()
# print("Frequencia Atual:",round(frequencia[0]/1000,2),'GHz')
# print("Frequencia minima:",round(frequencia[1]/1000,2),'GHz')
# print("Frequencia maxima:",round(frequencia[2]/1000,2),'GHz')
todos_os_discos= psutil.disk_partitions()
print("Quantidade de discos identificados:",len(todos_os_discos))
for disco in todos_os_discos:
    if(disco[3]!="cdrom"):
        disco_total=psutil.disk_usage(disco[0])[0]/1024/1024/1024
        Usado=psutil.disk_usage(disco[0])[1]/1024/1024/1024
        # Livre=psutil.disk_usage(disco[0])[2]/1024/1024/1024
        # Porcentagem=psutil.disk_usage(disco[0])[3]
        # print("Disco {}: \t Total:{} GB \t Usado: {} GB \t Livre:{} Gb \t Porcentagem: {}%".format(disco[0],round(disco_total,2),
        # round(Usado,2),round(Livre,2),round(Porcentagem,2)))

        print("Disco {}: \t Total:{} GB \t Usado: {} GB".format(disco[0],round(disco_total,2),
        round(Usado,2)))


# disco_total=psutil.disk_usage('/')[0]/1024/1024/1024
# print("Disco total:",round(disco_total,2),"GB")
# memoria_total = psutil.virtual_memory()[0]/1024/1024/1024
# print("Memoria virtual total:",round(memoria_total,2),"GB")

# swap=psutil.swap_memory()[0]/1024/1024/1024
# print("Swap total:",round(swap,2),"GB")

# a=datetime.datetime.fromtimestamp(1599106350.551954)
# print(a)
# while True: 
    
    
    # print("----------Proxima Leitura------------")
    # dia = datetime.date.today()
    # hora = datetime.datetime.now().time()
    # print("Data:",dia)
    # print("Hora:",hora)
    # todos_os_discos= psutil.disk_partitions()
    # for disco in todos_os_discos:
    #     if(disco[3]!="cdrom"):
    #         Porcentagem=psutil.disk_usage(disco[0])[3]
    #         print("Disco {}: \t Porcentagem: {} %".format(disco[0],round(Porcentagem,2)))

    # Disponivel=psutil.virtual_memory()[1]/1024/1024/1024
    # Porcentagem=psutil.virtual_memory()[2]
    # print("Memoria virtual disponivel:",round(Disponivel,2),"GB")
    # print("Memoria virtual:",Porcentagem,"%")
    
    # percpu = psutil.cpu_percent(interval=1)
    # print("CPU",percpu,"%")
    # per_cpu_solo = psutil.cpu_percent(interval=1, percpu=True)
    # a=1
    # for itens in per_cpu_solo:
        
    #     print("CPU ",a,":",itens,"%")
    #     a=a+1

    time.sleep(5)
