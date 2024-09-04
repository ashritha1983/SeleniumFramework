package pages;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Orderconfirmation extends BaseTest {
    static WebDriver wd;

    public static By confirmationMessage = By.cssSelector("body div[id='root'] div[class='container'] div[class='products-wrapper'] div[class='products'] div[class='wrapperTwo'] span:nth-child(1)");

    public Orderconfirmation(WebDriver wd) {
        this.wd = wd;
    }
    public static String getConfirmationMessage(){
        return wd.findElement(confirmationMessage).getText();
    }
}

//package pages;
//
//import base.BaseTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class Orderconfirmation {
//    private static WebDriver wd;
//
//    private static By confirmationMessage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
//
//    public Orderconfirmation(WebDriver wd) {
//        this.wd = wd;
//    }
//
//    public static String getconfirmationMessage() {
//        return wd.findElement(confirmationMessage).getText();
//
//    }
//}

