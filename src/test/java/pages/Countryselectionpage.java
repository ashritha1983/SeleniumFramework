package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Countryselectionpage {
    private static WebDriver wd;
    private static WebDriverWait wait;

    private static By countryDropdown = By.id("country-dropdown");
    private static By termsCheckbox = By.xpath("//input[@type='checkbox']");
    private static By proceedButton = By.xpath("//button[normalize-space()='Proceed']");

    public Countryselectionpage(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, Duration.ofSeconds(10));
    }

    public boolean isCountryDropdownVisible() {
        try {
            WebElement countryDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
            return countryDropdownElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

//    public static void selectCountry(String countryName) throws InterruptedException {
//        WebElement countryDropdown = wd.findElement(By.xpath("//lect[@style='width: 200px;']"));
//        Thread.sleep(2000);
////        JavascriptExecutor js = (JavascriptExecutor) wd;
////        js.executeScript("arguments[0].value='India';", countryDropdown);
//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("arguments[0].value=arguments[1];", countryDropdown, countryName);
//        Thread.sleep(2000);
//    }

public static void selectCountry(String countryName) throws InterruptedException {
    WebElement countryDropdown = wd.findElement(By.xpath("//select[@style='width: 200px;']"));
    Thread.sleep(2000);

    JavascriptExecutor js = (JavascriptExecutor) wd;
    js.executeScript("arguments[0].value=arguments[1];", countryDropdown, countryName);
    Thread.sleep(2000);

}
    public static void checkTermsAndConditions() throws InterruptedException{
        WebElement checkbox = wd.findElement(termsCheckbox);
        if (!checkbox.isSelected()) {
            checkbox.click();
            Thread.sleep(2000);
        }
    }
    public static void proceed() throws InterruptedException{
        WebElement proceedButtonElement = wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        proceedButtonElement.click();
        Thread.sleep(2000);
    }
}

