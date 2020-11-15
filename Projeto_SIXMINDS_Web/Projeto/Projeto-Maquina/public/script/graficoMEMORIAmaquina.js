atualizarMemoria();
var destroi = 0;
function plotarMemoria(leituraUso, tempoLido, leituraUsoGB) {
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
                backgroundColor: "rgba(17, 138, 178, 0.30)",
                borderColor: "rgba(17, 138, 178, 1)",
                borderWidth: 1
            },
            {
                label: 'GB uso',
                data: leituraUsoGB,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 0.2)',
                borderWidth: 1
            },
            ]
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
    destroi++
}
function memoriaGB() {
    fetch("http://localhost:3000/leituras/dadosMemoriaUsoGB", { cache: "no-store" })
        .then(function (response) {
            if (response.ok) {
                response.json().then(function (resposta) {
                    console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
                    let registro = resposta;
                    console.log(registro);
                    console.log(registro.length);
                    leituraUsoGB = [];

                    for (n = registro.length - 1; n >= 0; n--) {
                        leituraUsoGB.push(registro[n].valormemoriaGB);
                    }
                    console.log(leituraUsoGB);

                });
            } else {
                console.error("Nenhum dado encontrado ou erro na leituras");
            }
        })
        .catch(function (error) {
            console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
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
                    memoriaGB();

                    plotarMemoria(leituraUso, tempoLido, leituraUsoGB);
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