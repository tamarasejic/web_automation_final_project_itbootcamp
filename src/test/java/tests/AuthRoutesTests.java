package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/home");

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/login")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/profile");

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/login")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/cities");

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/login")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.navigate().to(baseUrl + "/admin/users");

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/login")
                .until(ExpectedConditions.urlToBe(baseUrl + "/login"));
    }
}
