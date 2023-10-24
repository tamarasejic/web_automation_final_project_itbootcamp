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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editsProfile() {
        String email = config.getAdminEmail();
        String password = config.getAdminPassword();
        String name = "Marko Markovic";
        String phone = "+38161234568";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/milan1232";
        String github = "https://github.com/tamarasejic";

        navPage.clickOnLoginButton();

        loginPage.clearAndTypeEmail(email);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();
        wait
                .withMessage("Url should be " + baseUrl + "/home")
                .until(ExpectedConditions.urlContains("/home"));

        navPage.clickOnMyProfileButton();
        wait
                .withMessage("Url should be " + baseUrl + "/profile")
                .until(ExpectedConditions.urlToBe(baseUrl + "/profile"));

        profilePage.clearAndTypeName(name);
        profilePage.clearAndTypePhone(phone);
        profilePage.clearAndTypeCity(city);
        profilePage.clearAndTypeCountry(country);
        profilePage.clearAndTypeTwitter(twitter);
        profilePage.clearAndTypeGitHub(github);

        profilePage.clickOnSaveButton();
        messagePopUpPage.waitSavedProfileEditSuccessPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getSavedProfileEditSuccessPopUpText()
                        .contains("Profile saved successfuly"),
                "Saved profile pop up message text should contain 'Profile saved successfuly'.");

        Assert.assertEquals(profilePage.getNameValueValue(),
                name,
                "Value of the 'value' attribute for the 'Name' input should be '" + name + "'");

        Assert.assertEquals(profilePage.getPhoneValueValue(),
                phone,
                "Value of the 'value' attribute for the 'Phone' input should be '" + phone + "'");

        Assert.assertEquals(profilePage.getCityValueValue(),
                city,
                "Value of the 'value' attribute for the 'City' input should be '" + city + "'");

        Assert.assertEquals(profilePage.getCountryValueValue(),
                country,
                "Value of the 'value' attribute for the 'Country' input should be '" + country + "'");

        Assert.assertEquals(profilePage.getTwitterValueValue(),
                twitter,
                "Value of the 'value' attribute for the 'Twitter' input should be '" + twitter + "'");

        Assert.assertEquals(profilePage.getGitHubValueValue(),
                github,
                "Value of the 'value' attribute for the 'GitHub' input should be '" + github + "'");

        navPage.clickOnLogoutButton();
        wait
                .withMessage("User should be redirected to " + baseUrl  + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }
}
