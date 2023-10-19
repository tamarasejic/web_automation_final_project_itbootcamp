package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickOnNewItemButton(){
        getNewItemButton().click();
    }
    public WebElement getCreateEditDialog(){
        return driver.findElement(By.className("v-card"));
    }
    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    public void clearAndTypeName(String name){
        getNameInput().clear();
        getNameInput().sendKeys(name);
    }
    public String getNameInputTypeValue(){
        return getNameInput().getAttribute("type");
    }

}
