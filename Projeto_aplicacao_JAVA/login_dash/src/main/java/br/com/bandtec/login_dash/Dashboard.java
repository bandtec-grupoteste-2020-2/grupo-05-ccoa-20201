package br.com.bandtec.login_dash;

//import org.jfree.chart.ChartFactory;

import java.awt.Color;

//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
import java.util.List;
import javafx.scene.control.RadioButton;
import javax.swing.JRadioButton;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Dashboard extends javax.swing.JFrame {
    JdbcTemplate jdbcTemplate1;
    Funcoes funcao=new Funcoes();
    String cpuExportacao;
       
    
    LineChart lineChartCpu;        
    LineChart lineChartDisco;
    LineChart lineChartMemoria;
    
    void rbSelecionado(JRadioButton escolhido){
        rbClock.setSelected(false);
        rbTemperatura.setSelected(false);
        rbUso.setSelected(false);
        /**--------------------*/
        escolhido.setSelected(true);
        String selecionado=escolhido.getText();
        pegaComp(selecionado);
        System.out.println(selecionado);
    }
    
    void pegaComp(String selecionado){
        zerarLine();
        funcao.pegarComponente(jdbcTemplate1,lineChartCpu,lineChartDisco,lineChartMemoria,selecionado);
    }
    
    void zerarLine(){
        lineChartCpu= new LineChart(jPanelCPU, "CPU", "Eixo X", "Eixo Y"); 
    }
    
    public Dashboard(JdbcTemplate jdbcTemplate) {
        initComponents();
        jdbcTemplate1=jdbcTemplate;
        
        lineChartCpu= new LineChart(jPanelCPU, "CPU", "Eixo X", "Eixo Y");        
        lineChartDisco = new LineChart(jPanelDisco, "Disco", "Eixo X", "Eixo Y");
        lineChartMemoria = new LineChart(jPanelMemoria, "Memoria", "Eixo X", "Eixo Y");
        
        funcao.pegarComponente(jdbcTemplate1,lineChartCpu,lineChartDisco,lineChartMemoria,"nada");        
    }

    private Dashboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanelCpuLoad = new javax.swing.JPanel();
        jPanelCPU = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rbUso = new javax.swing.JRadioButton();
        rbTemperatura = new javax.swing.JRadioButton();
        rbClock = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jPanelMemoryLoad = new javax.swing.JPanel();
        jPanelMemoria = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelDiskLoad = new javax.swing.JPanel();
        jPanelDisco = new javax.swing.JPanel();

        jLabel1.setText("cpu");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monitoramento de Hardware - Six Minds");
        setBackground(new java.awt.Color(34, 53, 104));
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 900));

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 650));

        jPanelCpuLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelCpuLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelCPULayout = new javax.swing.GroupLayout(jPanelCPU);
        jPanelCPU.setLayout(jPanelCPULayout);
        jPanelCPULayout.setHorizontalGroup(
            jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        jPanelCPULayout.setVerticalGroup(
            jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelCpuLoadLayout = new javax.swing.GroupLayout(jPanelCpuLoad);
        jPanelCpuLoad.setLayout(jPanelCpuLoadLayout);
        jPanelCpuLoadLayout.setHorizontalGroup(
            jPanelCpuLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCpuLoadLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanelCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelCpuLoadLayout.setVerticalGroup(
            jPanelCpuLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCpuLoadLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanelCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("coisa ");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 45));

        rbUso.setText("CPU_uso(%)");
        rbUso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsoActionPerformed(evt);
            }
        });

        rbTemperatura.setText("Temperatura");
        rbTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTemperaturaActionPerformed(evt);
            }
        });

        rbClock.setText("Clock");
        rbClock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbClockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbTemperatura, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbUso, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbClock, javax.swing.GroupLayout.Alignment.LEADING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbUso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbTemperatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbClock)
                .addGap(109, 109, 109))
        );

        jTabbedPane1.addTab("CPU", jPanel2);

        jPanelMemoryLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelMemoryLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelMemoriaLayout = new javax.swing.GroupLayout(jPanelMemoria);
        jPanelMemoria.setLayout(jPanelMemoriaLayout);
        jPanelMemoriaLayout.setHorizontalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        jPanelMemoriaLayout.setVerticalGroup(
            jPanelMemoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelMemoryLoadLayout = new javax.swing.GroupLayout(jPanelMemoryLoad);
        jPanelMemoryLoad.setLayout(jPanelMemoryLoadLayout);
        jPanelMemoryLoadLayout.setHorizontalGroup(
            jPanelMemoryLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMemoryLoadLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelMemoryLoadLayout.setVerticalGroup(
            jPanelMemoryLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMemoryLoadLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 287, Short.MAX_VALUE)
                .addComponent(jPanelMemoryLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMemoryLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Memória", jPanel3);

        jPanelDiskLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelDiskLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelDiscoLayout = new javax.swing.GroupLayout(jPanelDisco);
        jPanelDisco.setLayout(jPanelDiscoLayout);
        jPanelDiscoLayout.setHorizontalGroup(
            jPanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        jPanelDiscoLayout.setVerticalGroup(
            jPanelDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelDiskLoadLayout = new javax.swing.GroupLayout(jPanelDiskLoad);
        jPanelDiskLoad.setLayout(jPanelDiskLoadLayout);
        jPanelDiskLoadLayout.setHorizontalGroup(
            jPanelDiskLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiskLoadLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanelDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanelDiskLoadLayout.setVerticalGroup(
            jPanelDiskLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiskLoadLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanelDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 287, Short.MAX_VALUE)
                .addComponent(jPanelDiskLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDiskLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Disco", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsoActionPerformed
        rbSelecionado(rbUso);
    }//GEN-LAST:event_rbUsoActionPerformed

    private void rbTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTemperaturaActionPerformed
        rbSelecionado(rbTemperatura);
    }//GEN-LAST:event_rbTemperaturaActionPerformed

    private void rbClockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbClockActionPerformed
        rbSelecionado(rbClock);
    }//GEN-LAST:event_rbClockActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {;
    

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);          
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCPU;
    private javax.swing.JPanel jPanelCpuLoad;
    private javax.swing.JPanel jPanelDisco;
    private javax.swing.JPanel jPanelDiskLoad;
    private javax.swing.JPanel jPanelMemoria;
    private javax.swing.JPanel jPanelMemoryLoad;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbClock;
    private javax.swing.JRadioButton rbTemperatura;
    private javax.swing.JRadioButton rbUso;
    // End of variables declaration//GEN-END:variables
}
