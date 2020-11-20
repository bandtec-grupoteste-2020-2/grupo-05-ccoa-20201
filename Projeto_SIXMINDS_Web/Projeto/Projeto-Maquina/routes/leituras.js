const express = require('express');
// const { ArduinoDataTemp } = require('./newserial')
const db = require('./database')
const router = express.Router();

let jason = {};

console.log('Chegou onde eu qr');

router.get('/', (request, response, next) => {
    response.send("Funcionou");
});

router.get('/sendData', (request, response) => {
    var sql = "SELECT * FROM Usuario";

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});
router.get('/recebermaquinas', (request, response) => {
    var sql = "SELECT * FROM Maquina";

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});
router.get('/recebercomponentes', (request, response) => {
    var sql = "SELECT * FROM Componente";

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/pegarumaleituradetemperatura', (request, response) => {
    var sql = 'select Leitura.idLeitura, Maquina.tipoMaquina, Leitura.descricao, Leitura.valor, Componente.metrica from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao like "Core %" and metrica="°C" order by idLeitura desc  limit 1; ';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.post('/enviar/:maquina/:componente/:ativado/:minimo/:maximo', (request, response) => {
    let maquina = request.params.maquina;
    let componente = request.params.componente;
    let ativado = request.params.ativado;
    let minimo = request.params.minimo;
    let maximo = request.params.maximo;
    var sql = `update MaquinaComponente set ativado = ${ativado},minimo=${minimo},maximo=${maximo}
	where fkMaquina = ${maquina} and fkComponente= '${componente}'; `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});
router.get('/receber/:maquina/:componente', (request, response) => {
    let maquina = request.params.maquina;
    let componente = request.params.componente;

    var sql = `select ativado,minimo,maximo,metrica
     from MaquinaComponente,Componente 
     where fkComponente=idComponente and fkMaquina=${maquina} and fkComponente=${componente} ; `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.post('/criar/:maquina/:componente/:ativado/:minimo/:maximo', (request, response) => {
    let maquina = request.params.maquina;
    let componente = request.params.componente;
    let ativado = request.params.ativado;
    let minimo = request.params.minimo;
    let maximo = request.params.maximo;
    var sql = `insert into MaquinaComponente(fkMaquina,fkComponente,ativado,minimo,maximo) values 
    (${maquina},${componente},${ativado},${minimo},${maximo}); `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/numCore', (request, response) => {
    var sql = `select count(distinct descricao) as NumCore from Leitura where descricao like "Core %" ;`;
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});



router.get('/dadosCore/:numCore/:maquina_atual', (request, response) => {
    var numCore = request.params.numCore;
    var maquina_atual = request.params.maquina_atual;
    var sql = `select Leitura.valor, CAST(tempoLeitura AS TIME) as hora,MaquinaComponente.minimo,MaquinaComponente.maximo,Componente.metrica  from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina= ${maquina_atual} and descricao like "Core ${numCore}" and metrica = "%" order by idLeitura desc limit 10;`;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });
});

// router.get('/dadosCore2', (request, response) => {
//     var sql = 'select Leitura.valor as valorCore2, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Core 2"and metrica = "%" order by idLeitura desc limit 10;  ';

//     db.query(sql, function (err, result) {
//         if (err) throw err;
//         response.json(result);
//     });

// });

router.get('/dadosDiscoTemp', (request, response) => {
    var sql = 'select Leitura.valor as valorDiscoTemp, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Disco temperatura"and metrica = "°C" order by idLeitura desc limit 10;';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosDiscoPerc', (request, response) => {
    var sql = 'select Leitura.valor as valorDiscoUsoPorc, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Disco uso %"and metrica = "%"  order by idLeitura desc limit 10;';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosMemoriaUsoPerc', (request, response) => {
    var sql = 'select Leitura.valor, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Memoria uso %"and metrica = "%" order by idLeitura desc limit  10;';
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosMemoriaUsoGB', (request, response) => {
    var sql = 'select Leitura.valor as valormemoriaGB, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Memoria uso GB"and metrica = "GB" order by idLeitura desc limit 10;';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosdeCadaComp/:idMaquina/:numCore', (request, response) => {
    let idMaquina = request.params.idMaquina;
    let numCore = request.params.numCore;

    var sql = `select idMaquina,tipoMaquina,nomeComponente,metrica,valor,minimo,maximo from Maquina, MaquinaComponente,Componente,Leitura where idMaquina=fkMaquina and idComponente=fkComponente
	and metrica="%" and idMaquina=${idMaquina} and idMaquinaComponente=fkMaquinaComponente order by idLeitura desc limit ${numCore}; `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

module.exports = router;