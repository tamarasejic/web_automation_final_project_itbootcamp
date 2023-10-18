package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
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
    public String getEmailInputTypeValue(){
        return getEmailInput().getAttribute("type");
    }
    public String getPasswordInputTypeValue(){
        return getPasswordInput().getAttribute("type");
    }
}
