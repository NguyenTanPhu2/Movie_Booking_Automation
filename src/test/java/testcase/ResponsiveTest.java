package testcase;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.components.Banner;
import pages.components.Footer;
import report.ExtentReportManager;

public class ResponsiveTest extends BaseTest {

    private HomePage homePage;
    private Footer footer;
    private Banner banner;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        footer = new Footer(driver);
        banner = new Banner(driver);
    }

    @Test(priority = 1, groups = "responsive")
    public void verify_Responsive_Layout_On_Desktop() {

        ///VP: Verify Desktop layout
        LOG.info("VP: Verify Desktop layout");
        ExtentReportManager.info("VP: Verify Desktop layout");

        int width = driver.manage().window().getSize().getWidth();

        Assert.assertTrue(width >= 1024, "Browser viewport is not in Desktop size. Current width: " + width
        );
    }

    @Test(priority = 2, groups = "responsive")
    public void verify_Header_Responsive_Layout_On_Tablet_Mobile() {
        //Step 1: Switch to Mobile
        LOG.info("Step 1: Switch to Mobile");
        ExtentReportManager.info("Step 1: Switch to Mobile");
        homePage.switchToPhone();

        ///VP 1: Verify Logo Mobile Layout
        LOG.info("VP 1: Verify Logo Mobile Layout");
        ExtentReportManager.info("VP 1: Verify Logo Mobile Layout");

        boolean recordingLogoMobile = homePage.getTopNavigation().isLogo();

        Assert.assertTrue(recordingLogoMobile, "Logo is not displayed correctly on Mobile");

        ///Step 2: Verify Mobile Menu
        LOG.info("Step 2: Verify Mobile Menu");
        ExtentReportManager.info("Step 2: Verify Mobile Menu");

        homePage.getTopNavigation().clickMenu();

        boolean recordingMenu = homePage.getTopNavigation().isMenuDisplay();

        Assert.assertTrue(recordingMenu, "Mobile menu is not displayed");
    }

    @Test(priority = 3, groups = "responsive")
    public void verify_Banner_Responsive_Layout() {
        /// VP: Banner on Desktop
        LOG.info("VP: Banner on Desktop");
        ExtentReportManager.info("VP: Banner on Desktop");
        Assert.assertTrue(banner.isAltTextDisplayed(), "Banner is not displayed on Desktop");
        banner.switchToPhone();

        banner.refreshPage();

        /// VP: Banner on Phone
        LOG.info("VP: Banner on Phone");
        ExtentReportManager.info("VP: Banner on Phone");
        Assert.assertTrue(banner.isAltTextDisplayed(), "Banner is not displayed on Phone");
    }

    @Test(priority = 4, groups = "responsive")
    public void verify_Movie_Grid_Responsive_Layout() {
        ///VP 1:Verify Grid Movie on desktop
        LOG.info("VP 1: Verify Grid Movie on desktop");
        ExtentReportManager.info("VP 1: Verify Grid Movie on desktop");
        boolean recordingDeskTopMovieList = homePage.isScheduleDisplays();
        Assert.assertTrue(recordingDeskTopMovieList, "Movie list is not displayed");

        ///Step 1: Switch to mobile
        LOG.info("Step 1: Switch to mobile");
        ExtentReportManager.info("Step 1: Switch to mobile");
        homePage.switchToPhone();

        ///VP 2: Verify Grid Movie on Mobile
        LOG.info("VP 2: Verify Grid Movie on Mobile");
        ExtentReportManager.info("VP 2: Verify Grid Movie on Mobile");
        boolean recordingMobileMovieList = homePage.isScheduleDisplays();
        Assert.assertTrue(recordingMobileMovieList, "Movie list is not displayed");

    }

    @Test(priority = 5, groups = "responsive")
    public void verify_News_Section_Responsive_Layout() {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///VP 1: Verify News Display on Desktop
        LOG.info("VP 1: Verify News Display on Desktop");
        ExtentReportManager.info("VP 1: Verify News Display on Desktop");
        boolean recordingNewsOnDesktop = homePage.getTopNavigation().isNews();
        Assert.assertTrue(recordingNewsOnDesktop, "News list is not displayed");

        ///Step 2: Switch to mobile
        LOG.info("Step 2: Switch to mobile");
        ExtentReportManager.info("Step 2: Switch to mobile");
        homePage.switchToPhone();

        ///Step 3: Click Menu
        LOG.info("Step 3: Click menu");
        ExtentReportManager.info("Step 3: Click menu");
        homePage.getTopNavigation().clickMenu();

        ///Step 4: Click 'News'
        LOG.info("Step 4: Click 'News'");
        ExtentReportManager.info("Step 4:Click 'News'");
        homePage.getTopNavigation().clickOnNews();

        homePage.clickOutside();

        ///VP 2: Verify News Display on Mobile
        LOG.info("VP 2: Verify News Display on Mobile");
        ExtentReportManager.info("VP 2: Verify News Display on Mobile");
        boolean recordingNewsOnMobile = homePage.getTopNavigation().isNews();
        Assert.assertTrue(recordingNewsOnMobile, "News list is not displayed");
    }

    @Test(priority = 6, groups = "responsive")
    public void verify_Footer_Responsive_Layout() {
        ///Step 1: Scroll to footer
        LOG.info("Step 1: Scroll to footer");
        ExtentReportManager.info("Step 1: Scroll to footer");
        footer.scroll();

        ///VP 1: Verify footer displays on Desktop
        LOG.info("VP 1: Verify footer displays on Desktop");
        ExtentReportManager.info("VP 1: Verify footer displays on Desktop");
        boolean recordingFooterDesktop = footer.isFooter();
        Assert.assertTrue(recordingFooterDesktop, "Footer is not displayed on Desktop");

        ///Step 2: Switch to mobile
        LOG.info("Step 2: Switch to mobile");
        ExtentReportManager.info("Step 2: Switch to mobile");
        homePage.switchToPhone();

        ///Step 3: Scroll to footer
        LOG.info("Step 3: Scroll to footer");
        ExtentReportManager.info("Step 3: Scroll to footer");
        footer.scroll();

        ///VP 2: Verify footer displays on Mobile
        LOG.info("VP 2: Verify footer displays on Mobile");
        ExtentReportManager.info("VP 2: Verify footer displays on Mobile");
        boolean recordingFooterMobile = footer.isFooter();
        Assert.assertTrue(recordingFooterMobile, "Footer is not displayed on Mobile");
    }
}
