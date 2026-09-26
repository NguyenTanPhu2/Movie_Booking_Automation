package pages.components;

import base.BasePage;
import constants.TimeOutConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Session extends BasePage {

    WebDriver driver;

    public Session(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTokenFromStorage() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        getWebDriverWait(TimeOutConstants.SHORT_TIMEOUT);
        return (String) js.executeScript(
                "return JSON.parse(localStorage.getItem('currentUser')).accessToken;"
        );
    }

    public void removeToken() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;

        js.executeScript(
                "localStorage.removeItem('currentUser');"
        );
    }
}
