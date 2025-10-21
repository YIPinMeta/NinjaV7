package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.RetryAnalyzer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TC02_Login extends BaseClass {

    // Create Log4j logger
    private static final Logger logger = LogManager.getLogger(TC02_Login.class);

    @Test(
        groups = {"sanity", "regression", "data-driven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = RetryAnalyzer.class
    )
    void testLogin(String email, String pwd) {
        logger.info("===== Starting TC02_Login Test with user: " + email + " =====");

        try {
            HomePage hp = new HomePage(getDriver());
            logger.debug("HomePage object created successfully.");

            hp.clickMyAccount();
            logger.debug("Clicked on 'My Account' link.");

            hp.goToLogin();
            logger.debug("Navigated to Login page.");

            LoginPage lp = new LoginPage(getDriver());
            lp.setEmail(email);
            logger.debug("Entered email: " + email);

            lp.setPwd(pwd);
            logger.debug("Entered password.");

            lp.clickLogin();
            logger.debug("Clicked on Login button.");

            AccountPage ap = new AccountPage(getDriver());
            boolean status = ap.getMyAccountConfirmation().isDisplayed();
            logger.debug("My Account confirmation displayed: " + status);

            if (status) {
                logger.info("Login successful for user: " + email);
                ap.clickMyAccountDropDown();
                ap.clickLogout();
                logger.debug("User logged out successfully.");
                Assert.assertTrue(status, "Login was successful but assertion failed unexpectedly.");
            } else {
                logger.warn("Login failed for user: " + email);
                Assert.fail("Login not successful for user: " + email);
            }

        } catch (AssertionError e) {
            logger.error("Assertion failed in TC02_Login for user: " + email + " — " + e.getMessage());
            throw e; // Re-throw to mark test as failed
        } catch (Exception e) {
            logger.error("Unexpected exception occurred during login test for user: " + email, e);
            throw e;
        } finally {
            logger.info("===== Ending TC02_Login Test for user: " + email + " =====");
        }
    }
}
