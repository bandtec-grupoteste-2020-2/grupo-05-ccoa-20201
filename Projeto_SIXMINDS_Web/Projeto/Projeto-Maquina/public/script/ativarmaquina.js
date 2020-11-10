atualizar_Maquinas();
function atualizar_Maquinas() {

    fetch('http://localhost:3000/leituras/recebermaquinas', { cache: 'no-store' }).then(function (response) {
        if (response.ok) {

            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

                for (i = 0; i < resposta.length; i++) {


                    var registro = resposta[i];
                    const tipodaMaquina = registro.tipoMaquina;
                    const iddaMaquina = registro.idMaquina;

                    var option = new Option(tipodaMaquina, iddaMaquina);
                    var select = document.getElementById("maquina_valor");
                    select.add(option);


                }
            })
        } else {
            console.error('Nenhum dado encontrado ou erro na leituras');
        }
    }).catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

}
///////////////////////////
atualizar_Componentes();
function atualizar_Componentes() {

    fetch('http://localhost:3000/leituras/recebercomponentes', { cache: 'no-store' }).then(function (response) {
        if (response.ok) {

            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);

                for (i = 0; i < resposta.length; i++) {


                    var registro = resposta[i];
                    const nomeComponente = registro.nomeComponente;
                    const idComponente = registro.idComponente;

                    var option = new Option(nomeComponente, idComponente);
                    var select = document.getElementById("componente_valor");
                    select.add(option);



                }
            })
        } else {
            console.error('Nenhum dado encontrado ou erro na leituras');
        }
    }).catch(function (error) {
        console.error(`Erro na obtenção dos dados p/ gráfico: ${error.message}`);
    });

}


function atualizar_banco(maquina, componente, ativado) {
    maquina = parseInt(maquina)
    componente = parseInt(componente)
    ativado = parseInt(ativado)
    console.log(maquina)
    console.log(componente)
    console.log(ativado)

    fetch(`http://localhost:3000/leituras/enviar/${maquina}/${componente}/${ativado}`, { method: "POST" }, { cache: 'no-store' }).then(function (response) {
        if (response.ok) {
            response.json().then(function (resposta) {

                console.log(`Dados recebidos: ${JSON.stringify(resposta)}`);


                var linhasalteradas = resposta.affectedRows;
                if (linhasalteradas == 0) {
                    fetch(`http://localhost:3000/leituras/criar/${maquina}/${componente}/${ativado}`, { method: "POST" }, { cache: 'no-store' }).then(function (response) {
                        if (response.ok) {
                            console.log("Alterado com sucesso")
                        } else {
                            console.error('Nenhum dado encontrado ou erro na leituras');
                        }
                        return false;
                    });

                }

            })

            console.log("Alterado com sucesso")
        } else {
            console.error('Nenhum dado encontrado ou erro na leituras');
        }
        return false;
    });
}
