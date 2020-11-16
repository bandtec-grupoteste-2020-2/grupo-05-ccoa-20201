function cancelar2() {
  var tchaus2 = 0;
  if (tchaus2 = 0) {
    console.log = "Matei a Memória GERAL"
  }
  else {
    atualizarMemoriaGeral();

    function plotarMemoriaGeral(tempoLeituraGeral, leituraUsoPorcGeral) {
      var ctx = document.getElementById("memory_geral_chart").getContext("2d");
      var myChart = new Chart(ctx, {
        type: "line",
        data: {
          labels: tempoLeituraGeral,
          datasets: [
            {
              label: "% de utilização memória",
              data: leituraUsoPorcGeral,
              fill: true,
              backgroundColor: "rgba(170, 120, 166, 0.30)",
              borderColor: "rgba(170, 120, 166, 0.69)",
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

    window.onload = atualizarMemoriaGeral();
    function atualizarMemoriaGeral() {
      fetch("http://localhost:3000/leituras/dadosMemoriaUsoPerc", { cache: "no-store" })
        .then(function (response) {
          if (response.ok) {
            response.json().then(function (resposta) {
              console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
              let registro = resposta;
              console.log(registro);
              console.log(registro.length);
              let leituraUsoPorcGeral = [];
              let tempoLeituraGeral = [];

              for (n = registro.length - 1; n >= 0; n--) {
                leituraUsoPorcGeral.push(registro[n].valor);
                tempoLeituraGeral.push(registro[n].hora);
              }
              console.log(leituraUsoPorcGeral);

              plotarMemoriaGeral(tempoLeituraGeral, leituraUsoPorcGeral);
            });
          } else {
            console.error("Nenhum dado encontrado ou erro na leituras");
          }
        })
        .catch(function (error) {
          console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

      setTimeout(() => {
        atualizarMemoriaGeral();
      }, 5000);
    }
  }
}
