package webdrivertest;

import driver.ChromeDriverProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import pageobjectpastebin.CreatedPastePage;
import pageobjectpastebin.MainPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static util.Util.getPageTitle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BringItOn {

//    private CreatedPastePage createdPastePage;

    @AfterAll
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

//    @BeforeAll
    @Test
    public void verifyThatTitleCorrectTest() {
        String TITLE = "how to gain dominance among developers";
        String HIGHLIGHTING = "Bash";
        String CODE = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        MainPage mainPage = new MainPage(ChromeDriverProvider.getDriver());
        CreatedPastePage createdPastePage = mainPage.open()
                .enterTextToPasteField(CODE)
                .setHihlighting(HIGHLIGHTING)
                .setExpiration("10 Minutes")
                .setNameTitle(TITLE)
                .createPaste();

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(getPageTitle()).contains(TITLE);
        assertions.assertThat(createdPastePage.getHihlighting()).contains(HIGHLIGHTING);
        assertions.assertThat(createdPastePage.getCode()).contains(CODE);
        assertions.assertAll();
    }

//    @Test
//    public void verifyThatTitleCorrectTest() {
//        assertThat(getPageTitle())
//                .contains(TITLE);
//
//        SoftAssertions assertions = new SoftAssertions();
//        assertions.assertThat(createdPastePage.getHihlighting()).contains(HIGHLIGHTING);
//        assertions.assertThat(createdPastePage.getCode()).contains(CODE);
//        assertions.assertAll();
//    }

//    @Test
//    public void verifyCodeHighlightingCorrectTest() {
//        assertThat(createdPastePage.getHihlighting())
//                .contains(HIGHLIGHTING);
//    }
//
//    @Test
//    public void verifyCodeCorrectTest() {
//        assertThat(createdPastePage.getCode())
//                .contains(CODE);
//    }

}
