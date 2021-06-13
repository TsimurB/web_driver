package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pageobject.MainPageBringItOn;
import pageobject.MainPageICanWin;

public class BringItOn {
    @AfterEach
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

    @Test
    public void secondTest() {
        MainPageBringItOn mainPage = new MainPageBringItOn(ChromeDriverProvider.getDriver());
        mainPage.open()
                .enterTextToPasteField("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")
                .setHihlighting("Bash")
                .setExpiration("10 Minutes")
                .setNameTitle("how to gain dominance among developers")
                .newPage();
    }
}
