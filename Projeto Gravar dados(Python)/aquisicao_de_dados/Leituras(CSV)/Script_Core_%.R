if (Maquina_IOT >= 1 || Maquina.IOT >= 1) {
  nome_tabela=Maquina_IOT
} 

#Criação dos subconjuntos
{
  cpu_core1_uso_perc=subset(subset(nome_tabela,descricao=='Core 1'),metrica=='%')
  cpu_core2_uso_perc=subset(subset(nome_tabela,descricao=='Core 2'),metrica=='%') 
  cpu_core3_uso_perc=subset(subset(nome_tabela,descricao=='Core 3'),metrica=='%')
  cpu_core4_uso_perc=subset(subset(nome_tabela,descricao=='Core 4'),metrica=='%')
  }

#Criação de cada plot (dias da semana)
{
  par(mfrow=c(2,2), mar=c(4,4,3.5,0.5))
  plot(as.Date(cpu_core1_uso_perc$dataleitura),cpu_core1_uso_perc$valor,main = 'Uso da core 1 %/tempo',xlab ="Tempo",ylab = "%" )
  plot(as.Date(cpu_core2_uso_perc$dataleitura),cpu_core2_uso_perc$valor,main = 'Uso da core 2 %/tempo',xlab ="Tempo",ylab = "%" ) 
  plot(as.Date(cpu_core3_uso_perc$dataleitura),cpu_core3_uso_perc$valor,main = 'Uso da core 3 %/tempo',xlab ="Tempo",ylab = "%" )
  plot(as.Date(cpu_core4_uso_perc$dataleitura),cpu_core4_uso_perc$valor,main = 'Uso da core 4 %/tempo',xlab ="Tempo",ylab = "%" )
}

#Criação de cada plot (ordenado por Id)
{
  plot(Core1_porc$valor~Core1_porc$idLeitura, main = "Core 1 % / id", xlab = "tempo", ylab = "%")
  plot(Core2_porc$valor~Core2_porc$idLeitura, main = "Core 2 % / id", xlab = "tempo", ylab = "%")
  plot(Core3_porc$valor~Core3_porc$idLeitura, main = "Core 3 % / id", xlab = "tempo", ylab = "%")
  plot(Core4_porc$valor~Core4_porc$idLeitura, main = "Core 4 % / id", xlab = "tempo", ylab = "%")
}

#Criação dos Hist
{
  par(mfrow=c(2,2), mar=c(2.5,4,3.5,0.5))
  hist(cpu_core1_uso_perc$valor,main = 'Uso da core 1 em Freq / % ',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
  hist(cpu_core2_uso_perc$valor,main = 'Uso da core 2 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
  hist(cpu_core3_uso_perc$valor,main = 'Uso da core 3 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
  hist(cpu_core4_uso_perc$valor,main = 'Uso da core 4 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
}

#Criação dos summary

  summary(cpu_core1_uso_perc$valor)
  summary(cpu_core2_uso_perc$valor)
  summary(cpu_core3_uso_perc$valor)
  summary(cpu_core4_uso_perc$valor)


#Criação dos plot em linear model 
  par(mfrow=c(2,2), mar=c(4,4,3.5,0.5))
  plot(lm(cpu_core1_uso_perc$valor~cpu_core1_uso_perc$idLeitura)) 
  plot(lm(cpu_core2_uso_perc$valor~cpu_core2_uso_perc$idLeitura))
  plot(lm(cpu_core3_uso_perc$valor~cpu_core3_uso_perc$idLeitura))
  plot(lm(cpu_core4_uso_perc$valor~cpu_core4_uso_perc$idLeitura))






