package br.com.sixminds.client.java.sixminds.dashboard;

import br.com.sixminds.client.java.sixminds.graficos.LineChart;
import br.com.sixminds.client.java.sixminds.modelos.*;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author User
 */
public class Funcoes {
    
    void pegarComponente(JdbcTemplate jdbcTemplate1,LineChart plotCPU,LineChart plotMem,LineChart plotDisco,String ativadoCPU,JLabel cpuAtivado, JLabel mini, JLabel maxi){
        cpuAtivado.setText("");
        List<Componentes> listaComp=jdbcTemplate1.query("select idComponente,nomeComponente from Componente, MaquinaComponente,"
                + "Maquina where idComponente=fkComponente and idMaquina=fkMaquina and idMaquina=1 and ativado=1;",
                new BeanPropertyRowMapper(Componentes.class));
        for(Componentes compon : listaComp){
            cpuAtivado.setText(String.format("<html>%s<br><html>"+"%s",cpuAtivado.getText(),compon.getNomecomponente()));
            Integer numero=10;
            if (compon.getNomecomponente().equals("CPU_uso")) {
                funcaoCPU(jdbcTemplate1,plotCPU,plotMem,plotDisco,ativadoCPU,compon,cpuAtivado,mini,maxi);
            }
            else{
                List<LeituraComponente> listaCada=jdbcTemplate1.query(
                    "select idLeitura,idComponente,nomeComponente,descricao,idMaquinaComponente,ativado,valor,minimo,maximo from Usuario,Maquina,MaquinaComponente,"
                    + "Componente,Leitura where nomeUsuario=\"João\" and idMaquina=1 and idUsuario=Usuario_idUsuario\n" +
                    " and idMaquina=fkMaquina and nomeComponente=? and idComponente=fkComponente and idMaquinaComponente=fkMaquinaComponente order by idLeitura desc limit 10;",
                    new BeanPropertyRowMapper(LeituraComponente.class),compon.getNomecomponente());

                for(LeituraComponente leitura : listaCada){
                    separar(plotCPU,plotDisco,plotMem,leitura,ativadoCPU,numero,cpuAtivado,mini,maxi);
//                    System.out.println(leitura.getNomeComponente());
//                    System.out.println(leitura.getValor());
                    numero--;
                }
            }
        }
    }
    
    
    void funcaoCPU(JdbcTemplate jdbcTemplate1,LineChart plotCPU,LineChart plotMem,LineChart plotDisco,String ativadoCPU,Componentes compon,JLabel cpuAtivado, JLabel mini, JLabel maxi){
        /*-CONTA QUANTOS NUCLEOS TEM NO PCZAO-*/
        List<Cores> listaQnt=jdbcTemplate1.query(
                    " select distinct(descricao) from Maquina,Componente,MaquinaComponente,Leitura where "
                    + "nomeComponente=\"CPU_uso\" and fkComponente=idComponente and descricao like \"Core%\" "
                    + "and idMaquinaComponente=fkMaquinaComponente and fkMaquina=idMaquina;",new BeanPropertyRowMapper(Cores.class));

        for (Cores core : listaQnt) {
            Integer numero=10;
            List<LeituraComponente> listaCada=jdbcTemplate1.query(
                    "select idLeitura,idComponente,nomeComponente,descricao,idMaquinaComponente,ativado,valor,minimo,maximo from Usuario,Maquina,MaquinaComponente,"
                            + "Componente, Leitura where nomeUsuario=\"João\" and idMaquina=1 and idUsuario=Usuario_idUsuario\n" +
" and idMaquina=fkMaquina and idComponente=fkComponente and nomeComponente=? and descricao=? and idMaquinaComponente=fkMaquinaComponente order by idLeitura desc limit 10;",
                    new BeanPropertyRowMapper(LeituraComponente.class),compon.getNomecomponente(),core.getDescricao());
            for(LeituraComponente leitura : listaCada){
                separar(plotCPU,plotDisco,plotMem,leitura,ativadoCPU,numero,cpuAtivado,mini,maxi);
                numero--;
//                System.out.println(leitura.getValor());
            }
        }
    }
       
    
    
    
    // Esses JPanel é só pra ler, mas na real são line charts
    void separar(LineChart jPanelCPU,LineChart jPanelMemoria,LineChart jPanelDisco,LeituraComponente leitura,String ativadoCPU,Integer numero,JLabel cpuAtivado, JLabel mini, JLabel maxi){
 
        if (leitura.getNomeComponente().equals("CPU_uso") || leitura.getNomeComponente().equals("CPU_temperatura") || leitura.getNomeComponente().equals("CPU_clock")) {
            if (ativadoCPU.equals("nada")) {
                if (leitura.getNomeComponente().equals("CPU_uso")) {
                //Inserir dado na Line
                    jPanelCPU.inserir(leitura.getValor(),leitura.getDescricao(),numero);
                    mini.setText(String.format("%.2f",leitura.getMinimo()));
                    maxi.setText(String.format("%.2f",leitura.getMaximo()));
                }
            }
            else{
                if (ativadoCPU.equals("CPU_uso(%)")) {
                    if (leitura.getNomeComponente().equals("CPU_uso")) {
                    //Inserir dado na Line
                        jPanelCPU.inserir(leitura.getValor(),leitura.getDescricao(),numero);
                        mini.setText(String.format("%.2f",leitura.getMinimo()));
                        maxi.setText(String.format("%.2f",leitura.getMaximo()));
                    }
                }
                else if(ativadoCPU.equals("Temperatura")){
                    if (leitura.getNomeComponente().equals("CPU_temperatura")) {
                        System.out.println("TEORICAMENTE FOI-----------");
                    //Inserir dado na Line
                        jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),numero);
                        mini.setText(String.format("%.2f",leitura.getMinimo()));
                        maxi.setText(String.format("%.2f",leitura.getMaximo()));
                    }
                }
                else{
                    if (leitura.getNomeComponente().equals("CPU_clock")) {
                        System.out.println("TEORICAMENTE FOI-----------");
                    //Inserir dado na Line
                        jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),numero);
                        mini.setText(String.format("%.2f",leitura.getMinimo()));
                        maxi.setText(String.format("%.2f",leitura.getMaximo()));
                    }
                }
            }  
        }

        else if (leitura.getNomeComponente().equals("Disco_uso")) {
            jPanelDisco.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.geiIdLeitura());
        }
        else if(leitura.getNomeComponente().equals("Memória_uso")){
            jPanelMemoria.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.geiIdLeitura());
        }
        
    }
}
    

