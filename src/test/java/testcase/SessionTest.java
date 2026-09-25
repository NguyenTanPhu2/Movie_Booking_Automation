package testcase;

import base.BaseTest;
import data.TestDataProvider;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.components.LogOut;
import pages.modals.CommonModal;
import report.ExtentReportManager;

public class SessionTest extends BaseTest {

    /// Page Object
    HomePage homePage;
    LoginPage loginPage;
    CommonModal commonModal;
    LogOut logOut;

    private String getTokenFromStorage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript(
                "for (let i = 0; i < localStorage.length; i++) { " +
                        "const key = localStorage.key(i); " +
                        "if (key && /(token|auth|jwt|access)/i.test(key)) { " +
                        "const value = localStorage.getItem(key); " +
                        "if (value && value.trim() !== '') return value; " +
                        "} " +
                        "} return null;"
        );
    }

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        commonModal = new CommonModal(driver);
        logOut = new LogOut(driver);
    }

    @Test(priority = 1, dataProvider = "login-credentials", dataProviderClass = TestDataProvider.class, groups = "session")
    public void verify_Login_Status_After_Refresh(String account, String password) {
        ///Step 1: Navigate to LoginPage
        LOG.info("Step 1: Navigate to LoginPage");
        ExtentReportManager.info("Step 1: Navigate to LoginPage");
        homePage.getTopNavigation().navigateToLoginPage();

        ///Step 2: Login account
        LOG.info("Step 2: Login account");
        ExtentReportManager.info("Step 2: Login account");
        loginPage.login(account, password);

        if (commonModal.isLbMessage()) {
            commonModal.waitModalDisappear();
        }

        ///Step 3: Refresh page
        LOG.info("Step 3: Refresh page");
        ExtentReportManager.info("Step 3: Refresh page");
        homePage.refreshPage();

        ///VP: Verify user remains logged in after refresh
        LOG.info("VP: Verify user remains logged in after refresh");
        ExtentReportManager.info("VP: Verify user remains logged in after refresh");
        boolean recordingRefresh = homePage.getTopNavigation().isLogOutDisplays();
        Assert.assertTrue(recordingRefresh, "User should remain logged in after page refresh");
    }

    @Test(priority = 2, dataProvider = "login-credentials", dataProviderClass = TestDataProvider.class, groups = "session")
    public void verify_Session_Token_Created_After_Login(String account, String password) {
        ///Step 1: Navigate to LoginPage
        LOG.info("Step 1: Navigate to LoginPage");
        ExtentReportManager.info("Step 1: Navigate to LoginPage");
        homePage.getTopNavigation().navigateToLoginPage();

        ///Step 2: Login account
        LOG.info("Step 2: Login account");
        ExtentReportManager.info("Step 2: Login account");
        loginPage.login(account, password);
        commonModal.waitModalDisappear();

        ///VP: Verify session token is created after login
        LOG.info("VP: Verify session token is created after login");
        ExtentReportManager.info("VP: Verify session token is created after login");

        String token = getTokenFromStorage();

        Assert.assertTrue(token != null && !token.isEmpty(), "Session token should be created after login");
    }

    @Test(priority = 3, dataProvider = "login-credentials", dataProviderClass = TestDataProvider.class, groups = "session")
    public void verify_Login_Required_After_Token_Expiration(String account, String password) {
        ///Step 1: Navigate to LoginPage
        LOG.info("Step 1: Navigate to LoginPage");
        ExtentReportManager.info("Step 1: Navigate to LoginPage");
        homePage.getTopNavigation().navigateToLoginPage();

        ///Step 2: Login account
        LOG.info("Step 2: Login account");
        ExtentReportManager.info("Step 2: Login account");
        loginPage.login(account, password);


        ///Step 3: Remove token-like entries and refresh page
        LOG.info("Step 3: Remove token-like entries and refresh page");
        ExtentReportManager.info("Step 3: Remove token-like entries and refresh page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("for (let i = localStorage.length - 1; i >= 0; i--) { const key = localStorage.key(i); if (key && /(token|auth|jwt|access)/i.test(key)) { localStorage.removeItem(key); } }");
        homePage.refreshPage();

        ///VP: Verify login is required after token expiration
        LOG.info("VP: Verify login is required after token expiration");
        ExtentReportManager.info("VP: Verify login is required after token expiration");
        Assert.assertTrue(homePage.getTopNavigation().isLoginDisplays(), "User should be required to log in after token expiration");
    }

    @Test(priority = 4, dataProvider = "login-credentials", dataProviderClass = TestDataProvider.class, groups = "session")
    public void verify_Login_Status_After_Logout_And_Refresh(String account, String password) {
        ///Step 1: Navigate to LoginPage
        LOG.info("Step 1: Navigate to LoginPage");
        ExtentReportManager.info("Step 1: Navigate to LoginPage");
        homePage.getTopNavigation().navigateToLoginPage();

        ///Step 2: Login account
        LOG.info("Step 2: Login account");
        ExtentReportManager.info("Step 2: Login account");
        loginPage.login(account, password);
        commonModal.waitModalDisappear();

        ///Step 3: Click logout
        LOG.info("Step 3: Click logout");
        ExtentReportManager.info("Step 3: Click logout");
        homePage.getTopNavigation().clickOnLogOut();

        ///Step 4: Confirm logout
        LOG.info("Step 4: Confirm logout");
        ExtentReportManager.info("Step 4: Confirm logout");
        logOut.clickConfirmLogOut();

        ///Step 5: Refresh page
        LOG.info("Step 5: Refresh page");
        ExtentReportManager.info("Step 5: Refresh page");
        homePage.refreshPage();

        ///VP: Verify user remains logged out after refresh
        LOG.info("VP: Verify user remains logged out after refresh");
        ExtentReportManager.info("VP: Verify user remains logged out after refresh");
        Assert.assertTrue(homePage.getTopNavigation().isLoginDisplays(), "User should remain logged out after logout and page refresh");
    }
}
