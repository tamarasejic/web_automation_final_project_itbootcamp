package tests;

import data_provider.DataProviderClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage() {
        navPage.clickOnLanguageButton();
        navPage.clickOnLanguageByISO2LetterCodeText("EN");
        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be '" + baseUrl + "/login")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getEmailInputTypeValue(),
                "email",
                "Value of the 'type' attribute for the 'E-mail' input should be 'email'");

        Assert.assertEquals(loginPage.getPasswordInputTypeValue(),
                "password",
                "Value of the 'type' attribute for the 'Password' input should be 'password'");

    }

    @Test(priority = 3, dataProvider = "non-existing-user",
            dataProviderClass = DataProviderClass.class, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(String email, String password) {
        navPage.clickOnLoginButton();

        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);

        loginPage.clickOnLoginButton();
        messagePopUpPage.waitForErrorPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorPopUpMessageText(),
                "User does not exists",
                "Error pop up message text should be 'User does not exists'.");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login",
                "Url should be " + baseUrl  + "/login");
    }

}
