from services.mysql import Mysql
from services.dataGenerator import getData
import time

#Inserir user, password, host, database
mysql = Mysql('teste2','bandtec', 'localhost', 'PROJETO')

mysql.connect()

while True:
    values = getData()
    mysql.insert(values)
    time.sleep(2)
