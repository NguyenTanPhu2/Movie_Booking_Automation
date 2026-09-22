package testcase;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CinemaPage;
import pages.HomePage;
import pages.modals.CommonModal;
import report.ExtentReportManager;

public class CinemaTest extends BaseTest {

    /// Page Object
    HomePage homePage;
    CinemaPage cinemaPage;
    CommonModal commonModal;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        cinemaPage = new CinemaPage(driver);
        commonModal = new CommonModal(driver);
    }

    @Test(priority = 1, dataProvider = "cinema-complex",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Cinema_Complex_System_List(String[] cinemaComplex) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///VP 1: Verify Cinema complex 'CGV' is display
        LOG.info("VP 1: Verify Cinema complex 'CGV' is display");
        ExtentReportManager.info("VP 1: Verify Cinema complex 'CGV' is display");
        boolean recordingCGVDisplays = cinemaPage.isCinemaComplexDisPlays(cinemaComplex[0]);
        Assert.assertTrue(recordingCGVDisplays, "Cinema complex is not displayed");

        ///VP 2: Verify Cinema complex 'BHD' is display
        LOG.info("VP 2: Verify Cinema complex 'BHD' is display");
        ExtentReportManager.info("VP 2: Verify Cinema complex 'BHD' is display");
        boolean recordingBHDDisplays = cinemaPage.isCinemaComplexDisPlays(cinemaComplex[1]);
        Assert.assertTrue(recordingBHDDisplays, "Cinema complex is not displayed");
    }

    @Test(priority = 2, dataProvider = "cinema-system-list",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Cinema_List_By_System(String cinemaComplex, String nameCinema) {
        //Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema Complex
        LOG.info("Step 2: Click choose Cinema Complex");
        ExtentReportManager.info("Step 2: Click choose Cinema Complex");
        cinemaPage.clickCinemaComplex(cinemaComplex);

        ///VP : Verify Cinema 'CGV - Pandora City' is display
        LOG.info("VP : Verify Cinema complex 'CGV - Pandora City' is display");
        ExtentReportManager.info("VP : Verify Cinema complex 'CGV - Pandora City' is display");
        boolean recordingCinemaComplex = cinemaPage.isCinemaDisplays(nameCinema);
        Assert.assertTrue(recordingCinemaComplex, "Cinema is not displayed");
    }

    @Test(priority = 3, dataProvider = "cinema-complex-system-switching",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Cinema_System_Switching(String[][] cinemaData) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema
        LOG.info("Step 2: Click choose Cinema CGV ");
        ExtentReportManager.info("Step 2: Click choose Cinema CGV ");
        cinemaPage.clickCinemaComplex(cinemaData[0][0]);

        ///VP 1: Verify Cinema complex 'CGV - Pandora City' is display
        LOG.info("VP 1: Verify Cinema complex 'CGV - Pandora City' is display");
        ExtentReportManager.info("VP 1: Verify Cinema complex 'CGV - Pandora City' is display");
        boolean recordingCgv = cinemaPage.isCinemaDisplays(cinemaData[0][1]);
        Assert.assertTrue(recordingCgv, "Cinema complex is not displayed");

        ///Step 3: Click choose Cinema  BHD
        LOG.info("Step 3: Click choose Cinema BHD ");
        ExtentReportManager.info("Step 3: Click choose Cinema ");
        cinemaPage.clickCinemaComplex(cinemaData[1][0]);

        ///VP 2: Verify Cinema complex 'BHD Star Cineplex - Phạm Hùng' is display
        LOG.info("VP : Verify Cinema complex 'BHD Star Cineplex - Phạm Hùng' is display");
        ExtentReportManager.info("VP : Verify Cinema complex 'BHD Star Cineplex - Phạm Hùng' is display");
        boolean recordingBHD = cinemaPage.isCinemaDisplays(cinemaData[1][1]);
        Assert.assertTrue(recordingBHD, "Cinema complex is not displayed");
    }

    @Test(priority = 4, dataProvider = "cinema-name-address",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Cinema_Name_And_Address(String cinemaComplex, String nameCinema, String address) {

        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema
        LOG.info("Step 2: Click choose Cinema Lotte Complex");
        ExtentReportManager.info("Step 2: Click choose Cinema Lotte Complex");
        cinemaPage.clickCinemaComplex(cinemaComplex);

        ///VP 1: Verify Cinema complex 'Lotte - Phú Thọ' is display
        LOG.info("VP 1: Verify Cinema complex 'Lotte - Phú Thọ' is display");
        ExtentReportManager.info("VP 1: Verify Cinema complex 'Lotte - Phú Thọ' is display");
        boolean recordingLottePhuTho = cinemaPage.isCinemaDisplays(nameCinema);
        Assert.assertTrue(recordingLottePhuTho, "Lotte is not displayed");

        ///VP 2: verify address is displays
        LOG.info("VP 2: verify address is displays");
        ExtentReportManager.info("VP 2: verify address is displays");
        boolean recordingAddress = cinemaPage.isAddressCinema(address);
        Assert.assertTrue(recordingAddress, "Address is not displayed");
    }

    @Test(priority = 5, dataProvider = "cinema-movie",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Movie_List_By_Cinema(String cinemaComplex, String nameCinema, String movieName) {

        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema Complex
        LOG.info("Step 2: Click choose Cinema Complex");
        ExtentReportManager.info("Step 2: Click choose Cinema Complex");
        cinemaPage.clickCinemaComplex(cinemaComplex);

        ///Step 3: Click choose Cinema
        LOG.info("Step 3: Click choose Cinema ");
        ExtentReportManager.info("Step 3: Click choose Cinema ");
        cinemaPage.clickChooseCinema(nameCinema);

        ///VP: verify show move
        LOG.info("VP: verify show move");
        ExtentReportManager.info("VP: verify show move");
        boolean recordingNameMove = cinemaPage.isNameMovieDisplays(movieName);
        Assert.assertTrue(recordingNameMove, "Name move is not displayed");
    }

    @Test(priority = 6, dataProvider = "cinema-poster-schedule",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Movie_Poster_Name_Showtime_Displayed(String cinemaComplex, String nameCinema, String movieName, String schedule) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema Complex
        LOG.info("Step 2: Click choose Cinema Complex");
        ExtentReportManager.info("Step 2: Click choose Cinema Complex");
        cinemaPage.clickCinemaComplex(cinemaComplex);

        ///Step 3: Click choose Cinema
        LOG.info("Step 3: Click choose Cinema ");
        ExtentReportManager.info("Step 3: Click choose Cinema ");
        cinemaPage.clickChooseCinema(nameCinema);

        ///Step 4: Scroll list film on Cinema Area
        LOG.info("Step 4: Scroll list film on Cinema Area");
        ExtentReportManager.info("Step 4: Scroll list film on Cinema Area");
        cinemaPage.internalRoll(movieName);

        ///VP 1: Verify Schedule isDisplay
        LOG.info("VP 1: Verify Schedule isDisplay");
        ExtentReportManager.info("VP 1: Verify Schedule isDisplay");
        boolean recordingSchedule = cinemaPage.isScheduleDisplay(schedule);

        Assert.assertTrue(recordingSchedule, "Schedule is not displayed");

        ///VP 2 : Verify Schedule isDisplay
        LOG.info("VP 2 : Verify Schedule isDisplay");
        ExtentReportManager.info("VP 2 : Verify Schedule isDisplay");
        boolean recordingPoster = cinemaPage.isPosterDisplayed(movieName);
        Assert.assertFalse(recordingPoster, "Poster is displaying the text 'John Cena WWE'");
    }

    @Test(priority = 7, dataProvider = "cinema-available_schedule",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Navigate_To_Booking_With_Available_Schedule(String schedule, String time) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Schedule
        LOG.info("Step 2: Click choose Schedule");
        ExtentReportManager.info("Step 2: Click choose Schedule");
        cinemaPage.clickSchedule(schedule, time);

        ///VP: Verify navigate to BookingPage
        LOG.info("VP: Verify navigate to BookingPage");
        ExtentReportManager.info("VP: Verify navigate to BookingPage");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demo1.cybersoft.edu.vn/purchase/16531", "Current URL is incorrect");
    }

    @Test(priority = 8, dataProvider = "cinema-sold_out_schedule",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Booking_With_Sold_Out_Schedule(String cinemaComplex, String nameCinema, String movieName, String date, String time) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click choose Cinema Complex
        LOG.info("Step 2: Click choose Cinema Complex");
        ExtentReportManager.info("Step 2: Click choose Cinema Complex");
        cinemaPage.clickCinemaComplex(cinemaComplex);

        ///Step 3: Click choose Cinema
        LOG.info("Step 3: Click choose Cinema ");
        ExtentReportManager.info("Step 3: Click choose Cinema ");
        cinemaPage.clickChooseCinema(nameCinema);

        ///Step 4: Scroll list film on Cinema Area
        LOG.info("Step 4: Scroll list film on Cinema Area");
        ExtentReportManager.info("Step 4: Scroll list film on Cinema Area");
        cinemaPage.internalRoll(movieName);

        ///Step 5: Click Schedule Sold Out
        LOG.info("Step 5: Click Schedule Sold Out");
        ExtentReportManager.info("Step 5: Click Schedule Sold Out");
        cinemaPage.clickSchedule(date, time);

        ///Step 6: Verify don't navigate to BookingPage
        LOG.info("Step 6: Verify don't navigate to BookingPage");
        ExtentReportManager.info("VP: Verify don't navigate to BookingPage");
        boolean recordingNavigate = commonModal.isLbMessage();
        Assert.assertTrue(recordingNavigate, "Navigate to BookingPage");
    }

    @Test(priority = 9, dataProvider = "cinema-system-switching",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Cinema_System_Click_Switching(String[][] cinema) {

        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Click Cinema BHD Star Cineplex - 3/2
        LOG.info("Step 2: Click Cinema BHD Star Cineplex - 3/2");
        ExtentReportManager.info("Step 2: Click Cinema BHD Star Cineplex - 3/2");
        cinemaPage.clickChooseCinema(cinema[0][0]);

        ///VP 1: Verify Show list movie
        LOG.info("VP 1: Verify Show list movie");
        ExtentReportManager.info("VP 1: Verify Show list movie");
        cinemaPage.isScheduleDisplay(cinema[0][1]);

        ///Step 3: Click Cinema BHD Star Cineplex - Bitexco
        LOG.info("Step 2: Click Cinema BHD Star Cineplex - Bitexco");
        ExtentReportManager.info("Step 2: Click Cinema BHD Star Cineplex - Bitexco");
        cinemaPage.clickChooseCinema(cinema[1][0]);

        ///VP 2: Verify Show list movie
        LOG.info("VP 2: Verify Show list movie");
        ExtentReportManager.info("VP 2: Verify Show list movie");
        cinemaPage.isScheduleDisplay(cinema[1][1]);
    }

    @Test(priority = 10, dataProvider = "cinema-schedule-buttons-displayed",
            dataProviderClass = TestDataProvider.class, groups = "cinema")
    public void verify_Schedule_Buttons_Displayed(String date) {
        ///Step 1: Click on Cinema
        LOG.info("Step 1: Click on Cinema");
        ExtentReportManager.info("Step 1: Click on Cinema");
        homePage.getTopNavigation().clickOnCinema();

        ///Step 2: Verify button Schedule Display
        LOG.info("Step 2: Verify button Schedule Display");
        ExtentReportManager.info("Step 2: Verify button Schedule Display");
        cinemaPage.isScheduleDisplay(date);
    }
}
