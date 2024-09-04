package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver wd;

    private By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private By checkoutSuccessMessage = By.cssSelector(".order-confirmation");

    public CheckoutPage(WebDriver wd) {
        this.wd = wd;
    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        WebElement placeOrderButtonElement = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButtonElement.click();
        System.out.println("Clicked on 'Place Order'.");
    }

    public boolean isCheckoutComplete() {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        try {
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutSuccessMessage));
            return confirmationMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
