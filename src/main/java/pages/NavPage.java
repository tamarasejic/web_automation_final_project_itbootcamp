package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickOnLanguageButton(){
        getLanguageButton().click();
    }
    public WebElement getLanguageByISO2LetterCodeText (String languageISOCode){
        return driver.findElement(By.xpath
                ("//*[text()='" + languageISOCode.toUpperCase() + "']/.."));
    }
    public void clickOnLanguageByISO2LetterCodeText(String languageISOCode){
        getLanguageByISO2LetterCodeText(languageISOCode).click();
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector(".v-toolbar__items a[href=\"/login\"]"));
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector(".v-toolbar__items a[href=\"/signup\"]"));
    }
    public void clickOnSignupButton(){
        getSignupButton().click();
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickOnAdminButton(){
        getAdminButton().click();
    }

    public WebElement getCitiesButton(){
        return driver.findElement(By.cssSelector("a[href=\"/admin/cities\"]"));
    }
    public void clickOnCitiesButton(){
        getCitiesButton().click();
    }
    public WebElement getMyProfileButton(){
        return driver.findElement(By.className("btnProfile"));
    }
    public void clickOnMyProfileButton(){
        getMyProfileButton().click();
    }


}
