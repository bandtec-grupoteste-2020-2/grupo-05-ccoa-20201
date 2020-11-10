if (Maquina_IOT >= 1 ) {
  nome_tabela=Maquina_IOT
} 
if ( Maquina.IOT >= 1) {
  nome_tabela=Maquina.IOT
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
  plot(as.Date(cpu_core1_uso_perc$dataleitura),cpu_core1_uso_perc$valor,main = 'Uso da core 1 %/tempo',xlab ="Tempo",ylab = "%" ,ylim=c(0,100))
  plot(as.Date(cpu_core2_uso_perc$dataleitura),cpu_core2_uso_perc$valor,main = 'Uso da core 2 %/tempo',xlab ="Tempo",ylab = "%" ,ylim=c(0,100)) 
  plot(as.Date(cpu_core3_uso_perc$dataleitura),cpu_core3_uso_perc$valor,main = 'Uso da core 3 %/tempo',xlab ="Tempo",ylab = "%" ,ylim=c(0,100))
  plot(as.Date(cpu_core4_uso_perc$dataleitura),cpu_core4_uso_perc$valor,main = 'Uso da core 4 %/tempo',xlab ="Tempo",ylab = "%" ,ylim=c(0,100))
}


#Criação de cada plot (ordenado por Id)
{
  plot(cpu_core1_uso_perc$valor~cpu_core1_uso_perc$idLeitura, main = "Core 1 % / id", xlab = "tempo", ylab = "%")
  plot(cpu_core2_uso_perc$valor~cpu_core2_uso_perc$idLeitura, main = "Core 2 % / id", xlab = "tempo", ylab = "%")
  plot(cpu_core3_uso_perc$valor~cpu_core3_uso_perc$idLeitura, main = "Core 3 % / id", xlab = "tempo", ylab = "%")
  plot(cpu_core4_uso_perc$valor~cpu_core4_uso_perc$idLeitura, main = "Core 4 % / id", xlab = "tempo", ylab = "%")
}

#Criação dos plot em linear model
  plot(lm(cpu_core1_uso_perc$valor~cpu_core1_uso_perc$idLeitura)) 
  plot(lm(cpu_core2_uso_perc$valor~cpu_core2_uso_perc$idLeitura))
  plot(lm(cpu_core3_uso_perc$valor~cpu_core3_uso_perc$idLeitura))
  plot(lm(cpu_core4_uso_perc$valor~cpu_core4_uso_perc$idLeitura))
  
  #Criação dos Hist
  {
    par(mfrow=c(2,2), mar=c(2.5,4,3.5,0.5))
    hist(cpu_core1_uso_perc$valor,main = 'Uso da core 1 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
    hist(cpu_core2_uso_perc$valor,main = 'Uso da core 2 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
    hist(cpu_core3_uso_perc$valor,main = 'Uso da core 3 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
    hist(cpu_core4_uso_perc$valor,main = 'Uso da core 4 em Freq / %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
    
    #Estado em que o core da CPU se encontra
    #CPU CORE 1 
    if (nrow(cpu_core1_uso_perc[cpu_core1_uso_perc$valor <= 30,]) > floor(nrow(cpu_core1_uso_perc)* 0.5)){
      print("CPU Core1 se encontra em estado BOM!")
      
    } else if(nrow(cpu_core1_uso_perc[cpu_core1_uso_perc$valor <= 60,]) > floor(nrow(cpu_core1_uso_perc)* 0.5)){
      print("CPU Core1 se encontra em estado de ALERTA!")
      
    } else {
      print("CPU Core1 se encontra em estado de EMERGÊNCIA!")
    }
    
    #CPU CORE 2 %
    if (nrow(cpu_core2_uso_perc[cpu_core2_uso_perc$valor <= 30,]) > floor(nrow(cpu_core2_uso_perc)* 0.5)){
      print("CPU Core2 se encontra em estado BOM!")
      
    } else if(nrow(cpu_core2_uso_perc[cpu_core2_uso_perc$valor <= 60,]) > floor(nrow(cpu_core2_uso_perc)* 0.5)){
      print("CPU Core2 se encontra em estado de ALERTA!")
      
    } else {
      print("CPU Core2 se encontra em estado de EMERGÊNCIA!")
    }
    
    #CPU CORE 3 %
    if (nrow(cpu_core3_uso_perc[cpu_core3_uso_perc$valor <= 30,]) > floor(nrow(cpu_core3_uso_perc)* 0.5)){
      print("CPU Core3 se encontra em estado BOM!")
      
    } else if(nrow(cpu_core3_uso_perc[cpu_core3_uso_perc$valor <= 60,]) > floor(nrow(cpu_core3_uso_perc)* 0.5)){
      print("CPU Core3  se encontra em estado de ALERTA!")
      
    } else {
      print("CPU Core3  se encontra em estado de EMERGÊNCIA!")
    }
    
    #CPU CORE 4 %
    if (nrow(cpu_core4_uso_perc[cpu_core4_uso_perc$valor <= 30,]) > floor(nrow(cpu_core4_uso_perc)* 0.5)){
      print("CPU Core4 se encontra em estado BOM!")
      
    } else if(nrow(cpu_core4_uso_perc[cpu_core4_uso_perc$valor <= 60,]) > floor(nrow(cpu_core4_uso_perc)* 0.5)){
      print("CPU Core4 se encontra em estado de ALERTA!")
      
    } else {
      print("CPU Core4 se encontra em estado de EMERGÊNCIA!")
    }
  }






