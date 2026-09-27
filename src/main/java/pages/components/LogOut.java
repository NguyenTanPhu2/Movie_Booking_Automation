package pages.components;

import base.BasePage;
import constants.TimeOutConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LogOut extends BasePage {

    private By byConfirmLogOut;
    private By byConfirmCancelLogOut;
    private WebDriver driver;

    public LogOut(WebDriver driver) {
        super(driver);
        this.driver=driver;
        this.byConfirmLogOut = By.xpath("//button[text()='Đồng ý']");
        this.byConfirmCancelLogOut = By.xpath("//button[text()='Hủy']");
    }

    public void clickConfirmLogOut() {
        click(byConfirmLogOut);
    }

    public void clickConfirmCancelLogOut() {
        click(byConfirmCancelLogOut);
    }

    public String getTokenFromStorage() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        getWebDriverWait(TimeOutConstants.SHORT_TIMEOUT);
        return (String) js.executeScript(
                "return JSON.parse(localStorage.getItem('currentUser')).accessToken;"
        );
    }

}
