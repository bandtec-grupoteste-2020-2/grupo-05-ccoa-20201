function adicionar_eliminar_novos_valores(tempoLeitura){

    atualizarDisco_geral(0);
    atualizarMemoriaGeral(0)
    eliminar_disco();
    eliminar_memoria();
    eliminar_cpu(tempoLeitura)
}
function destruir_tudo(){
    
    myChart.destroy();
    myChart_cpu_geral.destroy();
    myChart_disk.destroy();
    myChart_disk_geral.destroy();
    myChart_memoria.destroy();
    myChart_memoria_geral.destroy();
    atualizarDisco_geral(1);
    atualizarMemoriaGeral(1);
    
}
function plotar_tudo(){
    discoPorcentagem_geral();
    atualizarDisco_geral(1);
    atualizarMemoriaGeral(1);
}