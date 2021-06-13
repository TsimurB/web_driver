package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import pageobject.MainPageICanWin;

public class ICanWinTest {
    @AfterEach
    public void closeDriver(){
    ChromeDriverProvider.getDriver().close();
    }

    @Test
    public void firstTest() {
        MainPageICanWin mainPage = new MainPageICanWin(ChromeDriverProvider.getDriver());
        mainPage.open()
                .enterTextToPasteField("Hello from WebDriver")
                .setExpiration("10 Minutes")
                .setNameTitle("helloweb")
                .newPage();
    }

}
