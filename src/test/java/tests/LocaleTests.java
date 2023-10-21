package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyTheUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/",
                "Url should be " + baseUrl  + "/");
    }

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES() {
        navPage.clickOnLanguageButton();
        navPage.clickOnLanguageByISO2LetterCodeText("ES");

        Assert.assertEquals(localeHomePage.getHeaderTitleText(),
                "Página de aterrizaje",
                "Home page title in ES locale should be 'Página de aterrizaje'.");
    }

}
