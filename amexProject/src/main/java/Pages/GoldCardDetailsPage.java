package Pages;

import baseUtils.CommonSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoldCardDetailsPage extends CommonSetup {
    private WebDriverWait wait;

    @FindBy(xpath = "(//a[contains(@href,'GoldCardAmericanExpress') and text()='Demandez votre Carte'])[1]")
    WebElement requestCardBtn;

    public GoldCardDetailsPage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void clickRequestCardBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", requestCardBtn);

//        requestCardBtn.click();
    }

    public String title() {
        return driver.getTitle();
    }
}
