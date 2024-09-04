package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Countryselectionpage;
import pages.Homepage;
import utils.ExcelUtils;
import utils.Reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Listeners(utils.Listener.class)
public class AddToCartTest extends BaseTest {
    private Homepage homePage;

    @DataProvider(name = "addToCartData", parallel = true)
    public Object[][] excelDataProvider() {
        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
        String sheetName = "cart";
        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);

        if (!data.isEmpty()) {
            return data.toArray(new Object[0][]);
        } else {
            throw new RuntimeException("No data found in Excel file.");
        }
    }

    @BeforeClass
    public void setUp() {
        homePage = new Homepage(getDriver());
    }

    @Test(priority = 1, dataProvider = "addToCartData")
    public void addToCartTest(String search) throws InterruptedException {
        ExtentTest test = Reports.getTest();
        test.log(Status.INFO, "Starting addToCartTest at " + getCurrentTime());

        long startTime = System.currentTimeMillis();
        homePage.searchProduct(search);
        test.log(Status.INFO, "Successfully searched for item....");
        homePage.clickAddToCartButton(0);
        homePage.clickCartIcon();
        long endTime = System.currentTimeMillis();

        test.log(Status.INFO, "Completed addToCartTest at " + getCurrentTime());
        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}

class CheckoutTest extends BaseTest {
    private CartPage cartPage;

    @BeforeClass
    public void setUp() {
        cartPage = new CartPage(getDriver());
    }

    @Test(priority = 2)
    public void checkoutTest() {
        ExtentTest test = Reports.getTest();
        test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());

        long startTime = System.currentTimeMillis();
        cartPage.completeCheckout();
        test.log(Status.INFO, "Successfully added to cart....");
        long endTime = System.currentTimeMillis();

        test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}

class CountrySelectionTest extends BaseTest {
    private Countryselectionpage countryselectionpage;

    @DataProvider(name = "CountrySelectionData", parallel = true)
    public Object[][] excelDataProvider1() {
        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
        String sheetName = "Country";
        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);

        if (!data.isEmpty()) {
            return data.toArray(new Object[0][]);
        } else {
            throw new RuntimeException("No data found in Excel file.");
        }
    }

    @BeforeClass
    public void setUp() {
        countryselectionpage = new Countryselectionpage(getDriver());
    }

    @Test(priority = 3, dataProvider = "CountrySelectionData")
    public void countrySelectionTest(String country) throws InterruptedException {
        ExtentTest test = Reports.getTest();
        test.log(Status.INFO, "Starting countrySelectionTest at " + getCurrentTime());

        long startTime = System.currentTimeMillis();
        countryselectionpage.selectCountry(country);
        Thread.sleep(2000);
        test.log(Status.INFO, "Successfully searched for country....");
        countryselectionpage.checkTermsAndConditions();
        countryselectionpage.proceed();
        long endTime = System.currentTimeMillis();

        test.log(Status.INFO, "Completed countrySelectionTest at " + getCurrentTime());
        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}

