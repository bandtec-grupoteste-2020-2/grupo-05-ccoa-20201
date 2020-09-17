from services.mysql import Mysql
from services.dataGenerator import get_data_cpu
from services.dataGenerator import get_data_ram
from services.dataGenerator import get_data_disco
from services.dataGenerator import enviar
from services.dataGenerator import geranumeroaleatorio
import time

#Inserir user, password, host, database
mysql = Mysql('urubu100','urubu100', 'localhost', 'MAQUINAS')

mysql.connect()

while True:

    numerogerado=geranumeroaleatorio()

    values_ram = get_data_ram(numerogerado)
    mysql.insert_ram(values_ram)


    values_cpu = get_data_cpu(numerogerado)
    mysql.insert_cpu(values_cpu)

    values_disco = get_data_disco(numerogerado)
    mysql.insert_disco(values_disco)

    enviar(numerogerado,values_ram,values_cpu,values_disco)
    
    time.sleep(5)
