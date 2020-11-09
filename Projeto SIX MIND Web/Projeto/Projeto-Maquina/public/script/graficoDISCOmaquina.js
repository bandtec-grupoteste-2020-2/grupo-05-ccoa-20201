var ctx = document.getElementById('disk_use_chart').getContext('2d');
var myChart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['12:42:20', '12:42:25', '12:42:30', '12:42:35', '12:42:40', '12:42:45'],
        datasets: [{
            label: '% espaço ocupado',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: 'rgba(255, 159, 64, 0.2)',
            borderColor: 'rgba(255, 159, 64, 0.2)',
            borderWidth: 1
        }]
    },
    options: {
        responsive: true,
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});