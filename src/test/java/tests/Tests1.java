////
////package tests;
////
////import base.BaseTest;
////
////import com.aventstack.extentreports.model.Report;
////import org.testng.annotations.BeforeClass;
////import org.testng.annotations.DataProvider;
////import org.testng.annotations.Test;
////import pages.CartPage;
////import pages.Countryselectionpage;
////import pages.Homepage;
////import pages.Orderconfirmation;
////import utils.ExcelUtils;
////import utils.Reports;
////
////import java.io.IOException;
////import java.util.ArrayList;
////import java.util.List;
////
////public class Tests1 extends BaseTest {
////    private Homepage homePage;
////    private CartPage cartPage;
////    private Countryselectionpage countryselectionpage;
////    private Orderconfirmation orderconfirmation;
////
////    @DataProvider(name = "addToCartData")
////    public Object[][] excelDataProvider() {
////        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
////        String sheetName = "cart";
////        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
////
////        if (!data.isEmpty()) {
////            return data.toArray(new Object[0][]);
////        } else {
////            throw new RuntimeException("No data found in Excel file.");
////        }
////    }
////
////    @DataProvider(name = "CountrySelectionData")
////    public Object[][] excelDataProvider1() {
////        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
////        String sheetName = "Country";
////        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
////
////        if (!data.isEmpty()) {
////            return data.toArray(new Object[0][]);
////        } else {
////            throw new RuntimeException("No data found in Excel file.");
////        }
////    }
////
////    @BeforeClass
////    public void setUp() {
////        homePage = new Homepage(driver);
////        cartPage = new CartPage(driver);
////        countryselectionpage = new Countryselectionpage(driver);
////        orderconfirmation = new Orderconfirmation(driver);
////
////    }
////
////    @Test(priority = 1, dataProvider = "addToCartData")
////    public void addToCartTest(String search) throws InterruptedException {
////        homePage.searchProduct(search);
////        Reports.getTest().info("Successfully searched for item....");
////        homePage.clickAddToCartButton(0);
////        homePage.clickCartIcon();
////    }
////
////
////    @Test(priority = 2)
////    public void checkoutTest() {
////        cartPage.completeCheckout();
////        Reports.getTest().info("Successfully added to cart....");
////
////    }
////
////    @Test(priority = 3, dataProvider = "CountrySelectionData")
////    public void countrySelectionTest(String country) throws InterruptedException {
////        countryselectionpage.selectCountry(country);
////        Thread.sleep(2000);
////        Reports.getTest().info("Successfully seaeched for country....");
////        countryselectionpage.checkTermsAndConditions();
////        countryselectionpage.proceed();
////    }
////
////    @Test(priority = 4)
////    public void testConfirmationMessage() {
////        orderconfirmation = new Orderconfirmation(driver);
////        System.out.println("Thank you, your order has been placed successfully\n" + "You'll be redirected to Home page shortly!!");
////        System.out.println();
////    }
////}
//
////previous one
//
//
//
//package tests;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import jdk.jfr.Description;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.CartPage;
//import pages.Countryselectionpage;
//import pages.Homepage;
//import pages.Orderconfirmation;
//import utils.ExcelUtils;
//import utils.Reports;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Listeners(utils.Listener.class)
//public class Tests1 extends BaseTest {
//    private Homepage homePage;
//    private CartPage cartPage;
//    private Countryselectionpage countryselectionpage;
//    private Orderconfirmation orderconfirmation;
//
//    @DataProvider(name = "addToCartData")
//    public Object[][] excelDataProvider() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "cart";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @DataProvider(name = "CountrySelectionData")
//    public Object[][] excelDataProvider1() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "Country";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @BeforeClass
//    public void setUp() {
//        homePage = new Homepage(driver);
//        cartPage = new CartPage(driver);
//        countryselectionpage = new Countryselectionpage(driver);
//        orderconfirmation = new Orderconfirmation(driver);
//    }
//
//    @Test(priority = 1, dataProvider = "addToCartData", description = "To valid that the testcase selects the item and adds to cart")
//
//    public void addToCartTest(String search) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting addToCartTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        homePage.searchProduct(search);
//        test.log(Status.INFO, "Successfully searched for item....");
//        homePage.clickAddToCartButton(0);
//        homePage.clickCartIcon();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed addToCartTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 2, description = "To validate that the testcase clicks on place order and complete the checkout process")
//    public void checkoutTest() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        cartPage.completeCheckout();
//        test.log(Status.INFO, "Successfully added to cart....");
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 3, dataProvider = "CountrySelectionData", description = "To validate that the testcase successfully selects the country")
//    public void countrySelectionTest(String country) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting countrySelectionTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        countryselectionpage.selectCountry(country);
//        Thread.sleep(2000);
//        test.log(Status.INFO, "Successfully searched for country....");
//        countryselectionpage.checkTermsAndConditions();
//        countryselectionpage.proceed();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed countrySelectionTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 4, description = "To validate that the testcase sucessfullt prints confirmation message")
//    public void testConfirmationMessage() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting testConfirmationMessage at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        orderconfirmation = new Orderconfirmation(driver);
//        System.out.println("Thank you, your order has been placed successfully\n" + "You'll be redirected to Home page shortly!!");
//        System.out.println();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed testConfirmationMessage at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    private String getCurrentTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//        return sdf.format(new Date());
//    }
//}
//
//


////updated one
//
//package tests;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import jdk.jfr.Description;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.CartPage;
//import pages.Countryselectionpage;
//import pages.Homepage;
//import pages.Orderconfirmation;
//import utils.ExcelUtils;
//import utils.Reports;
//import utils.ScreenRecorderUtil;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Listeners(utils.Listener.class)
//public class Tests1 extends BaseTest {
//    private Homepage homePage;
//    private CartPage cartPage;
//    private Countryselectionpage countryselectionpage;
//    private Orderconfirmation orderconfirmation;
//
//    @DataProvider(name = "addToCartData")
//    public Object[][] excelDataProvider() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "cart";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @DataProvider(name = "CountrySelectionData")
//    public Object[][] excelDataProvider1() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "Country";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @BeforeClass
//    public void setUp() {
//        homePage = new Homepage(driver);
//        cartPage = new CartPage(driver);
//        countryselectionpage = new Countryselectionpage(driver);
//        orderconfirmation = new Orderconfirmation(driver);
//    }
//
//    @BeforeMethod
//    public void startRecording() {
//        try {
//            // Start recording with the name of the test method
//            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//            ScreenRecorderUtil.startRecord(methodName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @AfterMethod
//    public void stopRecording() {
//        try {
//            // Stop recording after the test method completes
//            ScreenRecorderUtil.stopRecord();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test(priority = 1, dataProvider = "addToCartData", description = "To validate that the testcase selects the item and adds to cart")
//    public void addToCartTest(String search) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting addToCartTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        homePage.searchProduct(search);
//        test.log(Status.INFO, "Successfully searched for item....");
//        homePage.clickAddToCartButton(0);
//        homePage.clickCartIcon();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed addToCartTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 2, description = "To validate that the testcase clicks on place order and complete the checkout process")
//    public void checkoutTest() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        cartPage.completeCheckout();
//        test.log(Status.INFO, "Successfully added to cart....");
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 3, dataProvider = "CountrySelectionData", description = "To validate that the testcase successfully selects the country")
//    public void countrySelectionTest(String country) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting countrySelectionTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        countryselectionpage.selectCountry(country);
//        Thread.sleep(2000);
//        test.log(Status.INFO, "Successfully searched for country....");
//        countryselectionpage.checkTermsAndConditions();
//        countryselectionpage.proceed();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed countrySelectionTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 4, description = "To validate that the testcase successfully prints confirmation message")
//    public void testConfirmationMessage() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting testConfirmationMessage at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        orderconfirmation = new Orderconfirmation(driver);
////        System.out.println("Thank you, your order has been placed successfully\n" + "You'll be redirected to Home page shortly!!");
////        System.out.println();
////        long endTime = System.currentTimeMillis();
////
////        test.log(Status.INFO, "Completed testConfirmationMessage at " + getCurrentTime());
////        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
////    }
////
////    private String getCurrentTime() {
////        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
////        return sdf.format(new Date());
////    }
////}
////
//package tests;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.CartPage;
//import pages.Countryselectionpage;
//import pages.Homepage;
//import pages.Orderconfirmation;
//import utils.ExcelUtils;
//import utils.Reports;
//import utils.ScreenRecorderUtil;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Listeners(utils.Listener.class)
//public class Tests1 extends BaseTest {
//    private Homepage homePage;
//    private CartPage cartPage;
//    private Countryselectionpage countryselectionpage;
//    private Orderconfirmation orderconfirmation;
//
//    private static ThreadLocal<String> testMethodName = new ThreadLocal<>();
//
//    @DataProvider(name = "addToCartData")
//    public Object[][] excelDataProvider() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "cart";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @DataProvider(name = "CountrySelectionData")
//    public Object[][] excelDataProvider1() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "Country";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @BeforeClass
//    public void setUp() {
//        homePage = new Homepage(driver);
//        cartPage = new CartPage(driver);
//        countryselectionpage = new Countryselectionpage(driver);
//        orderconfirmation = new Orderconfirmation(driver);
//    }
//
//    @BeforeMethod
//    public void startRecording() {
//        try {
//            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
//            ScreenRecorderUtil.startRecord(methodName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @AfterMethod
//    public void stopRecording() {
//        try {
//            // Stop recording after the test method completes
//            ScreenRecorderUtil.stopRecord();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test(priority = 1, dataProvider = "addToCartData", description = "To validate that the testcase selects the item and adds to cart")
//    public void addToCartTest(String search) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting addToCartTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        homePage.searchProduct(search);
//        test.log(Status.INFO, "Successfully searched for item....");
//        homePage.clickAddToCartButton(0);
//        homePage.clickCartIcon();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed addToCartTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 2, description = "To validate that the testcase clicks on place order and complete the checkout process")
//    public void checkoutTest() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        cartPage.completeCheckout();
//        test.log(Status.INFO, "Successfully added to cart....");
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 3, dataProvider = "CountrySelectionData", description = "To validate that the testcase successfully selects the country")
//    public void countrySelectionTest(String country) throws InterruptedException {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting countrySelectionTest at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        countryselectionpage.selectCountry(country);
//        Thread.sleep(2000);
//        test.log(Status.INFO, "Successfully searched for country....");
//        countryselectionpage.checkTermsAndConditions();
//        countryselectionpage.proceed();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed countrySelectionTest at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    @Test(priority = 4, description = "To validate that the testcase successfully prints confirmation message")
//    public void testConfirmationMessage() {
//        ExtentTest test = Reports.getTest();
//        test.log(Status.INFO, "Starting testConfirmationMessage at " + getCurrentTime());
//
//        long startTime = System.currentTimeMillis();
//        orderconfirmation = new Orderconfirmation(driver);
//        System.out.println("Thank you, your order has been placed successfully\n" + "You'll be redirected to Home page shortly!!");
//        System.out.println();
//        long endTime = System.currentTimeMillis();
//
//        test.log(Status.INFO, "Completed testConfirmationMessage at " + getCurrentTime());
//        test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//    }
//
//    private String getCurrentTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//        return sdf.format(new Date());
//    }
//}


//package tests;
//
//import base.BaseTest;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//import pages.CartPage;
//import pages.Countryselectionpage;
//import pages.Homepage;
//import pages.Orderconfirmation;
//import utils.ExcelUtils;
//import utils.Reports;
//import utils.ScreenRecorderUtil;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Listeners(utils.Listener.class)
//public class Tests1 extends BaseTest {
//    private Homepage homePage;
//    private CartPage cartPage;
//    private Countryselectionpage countryselectionpage;
//    private Orderconfirmation orderconfirmation;
//
//    @DataProvider(name = "addToCartData")
//    public Object[][] excelDataProvider() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "cart";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @DataProvider(name = "CountrySelectionData")
//    public Object[][] excelDataProvider1() {
//        String filePath = "C:\\Users\\Ashritha\\Desktop\\Framework\\Framework\\src\\main\\resources\\testData.xlsx";
//        String sheetName = "Country";
//        List<Object[]> data = ExcelUtils.getExcelData(filePath, sheetName);
//
//        if (!data.isEmpty()) {
//            return data.toArray(new Object[0][]);
//        } else {
//            throw new RuntimeException("No data found in Excel file.");
//        }
//    }
//
//    @Test(priority = 1, dataProvider = "addToCartData", description = "To validate that the testcase selects the item and adds to cart")
//    public void addToCartTest(String search) throws InterruptedException {
//        try {
//            ScreenRecorderUtil.startRecord("addToCartTest");
//
//            ExtentTest test = Reports.getTest();
//            test.log(Status.INFO, "Starting addToCartTest at " + getCurrentTime());
//
//            long startTime = System.currentTimeMillis();
//            homePage.searchProduct(search);
//            test.log(Status.INFO, "Successfully searched for item....");
//            homePage.clickAddToCartButton(0);
//            homePage.clickCartIcon();
//            long endTime = System.currentTimeMillis();
//
//            test.log(Status.INFO, "Completed addToCartTest at " + getCurrentTime());
//            test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ScreenRecorderUtil.stopRecord();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test(priority = 2, description = "To validate that the testcase clicks on place order and complete the checkout process")
//    public void checkoutTest() {
//        try {
//            ScreenRecorderUtil.startRecord("checkoutTest");
//
//            ExtentTest test = Reports.getTest();
//            test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());
//
//            long startTime = System.currentTimeMillis();
//            cartPage.completeCheckout();
//            test.log(Status.INFO, "Successfully added to cart....");
//            long endTime = System.currentTimeMillis();
//
//            test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
//            test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ScreenRecorderUtil.stopRecord();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test(priority = 3, dataProvider = "CountrySelectionData", description = "To validate that the testcase successfully selects the country")
//    public void countrySelectionTest(String country) throws InterruptedException {
//        try {
//            ScreenRecorderUtil.startRecord("countrySelectionTest");
//
//            ExtentTest test = Reports.getTest();
//            test.log(Status.INFO, "Starting countrySelectionTest at " + getCurrentTime());
//
//            long startTime = System.currentTimeMillis();
//            countryselectionpage.selectCountry(country);
//            Thread.sleep(2000);
//            test.log(Status.INFO, "Successfully searched for country....");
//            countryselectionpage.checkTermsAndConditions();
//            countryselectionpage.proceed();
//            long endTime = System.currentTimeMillis();
//
//            test.log(Status.INFO, "Completed countrySelectionTest at " + getCurrentTime());
//            test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ScreenRecorderUtil.stopRecord();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test(priority = 4, description = "To validate that the testcase successfully prints confirmation message")
//    public void testConfirmationMessage() {
//        try {
//            ScreenRecorderUtil.startRecord("testConfirmationMessage");
//
//            ExtentTest test = Reports.getTest();
//            test.log(Status.INFO, "Starting testConfirmationMessage at " + getCurrentTime());
//
//            long startTime = System.currentTimeMillis();
//            orderconfirmation = new Orderconfirmation(driver);
//            System.out.println("Thank you, your order has been placed successfully\n" +
//                    "You'll be redirected to Home page shortly!!");
//            long endTime = System.currentTimeMillis();
//
//            test.log(Status.INFO, "Completed testConfirmationMessage at " + getCurrentTime());
//            test.log(Status.INFO, "Execution Time: " + (endTime - startTime) + " milliseconds");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ScreenRecorderUtil.stopRecord();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private String getCurrentTime() {
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//        return sdf.format(new Date());
//    }
//}


//---------------

package tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.Countryselectionpage;
import pages.Homepage;
import pages.Orderconfirmation;
import utils.ExcelUtils;
import utils.Reports;
import utils.ScreenRecorderUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Listeners(utils.Listener.class)
public class Tests1 extends BaseTest {
    private Homepage homePage;
    private CartPage cartPage;
    private Countryselectionpage countryselectionpage;
    private Orderconfirmation orderconfirmation;

    private static ThreadLocal<String> testMethodName = new ThreadLocal<>();

    @DataProvider(name = "addToCartData")
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

    @DataProvider(name = "CountrySelectionData")
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
        homePage = new Homepage(driver);
        cartPage = new CartPage(driver);
        countryselectionpage = new Countryselectionpage(driver);
        orderconfirmation = new Orderconfirmation(driver);
    }

    @BeforeMethod
    public void startRecording() {
        try {
            String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
            ScreenRecorderUtil.startRecord(methodName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void stopRecording() {
        try {
            ScreenRecorderUtil.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1, dataProvider = "addToCartData", description = "To validate that the testcase selects the item and adds to cart")
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
    }

    @Test(priority = 2, description = "To validate that the testcase clicks on place order and complete the checkout process")
    public void checkoutTest() {
        ExtentTest test = Reports.getTest();
        test.log(Status.INFO, "Starting checkoutTest at " + getCurrentTime());
        long startTime = System.currentTimeMillis();
        cartPage.completeCheckout();
        test.log(Status.INFO, "Successfully added to cart....");
        long endTime = System.currentTimeMillis();
        test.log(Status.INFO, "Completed checkoutTest at " + getCurrentTime());
    }

    @Test(priority = 3, dataProvider = "CountrySelectionData", description = "To validate that the testcase successfully selects the country")
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
    }

    @Test(priority = 4, description = "To validate that the testcase successfully prints confirmation message")
    public void testConfirmationMessage() {
        ExtentTest test = Reports.getTest();
        test.log(Status.INFO, "Starting testConfirmationMessage at " + getCurrentTime());
        long startTime = System.currentTimeMillis();
        orderconfirmation = new Orderconfirmation(driver);
        System.out.println("Thank you, your order has been placed successfully\n" + "You'll be redirected to Home page shortly!!");
        System.out.println();
        long endTime = System.currentTimeMillis();
        test.log(Status.INFO, "Completed testConfirmationMessage at " + getCurrentTime());
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }
}

