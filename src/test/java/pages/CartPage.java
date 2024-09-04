//
//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//public class CartPage {
//    private WebDriver wd;
//    private CheckoutPage checkoutPage;
//
//    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
//
//    public CartPage(WebDriver wd) {
//        this.wd = wd;
//        this.checkoutPage = new CheckoutPage(wd);
//    }
//
//    public void addProductToCart(String productName) {
//        List<WebElement> products = wd.findElements(By.cssSelector("h4.product-name"));
//        for (WebElement product : products) {
//            if (product.getText().contains(productName)) {
//                WebElement addToCartButton = product.findElement(By.xpath("following-sibling::div/button"));
//                addToCartButton.click();
//                break;
//            }
//        }
//    }
//
//    public void proceedToCheckout() {
//        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
//        WebElement proceedToCheckoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
//        proceedToCheckoutButtonElement.click();
//        System.out.println("Clicked on 'Proceed to Checkout'.");
//    }
//
//    public void completeCheckout() {
//        proceedToCheckout();
//        checkoutPage.placeOrder();
//    }
//
//    public boolean isCheckoutComplete() {
//        return checkoutPage.isCheckoutComplete();
//    }
//
//    public boolean isProductInCart(String productName) {
//        List<WebElement> products = wd.findElements(By.cssSelector("p.product-name"));
//        for (WebElement product : products) {
//            if (product.getText().contains(productName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver wd;
    private WebDriverWait wait;
    private CheckoutPage checkoutPage;

    private By proceedToCheckoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By productNameSelector = By.cssSelector("h4.product-name");
    private By cartProductNameSelector = By.cssSelector("p.product-name");

    public CartPage(WebDriver wd) {
        this.wd = wd;
        this.wait = new WebDriverWait(wd, Duration.ofSeconds(10)); // Adjust timeout as needed
        this.checkoutPage = new CheckoutPage(wd);
    }

    public void addProductToCart(String productName) {
        List<WebElement> products = wd.findElements(productNameSelector);
        for (WebElement product : products) {
            if (product.getText().contains(productName)) {
                WebElement addToCartButton = product.findElement(By.xpath("following-sibling::div/button"));
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
                System.out.println("Added product to cart: " + productName);
                break;
            }
        }
    }

    public void proceedToCheckout() {
        WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedButton.click();
        System.out.println("Clicked on 'Proceed to Checkout'.");
    }

    public void completeCheckout() {
        proceedToCheckout();
        checkoutPage.placeOrder();
    }

    public boolean isCheckoutComplete() {
        return checkoutPage.isCheckoutComplete();
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> products = wd.findElements(cartProductNameSelector);
        for (WebElement product : products) {
            if (product.getText().contains(productName)) {
                return true;
            }
        }
        return false;
    }
}
