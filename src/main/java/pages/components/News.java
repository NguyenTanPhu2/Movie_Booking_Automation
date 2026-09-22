package pages.components;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class News extends BasePage {

    private By byTag;
    private By byBtnExtra;
    private By byViewBody;
    private By byBtnTag;
    private By byTitlelNews;
    private By byBtnCollapse;

    public News(WebDriver driver) {
        super(driver);
        this.byBtnExtra = By.xpath("//button[span[text()='XEM THÊM']]");
        this.byViewBody = By.xpath("//div[contains(@class,'MuiGrid-spacing-xs-2')]");
        this.byBtnCollapse = By.xpath("//button[span[text()='RÚT GỌN']]");

    }

    public boolean isTagDisplay(String tagName) {
        byTag = By.xpath("//span[text()='" + tagName + "']");
        return isElementDisplayed(byTag);
    }

    public void clickExtra() {
        jsClick(byBtnExtra);
    }

    public boolean isViewBodyDisplayed() {
        return isElementDisplayed(byViewBody);
    }

    public void clickNewsTag(String tag) {
        byBtnTag = By.xpath("//button[span[text()='" + tag + "']]");
        click(byBtnTag);
    }

    public void clickTitleNews(String content) {
        byTitlelNews = By.xpath("//a[p[text()='" + content + "']]");
        click(byTitlelNews);
    }

    public boolean isExtraDisplays() {
        return isElementDisplayed(byBtnExtra);
    }

    public void clickCollapse() {
        jsClick(byBtnCollapse);
    }
}
