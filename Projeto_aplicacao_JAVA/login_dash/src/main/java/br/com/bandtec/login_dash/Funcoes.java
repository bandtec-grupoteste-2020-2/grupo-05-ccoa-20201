/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.login_dash;

import java.util.List;
import javax.swing.JPanel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author User
 */
public class Funcoes {
    
    void pegarComponente(JdbcTemplate jdbcTemplate1,LineChart plotCPU,LineChart plotMem,LineChart plotDisco,String ativadoCPU){
        List<Componentes> listaComp=jdbcTemplate1.query("select idComponente,nomeComponente from componente,maquinacomponente,"
                + "maquina where idComponente=fkComponente and idMaquina=fkMaquina and idMaquina=1 and ativado=1;",
                new BeanPropertyRowMapper(Componentes.class));
        for(Componentes compon : listaComp){
            
            System.out.println(compon.getNomecomponente());
            
            List<LeituraComponente> listaCada=jdbcTemplate1.query(
                "select idLeitura,idComponente,nomeComponente,descricao,idMaquinaComponente,ativado,valor from usuario,maquina,maquinacomponente,"
                + "componente,leitura where nomeUsuario=\"João\" and idMaquina=1 and idUsuario=Usuario_idUsuario\n" +
                " and idMaquina=fkMaquina and nomeComponente=? and idComponente=fkComponente and idMaquinaComponente=fkMaquinaComponente limit 10;",
                new BeanPropertyRowMapper(LeituraComponente.class),compon.getNomecomponente());
            for(LeituraComponente leitura : listaCada){
                separar(plotCPU,plotDisco,plotMem,leitura,ativadoCPU);
                System.out.println(leitura.getValor());
            }
        }
    }
    // Esses JPanel é só pra ler, mas na real são line charts
    void separar(LineChart jPanelCPU,LineChart jPanelMemoria,LineChart jPanelDisco,LeituraComponente leitura,String ativadoCPU){
 
        if (leitura.getNomeComponente().equals("CPU_uso") || leitura.getNomeComponente().equals("CPU_temperatura") || leitura.getNomeComponente().equals("CPU_clock")) {
            if (ativadoCPU.equals("nada")) {
                if (leitura.getNomeComponente().equals("CPU_uso")) {
                    jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
                }
            }
            else{
                if (ativadoCPU.equals("CPU_uso(%)")) {
                    if (leitura.getNomeComponente().equals("CPU_uso")) {
                        jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
                    }
                }
                else if(ativadoCPU.equals("Temperatura")){
                    if (leitura.getNomeComponente().equals("CPU_temperatura")) {
                        jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
                    }
                }
                else{
                    if (leitura.getNomeComponente().equals("CPU_clock")) {
                        jPanelCPU.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
                    }
                }
            }   
        }

        
        
        
        else if (leitura.getNomeComponente().equals("Disco_uso")) {;
            jPanelDisco.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
        }
        else if(leitura.getNomeComponente().equals("Memória_uso")){
            jPanelMemoria.inserir(leitura.getValor(),leitura.getNomeComponente(),leitura.getIdLeitura());
        }
        
    }
}
    

