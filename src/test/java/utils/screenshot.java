package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class screenshot {
    public static void takeScreenshot(WebDriver driver, String path) throws Exception {
        File screenshotDir = new File("src/test/java/utils");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotDir, path));
        System.out.println("Screenshot taken successfully and saved to: " + new File(screenshotDir, path).getAbsolutePath());
    }
    public static String attachScreen(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
