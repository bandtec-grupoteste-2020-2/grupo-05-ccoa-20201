
atualizarGrafico();

var destroi2 = 0;
function plotarGrafico(porcentagem, tempo, leituraPorcentagem2) {
  if (destroi2 >= 1) {
    myChart.destroy() ;
    destroi2 = 0;
  }
  var ctx = document.getElementById("cpu_use_chart").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "line",
    data: {
      labels: tempo,
      datasets: [
        {
          label: "% de utilização Core 1",
          data: porcentagem,
          fill: true,
          backgroundColor: "rgba(17, 138, 178, 0.30)",
          borderColor: "rgba(17, 138, 178, 1)",
          borderWidth: 1,
        },
        {
          label: "% de utilização Core 2",
          data: leituraPorcentagem2,
          fill: true,
          backgroundColor: "rgba(255, 209, 102, 0.69)",
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
  destroi1++;
}
function core2(){
  fetch("http://localhost:3000/leituras/dadosCore2", { cache: "no-store" })
  .then(function (response) {
    if (response.ok) {
      response.json().then(function (resposta) {
        console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
        let registro = resposta;
        console.log(registro);
        console.log(registro.length);
        leituraPorcentagem2 = [];

        for (n = registro.length - 1; n >= 0; n--) {
          leituraPorcentagem2.push(registro[n].valorCore2);
        }
        console.log(leituraPorcentagem2);

      });
    } else {
      console.error("Nenhum dado encontrado ou erro na leituras");
    }
  })
  .catch(function (error) {
    console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
  });
}
window.onload = atualizarGrafico();
function atualizarGrafico() {
  fetch("http://localhost:3000/leituras/dadosCore", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let registro = resposta;
          console.log(registro);
          console.log(registro.length);
          let porcentagem = [];
          let tempo = [];

          for (n = registro.length-1; n >= 0; n--) {
            porcentagem.push(registro[n].valor);
            tempo.push(registro[n].hora);
          }
          console.log(registro[0].hora);
          console.log(porcentagem);
          core2()

          plotarGrafico(porcentagem, tempo, leituraPorcentagem2);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
  setTimeout(() => {
    atualizarGrafico();
    myChart.destroy();
  }, 5000);
}

