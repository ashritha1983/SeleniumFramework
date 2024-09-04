package utils;

public class PerformanceChartGenerator {

    public static String generateTestExecutionTable(String[] testNames, long[] executionTimes,
                                                    double[] pageLoadTimes, double[] cacheUsages,
                                                    double[] pageSpeeds) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<table border='1' style='width:100%; border-collapse: collapse;'>");
        htmlBuilder.append("<tr>")
                .append("<th>Test Name</th>")
                .append("<th>Execution Time (ms)</th>")
                .append("<th>Page Load Time (ms)</th>")
                .append("<th>Cache Usage (MB)</th>")
                .append("<th>Page Speed (ms)</th>")
                .append("</tr>");

        for (int i = 0; i < testNames.length; i++) {
            htmlBuilder.append("<tr>")
                    .append("<td>").append(testNames[i]).append("</td>")
                    .append("<td>").append(executionTimes[i]).append("</td>")
                    .append("<td>").append(pageLoadTimes[i]).append("</td>")
                    .append("<td>").append(cacheUsages[i]).append("</td>")
                    .append("<td>").append(pageSpeeds[i]).append("</td>")
                    .append("</tr>");
        }

        htmlBuilder.append("</table>");
        return htmlBuilder.toString();
    }
}

