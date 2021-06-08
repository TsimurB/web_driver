package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Util.sleep;

public class MainPage {

    private static final String PAGE_ADDRESS = "https://pastebin.com";
    private WebDriver driver;
    private By pasteField = By.id("postform-text");
    private By pasteExpirationDDL = By.id("select2-postform-expiration-container");
    private By pasteNameTitle = By.id("postform-name");
    private By submit = By.xpath("//button[@class='btn -big']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPage enterTextToPasteField(String text) {
        driver.findElement(pasteField).sendKeys(text);
        sleep(2000);
        return this;
    }

    public MainPage setExpiration(String time) {
        driver.findElement(pasteExpirationDDL).click();
        sleep(2000);
        driver.findElement(By.xpath(String.format("//li[text()='%s']", time))).click();
        sleep(2000);
        return this;
    }

    public MainPage setNameTitle(String text) {
        driver.findElement(pasteNameTitle).sendKeys(text);
        sleep(2000);
        return this;
    }

    public MainPage newPage() {
        driver.findElement(submit).click();
        sleep(2000);
        return newPage();
    }
}
