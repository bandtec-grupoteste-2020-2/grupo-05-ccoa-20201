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
    var sql = 'select Leitura.idLeitura, Maquina.tipoMaquina, Leitura.descricao, Leitura.valor, Componente.metrica from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao like "core%" and metrica="°C" order by idLeitura  limit 1; ';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.post('/enviar/:maquina/:componente/:ativado', (request, response) => {
    let maquina = request.params.maquina;
    let componente = request.params.componente;
    let ativado = request.params.ativado;
    var sql = `update maquinacomponente set ativado = ${ativado}
	where fkmaquina = ${maquina} and fkcomponente= '${componente}'; `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.post('/criar/:maquina/:componente/:ativado', (request, response) => {
    let maquina = request.params.maquina;
    let componente = request.params.componente;
    let ativado = request.params.ativado;
    var sql = `insert into maquinacomponente(fkMaquina,fkComponente,ativado) values 
    (${maquina},${componente},${ativado}); `;

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosCore', (request, response) => {
    var sql = 'select Leitura.valor, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Core 1"and metrica = "%" order by idLeitura desc limit 10;  ';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosCore2', (request, response) => {
    var sql = 'select Leitura.valor as valorCore2, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Core 2"and metrica = "%" order by idLeitura desc limit 10;  ';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

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
    var sql = 'select Leitura.valor, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Memoria uso %"and metrica = "%" order by idLeitura limit 10;';
    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

router.get('/dadosMemoriaUsoGB', (request, response) => {
    var sql = 'select Leitura.valor as valormemoriaGB, CAST(tempoLeitura AS TIME) as hora from Maquina, Leitura, Componente, MaquinaComponente where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idMaquina=3 and descricao = "Memoria uso GB"and metrica = "GB" order by idLeitura limit 10;';

    db.query(sql, function (err, result) {
        if (err) throw err;
        response.json(result);
    });

});

module.exports = router;

