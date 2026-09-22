package testcase;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.components.News;
import report.ExtentReportManager;

public class NewsTest extends BaseTest {
    //Page Object
    HomePage homePage;
    News news;


    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        news = new News(driver);
    }

    @Test(priority = 1, dataProvider = "news-tag",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_News_Section_Displayed(String[] tagName) {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///VP 1: Verify 'Điện Ảnh 24h'
        LOG.info("VP 1: Verify 'Điện Ảnh 24h'");
        ExtentReportManager.info("VP 1: Verify 'Điện Ảnh 24h'");
        boolean recordingNews = news.isTagDisplay(tagName[0]);
        Assert.assertTrue(recordingNews, "News is not displayed");

        ///VP 2: Verify 'Review'
        LOG.info("VP 2: Verify 'Review'");
        ExtentReportManager.info("VP 2: Verify 'Review'");
        boolean recordingReview = news.isTagDisplay(tagName[1]);
        Assert.assertTrue(recordingReview, "News is not displayed");

        ///VP 3: Verify 'Khuyến mãi'
        LOG.info("VP 2: Verify 'Khuyến mãi'");
        ExtentReportManager.info("VP 2: Verify 'Khuyến mãi'");
        boolean recordingDiscount = news.isTagDisplay(tagName[2]);
        Assert.assertTrue(recordingDiscount, "News is not displayed");

    }

    @Test(priority = 2, groups = "news")
    public void verify_News_Section_Layout() {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///VP: Verify body News Show
        LOG.info("VP: Verify body News Show");
        ExtentReportManager.info("VP: Verify body News Show");
        boolean recordingNews = news.isViewBodyDisplayed();
        Assert.assertTrue(recordingNews, "News is not displayed");
    }

    @Test(priority = 3, dataProvider = "news-tag",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_Review_Tab(String[] tagName) {

        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click tag 'Review'
        LOG.info("Step 2: Click tag 'Review'");
        ExtentReportManager.info("Step 2: Click tag 'Review'");
        news.clickNewsTag(tagName[1]);

        ///Step 3: Click 'Extra View'
        LOG.info("Step 3: Click 'Extra View'");
        ExtentReportManager.info("Step 3: Click 'Extra View'");
        news.clickExtra();

        ///VP: Verify body News Show
        LOG.info("VP: Verify body News Show");
        ExtentReportManager.info("VP: Verify body News Show");
        boolean recordingNews = news.isViewBodyDisplayed();
        Assert.assertTrue(recordingNews, "News is not displayed");
    }

    @Test(priority = 4, dataProvider = "news-tag",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_Promotion_Tab(String[] tagName) {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click tag 'Discount'
        LOG.info("Step 2: Click tag 'Discount'");
        ExtentReportManager.info("Step 2: Click tag 'Discount'");
        news.clickNewsTag(tagName[2]);

        ///Step 3: Click 'Extra View'
        LOG.info("Step 3: Click 'Extra View'");
        ExtentReportManager.info("Step 3: Click 'Extra View'");
        news.clickExtra();

        ///VP: Verify body News Show
        LOG.info("VP: Verify body News Show");
        ExtentReportManager.info("VP: Verify body News Show");
        boolean recordingNews = news.isViewBodyDisplayed();
        Assert.assertTrue(recordingNews, "News is not displayed");
    }

    @Test(priority = 5, dataProvider = "news-big-article",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_Large_News_Article_Navigation(String[][] titleBigNews) {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///Step 3: Click on Big News
        LOG.info("Step 3: Click on Big News");
        ExtentReportManager.info("Step 3: Click on Big News");
        news.clickTitleNews(titleBigNews[1][0]);

        ///VP: Verify navigate to News Page successfully
        LOG.info("VP: Verify navigate to News Page successfully");
        ExtentReportManager.info("VP: Verify navigate to News Page successfully");
        // Switch sang tab mới
        news.switchToNewTab();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, titleBigNews[1][1], "Current URL is incorrect");
    }

    @Test(priority = 6, dataProvider = "news-small-article",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_Small_News_Article_Navigation(String[][] titleSmallNews) {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///Step 3: Click on Small News
        LOG.info("Step 3: Click on Small News");
        ExtentReportManager.info("Step 3: Click on Small News");
        news.clickTitleNews(titleSmallNews[0][0]);

        ///VP: Verify navigate to News Page successfully
        LOG.info("VP: Verify navigate to News Page successfully");
        ExtentReportManager.info("VP: Verify navigate to News Page successfully");
        // Switch sang tab mới
        news.switchToNewTab();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, titleSmallNews[0][1], "Current URL is incorrect");
    }

    @Test(priority = 7, dataProvider = "news-medium-article",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_Medium_News_Article_Navigation(String[][] titleMediumNews) {

        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///Step 3: Click on Medium News
        LOG.info("Step 3: Click on Medium News");
        ExtentReportManager.info("Step 3: Click on Medium News");
        news.clickTitleNews(titleMediumNews[0][0]);

        ///VP: Verify navigate to News Page successfully
        LOG.info("VP: Verify navigate to News Page successfully");
        ExtentReportManager.info("VP: Verify navigate to News Page successfully");
        // Switch sang tab mới
        news.switchToNewTab();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, titleMediumNews[0][1], "Current URL is incorrect");
    }

    @Test(priority = 8, groups = "news")
    public void verify_View_More_Button_Displayed() {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///VP: Verify btn Extra displays
        LOG.info("VP: Verify btn Extra displays");
        ExtentReportManager.info("VP: Verify btn Extra displays");
        boolean recordingBtnExtra = news.isExtraDisplays();
        Assert.assertTrue(recordingBtnExtra, "Extra button is not displayed");
    }

    @Test(priority = 9, dataProvider = "news-tag",
            dataProviderClass = TestDataProvider.class, groups = "news")
    public void verify_View_More_Loads_More_News(String[] tagName) {
        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///Step 3: Click tag 'Review'
        LOG.info("Step 3: Click tag 'Review'");
        ExtentReportManager.info("Step 3: Click tag 'Review'");
        news.clickNewsTag(tagName[1]);

        ///VP: Verify body News Show
        LOG.info("VP: Verify body News Show");
        ExtentReportManager.info("VP: Verify body News Show");
        boolean recordingNews = news.isViewBodyDisplayed();
        Assert.assertTrue(recordingNews, "News is not displayed");
    }

    @Test(priority = 10, groups = "news")
    public void verify_Collapse_Function() {

        ///Step 1: Click on News
        LOG.info("Step 1: Click on News");
        ExtentReportManager.info("Step 1: Click on News");
        homePage.getTopNavigation().clickOnNews();

        ///Step 2: Click 'Extra View'
        LOG.info("Step 2: Click 'Extra View'");
        ExtentReportManager.info("Step 2: Click 'Extra View'");
        news.clickExtra();

        ///Step 3: Click 'Collapse'
        LOG.info("Step 3: Click 'Collapse'");
        ExtentReportManager.info("Step 3: Click 'Collapse'");
        news.clickCollapse();

        ///VP: Verify body News Show
        LOG.info("VP: Verify body News Show");
        ExtentReportManager.info("VP: Verify body News Show");
        boolean recordingNews = news.isViewBodyDisplayed();
        Assert.assertFalse(recordingNews, "News is not displayed");
    }

    @Test(priority = 11, groups = "news")
    public void verify_View_More_And_Collapse_On_Mobile() {
        ///Step 1: Switch to mobile Phone
        LOG.info("Step 1: Switch to mobile Phone");
        ExtentReportManager.info("Step 1: Switch to mobile Phone");
        news.switchToPhone();

        ///Step 2: Click menu
        LOG.info("Step 2: Click menu");
        ExtentReportManager.info("Step 2: Click menu");
        homePage.getTopNavigation().clickMenu();

        ///Step 3: Click 'News'
        LOG.info("Step 3: Click 'News'");
        ExtentReportManager.info("Step 3:Click 'News'");
        homePage.getTopNavigation().clickOnNews();

        homePage.clickOutside();

        ///Step 4: Click Extra
        LOG.info("Step 4: Click Extra");
        ExtentReportManager.info("Step 4: Click Extra");
        news.clickExtra();

        ///VP 1: Verify Body news displays
        LOG.info("VP 1: Verify Body news displays");
        ExtentReportManager.info("VP 1: Verify Body news displays");
        Assert.assertTrue(news.isViewBodyDisplayed(), "News body is not displayed after tapping View More on mobile");

        ///Step 6: Click Collapse
        LOG.info("Step 6: Click Collapse");
        ExtentReportManager.info("Step 6: Click Collapse");
        news.clickCollapse();

        ///VP 2: Verify Body news undisplays
        LOG.info("VP 2: Verify Body news undisplays");
        ExtentReportManager.info("VP 2: Verify Body news undisplays");
        Assert.assertFalse(news.isViewBodyDisplayed(), "News body is still displayed after collapsing on mobile");
    }
}
