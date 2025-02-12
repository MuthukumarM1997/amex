package Pages;

import baseUtils.CommonSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypesOfCardsPage extends CommonSetup {
    private WebDriverWait wait;

    @FindBy(xpath = "//a[contains(@href, 'gold-card-americanexpress')]")
    WebElement learnMoreButton;
    public TypesOfCardsPage(ChromeDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);

        PageFactory.initElements(driver,this);
    }

    public void clickLearnMoreBtn(){
        learnMoreButton.click();
    }
    public String  title(){
        return driver.getTitle();
    }
}
