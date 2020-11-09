package com.carlossantana.teste.jfreechart;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JFrame{    
   
//  private static final long serialVersionUID = 1L;  
  
  public LineChart(JPanel panel, String title, String xAxisLabel, String yAxisLabel) {  
    
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
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
 
  private DefaultCategoryDataset createDataset() {  
  
    String series1 = "Visitor";  
    String series2 = "Unique Visitor";  
    String series3 = "Teste";  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
           
    // 
    dataset.addValue(200, series1, "2016-12-19");  
    dataset.addValue(150, series1, "2016-12-20");  
    dataset.addValue(100, series1, "2016-12-21");  
    dataset.addValue(210, series1, "2016-12-22");  
    dataset.addValue(240, series1, "2016-12-23");  
    dataset.addValue(195, series1, "2016-12-24");  
    dataset.addValue(245, series1, "2016-12-25");  
  
    dataset.addValue(150, series2, "2016-12-19");  
    dataset.addValue(130, series2, "2016-12-20");  
    dataset.addValue(95, series2, "2016-12-21");  
    dataset.addValue(195, series2, "2016-12-22");  
    dataset.addValue(200, series2, "2016-12-23");  
    dataset.addValue(180, series2, "2016-12-24");  
    dataset.addValue(230, series2, "2016-12-25");  
    
    dataset.addValue(210, series3, "2016-12-19");  
    dataset.addValue(120, series3, "2016-12-20");  
    dataset.addValue(150, series3, "2016-12-21");  
    dataset.addValue(255, series3, "2016-12-22");  
    dataset.addValue(180, series3, "2016-12-23");  
    dataset.addValue(190, series3, "2016-12-24");  
    dataset.addValue(240, series3, "2016-12-25");  
    
  
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

