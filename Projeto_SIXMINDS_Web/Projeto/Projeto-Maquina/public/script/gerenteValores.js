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
                mediaFinal = parseInt(soma / numCoreVariavel[0]);
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
            totalCpu.push(mediaFinal, minCpu, maxCpu);
            totalDisc.push(disc, minDisc, maxDisc);
            totalMemo.push(memo, minMemo, maxMemo);
            // console.log(mediaFinal);
            // console.log(disc);
            // console.log(memo);
            // console.log("----------------")
            // console.log(totalCpu);
            // console.log(totalDisc);
            // console.log(totalMemo);

            // console.log(globalId.length);
            atribuirDados(totalMemo, totalCpu, totalDisc, i, globalTipo, globalId);
            igualarClass(totalMemo, totalCpu, totalDisc, i);
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

function atribuirDados(totalMemo, totalCpu, totalDisc, numMaqui, globalTipo, globalId) {

  // console.log("globalTipo" + globalTipo[0]);

  let comp = ["mem", "cpu", "disc"];
  let compo_maq = [totalMemo, totalCpu, totalDisc];

  for (c in comp) {
    let maquina = numMaqui + 1;

    for (let w = 1; w <= 3; w++) {

      let componente = document.getElementById(`${comp[c]}${maquina}_${w}`);

      if (comp[c] == "mem") {
        componente.innerHTML = totalMemo[w - 1];
      }
      else if (comp[c] == "cpu") {
        componente.innerHTML = totalCpu[w - 1];
      }
      else if (comp[c] == "disc") {
        componente.innerHTML = totalDisc[w - 1];
      }

    }

    maquina++;

  }

  for (let m = 1; m <= globalTipo.length; m++) {

    let maquina_tipo = document.getElementById(`tipo_maquina${m}`);
    maquina_tipo.innerHTML = "Tipo Máquina: " + globalTipo[m - 1];

    let id_maquina = document.getElementById(`id_maquina${m}`);
    id_maquina.innerHTML = "ID Máquina: " + globalId[m - 1];

  }

}
// setInterval(atualizarTable, 5000);
function piscar_icone(icone) {
  
  console.log("piscando");

  if(icone.style.display = "none"){
    icone.style.display = "block";
  }
  // setTimeout(icone + ".style.display='inline-block'", 100);
}




function criarTabelas(numMaqui) {
  // console.log(numMaqui);

  let cont_col = 1;

  //caixa_maquinas.innerHTML = '<div class="row">';

  let cont_comp_cpu = 1;
  let cont_comp_disc = 1;
  let cont_comp_mem = 1;

  for (let id_maquina = 1; id_maquina <= numMaqui; id_maquina++) {



    let caixa = `
    
    
    <div class="col-md-4"> <div id="maquina_${id_maquina}" class="card mb-4 shadow-sm shadow p-3 mb-5 bg-white rounded">      <div class="row ">             
    
    <table class="table table-striped table-dark" style="width: 80%;margin: auto;margin-top: 5%; text-align: center;">
    <thead>
        <tr>
            <th scope="col">Memória</th>
            <th scope="col">CPU</th>
            <th scope="col">Disco</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td id="tab${id_maquina}lin1">
                <i id="icone${id_maquina}lin1" style="color: #343a40; min-inline-size: 80px;">
                </i>
            </td>
            <td id="tab${id_maquina}lin2">
                <i id="icone${id_maquina}lin2" style="color: #343a40;min-inline-size: 80px;">
                </i>
            </td>
            <td id="tab${id_maquina}lin3" >
                <i id="icone${id_maquina}lin3" style="color: #343a40; min-inline-size: 80px;">
                </i>
            </td>
        </tr>
    </tbody 
</table>
    
    
    <table class="table table-striped table-dark "                  style="width: 80%;margin: auto;margin-top: 5%;display:none">                   </table>        </div>      <div class="card-body">          <p class="card-text">              <font style="vertical-align: inherit;">                  <font id="id_maquina${id_maquina}" style="vertical-align: inherit;">ID Máquina:</font><br>                  <font id="tipo_maquina${id_maquina}" style="vertical-align: inherit;">Tipo de Máquina</font>              </font>          </p>          <div class="d-flex justify-content-between align-items-center">              <div class="btn-group">                  <button type="button" id="amplia1"  class="btn btn-sm btn-outline-secondary"data-toggle="modal" data-target="#ampli${id_maquina}"
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
                                  
                                <table class="table table-striped table-light"             >                  <thead>                      <tr>                          <th scope="col">Componente</th>                          <th scope="col">Usado (%)</th>                          <th scope="col">Mínimo</th>                          <th scope="col">Máximo</th>                      </tr>                  </thead>                  <tbody>                      <tr>                          <th id="mem0" scope="row">Memória</th>                          <td id="mem${id_maquina}_${cont_comp_mem}"></td>                          <td id="mem${id_maquina}_${cont_comp_mem + 1}"></td>                          <td id="mem${id_maquina}_${cont_comp_mem + 2}"></td>                      </tr>                      <tr>                          <th id="cpu0" scope="row">CPU</th>                          <td id="cpu${id_maquina}_${cont_comp_cpu}"></td>                          <td id="cpu${id_maquina}_${cont_comp_cpu + 1}"></td>                          <td id="cpu${id_maquina}_${cont_comp_cpu + 2}"></td                      </tr>                      <tr>                          <th id="disc0" scope="row">Disco</th>                          <td id="disc${id_maquina}_${cont_comp_disc}"></td>                          <td id="disc${id_maquina}_${cont_comp_disc + 1}"></td>                          <td id="disc${id_maquina}_${cont_comp_disc + 2}"></td>                      </tr>                  </tbody>              </table>

                                </div>
                                <div class="modal-footer">

                                </div>
                            </div>
                        </div>
                    </div>
  
          
  `;



    caixa_maquinas.innerHTML += caixa;
  }

}

function igualarClass(totalMemo, totalCpu, totalDisc, num_maqui) {
  var comp = ["mem", "disc", "cpu"];
  // console.log("num_maqui " + (num_maqui+1))
  let maquina = num_maqui + 1;
  // let cont = 1;

  for(let r = 1; r<=3; r++){

      let caixa_icone  =document.getElementById(`tab${maquina}lin${r}`);
      let icone  =document.getElementById(`icone${maquina}lin${r}`);
      
    


      
      if (r==1) {       
        if (totalMemo[0] > totalMemo[2]) {          
          caixa_icone.className = "critico";
          icone.className = "fas fa-skull";
          // piscar_icone(icone);


        setInterval(piscar_icone(icone), 500);
          
        }
        else if (totalMemo[0] > totalMemo[1] && totalMemo[0] < totalMemo[2]) {
          
          caixa_icone.className = "alerta"; //"fas fa-exclamation-circle";
          icone.className = "fas fa-exclamation-circle";

        }
        else{          
          caixa_icone.className = "normal";
          icone.className = "fas fa-check";
        }
      }
      if (r==2) {
        if (totalCpu[0] > totalCpu[2]) {
          caixa_icone.className = "critico";
          icone.className = "fas fa-skull";
          setInterval(piscar_icone(icone), 500);


        }
        else if (totalCpu[0] > totalCpu[1] && totalCpu[0] < totalCpu[2]) {
          
          caixa_icone.className = "alerta"; //"fas fa-exclamation-circle";
        icone.className = "fas fa-exclamation-circle";}
        else{
          
          caixa_icone.className = "normal";
          icone.className = "fas fa-check";
        }
      }
      if (r==3) {
        if (totalDisc[0] > totalDisc[2]) {
          caixa_icone.className = "critico";
          icone.className = "fas fa-skull";
          setInterval(piscar_icone(icone), 500);

        }
        else if (totalDisc[0] > totalDisc[1] && totalDisc[0] < totalDisc[2]) {
          
          caixa_icone.className = "alerta"; //"fas fa-exclamation-circle";
          icone.className = "fas fa-exclamation-circle";}
        else{
          
          caixa_icone.className="normal";
          icone.className="fas fa-check";
        }
      }
  }



  for (c in comp) {
    console.log(maquina);
    for (let w = 1; w <= 3; w++) {

      let componente = document.getElementById(`${comp[c]}${maquina}_${w}`);

      if (comp[c] == "mem") {       
        if (totalMemo[0] > totalMemo[2]) {
          componente.className = "critico";
        }
        else if (totalMemo[0] > totalMemo[1] && totalMemo[0] < totalMemo[2]) {
          componente.className = "alerta";
        }
        else{
          componente.className = "normal";
        }
      }


      if (comp[c] == "cpu") {
        if (totalCpu[0] > totalCpu[2]) {
          componente.className = "critico";

        }
        else if (totalCpu[0] > totalCpu[1] && totalCpu[0] < totalCpu[2]) {
          componente.className = "alerta";
   
        }
        else{
          componente.className = "normal";

        }
      }


      if (comp[c] == "disc") {
        if (totalDisc[0] > totalDisc[2]) {
          componente.className = "critico";          
        }
        else if (totalDisc[0] > totalDisc[1] && totalDisc[0] < totalDisc[2]) {
          componente.className = "alerta";          
        }
        else{
          componente.className = "normal";
        }
      }

    }

  }

}


