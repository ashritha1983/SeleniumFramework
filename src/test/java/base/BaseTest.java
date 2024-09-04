//package base;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//
//public class BaseTest {
//    public static WebDriver driver;
////    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    @BeforeClass
//    public void setup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//    }
//
//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//}

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import utils.PerformanceMetrics;

public class BaseTest {
    protected static WebDriver driver;
//    protected static PerformanceMetrics performanceMetrics;

    @BeforeClass
    public void setup() {
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}


//
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//
//import java.io.FileInputStream;
//import java.time.Duration;
//import java.util.Properties;
//
//public class BaseTest {
//    public static Properties prop;
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    @BeforeTest
//    public void configReader() throws Exception {
//        prop = new Properties();
//        FileInputStream FI = new FileInputStream("src/main/resources/config.properties");
//        prop.load(FI);
//    }
//
//    @BeforeMethod
//    @Parameters("browserName")
//    public void launchBrowser(@Optional("chrome") String browserName) {
//        WebDriver localDriver = null;
//
//        if (browserName.equalsIgnoreCase("chrome")) {
//            localDriver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            localDriver = new EdgeDriver();
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            localDriver = new FirefoxDriver();
//        } else {
//            throw new IllegalArgumentException("Browser not supported: " + browserName);
//        }
//
//        driver.set(localDriver);
//
//        WebDriver currentDriver = driver.get();
//        currentDriver.manage().window().maximize();
//        currentDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        currentDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        currentDriver.get(prop.getProperty("TestUrl"));
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        WebDriver currentDriver = driver.get();
//        if (currentDriver != null) {
//            try {
//                currentDriver.quit();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                driver.remove();
//            }
//        }
//    }
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//}
