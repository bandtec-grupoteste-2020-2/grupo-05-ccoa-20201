// mistura();
atualizarDisco();
var destroi = 0;
function plotardisco(tempoLeitura, leituraTemperatura) {
    if (destroi >= 1) {
        myChart.destroy();
        destroi = 0;
    }
    var ctx = document.getElementById('disk_use_chart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: leituraTemperatura,
        datasets: [{
            label: '% espaço ocupado',
            data: tempoLeitura,
            backgroundColor: 'rgba(255, 159, 64, 0.2)',
            borderColor: 'rgba(255, 159, 64, 0.2)',
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
destroi ++;
}
// window.onload = mistura();
// function mistura() {
window.onload = atualizarDisco();
function atualizarDisco() {
    fetch("http://localhost:3000/leituras/dadosDiscoTemp", { cache: "no-store" })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    let registro = resposta;
                    console.log(registro);
                    console.log(registro.length);
                    let leituraTemperatura = [];
                    let tempoLeitura = [];

                    for (n = registro.length - 1; n >= 0; n--) {
                        leituraTemperatura.push(registro[n].valor);
                        tempoLeitura.push(registro[n].hora);
                    }
                    console.log(registro[0].hora);
                    console.log(leituraTemperatura);

                    plotardisco(leituraTemperatura, tempoLeitura);
                });
            } else {
                console.error("Nenhum dado encontrado ou erro na leituras");
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
    setTimeout(() => {
        atualizarDisco();
    }, 5000);
}

    // function atualizarDiscoTemp() {
    //     fetch("http://localhost:3000/leituras/dadosDiscoPerc", { cache: "no-store" })
    //         .then(function (response) {
    //             if (response.ok) {
    //                 response.json().then(function (resposta) {
    //                     console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
    //                     let registro = resposta;
    //                     console.log(registro);
    //                     console.log(registro.length);
    //                     let leituraMemoria = [];

    //                     for (n = registro.length - 1; n > 0; n--) {
    //                         leituraMemoria.push(registro[n].valor);
    //                         tempoLeitura.push(registro[n].hora);
    //                     }
    //                     console.log(registro[0].hora);
    //                     console.log(leituraMemoria);

    //                 });
    //             } else {
    //                 console.error("Nenhum dado encontrado ou erro na leituras");
    //             }
    //         })
    //         .catch(function (error) {
    //             console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    //         });
    // }
    // plotarDisco(leituraMemoria, leituraTemperatura, tempoLeitura);
    // setTimeout(() => {
    //     atualizarDisco();
    // }, 5000);
// }