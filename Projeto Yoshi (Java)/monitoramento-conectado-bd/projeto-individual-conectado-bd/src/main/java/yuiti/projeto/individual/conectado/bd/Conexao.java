
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
    public static void main(String[] args) {
     
   // }
   // void conectar(){
     BasicDataSource dataSource = new BasicDataSource();
        // indicando a calsse do driver de banco
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        //Indicando a URL do banco
        dataSource.setUrl("jdbc:mysql://localhost/maquinas?useTimezone=true&serverTimezone=UTC");
        // indicando o usuario e senha de acesso
    
        dataSource.setUsername("urubu100");
        dataSource.setPassword("urubu100");
        // JDBCTemplate permite enviar instruçõe SQL ao banco
        // bem como trata    e converte as respostas
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    
        System.out.println( jdbcTemplate.queryForList("select * from Maquina;"));
        List<Maquina> informacaoMaquina = jdbcTemplate.query(
                "select * from Maquina;", new BeanPropertyRowMapper(Maquina.class));
        
        // Enhanced for 
        for (Maquina maquina : informacaoMaquina) {
            System.out.println("IdMaquina: "+maquina.getIdMaquina());
            System.out.println("Memória total: "+maquina.getRamTotal());
            System.out.println("Número de núcleos: "+maquina.getNumeroNucleos());
            System.out.println("Tipo de máquina: "+maquina.getTipoMaquina());
            System.out.println("Sistema operacional: "+maquina.getSistemaOperacional());
            
        }
}
}
