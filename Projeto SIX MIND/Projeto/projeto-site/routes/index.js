var express = require('express');
var router = express.Router();

const axios = require("axios");
let url_bot = 'https://hooks.slack.com/services/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';

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' });
});

router.post('/slack', function (req, res, next) {
  console.log(`Enviando menssagem slack`);
  console.log("ola senhores");

  var subject = req.body.input_subject;
  var email = req.body.input_email;
  var description = req.body.textarea_description;

  var message = `${subject} \n\n ${description} \n\n Enviado por: ${email}`;
  send_message_slack(message);

  res.redirect("/dashboard.html")
  // res.location("http://pt.stackoverflow.com")
  // res.json()

})

function send_message_slack(message) {
  axios.post(
    url_bot,
    { text: message }
  )


}


module.exports = router;
