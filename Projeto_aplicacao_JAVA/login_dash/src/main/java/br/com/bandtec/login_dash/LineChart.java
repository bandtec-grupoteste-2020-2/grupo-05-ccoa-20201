package br.com.bandtec.login_dash;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JFrame{    
   
DefaultCategoryDataset dataset;
  
  public LineChart(JPanel panel, String title, String xAxisLabel, String yAxisLabel) {  
    
    // Create dataset  
    dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(
        title, // Chart title  
        xAxisLabel, // X-Axis Label  
        yAxisLabel, // Y-Axis Label  
        dataset  // dataset 
        );  
    chart.getPlot().setBackgroundPaint(Color.WHITE);
  
    ChartPanel chartPanel = new ChartPanel(chart);  
    chartPanel.setBackground(Color.red);
//    setContentPane(panel); 
        // Chart size
        chartPanel.setSize(panel.getWidth(), panel.getHeight());
        chartPanel.setVisible(true);
        
        panel.removeAll();
        panel.add(chartPanel);
        panel.revalidate();
        panel.repaint();

  }  
  
  public void inserir(Double valor, String nomeComponente, Integer idLeitura){
      dataset.addValue(valor,nomeComponente,idLeitura);  
  }
 
  public DefaultCategoryDataset createDataset() {  
  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
 
    return dataset;  
  }  
  
// public static void main(String[] args) {  
//    SwingUtilities.invokeLater(() -> {  
//      LineChartExample example = new LineChartExample("Line Chart Example");  
//      example.setAlwaysOnTop(true);  
//      example.pack();  
//      example.setSize(600, 400);  
////      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//      example.setVisible(true);
//    });  
//  }  
}  

