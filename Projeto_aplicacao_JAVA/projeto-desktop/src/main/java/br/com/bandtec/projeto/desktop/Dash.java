package br.com.bandtec.projeto.desktop;

import java.util.concurrent.ThreadLocalRandom;

public class Dash extends javax.swing.JFrame {

    public Dash() {
        initComponents();
        // Faz o JFrame abri no centro da tela do computador
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbResultadoCPU = new javax.swing.JLabel();
        pbCPU = new javax.swing.JProgressBar();
        lbResultadoDisco = new javax.swing.JLabel();
        pbDisco = new javax.swing.JProgressBar();
        lbResultadoMemoria = new javax.swing.JLabel();
        pbMemoria = new javax.swing.JProgressBar();
        lbResultadoRede = new javax.swing.JLabel();
        pbRede = new javax.swing.JProgressBar();
        bLeitura = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbCPUMin = new javax.swing.JLabel();
        lbCPUMax = new javax.swing.JLabel();
        lbCPUMedia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbDiscoMin = new javax.swing.JLabel();
        lbDiscoMax = new javax.swing.JLabel();
        lbDiscoMedia = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMemoriaMin = new javax.swing.JLabel();
        lbMemoriaMax = new javax.swing.JLabel();
        lbMemoriaMedia = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbRedeMin = new javax.swing.JLabel();
        lbRedeMax = new javax.swing.JLabel();
        lbRedeMedia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        lbResultadoCPU.setText("CPU - ");

        lbResultadoDisco.setText("Disco - ");

        lbResultadoMemoria.setText("Memória Ram - ");

        lbResultadoRede.setText("Rede Upload - ");

        bLeitura.setText("Realizar Leitura");
        bLeitura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLeituraActionPerformed(evt);
            }
        });

        jButton1.setText("Logoff");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("CPU");

        lbCPUMin.setText("Mínimo:");

        lbCPUMax.setText("Máximo:");

        lbCPUMedia.setText("Média:");

        jLabel9.setText("Disco");

        lbDiscoMin.setText("Mínimo:");

        lbDiscoMax.setText("Máximo:");

        lbDiscoMedia.setText("Média:");

        jLabel13.setText("Memória Ram");

        lbMemoriaMin.setText("Mínimo:");

        lbMemoriaMax.setText("Máximo:");

        lbMemoriaMedia.setText("Média:");

        jLabel17.setText("Rede Upload");

        lbRedeMin.setText("Mínimo:");

        lbRedeMax.setText("Máximo:");

        lbRedeMedia.setText("Média:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResultadoRede, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResultadoMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResultadoDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbResultadoCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbCPUMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCPUMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCPUMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDiscoMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDiscoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDiscoMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbMemoriaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMemoriaMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbMemoriaMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbRedeMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbRedeMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbRedeMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel17)))
                        .addComponent(pbRede, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbDiscoMin)
                        .addGap(29, 29, 29)
                        .addComponent(lbDiscoMax)
                        .addGap(29, 29, 29)
                        .addComponent(lbDiscoMedia))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(1, 1, 1)
                        .addComponent(lbResultadoCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbResultadoDisco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbResultadoMemoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbResultadoRede)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbRede, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bLeitura)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbCPUMin)
                                .addGap(29, 29, 29)
                                .addComponent(lbCPUMax)
                                .addGap(29, 29, 29)
                                .addComponent(lbCPUMedia))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbRedeMin)
                                .addGap(29, 29, 29)
                                .addComponent(lbRedeMax)
                                .addGap(29, 29, 29)
                                .addComponent(lbRedeMedia))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbMemoriaMin)
                        .addGap(29, 29, 29)
                        .addComponent(lbMemoriaMax)
                        .addGap(29, 29, 29)
                        .addComponent(lbMemoriaMedia)))
                .addContainerGap(74, Short.MAX_VALUE))
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
        String textoCPU2 = String.format("%.2f",porcentagemCPU);
        pbCPU.setString(textoCPU2+"%");

        pbDisco.setStringPainted(true);
        String textoDisco2 = String.format("%.2f",porcentagemDisco);
        pbDisco.setString(textoDisco2+"%");

        pbMemoria.setStringPainted(true);
        String textoMemoria2 = String.format("%.2f", porcentagemMemoria);
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
        
        Login loginzao = new Login();
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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
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
