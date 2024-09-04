package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {
    private WebDriver wd;

    public WebActions(WebDriver driver) {
        this.wd = driver;
    }

    public void searchProduct(String productName) {
        WebElement searchBox = wd.findElement(By.cssSelector("input[placeholder='Search']"));
        searchBox.sendKeys(productName);
        WebElement searchButton = wd.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();
    }

    public void clickAddToCartButton(int index) {
        WebElement addToCartButton = wd.findElements(By.cssSelector("button.add-to-cart")).get(index);
        addToCartButton.click();
    }

    public void clickCartIcon() {
        WebElement cartIcon = wd.findElement(By.cssSelector("a.cart-icon"));
        cartIcon.click();
    }

    public void completeCheckout() {
        WebElement checkoutButton = wd.findElement(By.cssSelector("button.checkout"));
        checkoutButton.click();
    }

    public void selectCountry(String countryName) {
        WebElement countryDropdown = wd.findElement(By.id("country-dropdown"));
        countryDropdown.click();
        WebElement countryOption = wd.findElement(By.xpath("//option[text()='" + countryName + "']"));
        countryOption.click();
    }

    public void checkTermsAndConditions() {
        WebElement termsCheckbox = wd.findElement(By.id("terms-checkbox"));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    public void proceed() {
        WebElement proceedButton = wd.findElement(By.cssSelector("button.proceed"));
        proceedButton.click();
    }

    public String getConfirmationMessage() {
        WebElement confirmationMessage = wd.findElement(By.cssSelector("div.confirmation-message"));
        return confirmationMessage.getText();
    }
}
