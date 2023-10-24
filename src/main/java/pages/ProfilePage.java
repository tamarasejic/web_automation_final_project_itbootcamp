package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputValueValue() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute(\"disabled\");", getEmailInput());
        Thread.sleep(500);
        return (String) js.executeScript("return document.getElementById('email').value");
    }

    public String getEmailInputTypeValue(){
        return getEmailInput().getAttribute("type");
    }
    public String getEmailInputDisabledValue(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');",
                getEmailInput()).toString();
    }
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    public String getNameInputTypeValue(){
        return getNameInput().getAttribute("type");
    }
    public WebElement getCityInput(){
        return driver.findElement(By.id("city"));
    }
    public String getCityInputTypeValue(){
        return getCityInput().getAttribute("type");
    }
    public WebElement getCountryInput(){
        return driver.findElement(By.id("country"));
    }
    public String getCountryInputTypeValue(){
        return getCountryInput().getAttribute("type");
    }
    public WebElement getTwitterInput(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getTwitterInputTypeValue(){
        return getTwitterInput().getAttribute("type");
    }
    public WebElement getGitHubInput(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getGitHubInputTypeValue(){
        return getGitHubInput().getAttribute("type");
    }
    public WebElement getPhoneInput(){
        return driver.findElement(By.id("phone"));
    }
    public String getPhoneInputTypeValue(){
        return getPhoneInput().getAttribute("type");
    }

    public void clearAndTypeName(String name){
        getNameInput().click();
        getNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public void clearAndTypePhone(String phone){
        getPhoneInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
    }
    public void clearAndTypeCity(String city){
        getCityInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
        getCityInput().sendKeys(Keys.ENTER);
    }
    public void clearAndTypeCountry(String country){
        getCountryInput().click();
        getCountryInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), country);
    }
    public void clearAndTypeTwitter(String twitter){
        getTwitterInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), twitter);
    }
    public void clearAndTypeGitHub(String github){
        getGitHubInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), github);
    }
    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton(){
        getSaveButton().click();
    }
    public String getNameValueValue(){
        return getNameInput().getAttribute("value");
    }
    public String getPhoneValueValue(){
        return getPhoneInput().getAttribute("value");
    }
    public String getCityValueValue(){
        return getCityInput().getAttribute("value");
    }
    public String getCountryValueValue(){
        return getCountryInput().getAttribute("value");
    }
    public String getTwitterValueValue(){
        return getTwitterInput().getAttribute("value");
    }
    public String getGitHubValueValue(){
        return getGitHubInput().getAttribute("value");
    }



}
