package br.com.bandtec.login_dash;

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

    /**
     * Creates new form Configuracao
     */
    public Configuracao(JdbcTemplate jdbcTemplate) {
        initComponents();
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

        List<String> apenasTipo = new ArrayList<String>();

        for (Componentes comp : dadosComponentes) {
            System.out.println(comp.getIdcomponente());
            System.out.println(comp.getNomecomponente());
            System.out.println("-----------------------------------------------");
            apenasTipo.add(comp.getNomecomponente());
        }
         Object[] item =apenasTipo.toArray();
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel(item);
        cbComponente.setModel(modelo1);
        System.out.println(apenasTipo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbComponente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbComponente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbComponente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComponenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbComponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbComponenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComponenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbComponenteActionPerformed

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
    private javax.swing.JComboBox<String> cbComponente;
    // End of variables declaration//GEN-END:variables
}
