
numeroMaquina();
function numeroMaquina() {
    var globalTipo=[];
    var globalId=[];
    fetch('http://localhost:3000/leituras/recebermaquinas', { cache: 'no-store' }).then(function (response) {
        if (response.ok) {

            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

                for (i = 0; i < resposta.length; i++) {


                    var registro = resposta[i];
                    const tipodaMaquina = registro.tipoMaquina;
                    const iddaMaquina = registro.idMaquina;

                    globalTipo.push(tipodaMaquina);
                    globalId.push(iddaMaquina);
                    
                }
                numeroNucleos(globalTipo,globalId);
            })
        } else {
            console.error('Nenhum dado encontrado ou erro na leituras');
        }
    }).catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

}



function numeroNucleos(globalTipo,globalId) {
    var numCoreVariavel = [];
    fetch("http://localhost:3000/leituras/numCore", { cache: "no-store" })
      .then(function (response) {
        if (response.ok) {
          response.json().then(function (resposta) {
    
            let registro = resposta;
            numCoreVariavel.push(registro[0].NumCore);
           
            // console.log(registro[].NumCore);
            // numCoreVariavel = (registro[0].NumCore);
            leituraCadaComp(globalTipo,globalId,numCoreVariavel);
          });
        } else {
          console.error("Nenhum dado encontrado ou erro na leituras");
        }
      })
      .catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
      });   
  }

function leituraCadaComp(globalTipo,globalId,numCoreVariavel) {
    var qntRegistro=numCoreVariavel[0]+2;
    // console.log(qntRegistro);
    for(let i=0;i<globalId.length;i++){

       fetch(`http://localhost:3000/leituras/dadosdeCadaComp/${globalId[i]}/${qntRegistro}`, { cache: "no-store" })
      .then(function (response) {

            if (response.ok) {
            response.json().then(function (resposta) {

                var soma=0.0;
                var mediaFinal;
                var disc;
                var memo;

                console.log(resposta);
                for(let x=0; x<qntRegistro; x++){

                    if(resposta[x].nomeComponente=="CPU_uso"){
                        atual=parseFloat(resposta[x].valor);
                        soma=soma+atual;
                        mediaFinal=soma/numCoreVariavel[0]; 
                    }
                    else if(resposta[x].nomeComponente=="Disco_uso"){
                        disc=resposta[x].valor;
                    }
                    else if(resposta[x].nomeComponente=="Memória_uso"){
                        memo=resposta[x].valor;
                    }
                }
                console.log(mediaFinal);
                console.log(disc);
                console.log(memo);
                atribuirDados(memo,mediaFinal,disc,i);
            });
            } else {
            console.error("Nenhum dado encontrado ou erro na leituras");
            }
      })
      .catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
      });  
    }
      
  }

function atribuirDados(memoria, cpu, disco, numMaqui){
    
}
