window.onload = quantidadeNucleos();

let leituraUsoPorc = [];
var conjunto_dataset = [];
var dataset_completo = {};
var tempoLeitura = [];
var conta = 0;
var myChart=undefined;
function separar(arroz) {
  let valor = [];
  for (let i = 0; i < arroz.length; i++) {
    valor.push(arroz[i]);
  }
  // debugger

  return valor;
}

function plotarCPU(arroz, tempoLeitura) {
  if(myChart!=undefined){

  myChart.destroy();
  conta=0;
  }
conta++
  var ctx = document.getElementById("cpu_chart").getContext("2d");
   myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: tempoLeitura,
      datasets: separar(arroz),
      
    },options: {
      scales: {
          yAxes: [{
              ticks: {
                  suggestedMin: 0,
                  suggestedMax: 100
              }
          }]
      }
  }
  });
  
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
  conjunto_dataset = [];
  for (let x = 1; numCore >= x; x++) {
    fetch(`http://localhost:3000/leituras/dadosCore/${x}/${maquina_atual.value}`, {
      cache: "no-store",
    })
      .then(function (response) {
        if (response.ok) {
          response.json().then(function (resposta) {
       
            let registro = resposta;

            tempoLeitura = [];
            leituraUsoPorc = [];
            cores=[];
            metrica = registro[0].metrica;
            
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
              parametro_minimo.innerHTML=`${registro[0].minimo} ${metrica}`
              parametro_maximo.innerHTML=`${registro[0].maximo} ${metrica}`
            }

            dataset_completo = {
              label: `% de utilização Core ${x}`,
              data: leituraUsoPorc,
              fill: true,
              backgroundColor: cores,
          
            };
     
            conjunto_dataset.push(dataset_completo);
            if(conjunto_dataset.length%numCore==0){
            plotarCPU(conjunto_dataset, tempoLeitura);
        }
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

  }, 5000);
}
