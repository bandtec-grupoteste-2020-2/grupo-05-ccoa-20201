from services.mysql import Mysql
from services.dataGenerator import get_data_cpu
from services.dataGenerator import get_data_ram
from services.dataGenerator import get_data_disco
from services.dataGenerator import arroz
import time

#Inserir user, password, host, database
mysql = Mysql('urubu100','urubu100', 'localhost', 'MAQUINAS')

mysql.connect()

while True:
    # values = getData()
    # values_ram = get_data_ram()
   
    values_ram = get_data_ram()
    mysql.insert_ram(values_ram)
    # time.sleep(5)

    values_cpu = get_data_cpu()
    mysql.insert_cpu(values_cpu)

    values_disco = get_data_disco()
    mysql.insert_disco(values_disco)

    feijao = arroz()
    
    time.sleep(5)
