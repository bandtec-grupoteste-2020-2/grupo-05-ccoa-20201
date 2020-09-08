
window.onload = atualizarGraficoGrande;
atualizarGraficoGrande(){
    fetch('/leituras/graficosao1', { cache: 'no-store' }).then(function (response){
        if (response.ok) {
            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                const contexto = document.getElementById(`myChart`).getContext('2d');
                var registro = resposta;
                
            }
        }
    }
} 