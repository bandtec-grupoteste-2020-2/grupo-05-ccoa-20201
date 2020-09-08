
window.onload = atualizarGrafico;
function atualizarGrafico() {

    fetch('/leituras/estatisticas', { cache: 'no-store' }).then(function (response) {
        if (response.ok) {

            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

            

                    const contexto = document.getElementById(`grafico`).getContext('2d');

                    var registro = resposta;
                    var largura = registro.length
                    var dado=[]
                    var dado2=[]
                for(i=0;i<largura;i++){
                    dado.push(registro[i].temp)

                }
                for(i=0;i<largura;i++){
                    dado2.push(registro[i].umidade)

                }
                console.log(dado)
                console.log(dado2)
					
                    plotarGrafico(contexto, dado, dado2);
                  
            })
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    }).catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

    setTimeout(() => {
        atualizarGrafico();

    }, 5000);
}
/*SOLO */
window.onload = atualizarGraficosolo;
function atualizarGraficosolo() {

    fetch('/leituras/estatisticas2', { cache: 'no-store' }).then(function (response) {
        if (response.ok) {

            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

            

                    const contexto = document.getElementById(`graficosolo`).getContext('2d');

					var registro = resposta;

                    var largura = registro.length
                    var dado=[]
                    var dado2=[]
                for(i=0;i<largura;i++){
                    dado.push(registro[i].temp)

                }
                for(i=0;i<largura;i++){
                    dado2.push(registro[i].umidade)

                }
                console.log(dado)
                console.log(dado2)
              
                    plotarGrafico2(contexto, dado, dado2);
                 
            })
        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    }).catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

    setTimeout(() => {
        atualizarGraficosolo();

    }, 5000);
   
}



