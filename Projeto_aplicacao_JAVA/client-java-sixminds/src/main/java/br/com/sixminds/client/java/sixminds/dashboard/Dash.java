/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sixminds.client.java.sixminds.dashboard;

import java.util.concurrent.ThreadLocalRandom;
import br.com.sixminds.client.java.sixminds.login.Login;

/**
 *
 * @author SixMinds
 */
public class Dash extends javax.swing.JFrame {

    /**
     * Creates new form Dash
     */
    public Dash() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lbCPUMin = new javax.swing.JLabel();
        lbDiscoMin = new javax.swing.JLabel();
        lbMemoriaMin = new javax.swing.JLabel();
        lbCPUMax = new javax.swing.JLabel();
        lbDiscoMax = new javax.swing.JLabel();
        lbMemoriaMax = new javax.swing.JLabel();
        lbCPUMedia = new javax.swing.JLabel();
        lbDiscoMedia = new javax.swing.JLabel();
        pbCPU = new javax.swing.JProgressBar();
        pbMemoria = new javax.swing.JProgressBar();
        pbDisco = new javax.swing.JProgressBar();
        bLeitura = new javax.swing.JButton();
        lbResultadoDisco = new javax.swing.JLabel();
        lbResultadoMemoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbMemoriaMedia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbResultadoCPU = new javax.swing.JLabel();
        lbRedeMedia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbRedeMin = new javax.swing.JLabel();
        lbRedeMax = new javax.swing.JLabel();
        pbRede = new javax.swing.JProgressBar();
        lbResultadoRede = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Memoria Ram");

        lbCPUMin.setText("Minimo:");

        lbDiscoMin.setText("Minimo:");

        lbMemoriaMin.setText("Minimo:");

        lbCPUMax.setText("Maximo:");

        lbDiscoMax.setText("Maximo:");

        lbMemoriaMax.setText("Maximo:");

        lbCPUMedia.setText("Média");

        lbDiscoMedia.setText("Média:");

        bLeitura.setText("Fazer Leitura de Dados");
        bLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLeituraActionPerformed(evt);
            }
        });

        lbResultadoDisco.setText("....");

        lbResultadoMemoria.setText("....");

        jLabel1.setText("CPU");

        lbMemoriaMedia.setText("Média:");

        jLabel2.setText("Disco");

        lbResultadoCPU.setText("....");

        lbRedeMedia.setText("Média:");

        jLabel4.setText("Rede Upload");

        lbRedeMin.setText("Minimo:");

        lbRedeMax.setText("Maximo:");

        lbResultadoRede.setText("....");

        jButton1.setText("Logoff");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCPUMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbCPUMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbCPUMax, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbDiscoMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbDiscoMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbDiscoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)))
                            .addComponent(bLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMemoriaMin, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(lbMemoriaMax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMemoriaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbRedeMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRedeMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbRedeMax, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbResultadoRede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pbRede, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pbCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pbDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbResultadoDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbResultadoMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pbMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                    .addComponent(lbResultadoCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbRedeMin)
                        .addGap(36, 36, 36)
                        .addComponent(lbRedeMax)
                        .addGap(29, 29, 29)
                        .addComponent(lbRedeMedia))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbResultadoCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lbResultadoDisco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbResultadoMemoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbResultadoRede)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbRede, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(bLeitura)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCPUMin)
                            .addComponent(lbDiscoMin)
                            .addComponent(lbMemoriaMin))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCPUMax)
                            .addComponent(lbDiscoMax)
                            .addComponent(lbMemoriaMax))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbCPUMedia)
                            .addComponent(lbDiscoMedia)
                            .addComponent(lbMemoriaMedia))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Integer contador = 0;
    
    Double CPUMin = 0.0;
    Double CPUMax = 0.0;
    Double CPUMedia = 0.0;
    
    Double DiscoMin = 0.0;
    Double DiscoMax = 0.0;
    Double DiscoMedia = 0.0;
    
    Double MemoriaMin = 0.0;
    Double MemoriaMax = 0.0;
    Double MemoriaMedia = 0.0;
    
    Double RedeMin = 0.0;
    Double RedeMax = 0.0;
    Double RedeMedia = 0.0;
    private void bLeituraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLeituraActionPerformed
        //    Configurando os valores maximo e minimos
        pbCPU.setMinimum(0);
        pbCPU.setMaximum(2400);
        pbDisco.setMinimum(0);
        pbDisco.setMaximum(186000);
        pbMemoria.setMinimum(0);
        pbMemoria.setMaximum(8000);
        pbRede.setMinimum(0);
        pbRede.setMaximum(1000);

        //    Gerando numeros aleatorios
        Integer numCPU = ThreadLocalRandom.current().nextInt(0, 2400);
        Integer numDisco = ThreadLocalRandom.current().nextInt(0,186000);
        Integer numMemoria = ThreadLocalRandom.current().nextInt(0,8000);
        Integer numRede = ThreadLocalRandom.current().nextInt(0,1000);

        //    Convertendo os valores INTEGER dos numeros aleatoris para DOUBLE
        Double numCPU2 = Double.valueOf(numCPU);
        Double numDisco2 = Double.valueOf(numDisco);
        Double numMemoria2 = Double.valueOf(numMemoria);
        Double numRede2 = Double.valueOf(numRede);

        //     Colocando os valores gerados nas respectivas barras
        pbCPU.setValue(numCPU);
        pbDisco.setValue(numDisco);
        pbMemoria.setValue(numMemoria);
        pbRede.setValue(numRede);

        //     Formula para pegar a porcentagem equivalente do respectivo numero gerado
        Double porcentagemCPU = numCPU2 / 2400 * 100;
        Double porcentagemDisco = numDisco2 / 186000 * 100;
        Double porcentagemMemoria = numMemoria2 / 8000 * 100;
        Double porcentagemRede = numRede2 / 1000 * 100;

        //     Formula p/ conversão de MHz pra GHz e MB pra GB
        Double numCPU3 = numCPU2 / 1000;
        Double numMemoria3 = numMemoria2 /1000;
        Double numDisco3 = numDisco2 / 1000;
        Double numRede3 = numRede2 / 10;

        //     Inserindo texto nas label acima das barras
        String textoCPU = String.format("CPU - %.2fGHz ", numCPU3);
        lbResultadoCPU.setText(textoCPU);

        String textoDisco = String.format("Disco - %.1fGB ", numDisco3);
        lbResultadoDisco.setText(textoDisco);

        String textoMemoria = String.format("Memoria Ram - %.1fGB", numMemoria3);
        lbResultadoMemoria.setText(textoMemoria);
        
        String textoRede = String.format("Rede Upload - %.1fMB", numRede3);
        lbResultadoRede.setText(textoRede);

        //     Permitindo configurar a barra
        //     Inserindo o valor da porcentagem dentro da barra
        pbCPU.setStringPainted(true);
        String textoCPU2 = String.format("%.0f",porcentagemCPU);
        pbCPU.setString(textoCPU2+"%");

        pbDisco.setStringPainted(true);
        String textoDisco2 = String.format("%.0f",porcentagemDisco);
        pbDisco.setString(textoDisco2+"%");

        pbMemoria.setStringPainted(true);
        String textoMemoria2 = String.format("%.0f", porcentagemMemoria);
        pbMemoria.setString(textoMemoria2+"%");
        
        pbRede.setStringPainted(true);
        String textoRede2 = String.format("%.2f", porcentagemRede);
        pbRede.setString(textoRede2+"%");

        //     Contador de qtd de vzs q o botao foi clicado
        contador++;

        //     Formula da média
        CPUMedia = CPUMedia + numCPU3;
        Double CPUMedia2 = CPUMedia / contador;
        String CPUMediaTxt = String.format("%.2fGHz", CPUMedia2);
        lbCPUMedia.setText("Média: "+CPUMediaTxt);

        DiscoMedia = DiscoMedia + numDisco3;
        Double DiscoMedia2 = DiscoMedia / contador;
        String DiscoMediaTxt = String.format("%.2fGB", DiscoMedia2);
        lbDiscoMedia.setText("Média: "+DiscoMediaTxt);

        MemoriaMedia = MemoriaMedia + numMemoria3;
        Double MemoriaMedia2 = MemoriaMedia / contador;
        String MemoriaMediaTxt = String.format("%.2fGB", MemoriaMedia2);
        lbMemoriaMedia.setText("Média: "+MemoriaMediaTxt);
        
        RedeMedia = RedeMedia + numRede3;
        Double RedeMedia2 = RedeMedia / contador;
        String RedeMediaTxt = String.format("%.2fMB", RedeMedia2);
        lbRedeMedia.setText("Média: "+RedeMediaTxt);

        //     Capturando valores minimos e maximos
        if (numCPU3 < CPUMin || CPUMin == 0){
            CPUMin = numCPU3;
            lbCPUMin.setText("Minimo: "+String.format("%.2fGHz",CPUMin));
        }
        if (numCPU3 > CPUMax){
            CPUMax = numCPU3;
            lbCPUMax.setText("Maximo: "+String.format("%.2fGHz", CPUMax));
        }

        if (numDisco3 < DiscoMin || DiscoMin == 0){
            DiscoMin = numDisco3;
            lbDiscoMin.setText("Minimo: "+String.format("%.2fGB", DiscoMin));
        }
        if (numDisco3 > DiscoMax){
            DiscoMax = numDisco3;
            lbDiscoMax.setText("Maximo: "+String.format("%.2fGB",DiscoMax));
        }

        if (numMemoria3 < MemoriaMin || MemoriaMin == 0 ){
            MemoriaMin = numMemoria3;
            lbMemoriaMin.setText("Minimo: "+String.format("%.2fGB", MemoriaMin));

        }
        if (numMemoria3 > MemoriaMax){
            MemoriaMax = numMemoria3;
            lbMemoriaMax.setText("Maximo: "+String.format("%.2fGB", MemoriaMax));
        }
        
        if (numRede3 < RedeMin || RedeMin == 0 ){
            RedeMin = numRede3;
            lbRedeMin.setText("Minimo: "+String.format("%.2fMB", RedeMin));

        }
        if (numRede3 > RedeMax){
            RedeMax = numRede3;
            lbRedeMax.setText("Maximo: "+String.format("%.2fMB", RedeMax));
        }
    }//GEN-LAST:event_bLeituraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login loginzao=new Login();
        loginzao.show();
        dispose();
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
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bLeitura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbCPUMax;
    private javax.swing.JLabel lbCPUMedia;
    private javax.swing.JLabel lbCPUMin;
    private javax.swing.JLabel lbDiscoMax;
    private javax.swing.JLabel lbDiscoMedia;
    private javax.swing.JLabel lbDiscoMin;
    private javax.swing.JLabel lbMemoriaMax;
    private javax.swing.JLabel lbMemoriaMedia;
    private javax.swing.JLabel lbMemoriaMin;
    private javax.swing.JLabel lbRedeMax;
    private javax.swing.JLabel lbRedeMedia;
    private javax.swing.JLabel lbRedeMin;
    private javax.swing.JLabel lbResultadoCPU;
    private javax.swing.JLabel lbResultadoDisco;
    private javax.swing.JLabel lbResultadoMemoria;
    private javax.swing.JLabel lbResultadoRede;
    private javax.swing.JProgressBar pbCPU;
    private javax.swing.JProgressBar pbDisco;
    private javax.swing.JProgressBar pbMemoria;
    private javax.swing.JProgressBar pbRede;
    // End of variables declaration//GEN-END:variables
}
