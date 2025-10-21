package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CatalogPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC05_AddToWishList extends BaseClass {

    // Create Log4j logger
    private static final Logger logger = LogManager.getLogger(TC05_AddToWishList.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testAddToWishList() throws InterruptedException {
        logger.info("===== Starting TC05_AddToWishList Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            hp.clickMyAccount();
            logger.debug("Clicked on 'My Account' link.");

            hp.goToLogin();
            logger.debug("Navigated to login page.");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("K.anderson030419@gmail.com");
            logger.debug("Entered email for login.");

            lp.setPwd("Test_123");
            logger.debug("Entered password for login.");

            lp.clickLogin();
            logger.debug("Clicked Login button.");

            Thread.sleep(500); // optional short pause for stability
            logger.debug("Waited briefly after login to ensure page load.");

            hp.clickLapAndNote();
            logger.debug("Clicked on 'Laptops & Notebooks' link.");

            hp.goToLapAndNoteCatalog();
            logger.debug("Navigated to Laptops & Notebooks catalog page.");

            CatalogPage cp = new CatalogPage(getDriver());
            cp.locateLaptop();
            logger.debug("Located target laptop on catalog page.");

            ProductPage pp = new ProductPage(getDriver());
            pp.ClickWishlist();
            logger.debug("Clicked 'Add to Wishlist' button.");

            String status = pp.verify_SuccessMsg();
            logger.debug("Success message received: " + status);

            Assert.assertTrue(status.contains("Success"), "Wishlist success message was not displayed!");
            logger.info("Assertion passed: Wishlist success message displayed correctly.");

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC05_AddToWishList: " + e.getMessage());
            throw e; // rethrow for TestNG to mark test as failed
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during AddToWishList test.", e);
            throw e;
        } finally {
            logger.info("===== Ending TC05_AddToWishList Test =====");
        }
    }
}
