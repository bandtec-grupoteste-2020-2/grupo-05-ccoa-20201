var Dia = new Date().getDate();
var Mes = new Date().getMonth() + 1;
var Ano = new Date().getFullYear();
var dataAno = Dia + "/" + Mes + "/" + Ano;
var color = Chart.helpers.color;
var horizontalBarChartData = {
	labels: ['Setor 1', 'Setor 2', 'Setor 3', 'Setor 4', 'Setor 5', 'Setor 6'],
	datasets: [{
		label: 'Umidade no Setor',
		backgroundColor: '#28a745',
		borderColor: '#28a745',
		borderWidth: 1,
		data: []
	}, ]

};

function setoresGrafico() {
	setInterval(function(){
		var ctx = document.getElementById('setores').getContext('2d');
	window.myHorizontalBar = new Chart(ctx, {
		type: 'horizontalBar',
		data: horizontalBarChartData,
		options: {
			// Elements options apply to all of the options unless overridden in a dataset
			// In this case, we are setting the border of each horizontal bar to be 2px wide
			elements: {
				rectangle: {
					borderWidth: 2,
				}
			},
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
	gerardados()
}, 3200)
};
		

setoresGrafico()

function gerardados(){
    horizontalBarChartData.datasets[0].data = [];
    for(let cont = 0; cont < 7; cont ++){
        horizontalBarChartData.datasets[0].data.push(parseInt(Math.random() * (39 + 1) + 30))        

    }

    window.myHorizontalBar.update();
   
}