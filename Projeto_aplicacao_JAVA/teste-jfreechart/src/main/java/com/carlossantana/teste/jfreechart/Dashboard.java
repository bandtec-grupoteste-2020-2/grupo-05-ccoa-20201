package com.carlossantana.teste.jfreechart;

//import org.jfree.chart.ChartFactory;

import java.awt.Color;

//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;

public class Dashboard extends javax.swing.JFrame {

//    private CategoryDataset createDataset() {
//
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        
////        String set1 = ("Conjunto 1");
//
//        dataset.addValue(1000.0,"01/2012","Mês/Ano");
//
//        dataset.addValue(1750.0,"02/2012","Mês/Ano");
//
//        dataset.addValue(1500.0,"03/2012","Mês/Ano");
//
//        return dataset;
//
//    };
//    
//    public void criaGrafico() {
//
//        CategoryDataset cds = createDataset();
//
//        String titulo = "Gráfico de Teste";
//
//        String eixoy = "Valores";
//
//        String txt_legenda = "Ledenda:";
//
//        boolean legenda = true;
//
//        boolean tooltips = true;
//
//        boolean urls = true;
//
//        JFreeChart graf = ChartFactory.createBarChart(
//                titulo,
//                txt_legenda,
//                eixoy,
//                cds,
//                PlotOrientation.VERTICAL,
//                legenda,
//                tooltips,
//                urls);
//        
//        
        
        
//
//        ChartPanel myChartPanel2 = new ChartPanel(graf, true);
//
//        myChartPanel2.setSize(jPanel2.getWidth(),jPanel2.getHeight());
//
//        myChartPanel2.setVisible(true);
//
//        jPanel2.removeAll();
//
//        jPanel2.add(myChartPanel2);
//
//        jPanel2.revalidate();
//
//        jPanel2.repaint();
//        
//        ChartPanel myChartPanel3 = new ChartPanel(graf, true);
//
//        
//        myChartPanel3.setSize(jPanel3.getWidth(),jPanel3.getHeight());
//
//        myChartPanel3.setVisible(true);
//
//        jPanel3.removeAll();
//
//        jPanel3.add(myChartPanel3);
//
//        jPanel3.revalidate();
//
//        jPanel3.repaint();
//        
//        ChartPanel myChartPanel4 = new ChartPanel(graf, true);
//
//        
//        myChartPanel4.setSize(jPanel4.getWidth(),jPanel4.getHeight());
//
//        myChartPanel4.setVisible(true);
//
//        jPanel4.removeAll();
//
//        jPanel4.add(myChartPanel4);
//
//        jPanel4.revalidate();
//
//        jPanel4.repaint();
//        
//        ChartPanel myChartPanel5 = new ChartPanel(graf, true);
//
//                
//        myChartPanel5.setSize(jPanel5.getWidth(),jPanel5.getHeight());
//
//        myChartPanel5.setVisible(true);
//
//        jPanel5.removeAll();
//
//        jPanel5.add(myChartPanel5);
//
//        jPanel5.revalidate();
//
//        jPanel5.repaint();
//        
//        

//    }
    
    public Dashboard() {
        initComponents();
        
        LineChart lineChartCpu = new LineChart(jPanelCpuLoad, "CPU", "Eixo X", "Eixo Y");
        LineChart lineChartMemory = new LineChart(jPanelMemoryLoad, "Memória", "Eixo X", "Eixo Y");
        LineChart lineChartNetwork = new LineChart(jPanelNetwork, "Rede", "Eixo X", "Eixo Y");        
        AreaChart areaChartDisk = new AreaChart(jPanelDiskLoad, "Disco", "Eixo X", "Eixo Y");                                
        
        
        LineChart lineChartCpuGeneral = new LineChart(jPanelCpuGeneral, "CPU","Eixo X","Eixo Y");
        LineChart lineChartMemoryGeneral = new LineChart(jPanelMemoryGeneral, "Memória", "Eixo X", "Eixo Y");
        LineChart lineChartNetworkGeneral = new LineChart(jPanelNetworkGeneral, "Rede", "Eixo X", "Eixo Y");        
        AreaChart areaChartDiskGeneral = new AreaChart(jPanelDiskGeneral, "Disco", "Eixo X", "Eixo Y"); 
        
        
        BarChart barChart = new BarChart(jPanel6, "Título", "Eixo X", "Eixo Y");

//        jPanel1.setBackground(Color.YELLOW);
             
//        LineChartExample lineChartMemory = new LineChartExample(jPanel3);        
//        LineChartExample lineChartDisk = new LineChartExample(jPanel4);        
//        LineChartExample lineChartNetwork = new LineChartExample(jPanel5);        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanelMemoryGeneral = new javax.swing.JPanel();
        jPanelCpuGeneral = new javax.swing.JPanel();
        jPanelDiskGeneral = new javax.swing.JPanel();
        jPanelNetworkGeneral = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelCpuLoad = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanelMemoryLoad = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanelDiskLoad = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanelNetwork = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setText("cpu");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monitoramento de Hardware - Six Minds");
        setBackground(new java.awt.Color(34, 53, 104));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(900, 900));

        jPanel8.setPreferredSize(new java.awt.Dimension(950, 550));

        jPanelMemoryGeneral.setBackground(new java.awt.Color(45, 200, 200));
        jPanelMemoryGeneral.setPreferredSize(new java.awt.Dimension(475, 275));

        javax.swing.GroupLayout jPanelMemoryGeneralLayout = new javax.swing.GroupLayout(jPanelMemoryGeneral);
        jPanelMemoryGeneral.setLayout(jPanelMemoryGeneralLayout);
        jPanelMemoryGeneralLayout.setHorizontalGroup(
            jPanelMemoryGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanelMemoryGeneralLayout.setVerticalGroup(
            jPanelMemoryGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelCpuGeneral.setBackground(new java.awt.Color(200, 200, 46));
        jPanelCpuGeneral.setPreferredSize(new java.awt.Dimension(475, 275));

        javax.swing.GroupLayout jPanelCpuGeneralLayout = new javax.swing.GroupLayout(jPanelCpuGeneral);
        jPanelCpuGeneral.setLayout(jPanelCpuGeneralLayout);
        jPanelCpuGeneralLayout.setHorizontalGroup(
            jPanelCpuGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanelCpuGeneralLayout.setVerticalGroup(
            jPanelCpuGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jPanelDiskGeneral.setBackground(new java.awt.Color(200, 45, 200));
        jPanelDiskGeneral.setPreferredSize(new java.awt.Dimension(475, 275));

        javax.swing.GroupLayout jPanelDiskGeneralLayout = new javax.swing.GroupLayout(jPanelDiskGeneral);
        jPanelDiskGeneral.setLayout(jPanelDiskGeneralLayout);
        jPanelDiskGeneralLayout.setHorizontalGroup(
            jPanelDiskGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanelDiskGeneralLayout.setVerticalGroup(
            jPanelDiskGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanelNetworkGeneral.setBackground(new java.awt.Color(200, 200, 200));
        jPanelNetworkGeneral.setPreferredSize(new java.awt.Dimension(475, 275));

        javax.swing.GroupLayout jPanelNetworkGeneralLayout = new javax.swing.GroupLayout(jPanelNetworkGeneral);
        jPanelNetworkGeneral.setLayout(jPanelNetworkGeneralLayout);
        jPanelNetworkGeneralLayout.setHorizontalGroup(
            jPanelNetworkGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 475, Short.MAX_VALUE)
        );
        jPanelNetworkGeneralLayout.setVerticalGroup(
            jPanelNetworkGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanelCpuGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanelMemoryGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanelDiskGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelNetworkGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelCpuGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelMemoryGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelNetworkGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(jPanelDiskGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Geral", jPanel8);

        jPanel2.setPreferredSize(new java.awt.Dimension(900, 650));

        jPanelCpuLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelCpuLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelCpuLoadLayout = new javax.swing.GroupLayout(jPanelCpuLoad);
        jPanelCpuLoad.setLayout(jPanelCpuLoadLayout);
        jPanelCpuLoadLayout.setHorizontalGroup(
            jPanelCpuLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanelCpuLoadLayout.setVerticalGroup(
            jPanelCpuLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("coisa ");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 45));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCpuLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );

        jTabbedPane1.addTab("CPU", jPanel2);

        jPanelMemoryLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelMemoryLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelMemoryLoadLayout = new javax.swing.GroupLayout(jPanelMemoryLoad);
        jPanelMemoryLoad.setLayout(jPanelMemoryLoadLayout);
        jPanelMemoryLoadLayout.setHorizontalGroup(
            jPanelMemoryLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanelMemoryLoadLayout.setVerticalGroup(
            jPanelMemoryLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addComponent(jPanelMemoryLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Memória", jPanel3);

        jPanelDiskLoad.setBackground(new java.awt.Color(100, 100, 100));
        jPanelDiskLoad.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelDiskLoadLayout = new javax.swing.GroupLayout(jPanelDiskLoad);
        jPanelDiskLoad.setLayout(jPanelDiskLoadLayout);
        jPanelDiskLoadLayout.setHorizontalGroup(
            jPanelDiskLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanelDiskLoadLayout.setVerticalGroup(
            jPanelDiskLoadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addComponent(jPanelDiskLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Disco", jPanel4);

        jPanelNetwork.setBackground(new java.awt.Color(100, 100, 100));
        jPanelNetwork.setPreferredSize(new java.awt.Dimension(675, 650));

        javax.swing.GroupLayout jPanelNetworkLayout = new javax.swing.GroupLayout(jPanelNetwork);
        jPanelNetwork.setLayout(jPanelNetworkLayout);
        jPanelNetworkLayout.setHorizontalGroup(
            jPanelNetworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );
        jPanelNetworkLayout.setVerticalGroup(
            jPanelNetworkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 287, Short.MAX_VALUE)
                .addComponent(jPanelNetwork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNetwork, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Rede", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 962, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("teste", jPanel6);

        jPanel1.setPreferredSize(new java.awt.Dimension(956, 300));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Selecionar Componente Aqui !!!");
        jLabel5.setPreferredSize(new java.awt.Dimension(932, 25));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(556, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configurações", jPanel1);

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

    /**
     * @param args the command line arguments
     */
    
//    public static void main(String args[]) {
//    
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);          
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelCpuGeneral;
    private javax.swing.JPanel jPanelCpuLoad;
    private javax.swing.JPanel jPanelDiskGeneral;
    private javax.swing.JPanel jPanelDiskLoad;
    private javax.swing.JPanel jPanelMemoryGeneral;
    private javax.swing.JPanel jPanelMemoryLoad;
    private javax.swing.JPanel jPanelNetwork;
    private javax.swing.JPanel jPanelNetworkGeneral;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
