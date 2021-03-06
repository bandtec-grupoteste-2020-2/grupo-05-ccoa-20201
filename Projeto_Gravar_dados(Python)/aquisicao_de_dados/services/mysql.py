import mysql.connector


class Mysql:
    def __init__(self, user, password, host, database):
        self.user = user
        self.password = password
        self.host = host
        self.database = database
        self.mysql = None
        self.cursor = None

    #Estabelecendo uma conexão
    def connect(self):
        try:
            self.mysql = mysql.connector.connect(
            user=self.user, password=self.password, host=self.host, database=self.database, auth_plugin='mysql_native_password')
            #Criando cursor para manipulação do banco.
            print(self.mysql)
            print("\033[32m", "Conexao ao Banco Estabelecida", "\033[0;0m")
            self.cursor = self.mysql.cursor()
        except Exception as err:
            print(err)
            print("\033[31m", "Erro na Conexão ao Banco", "\033[0;0m")                                                                                  
            raise

    def insert_comp(self, data):
        # print(data)
                
        query = ("INSERT INTO Leitura (fkMaquinaComponente, valor, tempoLeitura, descricao)"
        "VALUES(%s ,%s, %s, %s)"
        )
     
        values = data
        try:
            self.cursor.execute(query, values)
            self.mysql.commit()

        except Exception as err:
            print(err)
            self.mysql.rollback()
            self.close()

    def insert_comp2(self, data):
    
        # print(data)    
        query = ("INSERT INTO `Clima`(dia, minimo, maximo)"
        "VALUES(%s ,%s, %s)"
        )
     
        values = data
        try:
            self.cursor.execute(query, values)
            self.mysql.commit()

        except Exception as err:
            print(err)
            self.mysql.rollback()
            self.close()

            
    # def insert_ram(self, data):
    #     query = (
    #         "INSERT INTO `RamLeituras`(ramPorcentagem, ramUsadaGb, tempoLeitura, fkMaquina)"
    #         "VALUES (%s, %s, %s, %s)"    
    #     )    
    #     values = data
    #     try:
    #         # print('Inserindo Valores')
    #         self.cursor.execute(query,values)
    #         self.mysql.commit()
    #     except Exception as err:
    #         print(err)
    #         self.mysql.rollback()
    #         self.close()

    def verificar_ativado_componente(self):

        query = "SELECT idMaquinaComponente, nomeComponente, fkMaquina, ativado FROM MaquinaComponente, Componente WHERE idComponente=fkComponente;"

        try:
            self.cursor.execute(query)
            select_result = self.cursor.fetchall()

            # for x in select_result:
            #     print(x)

            return select_result


        except Exception as err:
            print(err)
            self.mysql.rollback()
            self.close()

    # def insert_cpu(self, data):

    #     for k in range(len(data[0])):

    #         query = (
    #             "INSERT INTO `CPULeituras`(nomeCPU, CPUPorcentagem, tempoLeitura, fkMaquina)"
    #             "VALUES (%s, %s, %s, %s)"    
    #         )    

    #         values = ("CPU_{}".format(k), data[0]["CPU_{}".format(k)], data[1], data[2])
    #         try:
    #             # for cpu in values:
    #             # print('Inserindo Valores')
    #             self.cursor.execute(query,values)
    #             self.mysql.commit()
    #         except Exception as err:
    #             print(err)
    #             self.mysql.rollback()
    #             self.close()          

    # def insert_disco(self, data):

    #     for key in data[0]:

    #         query = (
    #             "INSERT INTO `DiscosLeitura`(discoNome, discoPercentual, tempoLeitura, fkMaquina)"
    #             "VALUES (%s, %s, %s, %s)"    
    #         )    
    #         #O data[0] ainda não há certeza, 
    #         #mas se leva a crer que esteja correto. Obs.:César
            
    #         values = (key, data[0][key], data[1], data[2])
    #         try:
    #             # for cpu in values:
    #             # print('Inserindo Valores')
    #             self.cursor.execute(query,values)
    #             self.mysql.commit()
    #         except Exception as err:
    #             print(err)
    #             self.mysql.rollback()
    #             self.close()  
    
    # Fechando conexão
    def close(self):
        self.mysql.close()

        


