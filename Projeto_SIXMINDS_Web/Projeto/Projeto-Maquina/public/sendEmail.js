const nodemailer = require("nodemailer");

const transporter = nodemailer.createTransport({
  host: "smtp1.iagentesmtp.com.br",
  port: 587,
  secure: false,
  auth: {
    user: "carlos.santana@bandtec.com.br",
    pass: "c3f75b"}
});

const mailOptions = {
  from: "carlos.santana@bandtec.com.br",
  to: "eduardomarquesdesantana@gmail.com",
  subject: "Mais um teste para email automático",
  text: "teste",
  html: '<h1>Teste</h1><p>estou utilizando o nodemailer, um modulo js, para envio automático de emails</p>'
};

transporter.sendMail(mailOptions, function(error, info){
  if(error){
    console.log(error);
  }else {
    console.log("Email enviado: " + info.response);
  }
});
