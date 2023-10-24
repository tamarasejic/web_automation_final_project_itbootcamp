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
}
