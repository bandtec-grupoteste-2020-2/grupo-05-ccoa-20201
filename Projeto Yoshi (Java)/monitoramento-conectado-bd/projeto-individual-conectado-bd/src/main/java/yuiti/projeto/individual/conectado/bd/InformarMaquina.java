
package yuiti.projeto.individual.conectado.bd;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class InformarMaquina {
    void mostrarDadosDaMaquina(JdbcTemplate template,Integer valorMaquina,JLabel lbidmaquina,JLabel lbtipoMaquina,
            JLabel lbsistemaOperacional,JLabel lbmeoriaTotal,JLabel lbNumeroNucleos,JProgressBar barraCpu){
        System.out.println( template.queryForList("select * from Maquina;"));
        List<Maquina> informacaoMaquina = template.query(
                "select * from Maquina where idmaquina=?;", new BeanPropertyRowMapper(Maquina.class),valorMaquina);
        
  
        for (Maquina maquina : informacaoMaquina) {
            lbidmaquina.setText(String.valueOf(maquina.getIdMaquina()));
            lbmeoriaTotal.setText(String.valueOf(maquina.getRamTotal()));
            lbNumeroNucleos.setText(String.valueOf(maquina.getNumeroNucleos()));
            Integer numeroDeNucleos = maquina.getNumeroNucleos();
            lbtipoMaquina.setText(String.valueOf(maquina.getTipoMaquina()));
           
            lbsistemaOperacional.setText(String.valueOf(maquina.getSistemaOperacional()));
            
            
            pegarUsoCpu(template, valorMaquina,numeroDeNucleos,barraCpu);
        }
        
     
    }
    void pegarUsoCpu(JdbcTemplate template,Integer valorMaquina,Integer numeroNucleos,JProgressBar barraCpu){
     
        List<Leitura> leituras = template.query(
                "select leitura.idLeitura, maquina.tipoMaquina, leitura.descricao, leitura.valor, componente.metrica, leitura.tempoLeitura"
                        + " from maquina, leitura, componente, maquinaComponente "
                        + "where fkComponente = idComponente and idMaquina = fkMaquina and fkMaquinaComponente = idMaquinaComponente and idmaquina=? and descricao like \"Core%\" and metrica = '%' "
                        + "order by idLeitura desc limit ?; ", new BeanPropertyRowMapper(Leitura.class),valorMaquina,numeroNucleos);
     
 
          
        Double media = 0.0;
        for (Leitura cadaLeitura : leituras) {
             
            System.out.println("IdMaquina: "+cadaLeitura.getIdLeitura());
           
           media+=cadaLeitura.getValor();
            System.out.println("Memória total: "+cadaLeitura.getDescricao());
           
            System.out.println("Número de núcleos: "+cadaLeitura.getValor());
      
            System.out.println("Tipo de máquina: "+cadaLeitura.getMetrica());
          
            System.out.println("Sistema operacional: "+cadaLeitura.getTempoLeitura());
           
            
        }
  
        media=media/numeroNucleos;
   
        Integer finalmedia=media.intValue();
    
       
       barraCpu.setValue(finalmedia);
        
    }
}
