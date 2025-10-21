package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CatalogPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC03_AddToCart extends BaseClass {

    // Create Log4j logger
    private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testAddToCart() throws InterruptedException {
        logger.info("===== Starting TC03_AddToCart Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            hp.clickLapAndNote();
            logger.debug("Clicked 'Laptops & Notebooks' link on homepage.");

            hp.goToLapAndNoteCatalog();
            logger.debug("Navigated to Laptops & Notebooks catalog page.");

            CatalogPage cp = new CatalogPage(getDriver());
            cp.locateLaptop();
            logger.debug("Located desired laptop in catalog.");

            ProductPage pp = new ProductPage(getDriver());
            pp.setDeliveryDate();
            logger.debug("Set delivery date on product page.");

            pp.AddToCart();
            logger.debug("Clicked 'Add to Cart' button.");

            String successMsg = pp.verify_SuccessMsg();
            logger.debug("Success message received: " + successMsg);

            Assert.assertTrue(successMsg.contains("Success"), 
                              "Add to cart message did not contain 'Success'!");
            logger.info("Assertion passed: Product successfully added to cart.");

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC03_AddToCart: " + e.getMessage());
            throw e;  // rethrow so TestNG marks the test as failed
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during AddToCart test.", e);
            throw e;
        } finally {
            logger.info("===== Ending TC03_AddToCart Test =====");
        }
    }
}
