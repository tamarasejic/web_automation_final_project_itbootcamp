package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocaleHomePage extends BasicPage{
    public LocaleHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHeaderTitle(){
        return driver.findElement(By.tagName("h1"));
    }
    public String getHeaderTitleText(){
        return getHeaderTitle().getText();
    }
}
