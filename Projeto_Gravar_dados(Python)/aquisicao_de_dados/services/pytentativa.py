import requests
import json
from datetime import datetime
from random import randint
# import psutil

class CrawlerOpenHardwareMonitor:
    def __init__(self):
        self.url = 'http://apiadvisor.climatempo.com.br/api/v1/forecast/locale/3477/days/15?token=ceba41d508235a46a7e23245c97471bc'
        self.data = None
    
    def getJsonData(self):
        response = requests.get(self.url)
        data = json_data = response.json()
        self.data = data

    def getComponente(self, data):
        dataset_componentes=[]
        for k in data['DATA']:
            lista_dias = [k['Dia'],k['Minimo'],k['Maximo']]
            dataset_componentes.append(lista_dias)
        return dataset_componentes
    
    def getInfo(self):
        self.getJsonData()
        info = {
           
            "DATA": []       
        }

    
        data = self.data

        for i in data['data']:
      
                dia = {
                    'Dia': i["date"],
                    'Minimo': i["temperature"]["min"],
                    'Maximo': i["temperature"]["max"],
                    
                }
                info['DATA'].append(dia)
        return info