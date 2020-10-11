from services.mysql import Mysql
from services.pythohms import CrawlerOpenHardwareMonitor
from services.dataGenerator import geranumeroaleatorio



mysql = Mysql('urubu100', 'urubu100', 'localhost', 'MAQUINAS')
mysql.connect()

teste =  CrawlerOpenHardwareMonitor()
# teste.getInfo()

while True:
    fk_maquina = geranumeroaleatorio()
    dataset = teste.getInfo()
    print(dataset)
    # mysql.insert_comp(dataset)
# for k in dataset:
#     print(k, dataset[k])



