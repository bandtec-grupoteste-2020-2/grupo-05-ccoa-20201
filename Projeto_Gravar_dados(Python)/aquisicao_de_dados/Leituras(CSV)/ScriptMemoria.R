if (Maquina_IOT >= 1 || Maquina.IOT >= 1) {
  nome_tabela=Maquina_IOT || nome_tabela =Maquina.IOT
} 

#Cria��o dos subconjuntos
{
  Memoria_percent=subset(nome_tabela,descricao=='Memoria uso %',metrica='%')
  Memoria_uso=subset(nome_tabela,descricao=='Memoria uso GB',metrica='GB')
  Memoria_livre=subset(nome_tabela,descricao=='Memoria livre GB',metrica='GB')
}

#Cria��o dos plot
{
  par(mfrow=c(2,2), mar=c(4,4,3.5,0.5))
  plot(as.Date(Memoria_percent$dataleitura),Memoria_percent$valor,main = 'Mem�ria usada em %',xlab ="Tempo",ylab = "%" )
  plot(as.Date(Memoria_uso$dataleitura),Memoria_uso$valor,main = 'Mem�ria usada em GB',xlab ="Tempo",ylab = "GB" )
  plot(as.Date(Memoria_livre$dataleitura),Memoria_livre$valor,main = 'Mem�ria Livre em GB',xlab ="Tempo",ylab = "GB" )
}

#Cria��o dos Hist
{
  par(mfrow=c(2,2), mar=c(2.5,4,3.5,0.5))
  hist(Memoria_percent$valor,main = 'Mem�ria usada em %',xlab ='Valor da mem�ria usada em %',ylab = 'Frequ�ncia' )
  hist(Memoria_uso$valor,main = 'Memoria uso GB',xlab ='Valor da mem�ria usada em GB',ylab = 'Frequ�ncia' )
  hist(Memoria_livre$valor,main = 'Memoria livre GB',xlab ='Valor da mem�ria usada em GB',ylab = 'Frequ�ncia' )
}

#Cria��o dos summary
summary(Memoria_percent$valor)
summary(Memoria_uso$valor)
summary(Memoria_livre$valor)

#Cria��o dos plot em linear model 
  par(mfrow=c(2,2), mar=c(4,4,3.5,0.5))
  plot(lm(Memoria_percent$valor~Memoria_percent$idLeitura))
  plot(lm(Memoria_uso$valor~Memoria_uso$idLeitura))
  plot(lm(Memoria_livre$valor~Memoria_livre$idLeitura))
  