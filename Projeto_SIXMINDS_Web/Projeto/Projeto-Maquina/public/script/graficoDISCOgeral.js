
    var myChart_disk_geral;
    let leituraUsoPorc_disco_geral = [];
    var conjunto_2_dataset_disco_geral=[];
    var myChart_disk;
    function atualizar_conjunto_disco( leituraTemperatura, leituraUsoPorc){
      conjunto_2_dataset_disco_geral=[
        {
          label: "Temperatura (°C)",
          data: leituraTemperatura,
          fill: true,
          backgroundColor: "rgba(255, 209, 102, 0.30)",
          borderColor: "rgba(255, 209, 102, 0.69)",
          borderWidth: 1,
        },

        {
          label: "Espaço ocupado (%)",
          data: leituraUsoPorc,
          fill: true,
          backgroundColor: "rgba(6, 214, 160, 0.30)",
          borderColor: "rgba(6, 214, 160, 0.69)",
          borderWidth: 1,
        },
      ];

    }
    function plotarDisco(tempoLeitura, leituraTemperatura, leituraUsoPorc,vez) {
      
      if(vez==0){
        atualizar_conjunto_disco( leituraTemperatura, leituraUsoPorc)
      }else{
        atualizar_conjunto_disco( leituraTemperatura, leituraUsoPorc)
      var ctx = document.getElementById("disk_geral_chart").getContext("2d");
       myChart_disk_geral = new Chart(ctx, {
        type: "bar",
        data: {
          labels: tempoLeitura,
          datasets: conjunto_2_dataset_disco_geral,
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
       myChart_disk = new Chart(document.getElementById("disk_chart").getContext("2d"), {
        type: "bar",
        data: {
          labels: tempoLeitura,
          datasets: conjunto_2_dataset_disco_geral,
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
    function discoPorcentagem_geral() {
      fetch(`http://localhost:3000/leituras/dadosDiscoPerc/${maquina_atual.value}`, { cache: "no-store" })
        .then(function (response) {
          if (response.ok) {
            response.json().then(function (resposta) {
              
              let registro = resposta;
        
              leituraUsoPorc_disco_geral = [];
    
              for (n = registro.length - 1; n >= 0; n--) {
                leituraUsoPorc_disco_geral.push(registro[n].valorDiscoUsoPorc);
              }
            
            });
          } else {
            console.error("Nenhum dado encontrado ou erro na leituras");
          }
        })
        .catch(function (error) {
          console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
    }
    
    let leituraTemperatura = [];
    function atualizarDisco_geral(vez) {
      fetch(`http://localhost:3000/leituras/dadosDiscoTemp/${maquina_atual.value}`, { cache: "no-store" })
        .then(function (response) {
          if (response.ok) {
            response.json().then(function (resposta) {
            
              let registro = resposta;
         
              leituraTemperatura = [];
              let tempoLeitura = [];
    
              for (n = registro.length - 1; n >= 0; n--) {
                leituraTemperatura.push(registro[n].valorDiscoTemp);
                tempoLeitura.push(registro[n].hora);
              }

              discoPorcentagem_geral();
    
              plotarDisco(tempoLeitura, leituraTemperatura, leituraUsoPorc_disco_geral,vez);
            });
          } else {
            //console.error("Nenhum dado encontrado ou erro na leituras");
           
          }
        })
        .catch(function (error) {
          console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
        });
    
      setTimeout(() => {
       // atualizarDisco_geral();
      //  myChart.destroy();
      // eliminar_disco();
      }, 5000);
    }
   function eliminar_disco(){

    myChart_disk_geral.data.labels.shift();
    myChart_disk_geral.data.datasets.forEach(dataset => {
      dataset.data.shift();
 
    });
      myChart_disk_geral.data.labels.push(tempoLeitura[tempoLeitura.length - 1])
      myChart_disk_geral.data.datasets.forEach((dataset, n) => {
        dataset.data.push(conjunto_2_dataset_disco_geral[n].data[conjunto_2_dataset_disco_geral[n].data.length - 1])
     
      });
    myChart_disk.update();
    myChart_disk_geral.update();
   }