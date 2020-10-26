import psutil
from datetime import datetime
from random import randint
import requests
import json
URL = 'https://hooks.slack.com/services/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'
dici={'text':''}


def enviar(dataset_leituras):
    verificarMaquina(dataset_leituras)
    response = requests.post(URL,json = dici)#link para conectar o bot, o url tem q na linha 6
    print(dici, response)
    dici['text']=''
    return response

def verificarMaquina(componente_maquina):
   #MAQUINA 1 IOT

    novo_dataset_com_status= componente_maquina

    for i in novo_dataset_com_status:

        erro=0
        if i[0]==1:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de IOT está utilizando:\n"
            if i[1]==3:
                if i[2] <= 25.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 50.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1


            # VALORES DA MEMORIA RAM   4=ramGb
                    
            
            elif i[1]==4:
                if i[2] <= 25.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 50.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1


            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=30.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=60.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DO DISCO    disco=2
            
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=40.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=65.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1
        

    # MAQUINA 2 Usuario
        if i[0]==2:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de Usuario está utilizando:\n"
            if i[1]==3:
                if i[2] <= 50.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 60.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA MEMORIA RAM   4=ramGb
            elif i[1]==4:
                if i[2] <= 50.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 60.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=50.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=65.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES do disco    disco=2
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=50.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=75.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1

    #MAQUINA 3 Servidor
        if i[0]==3:
            # VALORES DA MEMORIA RAM   3=ram%
            dici['text']+="A máquina de Servidor está utilizando:\n"
            if i[1]==3:
                if i[2] <= 75.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 80.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA MEMORIA RAM   4=ramGb
            elif i[1]==4:
                if i[2] <= 75.0:
                    i.append("BOM!")
                    pass
                elif i[2] <= 80.0:
                    dici['text']+=("Memória {}% -- {} GB. Melhor ficar alerta.\n".format(i[2], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Memória {}% -- {} GB. Está em emergência.\n".format(i[2], i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES DA CPU    cpu=1    
            elif i[1]==1:
                if i[2]<=75.0:
                    i.append("BOM!")                    
                    pass
                elif i[2]<=90.0:
                    dici['text']+=("Processador {}% . Melhor ficar alerta.\n".format(i[2]))
                    i.append("ALERTA!")
                    erro+=1                    
                else:
                    dici['text']+=("Processador {}% . Está em emergência.\n".format(i[2]))
                    i.append("EMERGÊNCIA!")
                    erro+=1
            # VALORES do disco    disco=2
            # for z in values_disco[0]:
            if i[1]==2:
                if i[2]<=70.0:
                    i.append("BOM!")
                    pass
                elif i[2]<=90.0:
                    dici['text']+=("Disco {} -- {}% . Melhor ficar alerta.\n".format(i[-1], i[2]))
                    i.append("ALERTA!")
                    erro+=1
                else:
                    dici['text']+=("Disco {} -- {}% . Está em emergência.\n".format(i[-1], i[2]))
                    i.append("EMERGÊNCIA")
                    erro+=1
        if erro==0:
            dici['text']=''

    return novo_dataset_com_status

