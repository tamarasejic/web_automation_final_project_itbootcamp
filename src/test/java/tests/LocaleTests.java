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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN() {
        navPage.clickOnLanguageButton();
        navPage.clickOnLanguageByISO2LetterCodeText("EN");

        Assert.assertEquals(localeHomePage.getHeaderTitleText(),
                "Landing",
                "Home page title in EN locale should be 'Landing'.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN() {
        navPage.clickOnLanguageButton();
        navPage.clickOnLanguageByISO2LetterCodeText("CN");

        Assert.assertEquals(localeHomePage.getHeaderTitleText(),
                "首页",
                "Home page title in CN locale should be '首页'.");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFR() {
        navPage.clickOnLanguageButton();
        navPage.clickOnLanguageByISO2LetterCodeText("FR");

        Assert.assertEquals(localeHomePage.getHeaderTitleText(),
                "Page d'atterrissage",
                "Home page title in FR locale should be 'Page d'atterrissage'.");
    }

}
