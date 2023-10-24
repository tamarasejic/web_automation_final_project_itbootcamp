package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage() throws InterruptedException {
        navPage.clickOnLoginButton();

        loginPage.clearAndTypeEmail(config.getAdminEmail());
        loginPage.clearAndTypePassword(config.getAdminPassword());

        loginPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl  + "/home")
                .until(ExpectedConditions.urlContains("/home"));

        driver.navigate().to(baseUrl + "/profile");

        wait
                .withMessage("Url should be " + baseUrl + "/profile")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

        Assert.assertEquals(profilePage.getEmailInputValueValue(),
                "admin@admin.com",
                "Value of the 'value' attribute for the 'E-mail' input should be 'admin@admin.com'");

    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginButton();

        loginPage.clearAndTypeEmail(config.getAdminEmail());
        loginPage.clearAndTypePassword(config.getAdminPassword());
        loginPage.clickOnLoginButton();
        wait
                .withMessage("Url should be " + baseUrl  + "/home")
                .until(ExpectedConditions.urlContains("/home"));

        navPage.clickOnMyProfileButton();
        wait
                .withMessage("Url should be " + baseUrl + "/profile")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

        Assert.assertEquals(profilePage.getEmailInputTypeValue(),
                "email",
                "Value of the 'type' attribute for the 'E-mail' input should be 'email'");

        Assert.assertEquals(profilePage.getEmailInputDisabledValue(),
                "disabled",
                "Value of the 'disabled' attribute for the 'E-mail' input should be 'disabled'");

        Assert.assertEquals(profilePage.getNameInputTypeValue(),
                "text",
                "Value of the 'type' attribute for the 'Name' input should be 'text'");

        Assert.assertEquals(profilePage.getCityInputTypeValue(),
                "text",
                "Value of the 'type' attribute for the 'City' input should be 'text'");

        Assert.assertEquals(profilePage.getCountryInputTypeValue(),
                "text",
                "Value of the 'type' attribute for the 'Country' input should be 'text'");

        Assert.assertEquals(profilePage.getTwitterInputTypeValue(),
                "url",
                "Value of the 'type' attribute for the 'Twitter' input should be 'url'");

        Assert.assertEquals(profilePage.getGitHubInputTypeValue(),
                "url",
                "Value of the 'type' attribute for the 'GitHub' input should be 'url'");

        Assert.assertEquals(profilePage.getPhoneInputTypeValue(),
                "tel",
                "Value of the 'type' attribute for the 'Phone' input should be 'tel'");

        navPage.clickOnLogoutButton();
        wait
                .withMessage("User should be redirected to " + baseUrl  + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }
}
