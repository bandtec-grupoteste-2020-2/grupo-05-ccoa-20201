import requests
import json

class CrawlerOpenHardwareMonitor:
    def __init__(self):
        self.url = 'http://192.168.0.8:9000/data.json'
        self.data = None
    
    def getJsonData(self):
        response = requests.get(self.url)
        data = json_data = response.json()
        self.data = data
    
    def getInfo(self):
        self.getJsonData()
        info = {
            "Desktop": None,
            "CPU": [],
            "Memory": {
                "Load": None,
                "Use": None,
                'Available': None
            },
            "Disco":[]
        }

        clocks = []
        temperatures = []
        loads = []
        
        data = self.data

        for i in data['Children']:
            info['Desktop'] = i['Text']
            for desktop in i['Children']:
                if desktop['id'] <= 2:
                    info['MotherBoard'] = desktop['Text']
                if desktop['Text'].find('Generic Hard Disk') < 0:
                    info['AllDevices'].append(desktop['Text'])
                #CPU
                if desktop['Text'].find('Intel') >= 0 or desktop['Text'].find('AMD') >= 0:
                    for cpu_metrics in desktop['Children']:
                        #clock
                        if cpu_metrics['Text'] == 'Clocks':
                            for clock in cpu_metrics['Children']:
                                if clock['Text'].find('CPU') >= 0:
                                    clocks.append(clock['Value'])
                        #temperature
                        if cpu_metrics['Text'] == 'Temperatures':
                            for temps in cpu_metrics['Children']:
                                if temps['Text'].find('CPU') >= 0:
                                    temperatures.append(temps['Value'])
                        #load
                        if cpu_metrics['Text'] == 'Load':
                            for load in cpu_metrics['Children']:
                                if load['Text'].find('CPU') >= 0:
                                    loads.append(load['Value'])
                #Memory
                if desktop['Text'].find('Generic Memory') >= 0 or desktop['Text'].find('Memory') >= 0:
                    for cpu_metrics in desktop['Children']:
                        #Load
                        if cpu_metrics['Text'] == 'Load':
                            for memory in cpu_metrics['Children']:
                                if memory['Text'] == 'Memory':
                                    info['Memory']['Load'] = memory['Value']
                        #Use
                        if cpu_metrics['Text'] == 'Data':
                            for memory in cpu_metrics['Children']:
                                if memory['Text'] == 'Used Memory':
                                    info['Memory']['Use'] = memory['Value']
                                if memory['Text'] == 'Available Memory':
                                    info['Memory']['Available'] = memory['Value']

            for index, itens in enumerate(clocks):
                cpu = {
                    'Name': f'Core {index + 1}',
                    "Clock": clocks[index],
                    "Temperature": temperatures[index],
                    "Load": loads[index]
                }
                info['CPU'].append(cpu)
            return info


if __name__ == "__main__":
    teste =  CrawlerOpenHardwareMonitor()
    teste.getInfo()

    dataset = teste.getInfo()
    for k in dataset:
        print(k, dataset[k])
