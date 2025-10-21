package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AffiliatePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC06_AddAffiliate extends BaseClass {

    // Create Log4j logger
    private static final Logger logger = LogManager.getLogger(TC06_AddAffiliate.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testAddAffiliate() throws InterruptedException {
        logger.info("===== Starting TC06_AddAffiliate Test =====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            hp.clickAffilate();
            logger.debug("Clicked on 'Affiliate' link from home page.");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail("K.anderson030419@gmail.com");
            logger.debug("Entered affiliate user email.");

            lp.setPwd("Test_123");
            logger.debug("Entered affiliate user password.");

            lp.clickLogin();
            logger.debug("Clicked Login button.");

            AffiliatePage afp = new AffiliatePage(getDriver());
            afp.completeForm();
            logger.debug("Completed affiliate registration form.");

            boolean status = afp.Confirm().isDisplayed();
            logger.debug("Affiliate confirmation display status: " + status);

            Assert.assertTrue(status, "Affiliate confirmation message not displayed!");
            logger.info("Assertion passed: Affiliate registration confirmed successfully.");

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC06_AddAffiliate: " + e.getMessage());
            throw e; // Rethrow for TestNG failure reporting
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during AddAffiliate test.", e);
            throw e;
        } finally {
            logger.info("===== Ending TC06_AddAffiliate Test =====");
        }
    }
}
