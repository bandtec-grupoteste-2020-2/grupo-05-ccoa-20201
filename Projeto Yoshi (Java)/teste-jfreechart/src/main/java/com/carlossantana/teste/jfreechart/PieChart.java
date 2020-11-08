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
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "IPhone 5s" , 20.0 );  
      dataset.setValue( "SamSung Grand" , 20.0 );   
      dataset.setValue( "MotoG" , 40.0 );    
      dataset.setValue( "Nokia Lumia" , 10.0  );  
      
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