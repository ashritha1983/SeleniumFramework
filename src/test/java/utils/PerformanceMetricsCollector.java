package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PerformanceMetricsCollector {
    private WebDriver driver;

    public PerformanceMetricsCollector(WebDriver driver) {
        this.driver = driver;
    }

    public long measurePageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); // Example URL
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getCacheUsage() {
        // Placeholder for actual cache usage measurement
        return 1024 * 1024; // Example value: 1 MB
    }

    public double getSpeedIndex() {
        // Placeholder for actual Speed Index measurement
        return 1500.0; // Example value: 1500 ms
    }

    public void cleanup() {
        // Any cleanup code if needed
    }
}
