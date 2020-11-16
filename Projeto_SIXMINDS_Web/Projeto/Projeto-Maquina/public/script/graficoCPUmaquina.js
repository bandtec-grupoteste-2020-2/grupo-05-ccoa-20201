core2();
atualizarCPU();

let leituraUsoPorc2 = [];

function plotarCPU(tempoLeitura, leituraUsoPorc, leituraUsoPorc2) {
  var ctx = document.getElementById("cpu_chart").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "line",
    data: {
      labels: tempoLeitura,
      datasets: [
        {
          label: "% de utilização Core 1",
          data: leituraUsoPorc,
          fill: true,
          backgroundColor: "rgba(239, 71, 111, 0.30)",
          borderColor: "rgba(239, 71, 111, 0.69)",
          borderWidth: 1,
        },

        {
          label: "% de utilização Core 2",
          data: leituraUsoPorc2,
          fill: true,
          backgroundColor: "rgba(255, 209, 102, 0.30)",
          borderColor: "rgba(255, 209, 102, 0.69)",
          borderWidth: 1,
        },
      ],
    },
    options: {
      responsive: true,
      scales: {
        yAxes: [
          {
            ticks: {
              beginAtZero: true,
            },
          },
        ],
      },
    },
  });
}

function core2() {
  fetch("http://localhost:3000/leituras/dadosCore2", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let registro = resposta;
          console.log(registro);
          console.log(registro.length);
          leituraUsoPorc2 = [];

          for (n = registro.length - 1; n >= 0; n--) {
            leituraUsoPorc2.push(registro[n].valorCore2);
          }
          console.log(leituraUsoPorc2);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
}

window.onload = atualizarCPU();
function atualizarCPU() {
  fetch("http://localhost:3000/leituras/dadosCore", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let registro = resposta;
          console.log(registro);
          console.log(registro.length);
          let leituraUsoPorc = [];
          let tempoLeitura = [];

          for (n = registro.length - 1; n >= 0; n--) {
            leituraUsoPorc.push(registro[n].valor);
            tempoLeitura.push(registro[n].hora);
          }
          console.log(registro[0].hora);
          console.log(leituraUsoPorc);
          core2();

          plotarCPU(tempoLeitura, leituraUsoPorc, leituraUsoPorc2);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
    
  setTimeout(() => {
    atualizarCPU();
    myChart.destroy();
  }, 5000);
}
