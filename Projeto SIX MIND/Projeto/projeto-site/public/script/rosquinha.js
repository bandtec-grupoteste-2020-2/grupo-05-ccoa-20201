var roscaChartData = {
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
        window.myDoughnut = new Chart(ctx, {
            type: 'doughnut',
            data: roscaChartData,
            options: {
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
                    animateScale: true,
                    animateRotate: true
                }
            }
        });
        dados()
    }, 3200)
};

gerarRosquinha();

function dados() {
    roscaChartData.datasets[0].data = [];
    for (let cont = 0; cont < 4; cont++) {
        roscaChartData.datasets[0].data.push(parseInt(Math.random() * (24 + 1) + 10))
    }

    window.myDoughnut.update();

}
