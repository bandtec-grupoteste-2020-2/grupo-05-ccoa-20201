from services.mysql import Mysql
from services.pytentativa import CrawlerOpenHardwareMonitor
from services.dataGenerator import geranumeroaleatorio
import time



mysql = Mysql('urubu100', 'urubu100', 'localhost', 'MAQUINAS')
mysql.connect()

teste =  CrawlerOpenHardwareMonitor()

while True:
    dataset = teste.getComponente(teste.getInfo())
    print(dataset)
    for i in dataset:        
        # print(i)
        mysql.insert_comp2(i)
    time.sleep(5)
# for k in dataset:
#     print(k, dataset[k])
