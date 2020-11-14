// atualizarMemoria();

// function plotarMemoria(leitura, tempo) {
//     var ctx = document.getElementById('memory_use_chart').getContext('2d');
//     var myChart = new Chart(ctx, {
//         type: 'line',
//         data: {
//             labels: ['12:42:20', '12:42:25', '12:42:30', '12:42:35', '12:42:40', '12:42:45'],
//             datasets: [{
//                 label: '% uso',
//                 data: [12, 19, 3, 5, 2, 3],
//                 backgroundColor: 'rgba(75, 192, 192, 0.2)',
//                 borderColor: 'rgba(75, 192, 192, 0.2)',
//                 borderWidth: 1
//             }]
//         },
//         options: {
//             responsive: true,
//             scales: {
//                 yAxes: [{
//                     ticks: {
//                         beginAtZero: true
//                     }
//                 }]
//             }
//         }
//     });
// }
// window.onload = atualizarMemoria();
// function atualizarMemoria() {
//     fetch("http://localhost:3000/leituras/dadosMemoriaLivreGB", { cache: "no-store" })
//         .then(function (response) {
//             if (response.ok) {
//                 response.json().then(function (resposta) {
//                     console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);
//                     let registro = resposta;
//                     console.log(registro);
//                     console.log(registro.length);
//                     let leitura = [];
//                     let tempo = [];

//                     for (n = 0; n < registro.length; n++) {
//                         leitura.push(registro[n].valor);
//                         tempo.push(registro[n].hora);
//                     }
//                     console.log(registro[0].hora);
//                     console.log(leitura);

//                     plotarMemoria(leitura, tempo);
//                 });
//             } else {
//                 console.error("Nenhum dado encontrado ou erro na leituras");
//             }
//         })
//         .catch(function (error) {
//             console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
//         });
//     setTimeout(() => {
//         atualizarMemoria();
//     }, 5000);
// }