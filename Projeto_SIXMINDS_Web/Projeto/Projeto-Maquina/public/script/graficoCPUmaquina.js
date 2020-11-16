window.onload = quantidadeNucleos();

let leituraUsoPorc = [];
var arroz = [];
var fejao = {};
var tempoLeitura = [];

function separar(arroz) {
  let valor = [];
  for (let i = 0; i < arroz.length; i++) {
    valor.push(arroz[i]);
  }
  // debugger
  console.log(valor);
  return valor;
}

function plotarCPU(arroz, tempoLeitura) {
  var ctx = document.getElementById("cpu_chart").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: tempoLeitura,
      datasets: separar(arroz),
    },
  });
}

function quantidadeNucleos() {
  let numCore = [];
  fetch("http://localhost:3000/leituras/numCore", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
          console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
          let registro = resposta;
          numCore.push(registro[0].NumCore);
          console.log(registro[0].NumCore);
          let valor = parseInt(registro[0].NumCore);
          atualizarCPU(valor);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
  console.log(numCore);

 
}

function atualizarCPU(numCore) {
  arroz = [];
  for (let x = 1; numCore >= x; x++) {
    fetch(`http://localhost:3000/leituras/dadosCore/${x}`, {
      cache: "no-store",
    })
      .then(function (response) {
        if (response.ok) {
          response.json().then(function (resposta) {
            console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
            let registro = resposta;
            console.log(registro);
            console.log(registro.length);
            tempoLeitura = [];
            leituraUsoPorc = [];
            for (n = registro.length - 1; n >= 0; n--) {
              console.log(`NUMCORE AQUI: ${numCore}`);
              leituraUsoPorc.push(registro[n].valor);
              tempoLeitura.push(registro[n].hora);
            }

            fejao = {
              label: `% de utilização Core ${x}`,
              data: leituraUsoPorc,
              fill: true,
              backgroundColor: "rgba(239, 71, 111, 0.30)",
              borderColor: "rgba(239, 71, 111, 0.69)",
              borderWidth: 1,
            };

            console.log(fejao);
            arroz.push(fejao);
            plotarCPU(arroz, tempoLeitura);
            console.log(arroz);
            console.log(arroz.length);
          });
        } else {
          console.error("Nenhum dado encontrado ou erro na leituras");
        }
      })
      .catch(function (error) {
        console.error(
          `Erro na obtenção dos dados p/ gráfico: ${error.message}`
        );
      });
  }
  setTimeout(() => {
    quantidadeNucleos();
    myChart.destroy();
  }, 5000);
}
