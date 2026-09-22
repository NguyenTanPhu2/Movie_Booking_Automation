package testcase;

import base.BaseTest;
import data.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MovieDetailPage;
import pages.components.Searching;
import report.ExtentReportManager;

public class MovieDetailTest extends BaseTest {

    /// Page Object
    HomePage homePage;
    MovieDetailPage movieDetailPage;
    Searching searching;

    @BeforeMethod
    public void initializePages() {
        homePage = new HomePage(driver);
        movieDetailPage = new MovieDetailPage(driver);
        searching = new Searching(driver);
    }

    @Test(priority = 1, dataProvider = "movie-age-rating",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Movie_List_And_Age_Rating_Displayed(String[] movieName, String tagAge) {
        ///VP 1: Kiem tra Hien thi ten film
        LOG.info("VP 1: Kiem tra Hien thi ten film");
        ExtentReportManager.info("VP 1: Kiem tra Hien thi ten film");
        boolean recordingNameFilm = homePage.isMovieName(movieName[0]);
        Assert.assertTrue(recordingNameFilm, "Movie is not displayed");

        ///VP 2: Kiem tra hien thi age Rating
        LOG.info("VP 2: Kiem tra hien thi age Rating");
        ExtentReportManager.info("VP 2: Kiem tra hien thi age Rating");
        boolean recordingAgeRating = homePage.isAgeRating(movieName[0], tagAge);
        Assert.assertTrue(recordingAgeRating, "Age Rating is not displayed");
    }

    @Test(priority = 2, dataProvider = "movie-list",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Buy_Ticket_Button_On_Hover(String[] movieName) {
        ///Step 1: hover on film
        LOG.info("Step 1: Hover on film");
        ExtentReportManager.info("Step 1: Hover on film");
        homePage.hoverMouse(movieName[0]);

        ///VP: button play video display
        LOG.info("VP: Button play video display");
        ExtentReportManager.info("VP: Button play video display");
        boolean recordingBtnPlayVideo = homePage.isBntBooking(movieName[0]);
        Assert.assertTrue(recordingBtnPlayVideo, "Video is not displayed");
    }

    @Test(priority = 3, dataProvider = "movie-list",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Play_Trailer_Button(String[] movieName) {
        ///Step 1: hover on film
        LOG.info("Step 1: Hover on film");
        ExtentReportManager.info("Step 1: Hover on film");
        homePage.hoverMouse(movieName[0]);

        ///Step 2: Click btn Play video
        LOG.info("Step 2: Click btn Play video");
        ExtentReportManager.info("Step 2: Click btn Play video");
        homePage.clickPlayVideo(movieName[0]);

        ///VP: Popup Trailer display
        LOG.info("VP: Popup Trailer display");
        ExtentReportManager.info("VP: Popup Trailer display");
        boolean recordingPopup = homePage.isPopup();
        Assert.assertTrue(recordingPopup, "Popup is not displayed");
    }

    @Test(priority = 4, dataProvider = "movie-pagination",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Movie_List_Pagination(int[] index) {

        ///Step 1: Scroll den cuoi danh sach film
        LOG.info("Step 1: Scroll den cuoi danh sach film");
        ExtentReportManager.info("Step 1: Scroll den cuoi danh sach film");
        homePage.scroll();

        ///Step 2: click chuyen sang danh sach phim khac
        LOG.info("Step 2: click chuyen qua danh sach phim khac");
        ExtentReportManager.info("Step 2: click chuyen qua danh sach phim khac");
        homePage.clickStrangePageFilmList(index[1]);
    }

    @Test(priority = 5, dataProvider = "movie-detail",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Movie_Detail_From_Home_Page(String movieName, int index) {
        ///Step 1: Croll den cuoi danh sach film
        LOG.info("Step 1: Scroll den cuoi danh sach film");
        ExtentReportManager.info("Step 1: Scroll den cuoi danh sach film");
        homePage.scrollSchdule();

        ///Step 2: click trang danh sach phim
        LOG.info("Step 2: click trang danh sach phim");
        ExtentReportManager.info("Step 2: click trang danh sach phim");
        homePage.clickStrangePageFilmList(index);

        ///Step 3: Click on ten phim 'Dia Dao'
        LOG.info("Step 3: Click on ten phim 'Dia Dao'");
        ExtentReportManager.info("Step 3: Click on ten phim 'Dia Dao'");
        homePage.clickOnMovieName(movieName);

        ///VP: Navigate to Movie Detail page successfully
        LOG.info("VP: Navigate to Movie Detail page successfully");
        ExtentReportManager.info("VP: Navigate to Movie Detail page successfully");
        boolean recordingNameFilmDisplay = movieDetailPage.isNameFilmDisplayed(movieName);
        Assert.assertTrue(recordingNameFilmDisplay, "Movie Detail page is not displayed");
    }

    @Test(priority = 6, dataProvider = "movie-search-result",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Movie_Detail_From_Search_Result(String movieName) {

        homePage.openHalfScreen();
        ///Step 1: Enter Name film and searching
        LOG.info("Step 1:  Enter Name film and searching");
        ExtentReportManager.info("Step 1:  Enter Name film and searching");
        searching.enterMovieName(movieName);

        ///Step 2: Navigate to MovieDetailPage
        LOG.info("Step 2: Navigate To MovieDetailPage");
        ExtentReportManager.info("Step 2: Navigate To MovieDetailPage");
        homePage.clickOnMovieName(movieName);

        ///VP: Hien thi film
        LOG.info("VP: Hien thi film");
        ExtentReportManager.info("VP: Hien thi film");
        String recordingFilmDisplay = movieDetailPage.getTextNameMovie();
        Assert.assertEquals(recordingFilmDisplay, movieName, "Movie is not displayed");
    }

    @Test(priority = 7, dataProvider = "movie-duration-rating",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Movie_Name_Duration_And_Rating(String movieName, String duration) {

        ///Step 1: Click movieName
        LOG.info("Step 1: Click movieName");
        ExtentReportManager.info("Step 1: Click movieName");
        homePage.clickOnMovieName(movieName);

        ///VP1: Verify movieName is display
        LOG.info("VP1: Verify movieName is display");
        ExtentReportManager.info("VP1: Verify movieName is display");

        String recordingNameFilm = movieDetailPage.getTextNameMovie();
        Assert.assertEquals(recordingNameFilm, movieName, "Movie Name is displayed");

        ///VP 2: Verify Duration is correctly
        LOG.info("VP 2: Verify Duration is correctly");
        ExtentReportManager.info("VP 2: Verify Duration is correctly");
        String recordingDuration = movieDetailPage.getDuration();
        Assert.assertEquals(recordingDuration, duration, "Duration is not correctly");

        ///VP 3: Verify Rating is displays
        LOG.info("VP 3: Verify Rating is displays");
        ExtentReportManager.info("VP 3: Verify Rating is displays");
        boolean recordingRating = movieDetailPage.istRating();
        Assert.assertTrue(recordingRating, "Rating is correctly");
    }

    @Test(priority = 8, dataProvider = "movie-list",
            dataProviderClass = TestDataProvider.class, groups = "movie-detail")
    public void verify_Cinema_And_Schedule(String[] movieName) {
        ///Step 1: Navigate movie detail
        LOG.info("Step 1: Navigate movie detail");
        ExtentReportManager.info("Step 1: Navigate movie detail");
        homePage.clickOnMovieName(movieName[2]);

        ///Step 2: Click Booking
        LOG.info("Step 2: Click Booking");
        ExtentReportManager.info("Step 2: Click Booking");
        movieDetailPage.clickBooking();

        ///VP 1: Verify Cinema Area is display
        LOG.info("VP 1: Verify Cinema Area is display");
        ExtentReportManager.info("VP 1: Verify Cinema Area is display");
        boolean recordingCinemaArea = movieDetailPage.isCinemaArea();
        Assert.assertTrue(recordingCinemaArea, "Cinema Area is display");

        ///VP 2: Verify Schedule is display
        LOG.info("VP 2: Verify Schedule is display");
        ExtentReportManager.info("VP 2: Verify Schedule is display");
        boolean recordingShowTimeArea = movieDetailPage.isScheduleArea();
        Assert.assertTrue(recordingShowTimeArea, "Show Time Area is display");
    }

    @Test(priority = 9, dataProvider = "movie-trailer",
            dataProviderClass = TestDataProvider.class,groups = "movie-detail")
    public void verify_Play_Trailer_From_Search_Result(String[][] movieName) {

        homePage.openHalfScreen();

        ///Step 1: Enter Name film and searching
        LOG.info("Step 1:  Enter Name film and searching");
        ExtentReportManager.info("Step 1:  Enter Name film and searching");
        searching.enterMovieName(movieName[1][0]);

        ///Step 2: Mouse Hover len film
        LOG.info("Step 2: Mouse Hover len film");
        ExtentReportManager.info("Step 2: Mouse Hover len film");
        homePage.hoverMouse(movieName[1][0]);

        ///Step 3: Click btn Play video
        LOG.info("Step 3: Click btn Play video");
        ExtentReportManager.info("Step 3: Click btn Play video");
        homePage.clickPlayVideo(movieName[1][0]);

        ///VP: Popup Trailer display
        LOG.info("VP: Popup Trailer display");
        ExtentReportManager.info("VP: Popup Trailer display");
        boolean recordingPopup = homePage.isPopup();
        Assert.assertTrue(recordingPopup, "Popup is not displayed");
    }

    @Test(priority = 10, dataProvider = "movie-trailer",
            dataProviderClass = TestDataProvider.class,groups = "movie-detail")
    public void verify_Trailer_Displayed_Correctly(String[][] movieName) {
        homePage.openHalfScreen();

        ///Step 1: Enter Name film and searching
        LOG.info("Step 1:  Enter Name film and searching");
        ExtentReportManager.info("Step 1:  Enter Name film and searching");
        searching.enterMovieName(movieName[1][0]);

        ///Step 2: Click on movieName
        LOG.info("Step 2: Click on movieName");
        ExtentReportManager.info("Step 2: Click on movieName");
        homePage.clickOnMovieName(movieName[1][0]);

        ///Step 3: Click btn Play video
        LOG.info("Step 3: Click btn Play video");
        ExtentReportManager.info("Step 3: Click btn Play video");
        movieDetailPage.clickPlayTrailer();

        ///VP: Verify The actual movie trailer
        LOG.info("VP: Verify The actual movie trailer");
        ExtentReportManager.info("VP: Verify The actual movie trailer");

        String recordingPopup = movieDetailPage.getTrailer();
        Assert.assertEquals(recordingPopup, movieName[1][1], "Popup trailer name is incorrect");

    }

    @Test(priority = 11, dataProvider = "movie-trailer",
            dataProviderClass = TestDataProvider.class,groups = "movie-detail")
    public void verify_Trailer_Plays_Normally(String[][] movieName) {
        ///Step 1: Click on movieName
        LOG.info("Step 1: Click on movieName");
        ExtentReportManager.info("Step 1: Click on movieName");
        homePage.clickOnMovieName(movieName[0][0]);

        ///Step 2: Click btn Play video
        LOG.info("Step 3: Click btn Play video");
        ExtentReportManager.info("Step 3: Click btn Play video");
        movieDetailPage.clickPlayTrailer();

        ///VP: Verify The actual movie trailer
        LOG.info("VP: Verify The actual movie trailer");
        ExtentReportManager.info("VP: Verify The actual movie trailer");

        String recordingPopup = movieDetailPage.getTrailer();
        Assert.assertEquals(recordingPopup, movieName[0][1], "Popup trailer name is incorrect");
    }

    @Test(priority = 12, dataProvider = "movie-trailer",
            dataProviderClass = TestDataProvider.class,groups = "movie-detail")
    public void verify_Close_Trailer_By_Close_Button(String[][] movieName) {
        ///Step 1: Click on movieName
        LOG.info("Step 1: Click on movieName");
        ExtentReportManager.info("Step 1: Click on movieName");
        homePage.clickOnMovieName(movieName[0][0]);

        ///Step 2: Click btn Play video
        LOG.info("Step 3: Click btn Play video");
        ExtentReportManager.info("Step 3: Click btn Play video");
        movieDetailPage.clickPlayTrailer();

        ///Step 3: Click close popup trailer
        LOG.info("Step 3: Click close popup trailer");
        ExtentReportManager.info("Step 3: Click close popup trailer");
        movieDetailPage.clickCloseTrailer();

        ///VP: Verify Trailer is close
        LOG.info("VP: Verify Trailer is close");
        ExtentReportManager.info("VP: Verify Trailer is close");
        boolean recordingTrailer = movieDetailPage.isTrailerDisplays();
        Assert.assertFalse(recordingTrailer,"Trailer is still displayed after closing");
    }

    @Test(priority = 13, dataProvider = "movie-trailer",
            dataProviderClass = TestDataProvider.class,groups = "movie-detail")
    public void verify_Close_Trailer_By_Clicking_Outside(String[][] movieName) {
        ///Step 1: Click on movieName
        LOG.info("Step 1: Click on movieName");
        ExtentReportManager.info("Step 1: Click on movieName");
        homePage.clickOnMovieName(movieName[0][0]);

        ///Step 2: Click btn Play video
        LOG.info("Step 3: Click btn Play video");
        ExtentReportManager.info("Step 3: Click btn Play video");
        movieDetailPage.clickPlayTrailer();

        ///Step 3: Click close popup trailer
        LOG.info("Step 3: Click close popup trailer");
        ExtentReportManager.info("Step 3: Click close popup trailer");
        movieDetailPage.clickCloseTrailer();

        movieDetailPage.clickOutside();

        ///VP: Verify Trailer is close
        LOG.info("VP: Verify Trailer is close");
        ExtentReportManager.info("VP: Verify Trailer is close");
        boolean recordingTrailer = movieDetailPage.isTrailerDisplays();
        Assert.assertFalse(recordingTrailer,"Trailer is still displayed after closing");
    }
}
