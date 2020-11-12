package com.carlossantana.teste.jfreechart;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

 
public class PieChart extends JFrame {
   
   public PieChart(JPanel panel, String title) {  
    
    // Create dataset  
    DefaultPieDataset dataset = new DefaultPieDataset( );
    // Create chart  
    JFreeChart chart = ChartFactory.createPieChart(
        title, // Chart title          
        dataset,
        true,          
        true, 
        false);  
            
        ChartPanel chartPanel = new ChartPanel(chart);  

        chartPanel.setSize(panel.getWidth(), panel.getHeight());
        chartPanel.setVisible(true);

        panel.removeAll();
        panel.add(chartPanel);
        panel.revalidate();
        panel.repaint();
   }
   
   private static PieDataset createDataset( ) {
      String series1 = "IPhone 5s"  ;
      String series2 = "SamSung Grand";  
      String series3 = "MotoG";
      
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      dataset.setValue( series1 , 50.0 );  
      dataset.setValue( series2 , 25.0 );   
      dataset.setValue( series3 , 25.0 );    

      
      return dataset;         
   }
   
//   private static JFreeChart createChart( PieDataset dataset ) {
//      JFreeChart chart = ChartFactory.createPieChart(      
//         "Mobile Sales",   // chart title 
//         dataset,          // data    
//         true,             // include legend   
//         true, 
//         false);
//
//      return chart;
//   }
   
 

}