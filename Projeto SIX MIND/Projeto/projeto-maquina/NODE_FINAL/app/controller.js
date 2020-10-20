const express = require('express');
// const { ArduinoDataTemp } = require('./newserial')
const db = require('./database')
const router = express.Router();

let jason={};

console.log('Chegou onde eu qr');

router.get('/', (request, response, next) => {
    response.send("Funcionou");
});

router.get('/sendData', (request, response) => {
    var sql = "SELECT * FROM Usuario";
    
    db.query(sql,function(err, result) {
        if (err) throw err;
        response.json(result);
    });
   
});

module.exports = router;

