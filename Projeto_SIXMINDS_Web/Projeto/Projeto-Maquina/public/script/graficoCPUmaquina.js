window.onload = quantidadeNucleos();

let leituraUsoPorc = [];
var arroz = [];
var fejao = {};
var tempoLeitura = [];
var conta = 0;
function separar(arroz) {
  let valor = [];
  for (let i = 0; i < arroz.length; i++) {
    valor.push(arroz[i]);
  }
  // debugger

  return valor;
}

function plotarCPU(arroz, tempoLeitura,nucleos,numCore) {
  if(conta==1){
  myChart.destroy();
  conta++
  }
  if(nucleos==numCore){
  var ctx = document.getElementById("cpu_chart").getContext("2d");
  var myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: tempoLeitura,
      datasets: separar(arroz),
    },
  });
  }
}

function quantidadeNucleos() {
  let numCore = [];
  fetch("http://localhost:3000/leituras/numCore", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {
  
          let registro = resposta;
          numCore.push(registro[0].NumCore);

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
       
            let registro = resposta;

            tempoLeitura = [];
            leituraUsoPorc = [];
            cores=[];
            for (n = registro.length - 1; n >= 0; n--) {
      
              leituraUsoPorc.push(registro[n].valor);

              tempoLeitura.push(registro[n].hora);
              if(parseFloat(registro[n].valor)>parseFloat(registro[n].maximo)){
                cores.push('#ff6384')
              }else if(parseFloat(registro[n].valor)<parseFloat(registro[n].minimo)){
                cores.push('#ffce56')
              }else{
                cores.push('#17a2b8')
              }
              
            }

            fejao = {
              label: `% de utilização Core ${x}`,
              data: leituraUsoPorc,
              fill: true,
              backgroundColor: cores,
          
            };

     
            arroz.push(fejao);
            plotarCPU(arroz, tempoLeitura,x,numCore);
      
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
