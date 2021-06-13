package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Util.sleep;

public class MainPageBringItOn {
    private static final String PAGE_ADDRESS = "https://pastebin.com";
    private WebDriver driver;
    private By pasteField = By.id("postform-text");
    private By SyntaxHighlightingDDL = By.id("select2-postform-format-container");
    private By pasteExpirationDDL = By.id("select2-postform-expiration-container");
    private By pasteNameTitle = By.id("postform-name");
    private By submit = By.xpath("//button[@class='btn -big']");

    public MainPageBringItOn(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageBringItOn open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPageBringItOn enterTextToPasteField(String text) {
        driver.findElement(pasteField).sendKeys(text);
        sleep(2000);
        return this;
    }

    public MainPageBringItOn setExpiration(String time) {
        driver.findElement(pasteExpirationDDL).click();
        sleep(2000);
        driver.findElement(By.xpath(String.format("//li[text()='%s']", time))).click();
        sleep(2000);
        return this;
    }

    public MainPageBringItOn setHihlighting(String lang) {
        driver.findElement(SyntaxHighlightingDDL).click();
        sleep(2000);
        driver.findElement(By.xpath(String.format("//li[text()='%s']", lang))).click();
        sleep(2000);
        return this;
    }

    public MainPageBringItOn setNameTitle(String text) {
        driver.findElement(pasteNameTitle).sendKeys(text);
        sleep(2000);
        return this;
    }

    public MainPageICanWin newPage() {
        driver.findElement(submit).click();
        sleep(2000);
        return newPage();
    }
}
