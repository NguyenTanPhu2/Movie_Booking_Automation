package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends CommonPage {

    private By byClickOnName;
    private By byMovieName;
    private By byAgeRating;
    private By byBtnBooking;
    private By byBtnPlayTrailer;
    private By byIsTrailer;
    private By byStrangePageFilmList;
    private By bySchedule;

    public HomePage(WebDriver driver) {
        super(driver);
        this.byIsTrailer = By.xpath("//div[@class='modal-video']");
        this.bySchedule = By.xpath("//div[@id='lichChieu']");
    }

    public void clickOnMovieName(String nameFilm) {
        byClickOnName = By.xpath("//div[text()='" + nameFilm + "']");
        click(byClickOnName);
    }

    public void clickBackBrowser(){
        getDriver().navigate().back();
    }

    public boolean isMovieName(String movieName) {
        byMovieName = By.xpath("//div[text()='" + movieName + "']");
        return isElementDisplayed(byMovieName);
    }

    public boolean isAgeRating(String movieName, String ageRating) {
        byAgeRating = By.xpath("//div[text()= '" + movieName + "' and span[text()='" + ageRating + "']]");
        return isElementDisplayed(byAgeRating);
    }

    public void hoverMouse(String movieName) {
        byMovieName = By.xpath("//div[text()='" + movieName + "']");
        hoverMouse(byMovieName);
    }

    public boolean isBntBooking(String nameFilm) {
        byBtnBooking = By.xpath("//div[contains(.,'" + nameFilm + "')]/following-sibling::div/a");
        return isElementDisplayed(byBtnBooking);
    }

    public void clickPlayVideo(String movieName) {
        byBtnPlayTrailer = By.xpath("//a[.//div[contains(normalize-space(.), '" + movieName + "')]]//button");
        click(byBtnPlayTrailer);
    }

    public boolean isPopup() {
        return isElementDisplayed(byIsTrailer);
    }

    public void clickStrangePageFilmList(int index) {
        byStrangePageFilmList = By.xpath("(//div[contains(@class,'jss89')]//button[" + index + "])[2]");
        click(byStrangePageFilmList);
    }

    public void scrollSchdule() {
        scroll(bySchedule, 500);
    }
}
