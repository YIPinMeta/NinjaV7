package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC01_LaunchApplication extends BaseClass {

    // Create Log4j logger for this class
    private static final Logger logger = LogManager.getLogger(TC01_LaunchApplication.class);

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    void testLaunchApplication() {
        logger.info("===== Starting TC01_LaunchApplication Test =====");
        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            String title = getDriver().getTitle();
            logger.debug("Page title fetched: " + title);

            Assert.assertEquals(title, "Your store of fun", "Page title does not match!");
            logger.info("Assertion passed: Title matches expected value.");

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC01_LaunchApplication: " + e.getMessage());
            throw e;  // Re-throw to mark test as failed in TestNG
        } catch (Exception e) {
            logger.error("Unexpected exception occurred: " + e.getMessage(), e);
            throw e;  // Re-throw for TestNG failure reporting
        } finally {
            logger.info("===== Ending TC01_LaunchApplication Test =====");
        }
    }
}
