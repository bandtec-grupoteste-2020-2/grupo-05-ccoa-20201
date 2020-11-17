// function cancelar() {
//   var tchau = 0;
//   if (tchau = 0) {
//     console.log = "Matei a CPU GERAL"
//   }
//   else {
//     core2Geral();
//     atualizarCPUGeral();

//     let leituraUsoPorc2 = [];

//     function plotarCPUGeral(tempoLeituraGeral, leituraUsoPorcGeral, leituraUsoPorc2Geral) {
//       var ctx = document.getElementById("cpu_geral_chart").getContext("2d");
//       var myChart = new Chart(ctx, {
//         type: "line",
//         data: {
//           labels: tempoLeituraGeral,
//           datasets: [
//             {
//               label: "% de utilização Core 1",
//               data: leituraUsoPorcGeral,
//               fill: true,
//               backgroundColor: "rgba(239, 71, 111, 0.30)",
//               borderColor: "rgba(239, 71, 111, 0.69)",
//               borderWidth: 1,
//             },

//             {
//               label: "% de utilização Core 2",
//               data: leituraUsoPorc2Geral,
//               fill: true,
//               backgroundColor: "rgba(255, 209, 102, 0.30)",
//               borderColor: "rgba(255, 209, 102, 0.69)",
//               borderWidth: 1,
//             },
//           ],
//         },
//         options: {
//           responsive: true,
//           scales: {
//             yAxes: [
//               {
//                 ticks: {
//                   beginAtZero: true,
//                 },
//               },
//             ],
//           },
//         },
//       });
//     }

//     function core2Geral() {
//       fetch("http://localhost:3000/leituras/dadosCore2", { cache: "no-store" })
//         .then(function (response) {
//           if (response.ok) {
//             response.json().then(function (resposta) {
//               console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
//               let registro = resposta;
//               console.log(registro);
//               console.log(registro.length);
//               leituraUsoPorc2Geral = [];

//               for (n = registro.length - 1; n >= 0; n--) {
//                 leituraUsoPorc2Geral.push(registro[n].valorCore2);
//               }
//               console.log(leituraUsoPorc2Geral);
//             });
//           } else {
//             console.error("Nenhum dado encontrado ou erro na leituras");
//           }
//         })
//         .catch(function (error) {
//           console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
//         });
//     }

//     window.onload = atualizarCPUGeral();
//     function atualizarCPUGeral() {
//       fetch("http://localhost:3000/leituras/dadosCore", { cache: "no-store" })
//         .then(function (response) {
//           if (response.ok) {
//             response.json().then(function (resposta) {
//               console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
//               let registro = resposta;
//               console.log(registro);
//               console.log(registro.length);
//               let leituraUsoPorcGeral = [];
//               let tempoLeituraGeral = [];

//               for (n = registro.length - 1; n >= 0; n--) {
//                 leituraUsoPorcGeral.push(registro[n].valor);
//                 tempoLeituraGeral.push(registro[n].hora);
//               }
//               console.log(registro[0].hora);
//               console.log(leituraUsoPorcGeral);
//               core2Geral();

//               plotarCPUGeral(tempoLeituraGeral, leituraUsoPorcGeral, leituraUsoPorc2Geral);
//             });
//           } else {
//             console.error("Nenhum dado encontrado ou erro na leituras");
//           }
//         })
//         .catch(function (error) {
//           console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
//         });

//       setTimeout(() => {
//         atualizarCPUGeral();
//         myChart.destroy();
//       }, 5000);
//     }

//   }
// }
