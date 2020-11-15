package br.com.bandtec.login_dash;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author SixMinds
 */
public class Configuracao extends javax.swing.JFrame {

    JdbcTemplate jdbcTemplate1;
    
    List<Integer> Idmaq;
    List<Integer> Idcomp;
    List<String> Nomemaq;
    List<String> Nomecomp;
    public Configuracao(JdbcTemplate jdbcTemplate) {
        initComponents();
        jdbcTemplate1=jdbcTemplate;
//        Para Máquinas
        List<Maquina> dadosMaquinas = jdbcTemplate.query(
        "select idmaquina,tipomaquina from Maquina;",
        new BeanPropertyRowMapper(Maquina.class));
        System.out.println(dadosMaquinas);
        for (Maquina maq : dadosMaquinas) {
            System.out.println(maq.getTipoMaquina());
            System.out.println(maq.getIdMaquina());
            System.out.println("-----------------------------------------------");
        }
//        Para Componentes
        List<Componentes> dadosComponentes = jdbcTemplate.query(
        "select idComponente,nomeComponente from Componente;",
        new BeanPropertyRowMapper(Componentes.class));
//        EM MANUTENÇÃO
        System.out.println(dadosComponentes);

        List<String> apenasNome = new ArrayList<String>();
        List<Integer> apenasIdComp = new ArrayList<Integer>();
        for (Componentes comp : dadosComponentes) {
            System.out.println(comp.getIdcomponente());
            System.out.println(comp.getNomecomponente());
            System.out.println("-----------------------------------------------");
            apenasNome.add(comp.getNomecomponente());
            apenasIdComp.add(comp.getIdcomponente());
        }
        Idcomp=apenasIdComp;
        Nomecomp=apenasNome;
        Object[] item =apenasNome.toArray();
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel(item);
        cbComponente.setModel(modelo1);
        System.out.println(apenasNome);
        
        
//         Para Maquina
        List<Maquina> dadosMaquina = jdbcTemplate.query(
        "select idMaquina,tipoMaquina from Maquina;",
        new BeanPropertyRowMapper(Maquina.class));
//        EM MANUTENÇÃO
        System.out.println(dadosMaquina);

        List<String> apenasTipo = new ArrayList<String>();
        List<Integer> apenasIdMaq = new ArrayList<Integer>();
        for (Maquina maq : dadosMaquina) {
            System.out.println(maq.getIdMaquina());
            System.out.println(maq.getTipoMaquina());
            System.out.println("-----------------------------------------------");
            apenasTipo.add(maq.getTipoMaquina());
            apenasIdMaq.add(maq.getIdMaquina());
        }
        Idmaq=apenasIdMaq;
        Nomemaq=apenasTipo;
        Object[] item1 =apenasTipo.toArray();
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(item1);
        cbMaquina.setModel(modelo2);
        System.out.println(apenasTipo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbComponente = new javax.swing.JComboBox<>();
        cbMaquina = new javax.swing.JComboBox<>();
        cbEstado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbComponente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Componente" }));
        cbComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComponenteActionPerformed(evt);
            }
        });

        cbMaquina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maquina", " " }));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desativado", "Ativado" }));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btFechar.setText("fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("CONFIGURAR");

        jLabel2.setText("Maquina:");

        jLabel3.setText("Componente");

        jLabel4.setText("Estado:");

        lbResultado.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addComponent(btFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComponenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbComponenteActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nomeC=Nomecomp.get(0);
        String nomeM=Nomemaq.get(0);
        
        Integer IndexMaquina= cbMaquina.getSelectedIndex();
        String idMaquina= Idmaq.get(IndexMaquina).toString();
        System.out.println("maquina:");
        System.out.println(idMaquina);
        
        Integer IndexComp= cbComponente.getSelectedIndex();
        System.out.println(IndexComp);
        String idComponente= Idcomp.get(IndexComp).toString();
        System.out.println("componente:");
        System.out.println(idComponente);
        
        Integer esta= cbEstado.getSelectedIndex();
        String estad;
        Boolean estado;
        if (esta==0) {
            estado=Boolean.FALSE;
            estad="Desativado";
        }
        else{
            estado=Boolean.TRUE;
            estad="Ativado";
        }
        System.out.println("estado:");
        System.out.println(estado);
        int update=jdbcTemplate1.update("update MaquinaComponente set ativado = ? where fkmaquina = ? and fkcomponente= ?",estado,idMaquina,idComponente);
        if(update==0){
        int inserir=jdbcTemplate1.update("insert into MaquinaComponente(fkMaquina,fkComponente,ativado) values (?,?,?)",idMaquina,idComponente,estado);
        
            if(inserir==0){
                lbResultado.setText(String.format("Dado inserido não foi inserido com sucesso"));
            }
            else{
                lbResultado.setText(String.format("Componente: %s na maquina: %s foi INSERIDO com sucesso, está: %s",nomeC,nomeM,estad));
            }
        }else{
            lbResultado.setText(String.format("Componente: %s na maquina: %s foi ATUALIZADO para: %s",nomeC,nomeM,estad));
        }
        System.out.println(update);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Configuracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Configuracao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFechar;
    private javax.swing.JComboBox<String> cbComponente;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbMaquina;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbResultado;
    // End of variables declaration//GEN-END:variables
}
