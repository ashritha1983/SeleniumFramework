//package pages;
//
//import base.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.List;
//
//public class Homepage extends BaseTest {
//
//    private WebDriver wd;
//
//    private By searchBox = By.cssSelector("input.search-keyword");
//    private By productNames = By.cssSelector("h4.product-name");
//    private By addToCartButtons = By.xpath("//div[@class='product-action']/button");
//    private By cartIcon = By.cssSelector("a.cart-icon");
//    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
//
//    public Homepage(WebDriver wd) {
//        this.wd = wd;
//    }
//
//    public void searchProduct(String productName)throws InterruptedException     {
//        wd.findElement(searchBox).sendKeys(productName);
//        Thread.sleep(2000);
//    }
//
//    public List<WebElement> getProductNames() {
//        return wd.findElements(productNames);
//    }
//
//    public List<WebElement> getAddToCartButtons() {
//        return wd.findElements(addToCartButtons);
//    }
//
//    public void clickAddToCartButton(int index) {
//        getAddToCartButtons().get(index).click();
//
//    }
//
//    public void clickCartIcon() throws InterruptedException{
//        wd.findElement(cartIcon).click();
//        Thread.sleep(2000);
//    }
//
//    public void clickProceedToCheckoutButton() throws InterruptedException {
//        wd.findElement(proceedToCheckoutButton).click();
//        Thread.sleep(2000);
//
//    }
//
//    public boolean isPageLoaded() {
//        return wd.findElement(searchBox).isDisplayed();
//    }
//}
//

package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homepage extends BaseTest {

    private WebDriver wd;
    private WebDriverWait wait;

    private By searchBox = By.cssSelector("input.search-keyword");
    private By productNames = By.cssSelector("h4.product-name");
    private By addToCartButtons = By.xpath("//div[@class='product-action']/button");
    private By cartIcon = By.cssSelector("a.cart-icon");
    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");

    public Homepage(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, Duration.ofSeconds(10)); // Adjust timeout as needed
    }

    public void searchProduct(String productName) {
        WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchElement.sendKeys(productName);
    }

    public List<WebElement> getProductNames() {
        return wd.findElements(productNames);
    }

    public List<WebElement> getAddToCartButtons() {
        return wd.findElements(addToCartButtons);
    }

    public void clickAddToCartButton(int index) {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(getAddToCartButtons().get(index)));
        button.click();
    }

    public void clickCartIcon() {
        WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartElement.click();
    }

    public void clickProceedToCheckoutButton() {
        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedButton.click();
    }

    public boolean isPageLoaded() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
