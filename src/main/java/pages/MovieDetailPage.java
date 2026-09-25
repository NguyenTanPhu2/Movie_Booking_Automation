package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MovieDetailPage extends CommonPage {

    private By bySchedule;
    private By byGetNameMovie;
    private By byLbMovieName;
    private By byDuration;
    private By byRating;
    private By byBtnBooking;
    private By byCinemaArea;
    private By byScheduleArea;
    private By byNewiFrame;
    private By byNameTrailer;
    private By byPoster;
    private By byPlayTrailer;
    private By byCloseTrailer;
    private By byIsTrailer;

    public MovieDetailPage(WebDriver driver) {
        super(driver);
        this.byGetNameMovie = By.xpath("//div[h1]");
        this.byDuration = By.xpath("//div[h5[contains(@class,'MuiTypography-h5')]]");
        this.byRating = By.xpath("//span[@aria-label='5 Stars']");
        this.byBtnBooking = By.xpath("//a[text()='Mua vé']");
        this.byCinemaArea = By.xpath("//div[@role='tablist']");
        this.byScheduleArea = By.xpath("//div[@role='tabpanel']");
        this.byNewiFrame = By.cssSelector(".modal-video iframe");
        this.byNameTrailer = By.xpath("//a[contains(@class,'ytmVideoInfoVideoTitle')]//span");
        this.byPoster = By.xpath("//div[contains(@class,'MuiGrid-grid-xs-3')]/div[contains(@style,'background-image')]");
        this.byPlayTrailer = By.xpath("//button[span[@class='MuiFab-label']]");
        this.byCloseTrailer = By.xpath("//button[@class='modal-video-close-btn']");
        this.byIsTrailer = By.xpath("//div[@class='modal-video']");
    }

    public void clickOnSchedule(String schedule) {
        bySchedule = By.xpath("//a[p[text()='" + schedule + "']]");
        click(bySchedule);
    }

    public String getTextNameMovie() {
        return getText(byGetNameMovie);
    }

    public boolean isNameFilmDisplayed(String nameFilm) {
        byLbMovieName = By.xpath("//div[h1[text()='" + nameFilm + "']]");
        return isElementDisplayed(byLbMovieName);
    }

    public String getDuration() {
        return getText(byDuration);
    }

    public boolean istRating() {
        return isElementDisplayed(byRating);
    }

    public void clickBooking() {
        click(byBtnBooking);
    }

    public boolean isCinemaArea() {
        return isElementDisplayed(byCinemaArea);
    }

    public boolean isScheduleArea() {
        return isElementDisplayed(byScheduleArea);
    }

    public void findIframe() {
        findIFrame(byNewiFrame);
    }

    public String getTrailer() {
        findIframe();
        return getIFrame(byNameTrailer);
    }

    public void hoverPoster() {
        hoverMouse(byPoster);
    }

    public void clickPlayTrailer() {
        hoverPoster();
        click(byPlayTrailer);
    }

    public void clickCloseTrailer() {
        click(byCloseTrailer);
    }

    public boolean isTrailerDisplays() {
        return isElementDisplayed(byIsTrailer);
    }
}
