package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignUpPage() {
        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be '" + baseUrl + "/signup")
                .until(ExpectedConditions.urlToBe(baseUrl + "/signup"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        navPage.clickOnSignupButton();

        Assert.assertEquals(signupPage.getEmailInputTypeValue(),
                "email",
                "Value of the 'type' attribute for the 'E-mail' input should be 'email'");

        Assert.assertEquals(signupPage.getPasswordInputTypeValue(),
                "password",
                "Value of the 'type' attribute for the 'Password' input should be 'password'");

        Assert.assertEquals(signupPage.getConfirmPasswordInputTypeValue(),
                "password",
                "Value of the 'type' attribute for the 'Confirm Password' input should be 'password'");
    }

}
