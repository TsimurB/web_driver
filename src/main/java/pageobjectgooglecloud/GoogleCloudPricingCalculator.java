package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculator {
    private WebDriver driver;

    public GoogleCloudPricingCalculator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorFrame switchToCalculator() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'https://cloud.google.com/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        return new CalculatorFrame(driver);
    }
}
