atualizarMemoria();
var destroi = 0;
function plotarMemoria(leituraUso, tempoLido) {
    if (destroi >= 1) {
        myChart.destroy();
        destroi = 0;
    }
    var ctx = document.getElementById('memory_use_chart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: tempoLido,
            datasets: [{
                label: '% uso',
                data: leituraUso,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 0.2)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
    destroi ++
}
window.onload = atualizarMemoria();
function atualizarMemoria() {
    fetch("http://localhost:3000/leituras/dadosMemoriaUsoPerc", { cache: "no-store" })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    let registro = resposta;
                    console.log(registro);
                    console.log(registro.length);
                    let leituraUso = [];
                    let tempoLido = [];

                    for (n = 0; n < registro.length; n++) {
                        leituraUso.push(registro[n].valor);
                        tempoLido.push(registro[n].hora);
                    }
                    console.log(registro[0].hora);
                    console.log(leituraUso);

                    plotarMemoria(leituraUso, tempoLido);
                });
            } else {
                console.error("Nenhum dado encontrado ou erro na leituras");
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
    setTimeout(() => {
        atualizarMemoria();
    }, 5000);
}