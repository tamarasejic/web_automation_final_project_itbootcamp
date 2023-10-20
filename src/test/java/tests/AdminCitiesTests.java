package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{

    private String cityName;

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities() {
        navPage.clickOnLoginButton();

        loginPage.clearAndTypeEmail(config.getAdminEmail());
        loginPage.clearAndTypePassword(config.getAdminPassword());

        loginPage.clickOnLoginButton();

        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/admin/cities",
                "Url should be " + baseUrl  + "/admin/cities");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();

        citiesPage.clickOnNewItemButton();

        wait
                .withMessage("Create/Edit new city dialog should be visible.")
                .until(ExpectedConditions
                        .visibilityOf(citiesPage.getCreateEditDialog()));

        Assert.assertEquals(citiesPage.getNameInputTypeValue(),
                "text",
                "Value of the 'type' attribute for the 'Name' input should be 'text'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity() {
        Faker faker = new Faker();
        String nameUser = faker.name().fullName();
        cityName = nameUser + "'s city";

        navPage.clickOnAdminButton();
        navPage.clickOnCitiesButton();

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlToBe(baseUrl + "/admin/cities"));
        citiesPage.clickOnNewItemButton();

        wait
                .withMessage("Create/Edit new city dialog should be visible.")
                .until(ExpectedConditions
                        .visibilityOf(citiesPage.getCreateEditDialog()));

        citiesPage.clearAndTypeName(cityName);
        citiesPage.clickOnDialogSaveButton();

        wait
                .withMessage("Saved city pop up should be visible.")
                .until(ExpectedConditions
                        .visibilityOf(messagePopUpPage.getSavedCityPopup()));

        Assert.assertTrue(messagePopUpPage.getSavedCityPopupMessageText()
                        .contains("Saved successfully"),
                "Saved city pop up message text should contain 'Saved successfully'.");
    }

}
