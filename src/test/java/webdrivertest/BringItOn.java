package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.*;
import pageobjectpastebin.CreatedPastePage;
import pageobjectpastebin.MainPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static util.Util.getPageTitle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BringItOn {
    private static final String TITLE = "how to gain dominance among developers";
    private static final String HIGHLIGHTING = "Bash";
    private static final String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private CreatedPastePage createdPastePage;

    @AfterAll
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

    @BeforeAll
    public void preparation() {
        MainPage mainPage = new MainPage(ChromeDriverProvider.getDriver());
        createdPastePage = mainPage.open()
                .enterTextToPasteField(CODE)
                .setHihlighting(HIGHLIGHTING)
                .setExpiration("10 Minutes")
                .setNameTitle(TITLE)
                .createPaste();
    }

    @Test
    public void verifyThatTitleCorrectTest() {
        assertThat(getPageTitle())
                .contains(TITLE);
    }

    @Test
    public void verifyCodeHighlightingCorrectTest() {
        assertThat(createdPastePage.getHihlighting())
                .contains(HIGHLIGHTING);
    }

    @Test
    public void verifyCodeCorrectTest() {
        assertThat(createdPastePage.getCode())
                .contains(CODE);
    }

}
