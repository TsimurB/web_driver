package pageobjectpastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.Util.sleep;

public class MainPage {

    private static final String PAGE_ADDRESS = "https://pastebin.com";
    private WebDriver driver;
    private By pasteField = By.id("postform-text");
    private By pasteExpirationDDL = By.id("select2-postform-expiration-container");
    private By pasteNameTitle = By.id("postform-name");
    private By submit = By.xpath("//button[@class='btn -big']");
    private By SyntaxHighlightingDDL = By.id("select2-postform-format-container");


//    @FindBy(id = "postform-text");
//    private WebElement input;


    public MainPage(WebDriver driver) {
                this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPage enterTextToPasteField(String text) {
        driver.findElement(pasteField).sendKeys(text);
        return this;
    }

    public MainPage setExpiration(String time) {
        driver.findElement(pasteExpirationDDL).click();
        driver.findElement(By.xpath(String.format("//li[text()='%s']", time))).click();
        return this;
    }

    public MainPage setNameTitle(String text) {
        driver.findElement(pasteNameTitle).sendKeys(text);
        return this;
    }

    public CreatedPastePage createPaste() {
        driver.findElement(submit).click();
        sleep(2000);
        return new CreatedPastePage(driver);
    }

    public MainPage setHihlighting(String lang) {
        driver.findElement(SyntaxHighlightingDDL).click();
        driver.findElement(By.xpath(String.format("//li[text()='%s']", lang))).click();
        return this;
    }
}
