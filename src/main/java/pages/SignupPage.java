package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public void clearAndTypeEmail(String email){
        getEmailInput().clear();
        getEmailInput().sendKeys(email);
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public void clearAndTypePassword(String password){
        getPasswordInput().clear();
        getPasswordInput().sendKeys(password);
    }

    public WebElement getConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public void clearAndTypeConfirmPassword(String confirmPassword){
        getConfirmPasswordInput().clear();
        getConfirmPasswordInput().sendKeys(confirmPassword);
    }

    public String getEmailInputTypeValue(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputTypeValue(){
        return getPasswordInput().getAttribute("type");
    }
    public String getConfirmPasswordInputTypeValue(){
        return getConfirmPasswordInput().getAttribute("type");
    }
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeName(String name){
        getNameInput().clear();
        getNameInput().sendKeys(name);
    }
    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("[type=\"submit\"]"));
    }
    public void clickOnSignupButton(){
        getSignupButton().click();
    }

}
