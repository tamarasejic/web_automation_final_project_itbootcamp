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

}
