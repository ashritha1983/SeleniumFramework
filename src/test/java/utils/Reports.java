package utils;//method to send report via gmail

//package utils;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import static utils.screenshot.attachScreen;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static long startTime;
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
//        String toEmail = "ashritha0319@gmail.com";
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//        EmailUtils.sendReportByEmail(toEmail, subject, body, reportFilePath);
//        System.out.println("Email sent successfully");
//    }
//
//
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
//        test.set(extentTest);
//        startTime = System.currentTimeMillis(); // Start timer
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
//            extentTest.fail(result.getThrowable());
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    private void attachChartToReport() {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            String base64Chart = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!base64Chart.isEmpty()) {
//                try {
//                    extentTest.info("Execution Time Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Chart).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}


//method to send report via outlook

//package utils;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import static utils.screenshot.attachScreen;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static long startTime;
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = REPORT_PATH;
//        String toEmail = "ashritha@quality-matrix.com"; // Replace with your Outlook email address
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//
//        EmailUtils.sendReportByEmail(toEmail, subject, body, reportFilePath);
//        System.out.println("Email sent successfully");
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
//        test.set(extentTest);
//        startTime = System.currentTimeMillis();
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
//            extentTest.fail(result.getThrowable());
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    private void attachChartToReport() {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            String base64Chart = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!base64Chart.isEmpty()) {
//                try {
//                    extentTest.info("Execution Time Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Chart).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}


//method to send report via gmail&outlook
//
//package utils;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.util.Scanner;
//
//import static utils.screenshot.attachScreen;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static long startTime;
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
////        String testDescription = result.getMethod().getDescription();
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
////    @Override
////    public void onFinish(ITestContext context) {
////        if (extent != null) {
////            attachChartToReport();
////            extent.flush();
////        }
////
////        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
////
////        String[] gmailAddresses = {"ashritha0319@gmail.com"};
////        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
////
////        String subject = "Automation Test Report";
////        String body = "Please find the attached automation test report.";
////
////        String gmailFileName = "email_utils.html";
////        String outlookFileName = "outlook.html";
////
////        // report to Gmail
////        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
////
////        // report to Outlook
////        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);
////
////        System.out.println("Emails sent successfully");
////    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
//        String reportFileName = "Automation_Report.html";
//        String downloadDirectory = System.getProperty("user.home") + "/Downloads/"; // You can specify a different directory here
//
//        System.out.println("Report file path: " + reportFilePath);
//        System.out.println("Report file name: " + reportFileName);
//
//        downloadReport(reportFilePath, reportFileName, downloadDirectory);
//
//        String[] gmailAddresses = {"ashritha0319@gmail.com"};
//        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
//
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//
//        String gmailFileName = "email_utils.html";
//        String outlookFileName = "outlook.html";
//
//        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
//
//        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);
//
//        System.out.println("Emails sent successfully.");
//    }
//
//    private void downloadReport(String filePath, String fileName, String downloadDirectory) {
//        File sourceFile = new File(filePath);
//        File destinationFile = new File(downloadDirectory + fileName);
//
//        if (sourceFile.exists()) {
//            try {
//                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("Report downloaded successfully to: " + destinationFile.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Failed to download the report.");
//            }
//        } else {
//            System.out.println("Report file does not exist at: " + filePath);
//        }
//    }
//
//
//        @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
//        test.set(extentTest);
//        startTime = System.currentTimeMillis();
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        String description = result.getMethod().getMethodName();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
//            extentTest.fail(result.getThrowable());
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        String description = result.getMethod().getMethodName();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    private void attachChartToReport() {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            String base64Chart = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!base64Chart.isEmpty()) {
//                try {
//                    extentTest.info("Execution Time Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Chart).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}
//
//
//
//

//updated description one
//
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.util.Scanner;
//
//import static utils.screenshot.attachScreen;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static long startTime;
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
//        String reportFileName = "Automation_Report.html";
//        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
//
//        System.out.println("Report file path: " + reportFilePath);
//        System.out.println("Report file name: " + reportFileName);
//
//        downloadReport(reportFilePath, reportFileName, downloadDirectory);
//
//        String[] gmailAddresses = {"ashritha0319@gmail.com"};
//        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
//
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//
//        String gmailFileName = "email_utils.html";
//        String outlookFileName = "outlook.html";
//
//        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
//        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);
//
//        System.out.println("Emails sent successfully.");
//    }
//
//    private void downloadReport(String filePath, String fileName, String downloadDirectory) {
//        File sourceFile = new File(filePath);
//        File destinationFile = new File(downloadDirectory + fileName);
//
//        if (sourceFile.exists()) {
//            try {
//                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("Report downloaded successfully to: " + destinationFile.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Failed to download the report.");
//            }
//        } else {
//            System.out.println("Report file does not exist at: " + filePath);
//        }
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), description);
//        test.set(extentTest);
//        startTime = System.currentTimeMillis();
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
//            extentTest.info("Description: " + description);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
//            extentTest.fail(result.getThrowable());
//            extentTest.info("Description: " + description);
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
//            extentTest.info("Description: " + description);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    private void attachChartToReport() {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            String base64Chart = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!base64Chart.isEmpty()) {
//                try {
//                    extentTest.info("Execution Time Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(base64Chart).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//
//import static utils.screenshot.attachScreen;
//import utils.ChartGenerator;  // Assuming this is the existing chart generator
//import utils.PerformanceChartGenerator;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static long startTime;
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartsToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
//        String reportFileName = "Automation_Report.html";
//        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
//
//        System.out.println("Report file path: " + reportFilePath);
//        System.out.println("Report file name: " + reportFileName);
//
//        downloadReport(reportFilePath, reportFileName, downloadDirectory);
//
//        String[] gmailAddresses = {"ashritha0319@gmail.com"};
//        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
//
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//
//        String gmailFileName = "email_utils.html";
//        String outlookFileName = "outlook.html";
//
//        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
//        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);
//
//        System.out.println("Emails sent successfully.");
//    }
//
//    private void downloadReport(String filePath, String fileName, String downloadDirectory) {
//        File sourceFile = new File(filePath);
//        File destinationFile = new File(downloadDirectory + fileName);
//
//        if (sourceFile.exists()) {
//            try {
//                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("Report downloaded successfully to: " + destinationFile.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Failed to download the report.");
//            }
//        } else {
//            System.out.println("Report file does not exist at: " + filePath);
//        }
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), description);
//        test.set(extentTest);
//        startTime = System.currentTimeMillis();
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.PASS, "Test case passed: " + result.getMethod().getMethodName());
//            extentTest.info("Description: " + description);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.FAIL, "Test case failed: " + result.getMethod().getMethodName());
//            extentTest.fail(result.getThrowable());
//            extentTest.info("Description: " + description);
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        String description = result.getMethod().getDescription();
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            long duration = System.currentTimeMillis() - startTime;
//            extentTest.log(Status.SKIP, "Test case skipped: " + result.getMethod().getMethodName());
//            extentTest.info("Description: " + description);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    private void attachChartsToReport() {
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            // Attach existing chart (if applicable)
//            String existingChartBase64 = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!existingChartBase64.isEmpty()) {
//                try {
//                    extentTest.info("Existing Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(existingChartBase64).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            // Attach new performance metrics chart
//            long pageLoadTime = 1200; // Replace with actual value
//            long cacheUsage = 800;    // Replace with actual value
//            double speedIndex = 75.5; // Replace with actual value
//            String performanceChartBase64 = PerformanceChartGenerator.generatePieChartBase64(pageLoadTime, cacheUsage, speedIndex);
//            if (!performanceChartBase64.isEmpty()) {
//                try {
//                    extentTest.info("Performance Metrics Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(performanceChartBase64).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}
//


//--------------------
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.util.HashMap;
//import java.util.Map;
//
//import static utils.screenshot.attachScreen;
//import utils.PerformanceChartGenerator;
//
//public class Reports implements ITestListener {
//    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
//    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    private static ThreadLocal<Long> startTime = new ThreadLocal<>();
//    private static Map<String, Long> testExecutionTimes = new HashMap<>();
//
//    @Override
//    public void onStart(ITestContext context) {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", "Chrome");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        if (extent != null) {
//            attachChartsAndTableToReport();
//            extent.flush();
//        }
//
//        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
//        String reportFileName = "Automation_Report.html";
//        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
//
//        System.out.println("Report file path: " + reportFilePath);
//        System.out.println("Report file name: " + reportFileName);
//
//        downloadReport(reportFilePath, reportFileName, downloadDirectory);
//
//        String[] gmailAddresses = {"ashritha0319@gmail.com"};
//        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
//
//        String subject = "Automation Test Report";
//        String body = "Please find the attached automation test report.";
//
//        String gmailFileName = "email_utils.html";
//        String outlookFileName = "outlook.html";
//
//        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
//        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);
//
//        System.out.println("Emails sent successfully.");
//    }
//
//    private void downloadReport(String filePath, String fileName, String downloadDirectory) {
//        File sourceFile = new File(filePath);
//        File destinationFile = new File(downloadDirectory + fileName);
//
//        if (sourceFile.exists()) {
//            try {
//                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                System.out.println("Report downloaded successfully to: " + destinationFile.getAbsolutePath());
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("Failed to download the report.");
//            }
//        } else {
//            System.out.println("Report file does not exist at: " + filePath);
//        }
//    }
//
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        String methodName = result.getMethod().getMethodName();
//        ExtentTest extentTest = extent.createTest(methodName, result.getMethod().getDescription());
//        test.set(extentTest);
//        startTime.set(System.currentTimeMillis());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime.get();
//        String methodName = result.getMethod().getMethodName();
//        testExecutionTimes.put(methodName, duration);
//
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            extentTest.log(Status.PASS, "Test case passed: " + methodName);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime.get();
//        String methodName = result.getMethod().getMethodName();
//        testExecutionTimes.put(methodName, duration);
//
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            extentTest.log(Status.FAIL, "Test case failed: " + methodName);
//            extentTest.fail(result.getThrowable());
//
//            String base64Screenshot = attachScreen(BaseTest.getDriver());
//            if (base64Screenshot != null) {
//                extentTest.fail("Screenshot of failure:",
//                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
//            }
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        long endTime = System.currentTimeMillis();
//        long duration = endTime - startTime.get();
//        String methodName = result.getMethod().getMethodName();
//        testExecutionTimes.put(methodName, duration);
//
//        ExtentTest extentTest = test.get();
//        if (extentTest != null) {
//            extentTest.log(Status.SKIP, "Test case skipped: " + methodName);
//            extentTest.info("Execution time: " + duration + " ms");
//        }
//    }
//    private void attachChartsAndTableToReport() {
//        ExtentTest extentTest = Reports.getTest();
//        if (extentTest != null) {
//            // Attach existing chart (if applicable)
//            String existingChartBase64 = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
//            if (!existingChartBase64.isEmpty()) {
//                try {
//                    extentTest.info("Execution time Chart:",
//                            MediaEntityBuilder.createScreenCaptureFromBase64String(existingChartBase64).build());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//            String[] testNames = {"addToCartTest", "checkoutTest", "countrySelectionTest", "testConfirmationMessage"};
//            long[] executionTimes = {5000, 3000, 4000, 2000}; // Replace with actual execution times in milliseconds
//            double[] pageLoadTimes = {1.2, 0.8, 1.5, 0.9}; // Replace with actual page load times in seconds
//            double[] cacheUsages = {0, 0, 0, 0}; // Replace with actual cache usages in MB
//            double[] pageSpeeds = {200, 180, 220, 190}; // Replace with actual page speeds in milliseconds
//
//            String performanceTableHtml = PerformanceChartGenerator.generateTestExecutionTable(
//                    testNames, executionTimes, pageLoadTimes, cacheUsages, pageSpeeds);
//
//            if (!performanceTableHtml.isEmpty()) {
//                try {
//                    // Log the HTML directly to the report
//                    extentTest.info("Performance Metrics Table: <br>" + performanceTableHtml);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void logInfo(String message) {
//        if (test.get() != null) {
//            test.get().info(message);
//        } else {
//            System.err.println("ExtentTest is not initialized. Cannot log info message: " + message);
//        }
//    }
//}
//
//
//
//


import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static utils.screenshot.attachScreen;
import utils.PerformanceChartGenerator;

public class Reports implements ITestListener {
    private static final String REPORT_PATH = System.getProperty("user.dir") + "/utils/Reports/index.html";
    private static final String JSON_PATH = System.getProperty("user.dir") + "/utils/Reports/failed_tests.json";
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<Long> startTime = new ThreadLocal<>();
    private static JSONArray failedTestsArray = new JSONArray();

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            attachChartsAndTableToReport();
            extent.flush();
        }

        try (FileWriter file = new FileWriter(JSON_PATH)) {
            file.write(failedTestsArray.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        showAlertDialog(failedTestsArray);

        String reportFilePath = System.getProperty("user.dir") + "/utils/Reports/index.html";
        String reportFileName = "Automation_Report.html";
        String downloadDirectory = System.getProperty("user.home") + "/Downloads/";
        downloadReport(reportFilePath, reportFileName, downloadDirectory);

        String[] gmailAddresses = {"ashritha0319@gmail.com"};
        String[] outlookAddresses = {"ashritha@quality-matrix.com"};
        String subject = "Automation Test Report";
        String body = "Please find the attached automation test report.";
        String gmailFileName = "email_utils.html";
        String outlookFileName = "outlook.html";

        EmailUtils.sendReportByEmail(gmailAddresses, subject, body, reportFilePath, gmailFileName);
        outlook.sendReportByEmail(outlookAddresses, subject, body, reportFilePath, outlookFileName);

        System.out.println("Emails sent successfully.");
    }

    private void downloadReport(String filePath, String fileName, String downloadDirectory) {
        File sourceFile = new File(filePath);
        File destinationFile = new File(downloadDirectory + fileName);

        if (sourceFile.exists()) {
            try {
                Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Report downloaded successfully to: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to download the report.");
            }
        } else {
            System.out.println("Report file does not exist at: " + filePath);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ExtentTest extentTest = extent.createTest(methodName, result.getMethod().getDescription());
        test.set(extentTest);
        startTime.set(System.currentTimeMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime.get();
        String methodName = result.getMethod().getMethodName();

        ExtentTest extentTest = test.get();
        if (extentTest != null) {
            extentTest.log(Status.PASS, "Test case passed: " + methodName);
            extentTest.info("Execution time: " + duration + " ms");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime.get();
        String methodName = result.getMethod().getMethodName();

        JSONObject failedTest = new JSONObject();
        failedTest.put("name", methodName);
        failedTest.put("executionTime", duration);
        failedTestsArray.add(failedTest);

        ExtentTest extentTest = test.get();
        if (extentTest != null) {
            extentTest.log(Status.FAIL, "Test case failed: " + methodName);
            extentTest.fail(result.getThrowable());

            String base64Screenshot = attachScreen(BaseTest.getDriver());
            if (base64Screenshot != null) {
                extentTest.fail("Screenshot of failure:",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
            extentTest.info("Execution time: " + duration + " ms");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime.get();
        String methodName = result.getMethod().getMethodName();

        ExtentTest extentTest = test.get();
        if (extentTest != null) {
            extentTest.log(Status.SKIP, "Test case skipped: " + methodName);
            extentTest.info("Execution time: " + duration + " ms");
        }
    }

    private void attachChartsAndTableToReport() {
        ExtentTest extentTest = Reports.getTest();
        if (extentTest != null) {
            String existingChartBase64 = ChartGenerator.generateChartBase64("utils/Reports/execution_times.csv");
            if (!existingChartBase64.isEmpty()) {
                try {
                    extentTest.info("Execution time Chart:",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(existingChartBase64).build());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // Generate and attach performance table
            String[] testNames = {"addToCartTest", "checkoutTest", "countrySelectionTest", "testConfirmationMessage"};
            long[] executionTimes = {5000, 3000, 4000, 2000}; // Replace with actual execution times
            double[] pageLoadTimes = {1.2, 0.8, 1.5, 0.9}; // Replace with actual page load times
            double[] cacheUsages = {0, 0, 0, 0}; // Replace with actual cache usages
            double[] pageSpeeds = {200, 180, 220, 190}; // Replace with actual page speeds

            String performanceTableHtml = PerformanceChartGenerator.generateTestExecutionTable(
                    testNames, executionTimes, pageLoadTimes, cacheUsages, pageSpeeds);

            if (!performanceTableHtml.isEmpty()) {
                try {
                    extentTest.info("Performance Metrics Table: <br>" + performanceTableHtml);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showAlertDialog(JSONArray failedTests) {
        if (failedTests.isEmpty()) {
            return;
        }

        StringBuilder message = new StringBuilder("Failed Test Cases:\n");
        for (int i = 0; i < failedTests.size(); i++) {
            JSONObject failure = (JSONObject) failedTests.get(i);
            String testName = (String) failure.get("name");
            long executionTime = (long) failure.get("executionTime");
            message.append((i + 1)).append(". ").append(testName)
                    .append(" - Execution Time: ").append(executionTime).append(" ms\n");
        }

        String[] options = {"View Report", "Cancel"};

        int choice = JOptionPane.showOptionDialog(
                null,
                message.toString(),
                "Test Failures",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[1]
        );

        if (choice == 0) {
            try {
                Desktop.getDesktop().browse(new File(REPORT_PATH).toURI());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to open the report.");
            }
        }
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void logInfo(String message) {
        if (test.get() != null) {
            test.get().info(message);
        } else {
            System.err.println("ExtentTest is null, cannot log message: " + message);
        }
    }
}
