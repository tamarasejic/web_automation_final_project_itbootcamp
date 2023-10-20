package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public WebElement getDialogSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnDialogSaveButton(){
        getDialogSaveButton().click();
    }
    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public void clearAndTypeSearch(String cityName) {
        getSearchInput().clear();
        getSearchInput().sendKeys(cityName);
    }
    public void waitForNumberOfRowsToBe(int numberOfRowsToBe){
        wait
                .withMessage("Number of rows should be" + numberOfRowsToBe + ".")
                .until(ExpectedConditions
                        .numberOfElementsToBe(By.cssSelector(".v-data-table__wrapper tbody > tr"), numberOfRowsToBe));
        driver.findElements(By.cssSelector(".v-data-table__wrapper tbody > tr"));
    }
    public WebElement getEditButtonFromTableRow(){
        return driver.findElement(By.xpath("//tbody /tr[1] /td //*[@id='edit']"));
    }
    public void clickOnEditButtonFromTableRow(){
        getEditButtonFromTableRow().click();
    }
    public void clearAndTypeEditedName(String editedName){
        getNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"), editedName);
    }
    public WebElement getNameFromTableRow(){
        return driver.findElement(By.xpath("//tbody /tr[1] /td[2]"));
    }
    public String getNameFromTableRowText(){
        return getNameFromTableRow().getText();
    }
    public WebElement getDeleteButtonFromTableRow(){
        return driver.findElement(By.xpath("//tbody /tr[1] /td //*[@id='delete']"));
    }
    public void clickOnDeleteButtonFromTableRow(){
        getDeleteButtonFromTableRow().click();
    }

}
