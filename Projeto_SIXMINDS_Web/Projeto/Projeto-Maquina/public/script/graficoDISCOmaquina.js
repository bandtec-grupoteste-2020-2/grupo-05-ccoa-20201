discoPorcentagem();
atualizarDisco();

let leituraPorcentagem = [];
var destroi = 0;
function plotardisco(tempoLeitura,leituraTemperatura, leituraPorcentagem) {
  //   if (destroi <= 1) {
  //     myChart.destroy();
  //     destroi = 0;
  //   }
  var ctx = document.getElementById("disk_use_chart").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: tempoLeitura,
      datasets: [
        {
          label: "Temperatura (°C)",
          data: leituraTemperatura,
          fill: true,
          backgroundColor: "rgba(255, 209, 102, 0.69)",
          borderColor: "rgba(255, 209, 102, 0.69)",
          borderWidth: 1,
        },

        {
          label: "Espaço ocupado (%)",
          data: leituraPorcentagem,
          fill: true,
          backgroundColor: "rgba(6, 214, 160, 0.69)",
          borderColor: "#0096889c",
          borderWidth: 1,
        },
      ],
    },
    options: {
      responsive: true,
      scales: {
        yAxes:  [
          {
            ticks: {
              beginAtZero: true,
            },
          },
        ],
      },
    },
  });
  destroi++;
}

function discoPorcentagem(){
    fetch("http://localhost:3000/leituras/dadosDiscoPerc", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let registro = resposta;
          console.log(registro);
          console.log(registro.length);
          leituraPorcentagem = [];

          for (n = registro.length - 1; n >= 0; n--) {
            leituraPorcentagem.push(registro[n].valorDiscoUsoPorc);
          }
          console.log(registro[0].hora);
          console.log(leituraPorcentagem);

          
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
}


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
            leituraTemperatura.push(registro[n].valorDiscoTemp);
            tempoLeitura.push(registro[n].hora);
          }
          console.log(registro[0].hora);
          console.log(leituraTemperatura);
          discoPorcentagem();

          plotardisco(tempoLeitura,leituraTemperatura, leituraPorcentagem);
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
    myChart.destroy();
  }, 5000);
}
