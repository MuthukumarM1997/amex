package Pages;

import baseUtils.CommonSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyPage extends CommonSetup {
    private WebDriverWait wait;
    @FindBy(id = "MR")
    WebElement civilityMrBtn;
    @FindBy(id = "MS")
    WebElement civilityMomBtn;
    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastname;
    @FindBy(name = "fieldControl-input-dateOfBirth")
    WebElement dob;
    @FindBy(name = "email")
    WebElement email;
    @FindBy(name = "mobilePhoneNumber")
    WebElement mobileNumber;
    @FindBy(xpath = "//button[text()='Sauvegarder et Continuer']")
    WebElement submit;
    @FindBy(xpath = "//input[@id='MR']/../../../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement civilityErrorMsg;
    @FindBy(xpath = "//input[@name='firstName']/../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement firstNameErrorMsg;
    @FindBy(xpath = "//input[@name='lastName']/../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement lastnameErrorMsg;
    @FindBy(xpath = "//input[@name='fieldControl-input-dateOfBirth']/../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement dobErrorMsg;
    @FindBy(xpath = "//input[@name='email']/../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement emailErrorMsg;
    @FindBy(xpath = "//input[@name='mobilePhoneNumber']/../../following-sibling::div/span[@id='fieldControl-input-error-alert']")
    WebElement mobileNumberErrorMsg;
    @FindBy(id = "countryCode")
    WebElement countryCode;

    @FindBy(xpath = "//button[text()='Tout Accepter']")
    WebElement acceptCookieBtn;
    public ApplyPage(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }


    public void selectGender(String gender) {
        if (gender.equals("male")) {
            civilityMrBtn.click();
        } else {
            civilityMomBtn.click();
        }
    }

    public void submitBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
    }

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastname.sendKeys(lname);
    }

    public void enterdob(String dobs) {
        dob.sendKeys(dobs);
    }

    public void enterEmail(String emailId) {
        email.sendKeys(emailId);
    }

    public void enterCountryCode(String code) {
        Select select = new Select(countryCode);
        select.selectByValue("Inde");
    }

    public void enterMobile(String phone) {
        mobileNumber.sendKeys(phone);
    }

    public String civilityErrorMsg(){
        return civilityErrorMsg.getText();
    }
    public String getfirstNameErrorMsg()
    {
        return firstNameErrorMsg.getText();
    }
    public String getlastnameErrorMsg(){
        return lastnameErrorMsg.getText();
    }
    public String getdobErrorMsg(){
        return dobErrorMsg.getText();
    }
    public String getemailErrorMsg(){
        return emailErrorMsg.getText();
    }
    public String getmobileNumberErrorMsg(){
        return mobileNumberErrorMsg.getText();
    }
    public void clickacceptCookieBtn(){
        acceptCookieBtn.click();
    }
}
