package com.carlossantana.teste.jfreechart;

/**
 *
 * @author santana
 */
import javax.swing.JFrame;  
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;  
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class LineChartExample extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public LineChartExample(JPanel painel) {  
    
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(
        "Site Traffic", // Chart title  
        "Date", // X-Axis Label  
        "Number of Visitor", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
//    setContentPane(panel); 


        panel.setSize(painel.getWidth(), painel.getHeight());

        panel.setVisible(true);

        painel.removeAll();

        painel.add(panel);

        painel.revalidate();

        painel.repaint();

  }  
  
  private DefaultCategoryDataset createDataset() {  
  
    String series1 = "Visitor";  
    String series2 = "Unique Visitor";  
    String series3 = "Teste";  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
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