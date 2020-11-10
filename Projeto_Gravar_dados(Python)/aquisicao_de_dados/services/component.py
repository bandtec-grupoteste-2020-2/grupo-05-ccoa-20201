class Cpu:
 
    def __init__(self, value, status):
        self.value = value
        self.status = status
        self.chinelo = None

    template_phrase = 'Processador {}% . Está em {}'


    def createString(self):
        result_string = self.template_phrase.format(self.value, self.status)
        # print(self.template_phrase)
        return result_string






class Disk: 
    pass

class Memory: 
    pass