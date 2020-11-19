numeroMaquina();
var globalTipo = [];
var globalId = [];
function numeroMaquina() {
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
        numeroNucleos(globalTipo, globalId);
      })
    } else {
      console.error('Nenhum dado encontrado ou erro na leituras');
    }
  }).catch(function (error) {
    console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
  });

}



function numeroNucleos(globalTipo, globalId) {
  var numCoreVariavel = [];
  fetch("http://localhost:3000/leituras/numCore", { cache: "no-store" })
    .then(function (response) {
      if (response.ok) {
        response.json().then(function (resposta) {

          let registro = resposta;
          numCoreVariavel.push(registro[0].NumCore);

          // console.log(registro[].NumCore);
          // numCoreVariavel = (registro[0].NumCore);
          leituraCadaComp(globalTipo, globalId, numCoreVariavel);
        });
      } else {
        console.error("Nenhum dado encontrado ou erro na leituras");
      }
    })
    .catch(function (error) {
      console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });
}

function leituraCadaComp(globalTipo, globalId, numCoreVariavel) {
  var qntRegistro = numCoreVariavel[0] + 2;
  // console.log(qntRegistro);
  criarTabelas(globalId.length);

  for (let i = 0; i < globalId.length; i++) {

    fetch(`http://localhost:3000/leituras/dadosdeCadaComp/${globalId[i]}/${qntRegistro}`, { cache: "no-store" })
      .then(function (response) {

        if (response.ok) {
          response.json().then(function (resposta) {

            var soma = 0.0;
            var mediaFinal;
            var disc;
            var memo;
            var minCpu;
            var maxCpu;
            var minDisc;
            var maxDisc;
            var maxMemo;
            var minMemo;
            var totalCpu = [];
            var totalDisc = [];
            var totalMemo = [];

            console.log(resposta);
            for (let x = 0; x < qntRegistro; x++) {

              if (resposta[x].nomeComponente == "CPU_uso") {
                atual = parseInt(resposta[x].valor);
                soma = soma + atual;
                mediaFinal =parseInt( soma / numCoreVariavel[0]);
                minCpu = resposta[x].minimo;
                maxCpu = resposta[x].maximo;
              }
              else if (resposta[x].nomeComponente == "Disco_uso") {
                disc = resposta[x].valor;
                minDisc = resposta[x].minimo;
                maxDisc = resposta[x].maximo;
              }
              else if (resposta[x].nomeComponente == "Memória_uso") {
                memo = resposta[x].valor;
                minMemo = resposta[x].minimo;
                maxMemo = resposta[x].maximo;
              }
            }
            totalCpu.push(mediaFinal,minCpu, maxCpu);
            totalDisc.push(disc,minDisc, maxDisc);
            totalMemo.push(memo,minMemo, maxMemo);
            // console.log(mediaFinal);
            // console.log(disc);
            // console.log(memo);
            // console.log("----------------")
            // console.log(totalCpu);
            // console.log(totalDisc);
            // console.log(totalMemo);
            
            // console.log(globalId.length);
            atribuirDados(totalMemo, totalCpu, totalDisc, i, globalTipo, globalId);
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

function atribuirDados(totalMemo, totalCpu, totalDisc, numMaqui, globalTipo,globalId) {

  console.log("globalTipo" + globalTipo[0]);

  let comp = ["mem", "cpu", "disc"];
  let compo_maq = [totalMemo, totalCpu, totalDisc];
  
  for(c in comp){
    let maquina = numMaqui + 1;
            
    for(let w = 1; w <= 3; w++){
                  
      let componente = document.getElementById(`${comp[c]}${maquina}_${w}`);  

      if (comp[c] == "mem"){
        componente.innerHTML = totalMemo[w - 1];        
      }
      else if (comp[c] == "cpu"){        
        componente.innerHTML = totalCpu[w - 1];
      }
      else if (comp[c] == "disc"){     
        componente.innerHTML = totalDisc[w - 1];  
      }

    }

    maquina++;
      
  }



  for(let m = 1; m <= globalTipo.length; m++){

      let maquina_tipo = document.getElementById(`tipo_maquina${m}`);
      maquina_tipo.innerHTML = "Tipo Máquina: " + globalTipo[m-1];

      let id_maquina = document.getElementById(`id_maquina${m}`);
      id_maquina.innerHTML = "ID Máquina: " + globalId[m-1];
    
  }
}





function criarTabelas(numMaqui){
  // console.log(numMaqui);
  
  let cont_col = 1;

  //caixa_maquinas.innerHTML = '<div class="row">';

  let cont_comp_cpu=1; 
  let cont_comp_disc=1; 
  let cont_comp_mem = 1;

  for(let id_maquina = 1; id_maquina <= numMaqui; id_maquina++){

    

  let caixa = `<div class="col-md-4">  <div id="maquina_${id_maquina}" class="card mb-4 shadow-sm shadow p-3 mb-5 bg-white rounded">      <div class="row ">        <table class="table table-striped table-dark"              style="width: 80%;margin: auto;margin-top: 5%; text-align: center;">              <thead>                  <tr>                      <th scope="col">Memória</th>                      <th scope="col">CPU</th>                      <th scope="col">Disco</th>                  </tr>              </thead>              <tbody>                  <tr>                      <td id="tab1lin1" style="background-color: #17a2b8; min-inline-size: 80px;">                          <i id="icone11" style="color: #343a40;" class="fas fa-check"></i></td>                      <td id="tab1lin2" style=" background-color: #FF6384; min-inline-size: 80px;"><i                              id="icone12" style="color: #343a40;" class="fas fa-skull"></i></td>                      <td style="background-color: #FFCE56; min-inline-size: 80px;"><i                              style="color: #343a40;" class="fas fa-exclamation-circle"></i></td>                  </tr>              </tbody      </table>      <table class="table table-striped table-dark "                  style="width: 80%;margin: auto;margin-top: 5%;display:none">                   </table>        </div>      <div class="card-body">          <p class="card-text">              <font style="vertical-align: inherit;">                  <font id="id_maquina${id_maquina}" style="vertical-align: inherit;">ID Máquina:</font><br>                  <font id="tipo_maquina${id_maquina}" style="vertical-align: inherit;">Tipo de Máquina</font>              </font>          </p>          <div class="d-flex justify-content-between align-items-center">              <div class="btn-group">                  <button type="button" id="amplia1"  class="btn btn-sm btn-outline-secondary"data-toggle="modal" data-target="#ampli${id_maquina}"
                    data-whatever="@mdo"> <font style="vertical-align: inherit;">Ampliar</font>                      </font>                  </button>                  <button type="button" class="btn btn-sm btn-outline-secondary">                      <font style="vertical-align: inherit;">                          <font style="vertical-align: inherit;"><a href="DashMaquina.html"                                  style="text-decoration: none; color: #6c757d;"><a                                      href="DashMaquina.html"                                      style="text-decoration: none; color: #6c757d;">Analisar</a></a>                          </font>                      </font>                  </button> </a>              </div          </div>      </div>  </div> </div>
  
  
  
  







                    
                    <div class="modal fade" id="ampli${id_maquina}" tabindex="-1" aria-labelledby="ampli${id_maquina}Label"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-danger" id="ampli${id_maquina}Label">
                                    Máquina ${id_maquina}
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span id="close" aria-hidden="true" class="text-dark">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">                
                                  
                                <table class="table table-striped table-light"             >                  <thead>                      <tr>                          <th scope="col">Componente</th>                          <th scope="col">Usado (%)</th>                          <th scope="col">Mínimo</th>                          <th scope="col">Máximo</th>                      </tr>                  </thead>                  <tbody>                      <tr>                          <th id="mem0" scope="row">Memória</th>                          <td id="mem${id_maquina}_${cont_comp_mem}"></td>                          <td id="mem${id_maquina}_${cont_comp_mem+1}"></td>                          <td id="mem${id_maquina}_${cont_comp_mem+2}"></td>                      </tr>                      <tr>                          <th id="cpu0" scope="row">CPU</th>                          <td id="cpu${id_maquina}_${cont_comp_cpu}"></td>                          <td id="cpu${id_maquina}_${cont_comp_cpu+1}"></td>                          <td id="cpu${id_maquina}_${cont_comp_cpu+2}"></td                      </tr>                      <tr>                          <th id="disc0" scope="row">Disco</th>                          <td id="disc${id_maquina}_${cont_comp_disc}"></td>                          <td id="disc${id_maquina}_${cont_comp_disc+1}"></td>                          <td id="disc${id_maquina}_${cont_comp_disc+2}"></td>                      </tr>                  </tbody>              </table>

                                </div>
                                <div class="modal-footer">

                                </div>
                            </div>
                        </div>
                    </div>
  
          
  `;


    
    // if(cont_col==2){
    //   // caixa_maquinas.innerHTML+= caixa;
    //   cont_col++;
    // }
   

    // console.log("cpu " + cont_comp_cpu);
    // console.log("disc " + cont_comp_disc);
    // console.log("mem "+ cont_comp_mem);


    caixa_maquinas.innerHTML += caixa;
  }


  
  function igualarClass() {
    var listaComponente = ["mem", "disc", "cpu"];
    for (componente in listaComponente) {
      
      let cont = 0;
      while (true) {
        let idTemporario = document.querySelector(`#${listaComponente[componente]}${cont}`);

      if (idTemporario == null) {
        break;
      }

      // console.log(idTemporario.innerHTML);
      idTemporario.className = "critico";
      cont++;
    }
   
  }
}
}