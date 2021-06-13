package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Util.sleep;

public class MainPageHurtMePlenty {
    private static final String PAGE_ADDRESS = "https://cloud.google.com/";
    private WebDriver driver;
    private By search = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private By choseCalk = By.xpath("//a[@class='gs-title']//b");
    private By compEngine = By.xpath("//div[@class='hexagon-in2']");

    //div[@title="Compute Engine"]

    private By searchField = By.id("postform-text");
    private By syntaxHighlightingDDL = By.id("select2-postform-format-container");
    private By pasteExpirationDDL = By.id("select2-postform-expiration-container");
    private By pasteNameTitle = By.id("postform-name");
    private By submit = By.xpath("//button[@class='btn -big']");


    public MainPageHurtMePlenty(WebDriver driver) {
        this.driver = driver;
    }

    public MainPageHurtMePlenty open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPageHurtMePlenty searchPage(String text) {
        driver.findElement(search).click();
        sleep(2000);
        driver.findElement(search).sendKeys(text);
        sleep(2000);
        return this;
    }


    public MainPageHurtMePlenty findCalk() {
        driver.findElement(choseCalk).click();
        sleep(2000);
        return this;
    }


    public MainPageHurtMePlenty initCompEngine() {
        driver.findElement(compEngine).click();
        sleep(2000);
        return this;
    }

//    public MainPageBringItOn setExpiration(String time) {
//        driver.findElement(pasteExpirationDDL).click();
//        sleep(2000);
//        driver.findElement(By.xpath(String.format("//li[text()='%s']", time))).click();
//        sleep(2000);
//        return this;
//    }
//
//    public MainPageBringItOn setHihlighting(String lang) {
//        driver.findElement(SyntaxHighlightingDDL).click();
//        sleep(2000);
//        driver.findElement(By.xpath(String.format("//li[text()='%s']", lang))).click();
//        sleep(2000);
//        return this;
//    }
//
//    public MainPageBringItOn setNameTitle(String text) {
//        driver.findElement(pasteNameTitle).sendKeys(text);
//        sleep(2000);
//        return this;
//    }
//
//    public MainPageICanWin newPage() {
//        driver.findElement(submit).click();
//        sleep(2000);
//        return newPage();
//    }
}
