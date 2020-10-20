
package yuiti.projeto.individual.conectado.bd;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class InformarMaquina {
    void mostrarDadosDaMaquina(JdbcTemplate template,Integer valorMaquina,JLabel lbidmaquina,JLabel lbtipoMaquina,
            JLabel lbsistemaOperacional,JLabel lbmeoriaTotal,JLabel lbNumeroNucleos){
        System.out.println( template.queryForList("select * from Maquina;"));
        List<Maquina> informacaoMaquina = template.query(
                "select * from Maquina where idmaquina=?;", new BeanPropertyRowMapper(Maquina.class),valorMaquina);
        
   
        for (Maquina maquina : informacaoMaquina) {
            lbidmaquina.setText(String.valueOf(maquina.getIdMaquina()));
            lbmeoriaTotal.setText(String.valueOf(maquina.getRamTotal()));
            lbNumeroNucleos.setText(String.valueOf(maquina.getNumeroNucleos()));
            lbtipoMaquina.setText(String.valueOf(maquina.getTipoMaquina()));
            lbsistemaOperacional.setText(String.valueOf(maquina.getSistemaOperacional()));
            
        }
        
     
    }
    void pegarUsoCpu(JdbcTemplate template,Integer valorMaquina){
     
        List<Leitura> leituras = template.query(
                "select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor, componente.metrica, leitura.tempoLeitura"
                        + " from maquina, leitura, componente, maquinaComponente "
                        + "where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=? "
                        + "order by idLeitura desc; ", new BeanPropertyRowMapper(Leitura.class),valorMaquina);
     
 
          
         /*
        for (Leitura cadaLeitura : leituras) {
            System.out.println("IdMaquina: "+cadaLeitura.getIdLeitura());
        
            System.out.println("Memória total: "+cadaLeitura.getDescricao());
           
            System.out.println("Número de núcleos: "+cadaLeitura.getValor());
      
            System.out.println("Tipo de máquina: "+cadaLeitura.getMetrica());
          
            System.out.println("Sistema operacional: "+cadaLeitura.getTempoLeitura());
           
            
        }*/
    }
}
