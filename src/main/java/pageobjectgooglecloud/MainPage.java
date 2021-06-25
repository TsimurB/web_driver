package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Util.sleep;

public class MainPage {
    private static final String PAGE_ADDRESS = "https://cloud.google.com/";
    private WebDriver driver;
    private final By search = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private final By choseCalk = By.xpath("//div[@class='gs-title']//b[contains(text(),'Google Cloud Platform Pricing Calculator')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPage searchPage(String text) {
        driver.findElement(search).click();
        sleep(2000);
        driver.findElement(search).sendKeys(text);
        sleep(2000);
        return this;
    }

    public MainPage findCalk() {
        driver.findElement(choseCalk).click();
        return this;
    }


    public CalculatorFrame switchToCalculator() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'https://cloud.google.com/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        return new CalculatorFrame(driver);
    }
}
