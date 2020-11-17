package br.com.sixminds.client.java.sixminds.dashboard;

import br.com.sixminds.client.java.sixminds.clientjira.ClienteJiraApi;
import br.com.sixminds.client.java.sixminds.clientjira.modelos.Issue;
import br.com.sixminds.client.java.sixminds.graficos.LineChart;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    String selecionado1="nada";
    
    //TIMERZAO
    Timer timer=new Timer();
    TimerTask tarefa=new TimerTask() {
        @Override
        public void run() {
            pegaComp(selecionado1);
        }
    };
    
    
    void rbSelecionado(JRadioButton escolhido){
        rbClock.setSelected(false);
        rbTemperatura.setSelected(false);
        rbUso.setSelected(false);
        /**--------------------*/
        escolhido.setSelected(true);
        String selecionado=escolhido.getText();
        selecionado1=selecionado;
        pegaComp(selecionado);
    }
    
    void pegaComp(String selecionado){
        zerarLine();
        funcao.pegarComponente(jdbcTemplate1,lineChartCpu,lineChartDisco,lineChartMemoria,selecionado1);
    }
    
   
    
    void zerarLine(){
        System.out.println("ZERADO");
        lineChartCpu= new LineChart(jPanelCPU, "CPU", "Eixo X", "Eixo Y");         
    }
    
    public Dashboard(JdbcTemplate jdbcTemplate) {
        timer.scheduleAtFixedRate(tarefa, 5000, 5000);
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
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanelDiskLoad = new javax.swing.JPanel();
        jPanelDisco = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tfSummaryJira = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescriptionJira = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tfLabelsJira = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btAbrirChamado = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();

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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CPU");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 45));

        rbUso.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        rbUso.setText("CPU_uso(%)");
        rbUso.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rbUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsoActionPerformed(evt);
            }
        });

        rbTemperatura.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        rbTemperatura.setText("Temperatura");
        rbTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTemperaturaActionPerformed(evt);
            }
        });

        rbClock.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
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
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTemperatura)
                    .addComponent(rbUso)
                    .addComponent(rbClock)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MEMÓRIA");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanelMemoryLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMemoryLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("DISCO");
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 45));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addComponent(jPanelDiskLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelDiskLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disco", jPanel4);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 200), 1, true));

        tfSummaryJira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSummaryJiraActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Assunto:");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Descrição:");

        tfDescriptionJira.setColumns(20);
        tfDescriptionJira.setRows(5);
        jScrollPane1.setViewportView(tfDescriptionJira);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Categorias:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Abertura de Chamados");

        btAbrirChamado.setText("Enviar");
        btAbrirChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirChamadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSummaryJira))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(tfLabelsJira))))
                        .addGap(52, 52, 52))
                    .addComponent(btAbrirChamado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tfSummaryJira, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfLabelsJira, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btAbrirChamado)
                .addGap(28, 28, 28))
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 200), 1, true));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lendo Chamados");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(514, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Jira Help Desk", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
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

    private void tfSummaryJiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSummaryJiraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSummaryJiraActionPerformed

    private void btAbrirChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirChamadoActionPerformed
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ClienteJiraApi clienteJiraApi = new ClienteJiraApi(
                "sixminds.atlassian.net",
                "carlos.santana@bandtec.com.br",
                "dGYq8LbV5ElKaOqSdjLR39AF"
        );

//        Issue issue = clienteJiraApi.getIssue("PSM-14");
//        System.out.println("Issue recuperada: "+gson.toJson(issue));;

//         Exemplo de objeto para novo chamado (Issue)
        
        Issue novaIssue = new Issue();
        novaIssue.setProjectKey("PSM");
        novaIssue.setSummary(tfSummaryJira.getText());
        novaIssue.setDescription(tfDescriptionJira.getText());
        novaIssue.setLabels(tfLabelsJira.getText());

        try {
            clienteJiraApi.criarIssue(novaIssue);
            System.out.println("Issue criada: "+gson.toJson(novaIssue));
            tfSummaryJira.setText("");
            tfDescriptionJira.setText("");
            tfLabelsJira.setText("");
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
    }//GEN-LAST:event_btAbrirChamadoActionPerformed

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
    private javax.swing.JButton btAbrirChamado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelCPU;
    private javax.swing.JPanel jPanelCpuLoad;
    private javax.swing.JPanel jPanelDisco;
    private javax.swing.JPanel jPanelDiskLoad;
    private javax.swing.JPanel jPanelMemoria;
    private javax.swing.JPanel jPanelMemoryLoad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rbClock;
    private javax.swing.JRadioButton rbTemperatura;
    private javax.swing.JRadioButton rbUso;
    private javax.swing.JTextArea tfDescriptionJira;
    private javax.swing.JTextField tfLabelsJira;
    private javax.swing.JTextField tfSummaryJira;
    // End of variables declaration//GEN-END:variables
}
