nome_tabela=Maquina.IOT

Memoria_percent=subset(nome_tabela,descricao=='Memoria uso %',metrica='%')
plot(as.Date(Memoria_percent$tempoLeitura),Memoria_percent$valor,main = 'Memória usada em %',xlab ="Tempo",ylab = "%" )
hist(Memoria_percent$valor,main = 'Memória usada em %',xlab ='Valor da memória usada em %',ylab = 'Frequência' )
summary(Memoria_percent$valor)

Memoria_uso=subset(nome_tabela,descricao=='Memoria uso GB',metrica='GB')
plot(as.Date(Memoria_uso$tempoLeitura),Memoria_uso$valor,main = 'Memória usada em GB',xlab ="Tempo",ylab = "GB" )
hist(Memoria_uso$valor,main = 'Memoria uso GB',xlab ='Valor da memória usada em GB',ylab = 'Frequência')
summary(Memoria_uso$valor)

Memoria_livre=subset(nome_tabela,descricao=='Memoria livre GB',metrica='GB')
plot(as.Date(Memoria_livre$tempoLeitura),Memoria_livre$valor,main = 'Memória Livre em GB',xlab ="Tempo",ylab = "GB" )
hist(Memoria_livre$valor,main = 'Memoria livre GB',xlab ='Valor da memória usada em GB',ylab = 'Frequência')
summary(Memoria_livre$valor)