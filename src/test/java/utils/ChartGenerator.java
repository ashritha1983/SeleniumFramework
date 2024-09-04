package utils;//package utils;
//
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.ChartUtils;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.data.category.CategoryDataset;
//import org.jfree.data.category.DefaultCategoryDataset;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class ChartGenerator {
//
//    public static void generateChart(String csvFilePath) {
//        CategoryDataset dataset = createDataset(csvFilePath);
//
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Test Case Execution Time",
//                "Test Case Name",
//                "Execution Time (ms)",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false
//        );
//
//        try {
//            // Save the chart as an image
//            ChartUtils.saveChartAsPNG(new java.io.File("utils/Reports/execution_times_chart.png"), chart, 800, 600);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Optionally display the chart in a Swing window
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Test Case Execution Time");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.add(new ChartPanel(chart));
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
//
//    private static CategoryDataset createDataset(String csvFilePath) {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
//            String line;
//            br.readLine(); // Skip header
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                if (values.length == 2) {
//                    String testCaseName = values[0];
//                    double executionTime = Double.parseDouble(values[1]);
//                    dataset.addValue(executionTime, "Execution Time", testCaseName);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return dataset;
//    }
//}




import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class ChartGenerator {

    public static String generateChartBase64(String csvFilePath) {
        String base64Chart = "";
        CategoryDataset dataset = createDataset(csvFilePath);

        JFreeChart chart = ChartFactory.createBarChart(
                "Execution Time Chart", // Updated chart title
                "Test Case Name",
                "Execution Time (ms)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ChartUtils.writeChartAsPNG(baos, chart, 800, 600);
            byte[] chartBytes = baos.toByteArray();
            base64Chart = Base64.getEncoder().encodeToString(chartBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return base64Chart;
    }

    private static CategoryDataset createDataset(String csvFilePath) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 2) {
                    String testCaseName = values[0];
                    double executionTime = Double.parseDouble(values[1]);
                    dataset.addValue(executionTime, "Execution Time", testCaseName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataset;
    }
}





