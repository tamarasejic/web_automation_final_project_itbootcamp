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


}
