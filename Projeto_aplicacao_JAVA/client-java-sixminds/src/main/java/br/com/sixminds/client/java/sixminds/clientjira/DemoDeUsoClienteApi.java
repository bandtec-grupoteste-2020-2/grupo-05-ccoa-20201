package br.com.sixminds.client.java.sixminds.clientjira;

import br.com.sixminds.client.java.sixminds.clientjira.modelos.Issue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class DemoDeUsoClienteApi {

    public static void main(String[] args) throws IOException {

        // Este "gson" é opcional. Apenas para imprimir os objetos na saída padrão, caso queira.
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ClienteJiraApi clienteJiraApi = new ClienteJiraApi(
                "sixminds.atlassian.net",
                "carlos.santana@bandtec.com.br",
                "dGYq8LbV5ElKaOqSdjLR39AF"
        );

//        Issue issue = clienteJiraApi.getIssue("PSM-14");
//        System.out.println("Issue recuperada: "+gson.toJson(issue));;

//         Exemplo de objeto para novo chamado (Issue)
        Issue novaIssue = new Issue();
        novaIssue.setProjectKey("PSM");
        novaIssue.setSummary("Fazendo mais um teste aqui");
        novaIssue.setDescription("novamente tudo funciona");
        novaIssue.setLabels("alerta-cpu", "alerta-disco");

        clienteJiraApi.criarIssue(novaIssue);
        System.out.println("Issue criada: "+gson.toJson(novaIssue));

    }
}
