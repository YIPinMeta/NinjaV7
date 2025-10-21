package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CatalogPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC04_CompletePurchase extends BaseClass {

    // Create Log4j logger
    private static final Logger logger = LogManager.getLogger(TC04_CompletePurchase.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    void addToCart() throws InterruptedException {
        logger.info("===== Starting TC04_CompletePurchase Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            hp.clickLapAndNote();
            logger.debug("Clicked on 'Laptops & Notebooks' link.");

            hp.goToLapAndNoteCatalog();
            logger.debug("Navigated to Laptops & Notebooks catalog page.");

            CatalogPage cp = new CatalogPage(getDriver());
            cp.locateLaptop();
            logger.debug("Located target laptop on catalog page.");

            ProductPage pp = new ProductPage(getDriver());
            pp.setDeliveryDate();
            logger.debug("Set delivery date on Product page.");

            pp.AddToCart();
            logger.debug("Clicked 'Add to Cart' button.");

            CheckoutPage chp = new CheckoutPage(getDriver());
            chp.scrollToCheckout();
            logger.debug("Scrolled to Checkout section.");

            chp.goToLogin();
            logger.debug("Navigated to login page from checkout.");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("k.anderson030419@gmail.com");
            logger.debug("Entered email for login.");

            lp.setPwd("Test_123");
            logger.debug("Entered password for login.");

            lp.clickLogin();
            logger.debug("Clicked Login button.");

            chp.completeCheckout();
            logger.debug("Completed checkout process.");

            ConfirmationPage conp = new ConfirmationPage(getDriver());
            boolean confirmationStatus = conp.Confirmation();
            logger.debug("Order confirmation status: " + confirmationStatus);

            Assert.assertTrue(confirmationStatus, "Order placement failed!");
            logger.info("Assertion passed: Order placed successfully.");

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC04_CompletePurchase: " + e.getMessage());
            throw e; // rethrow to fail the test in TestNG
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during Complete Purchase test.", e);
            throw e;
        } finally {
            logger.info("===== Ending TC04_CompletePurchase Test =====");
        }
    }
}
