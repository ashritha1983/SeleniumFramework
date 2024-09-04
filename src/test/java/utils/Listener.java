package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(Listener.class);
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        startTime.set(System.currentTimeMillis());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logExecutionTime(result, "SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logExecutionTime(result, "FAILURE");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logExecutionTime(result, "SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logExecutionTime(result, "FAILED BUT WITHIN SUCCESS PERCENTAGE");
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private void logExecutionTime(ITestResult result, String status) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime.get();
        String formattedDuration = formatDuration(duration);

        String logMessage = String.format("Test Method: %s | Status: %s | Duration: %s",
                result.getMethod().getMethodName(),
                status,
                formattedDuration);
        logger.info(logMessage);


    }

    private String formatDuration(long duration) {
        long seconds = duration / 1000;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%d minutes %d seconds", minutes, seconds);
    }
}
