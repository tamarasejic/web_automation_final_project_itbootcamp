package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getErrorPopUp() {
        return driver.findElement(By.className("v-snack__content"));
    }
    public void waitForErrorPopUpToBeVisible(){
        wait
                .withMessage("Message pop up should be visible.")
                .until(ExpectedConditions.visibilityOf(getErrorPopUp()));
    }
    public WebElement getErrorPopUpMessage() {
        return driver.findElement(By.cssSelector(".v-snack__content li"));
    }
    public String getErrorPopUpMessageText(){
        return getErrorPopUpMessage().getText();
    }

    public WebElement getDialogWindow(){
        return driver.findElement(By.className("dlgVerifyAccount"));
    }
    public String getDialogMessageText()  {
        return getDialogWindow().getText();
    }

    public WebElement getCloseButton(){
        return driver.findElement(By.className("btnClose"));
    }
    public void clickOnCloseButton(){
        getCloseButton().click();
    }
    public WebElement getSavedCityPopup(){
        return driver.findElement(By.className("success"));
    }
    public WebElement getSavedCityPopupMessage(){
        return driver.findElement(By.cssSelector(".success .v-snack__content"));
    }
    public String getSavedCityPopupMessageText(){
        return getSavedCityPopupMessage().getText();
    }


}
