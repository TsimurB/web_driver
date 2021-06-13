package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageobject.MainPageHurtMePlenty;

public class HurtMyPlenty {
    @AfterEach
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

    @Test
    public void firstTest() {
        MainPageHurtMePlenty mainPage = new MainPageHurtMePlenty(ChromeDriverProvider.getDriver());
        mainPage.open()
                .searchPage("Google Cloud Platform Pricing Calculator" + "\n")
                .findCalk();
//                .pageCalk();
//                .setExpiration("10 Minutes")
//                .setNameTitle("helloweb")
//                .newPage();
    }
}
