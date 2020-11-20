
    atualizarMemoriaGeral(1);
    var myChart_memoria_geral 
    var myChart_memoria 
  var conjunto_2_dataset_memoria_geral=[]
  function atualizar_conjunto_memoria( leituraUsoPorcGeral){
conjunto_2_dataset_memoria_geral=[
        {
          label: "% de utilização memória",
          data: leituraUsoPorcGeral,
          fill: true,
          backgroundColor: "rgba(170, 120, 166, 0.30)",
          borderColor: "rgba(170, 120, 166, 0.69)",
          borderWidth: 1,
        },
      ]
  }
    function plotarMemoriaGeral(tempoLeituraGeral, leituraUsoPorcGeral,vez) {
      if(vez==0){
      atualizar_conjunto_memoria( leituraUsoPorcGeral)
      }else{
        atualizar_conjunto_memoria( leituraUsoPorcGeral)
      var ctx = document.getElementById("memory_geral_chart").getContext("2d");
      
    myChart_memoria_geral = new Chart(ctx, {
        type: "line",
        data: {
          labels: tempoLeituraGeral,
          datasets: conjunto_2_dataset_memoria_geral,
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
    myChart_memoria = new Chart(document.getElementById("memory_chart").getContext("2d"), {
        type: "line",
        data: {
          labels: tempoLeituraGeral,
          datasets: conjunto_2_dataset_memoria_geral,
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
  }

    function atualizarMemoriaGeral(vez) {
      fetch("http://localhost:3000/leituras/dadosMemoriaUsoPerc", { cache: "no-store" })
        .then(function (response) {
          if (response.ok) {
            response.json().then(function (resposta) {
     
              let registro = resposta;
         
              let leituraUsoPorcGeral = [];
              let tempoLeituraGeral = [];

              for (n = registro.length - 1; n >= 0; n--) {
                leituraUsoPorcGeral.push(registro[n].valor);
                tempoLeituraGeral.push(registro[n].hora);
              }


              plotarMemoriaGeral(tempoLeituraGeral, leituraUsoPorcGeral,vez);
            });
          } else {
            console.error("Nenhum dado encontrado ou erro na leituras");
          }
        })
        .catch(function (error) {
          console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });

      setInterval(() => {
     //   atualizarMemoriaGeral();
     //eliminar_memoria()
      }, 5000);
    }
    function eliminar_memoria(){
     
      myChart_memoria_geral.data.labels.shift();
      myChart_memoria_geral.data.datasets.forEach(dataset => {
        dataset.data.shift();
   
      });
      myChart_memoria_geral.data.labels.push(tempoLeitura[tempoLeitura.length - 1])
      myChart_memoria_geral.data.datasets.forEach((dataset, n) => {
          dataset.data.push(conjunto_2_dataset_memoria_geral[n].data[conjunto_2_dataset_memoria_geral[n].data.length - 1])
       
        });
        myChart_memoria.update();
      myChart_memoria_geral.update();
     }