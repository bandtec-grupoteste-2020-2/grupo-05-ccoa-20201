const express = require("express");
const { ArduinoDataTemp } = require("./newserial");
const { ArduinoDataHumidity } = require("./serialHumidity");
const { ArduinoDataSwitch } = require("./serialSwitch");
const { ArduinoDataLuminosity } = require("./serialLuminosidity");
const db = require("./database");
const router = express.Router();


router.get("/", (request, response, next) => {
  let sum = ArduinoDataTemp.List.reduce((a, b) => a + b, 0);
  let average = (sum / ArduinoDataTemp.List.length).toFixed(2);
  let sumHour = ArduinoDataTemp.ListHour.reduce((a, b) => a + b, 0);
  let averageHour = (sumHour / ArduinoDataTemp.ListHour.length).toFixed(2);

  response.json({
    data: ArduinoDataTemp.List,
    total: ArduinoDataTemp.List.length,
    average: isNaN(average) ? 0 : average,
    dataHour: ArduinoDataTemp.ListHour,
    totalHour: ArduinoDataTemp.ListHour.length,
    averageHour: isNaN(averageHour) ? 0 : averageHour,
  });
});

router.get("/humidity", (request, response, next) => {
  let sum = ArduinoDataHumidity.List.reduce((a, b) => a + b, 0);
  let average = (sum / ArduinoDataHumidity.List.length).toFixed(2);
  let sumHour = ArduinoDataHumidity.ListHour.reduce((a, b) => a + b, 0);
  let averageHour = (sumHour / ArduinoDataHumidity.ListHour.length).toFixed(2);

  response.json({
    data: ArduinoDataHumidity.List,
    total: ArduinoDataHumidity.List.length,
    average: isNaN(average) ? 0 : average,
    dataHour: ArduinoDataHumidity.ListHour,
    totalHour: ArduinoDataHumidity.ListHour.length,
    averageHour: isNaN(averageHour) ? 0 : averageHour,
  });
});

router.get("/switch", (request, response, next) => {
  let sum = ArduinoDataSwitch.List.reduce((a, b) => a + b, 0);
  let average = (sum / ArduinoDataSwitch.List.length).toFixed(2);
  let sumHour = ArduinoDataSwitch.ListHour.reduce((a, b) => a + b, 0);
  let averageHour = (sumHour / ArduinoDataSwitch.ListHour.length).toFixed(2);

  response.json({
    data: ArduinoDataSwitch.List,
    total: ArduinoDataSwitch.List.length,
    average: isNaN(average) ? 0 : average,
    dataHour: ArduinoDataSwitch.ListHour,
    totalHour: ArduinoDataSwitch.ListHour.length,
    averageHour: isNaN(averageHour) ? 0 : averageHour,
  });
});

router.get("/luminosity", (request, response, next) => {
  let sum = ArduinoDataLuminosity.List.reduce((a, b) => a + b, 0);
  let average = (sum / ArduinoDataLuminosity.List.length).toFixed(2);
  let sumHour = ArduinoDataLuminosity.ListHour.reduce((a, b) => a + b, 0);
  let averageHour = (sumHour / ArduinoDataLuminosity.ListHour.length).toFixed(
    2
  );

  response.json({
    data: ArduinoDataLuminosity.List,
    total: ArduinoDataLuminosity.List.length,
    average: isNaN(average) ? 0 : average,
    dataHour: ArduinoDataLuminosity.ListHour,
    totalHour: ArduinoDataLuminosity.ListHour.length,
    averageHour: isNaN(averageHour) ? 0 : averageHour,
  });

});

router.get("/sendData", (request, response) => {
  let total = 0
   var presenca = ArduinoDataSwitch.List[ArduinoDataSwitch.List.length - 1];
    var presenca1 = ArduinoDataSwitch.List[ArduinoDataSwitch.List.length - 2];
    var presenca2 = ArduinoDataSwitch.List[ArduinoDataSwitch.List.length - 3];
    var presenca3 = ArduinoDataSwitch.List[ArduinoDataSwitch.List.length - 4];

let sorteio = (parseInt(Math.random()*3))
if(sorteio==0){
  let sorteio2 = parseInt(Math.random()*2)
  if(sorteio2==0){
    presenca=0
    presenca1=0
    presenca2=0
    presenca3=0
  }else{
    presenca=1
    presenca1=1
    presenca2=1
    presenca3=1
  }
}
   
    if(presenca==1){
      total+=25
    }
    if(presenca1==1){
      total+=25
    }
    if(presenca2==1){
      total+=25
    }
    if(presenca3==1){
      total+=25
    }

  




  console.log(`${total}%`)

  let randomescaninho = parseInt(Math.random() * 5 + 1)
  console.log(`escaninho:${randomescaninho}`)
  db.conectar()
    .then(() => {
      return db.sql.query(`
    insert into historico(Situacao,fkEscaninho,DataeHora)
        values (${total}, ${randomescaninho}, '${agora()}');`
      ).then(() => {
        console.log("Registro inserido com sucesso! \n");
      });;
    })
    .catch((erro) => {
      console.error(`Erro ao tentar registrar aquisição na base: ${erro}`);
    })
    .finally(() => {
      db.sql.close();
    });

  response.sendStatus(200);
});


function agora() {
  const agora_d = new Date();
  return `${agora_d.getFullYear()}-${agora_d.getMonth() + 1}-${agora_d.getDate()} ${agora_d.getHours()}:${agora_d.getMinutes()}:${agora_d.getSeconds()}`;
}

module.exports = router;
