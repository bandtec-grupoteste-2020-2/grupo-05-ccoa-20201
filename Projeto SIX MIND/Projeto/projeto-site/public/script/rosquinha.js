function dados() {
    roscaChartDataAtm.datasets[0].data = [];
    for (let cont = 0; cont < 4; cont++) {
        roscaChartDataAtm.datasets[0].data.push(parseInt(Math.random() * (24 + 1) + 10))
    }

    window.myDoughnutAtm.update();

}
function dadosSolo() {
    roscaChartDataSolo.datasets[0].data = [];
    for (let cont = 0; cont < 4; cont++) {
        roscaChartDataSolo.datasets[0].data.push(parseInt(Math.random() * (24 + 1) + 10))
    }

    window.myDoughnutSolo.update();

}
//------------------------  gráfico rosca Atimosfera-------------------------------------------------
var roscaChartDataAtm = {
    datasets: [{
        data: [],
        legend: 'top',
        backgroundColor: [
            '#00FF6F',
            '#FFF200',
            '#FF6F00',
            '#FF1700',
            // '#2849a7',
        ],
        label: [
            'Ideal',
            'Alerta',
            'Emergencial',
            'Crítico',
            // 'Blue', 
        ]
    }],
    labels: [
        'Ideal',
        'Alerta',
        'Emergencial',
        'Crítico',
        // 'Blue'
    ]

};

function gerarRosquinha() {
    setInterval(function() {
        var ctx = document.getElementById('rosquinha').getContext('2d');
        window.myDoughnutAtm = new Chart(ctx, {
            type: 'doughnut',
            data: roscaChartDataAtm,
            options: {
                animation: false,
                responsive: true,
                legend: {
                    position: 'left',
                    display: true,
                },
                title: {
                    text: 'Status dos Sensores',
                    display: false,
                },
                animation: {
                    animateScale: false,
                    animateRotate: false
                }
            }
        });
        dados()
    }, 4000)
};

gerarRosquinha();
//------------------------------------ GRAFICO ROSCA SOLO -----------------------------------------
var roscaChartDataSolo = {
    datasets: [{
        data: [],
        legend: 'top',
        backgroundColor: [
            '#FF1700',
            '#FFF200',
            '#FF6F00',
            '#00FF6F',
            // '#2849a7',
        ],
        label: [
            'Ideal',
            'Alerta',
            'Emergencial',
            'Crítico',
            // 'Blue', 
        ]
    }],
    labels: [
        'Ideal',
        'Alerta',
        'Emergencial',
        'Crítico',
        // 'Blue'
    ]

};


function gerarRosquinhaSolo() {
    setInterval(function() {
        var ctx = document.getElementById('rosquinha_solo').getContext('2d');
        window.myDoughnutSolo = new Chart(ctx, {
            type: 'doughnut',
            data: roscaChartDataSolo,
            options: {
                animation: false,
                responsive: true,
                legend: {
                    position: 'left',
                    display: true,
                },
                title: {
                    text: 'Status dos Sensores',
                    display: false,
                },
                animation: {
                    animateScale: false,
                    animateRotate: false
                }
            }
        });
        dadosSolo()
    }, 4000)
};

gerarRosquinhaSolo();



//-------------------------geração de dados aleatórios------------------------------------------------













