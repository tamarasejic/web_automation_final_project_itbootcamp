package tests;

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

}
