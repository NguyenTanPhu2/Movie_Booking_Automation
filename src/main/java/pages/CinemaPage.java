package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CinemaPage extends CommonPage {

    private By byCinemaComplexLogo;
    private By byCinemaComplex;
    private By byNameCinema;
    private By byAddressCinema;
    private By byMovieName;
    private By byPoster;
    private By bySchedule;
    private By byInternalRoll;
    private By byChooseSchedule;

    public CinemaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCinemaComplexDisPlays(String nameCinema) {
        byCinemaComplexLogo = By.xpath("//img[@alt='" + nameCinema + "']");
        return isElementDisplayed(byCinemaComplexLogo);
    }

    public void clickCinemaComplex(String nameCinemaComplex) {
        byCinemaComplex = By.xpath("//button[.//img[@alt='" + nameCinemaComplex + "']]");
        click(byCinemaComplex);
    }

    public boolean isCinemaDisplays(String nameCinema) {
        byNameCinema = By.xpath("//div[h4[text()='" + nameCinema + "']]");
        return isElementDisplayed(byNameCinema);
    }

    public boolean isAddressCinema(String address) {
        byAddressCinema = By.xpath("//div[h6[text()='" + address + "']]");
        return isElementDisplayed(byAddressCinema);
    }

    public void clickChooseCinema(String cinemaName) {
        byNameCinema = By.xpath("//button[.//h4[normalize-space()='" + cinemaName + "']]");
        click(byNameCinema);
    }

    public boolean isNameMovieDisplays(String nameMovie) {
        byMovieName = By.xpath("//div[h2[text() = '" + nameMovie + "']]");
        return isElementDisplayed(byMovieName);
    }

    public boolean isScheduleDisplay(String schedule) {
        bySchedule = By.xpath("//div[p[text()='" + schedule + "']]");
        return isElementDisplayed(bySchedule);
    }

    public void internalRoll(String movieName) {
        byInternalRoll = By.xpath("//h2[contains(.,'" + movieName + "')]");
    }

    public boolean isPosterDisplayed(String movieName) {
        byPoster = By.xpath("//img[@alt='" + movieName + "']");
        return isElementDisplayed(byPoster);
    }

    public void clickSchedule(String date, String time) {
        byChooseSchedule = By.xpath("//div[p[text()='" + date + "'] and h3[text()='" + time + "']]");
        click(byChooseSchedule);
    }
}
