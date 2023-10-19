package tests;

import com.github.javafaker.Faker;
import data_provider.DataProviderClass;
import org.openqa.selenium.JavascriptExecutor;
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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists() {
        String name = "Another User";

        navPage.clickOnSignupButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/signup",
                "Url should be " + baseUrl  + "/signup");

        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(config.getAdminEmail());
        signupPage.clearAndTypePassword(config.getAdminPassword());
        signupPage.clearAndTypeConfirmPassword(config.getAdminPassword());

        signupPage.clickOnSignupButton();
        messagePopUpPage.waitForErrorPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorPopUpMessageText(),
                "E-mail already exists",
                "Error pop up message text should be 'E-mail already exists'.");

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/signup",
                "Url should be " + baseUrl  + "/signup");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void successfulSignup() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        navPage.clickOnSignupButton();

        signupPage.clearAndTypeName(name);
        signupPage.clearAndTypeEmail(email);
        signupPage.clearAndTypePassword(password);
        signupPage.clearAndTypeConfirmPassword(password);

        signupPage.clickOnSignupButton();

        wait
                .withMessage("User should be redirected to '" + baseUrl + "/home")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        wait
                .withMessage("Dialog window should be visible.")
                .until(ExpectedConditions.visibilityOf(messagePopUpPage.getDialogWindow()));

        Assert.assertEquals(messagePopUpPage.getDialogMessageText(),
                "IMPORTANT: Verify your account",
                "Dialog pop up message text should be 'IMPORTANT: Verify your account'.");

        messagePopUpPage.clickOnCloseButton();

        navPage.clickOnLogoutButton();

    }

}
