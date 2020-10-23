if (Maquina_IOT >= 1 || Maquina.IOT >= 1) {
  nome_tabela=Maquina_IOT
} 

#Criação dos subconjuntos
{
  Memoria_percent=subset(nome_tabela,descricao=='Memoria uso %',metrica='%')
  Memoria_uso=subset(nome_tabela,descricao=='Memoria uso GB',metrica='GB')
  Memoria_livre=subset(nome_tabela,descricao=='Memoria livre GB',metrica='GB')
}

#Criação dos plot
{
  par(mfrow=c(2,2), mar=c(4,4,3.5,0.5))
  plot(as.Date(Memoria_percent$dataleitura),Memoria_percent$valor,main = 'Memória usada em %',xlab ="Tempo",ylab = "%" )
  plot(as.Date(Memoria_uso$dataleitura),Memoria_uso$valor,main = 'Memória usada em GB',xlab ="Tempo",ylab = "GB" )
  plot(as.Date(Memoria_livre$dataleitura),Memoria_livre$valor,main = 'Memória Livre em GB',xlab ="Tempo",ylab = "GB" )
}

#Criação dos Hist
{
  par(mfrow=c(2,2), mar=c(2.5,4,3.5,0.5))
  hist(Memoria_percent$valor,main = 'Memória usada em %',xlab ='Valor da memória usada em %',ylab = 'Frequência' )
  hist(Memoria_uso$valor,main = 'Memoria uso GB',xlab ='Valor da memória usada em GB',ylab = 'Frequência' )
  hist(Memoria_livre$valor,main = 'Memoria livre GB',xlab ='Valor da memória usada em GB',ylab = 'Frequência' )
}

#Criação dos summary
summary(Memoria_percent$valor)
summary(Memoria_uso$valor)
summary(Memoria_livre$valor)
