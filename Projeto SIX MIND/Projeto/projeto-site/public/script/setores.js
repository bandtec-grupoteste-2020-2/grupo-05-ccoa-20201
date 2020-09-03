//---------------------------------- GRAFICO DE BARRAS (atm) ----------------------------------------
var Dia = new Date().getDate();
var Mes = new Date().getMonth() + 1;
var Ano = new Date().getFullYear();
var dataAno = Dia + "/" + Mes + "/" + Ano;
var color = Chart.helpers.color;
var horizontalBarChartDataAtm = {
	labels: ['Setor 1', 'Setor 2', 'Setor 3', 'Setor 4', 'Setor 5', 'Setor 6'],
	datasets: [{
		label: 'Umidade no Setor',
		backgroundColor: '#28a745',
		borderColor: '#28a745',
		borderWidth: 1,
		data: []
	},]

};

function setoresGraficoAtm() {
	setInterval(function () {
		var ctx = document.getElementById('setores_atm').getContext('2d');
	
		window.myHorizontalBarAtm = new Chart(ctx, {
			type: 'horizontalBar',
			data: horizontalBarChartDataAtm,
			
			options: {
				// Elements options apply to all of the options unless overridden in a dataset
				// In this case, we are setting the border of each horizontal bar to be 2px wide
				elements: {
					rectangle: {
						borderWidth: 2,
					}
				},
				animation: false,
				// duration: 0,
				responsive: true,
				legend: {
					position: 'right',
				},
				title: {
					display: false,
					text: `Umidade dos Setores ( ${dataAno} )`
				},
				legend: {
					display: false,
				},

				scales: {
					xAxes: [{
						ticks: {
							max: 100,
							min: 0
						}
					}]
				}
			}
		});
		gerardados_atm()
	}, 4000)
};


setoresGraficoAtm()

function gerardados_atm() {
	horizontalBarChartDataAtm.datasets[0].data = [];
	for (let cont = 0; cont < 7; cont++) {
		horizontalBarChartDataAtm.datasets[0].data.push(parseInt(Math.random() * (39 + 1) + 30))

	}

	// window.myHorizontalBarAtm.destroy();
	// setoresGraficoAtm();
	window.myHorizontalBarAtm.update();

}

// ------------------------- GRAFICO DE BARRAS (solo) --------------------------------------

var Dia = new Date().getDate();
var Mes = new Date().getMonth() + 1;
var Ano = new Date().getFullYear();
var dataAno = Dia + "/" + Mes + "/" + Ano;
var color = Chart.helpers.color;
var horizontalBarChartDataSolo = {
	labels: ['Setor 1', 'Setor 2', 'Setor 3', 'Setor 4', 'Setor 5', 'Setor 6'],
	datasets: [{
		label: 'Umidade no Setor',
		backgroundColor: '#007bff',
		borderColor: '#007bff',
		borderWidth: 1,
		data: []
	},]

};

function setoresGraficoSolo() {
	setInterval(function () {
		var ctx = document.getElementById('setores_solo').getContext('2d');
		window.myHorizontalBarSolo = new Chart(ctx, {
			type: 'horizontalBar',
			data: horizontalBarChartDataSolo,
			options: {
				// Elements options apply to all of the options unless overridden in a dataset
				// In this case, we are setting the border of each horizontal bar to be 2px wide
				elements: {
					rectangle: {
						borderWidth: 2,
					}
				},
				animation: false,

				responsive: true,
				legend: {
					position: 'right',
				},
				title: {
					display: false,
					text: `Umidade dos Setores ( ${dataAno} )`
				},
				legend: {
					display: false,
				},

				scales: {
					xAxes: [{
						ticks: {
							max: 100,
							min: 0
						}
					}]
				}
			}
		});
		gerardados_solo()
	}, 4000)
};


setoresGraficoSolo()

function gerardados_solo() {
	horizontalBarChartDataSolo.datasets[0].data = [];
	for (let cont = 0; cont < 7; cont++) {
		horizontalBarChartDataSolo.datasets[0].data.push(parseInt(Math.random() * (39 + 1) + 30))

	}

	window.myHorizontalBarSolo.update();
	// setoresGraficoSolo()

}
