
package yuiti.projeto.individual.conectado.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
public class Conexao {
   InformarMaquina informandoMaquina = new InformarMaquina();
   void conectar(Integer valorMaquina,JLabel lbidmaquina,JLabel lbtipoMaquina,JLabel lbsistemaOperacional,JLabel lbmeoriaTotal,JLabel lbNumeroNucleos){
     BasicDataSource dataSource = new BasicDataSource();
   
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
    
        dataSource.setUrl("jdbc:mysql://localhost/maquinas?useTimezone=true&serverTimezone=UTC");

    
        dataSource.setUsername("urubu100");
        dataSource.setPassword("urubu100");
 
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        informandoMaquina.mostrarDadosDaMaquina(jdbcTemplate,valorMaquina,lbidmaquina,lbtipoMaquina,lbsistemaOperacional,lbmeoriaTotal,lbNumeroNucleos);
        informandoMaquina.pegarUsoCpu(jdbcTemplate, valorMaquina);

  
   
   }
}
