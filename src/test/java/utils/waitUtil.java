package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtil {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean waitUsed;

    public waitUtil(WebDriver driver, long timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeoutInSeconds));
        this.waitUsed = false;
    }

    public void waitForVisibility(By locator, String testCaseName) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            waitUsed = true;
            System.out.println("Wait used in test case: " + testCaseName);
        } catch (Exception e) {
            System.out.println("Wait not required in test case: " + testCaseName);
        }
    }

    public boolean isWaitUsed() {
        return waitUsed;
    }
}

