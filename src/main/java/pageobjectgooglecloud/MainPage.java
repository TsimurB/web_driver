package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static util.Util.click;
import static util.Util.sleep;

public class MainPage {
    private static final String PAGE_ADDRESS = "https://cloud.google.com/";
    private WebDriver driver;
    private final By search = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private final By choseCalk = By.xpath("//div[@class='gs-title']//b[contains(text(),'Google Cloud Platform Pricing Calculator')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(PAGE_ADDRESS);
        return this;
    }

    public MainPage searchPage(String text) {
        driver.findElement(search).click();
        driver.findElement(search).sendKeys(text);
        return this;
    }

    public GoogleCloudPricingCalculator findCalk() {
        click(choseCalk);
        return new GoogleCloudPricingCalculator(driver);
    }
}
