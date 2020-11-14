package com.carlossantana.teste.jfreechart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class principal extends javax.swing.JFrame {

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String set1 = ("Conjunto 1");

        dataset.addValue(1000.0,"01/2012","Mês/Ano");

        dataset.addValue(1750.0,"02/2012","Mês/Ano");

        dataset.addValue(1500.0,"03/2012","Mês/Ano");

        return dataset;

    }
    
    public void criaGrafico() {

        CategoryDataset cds = createDataset();

        String titulo = "Gráfico de Teste";

        String eixoy = "Valores";

        String txt_legenda = "Ledenda:";

        boolean legenda = true;

        boolean tooltips = true;

        boolean urls = true;

        JFreeChart graf = ChartFactory.createBarChart(
                titulo,
                txt_legenda,
                eixoy,
                cds,
                PlotOrientation.VERTICAL,
                legenda,
                tooltips,
                urls);
        
        
        
        

        ChartPanel myChartPanel2 = new ChartPanel(graf, true);

        myChartPanel2.setSize(jPanel2.getWidth(),jPanel2.getHeight());

        myChartPanel2.setVisible(true);

        jPanel2.removeAll();

        jPanel2.add(myChartPanel2);

        jPanel2.revalidate();

        jPanel2.repaint();
        
        ChartPanel myChartPanel3 = new ChartPanel(graf, true);

        
        myChartPanel3.setSize(jPanel3.getWidth(),jPanel3.getHeight());

        myChartPanel3.setVisible(true);

        jPanel3.removeAll();

        jPanel3.add(myChartPanel3);

        jPanel3.revalidate();

        jPanel3.repaint();
        
        ChartPanel myChartPanel4 = new ChartPanel(graf, true);

        
        myChartPanel4.setSize(jPanel4.getWidth(),jPanel4.getHeight());

        myChartPanel4.setVisible(true);

        jPanel4.removeAll();

        jPanel4.add(myChartPanel4);

        jPanel4.revalidate();

        jPanel4.repaint();
        
        ChartPanel myChartPanel5 = new ChartPanel(graf, true);

                
        myChartPanel5.setSize(jPanel5.getWidth(),jPanel5.getHeight());

        myChartPanel5.setVisible(true);

        jPanel5.removeAll();

        jPanel5.add(myChartPanel5);

        jPanel5.revalidate();

        jPanel5.repaint();
        
        

    }
    
    public principal() {
        initComponents();
        LineChartExample lineChart = new LineChartExample(jPanel6);
        lineChart.setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("cpu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CPU", jPanel2);

        jLabel4.setText("memória");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel4)
                .addContainerGap(173, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Memória", jPanel3);

        jLabel3.setText("disco");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel3)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Disco", jPanel4);

        jLabel2.setText("rede");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel2)
                .addContainerGap(177, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Rede", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("teste", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
