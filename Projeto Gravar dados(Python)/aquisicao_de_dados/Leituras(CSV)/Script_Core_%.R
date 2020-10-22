nome_tabela=Maquina.IOT

cpu_core1_uso_perc=subset(subset(nome_tabela,descricao=='Core 1'),metrica=='%')
plot(as.Date(cpu_core1_uso_perc$tempoLeitura),cpu_core1_uso_perc$valor,main = 'Uso da core 1',xlab ="Tempo",ylab = "%" )
hist(cpu_core1_uso_perc$valor,main = 'Uso da core 1 em %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
summary(cpu_core1_uso_perc$valor)
plot(lm(cpu_core1_uso_perc$valor~cpu_core1_uso_perc$idLeitura))

cpu_core2_uso_perc=subset(subset(nome_tabela,descricao=='Core 2'),metrica=='%')
plot(as.Date(cpu_core2_uso_perc$tempoLeitura),cpu_core2_uso_perc$valor,main = 'Uso da core 2',xlab ="Tempo",ylab = "%" )
hist(cpu_core2_uso_perc$valor,main = 'Uso da core 2 em %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
summary(cpu_core2_uso_perc$valor)
plot(lm(cpu_core2_uso_perc$valor~cpu_core2_uso_perc$idLeitura))

cpu_core3_uso_perc=subset(subset(nome_tabela,descricao=='Core 3'),metrica=='%')
plot(as.Date(cpu_core3_uso_perc$tempoLeitura),cpu_core3_uso_perc$valor,main = 'Uso da core 3',xlab ="Tempo",ylab = "%" )
hist(cpu_core3_uso_perc$valor,main = 'Uso da core 3 em %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
summary(cpu_core3_uso_perc$valor)
plot(lm(cpu_core3_uso_perc$valor~cpu_core3_uso_perc$idLeitura))

cpu_core4_uso_perc=subset(subset(nome_tabela,descricao=='Core 4'),metrica=='%')
plot(as.Date(cpu_core4_uso_perc$tempoLeitura),cpu_core4_uso_perc$valor,main = 'Uso da core 4',xlab ="Tempo",ylab = "%" )
hist(cpu_core4_uso_perc$valor,main = 'Uso da core 4 em %',xlab ='Valor da CPU usada em %',ylab = 'Frequência' )
summary(cpu_core4_uso_perc$valor)
plot(lm(cpu_core4_uso_perc$valor~cpu_core4_uso_perc$idLeitura))