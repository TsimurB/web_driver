package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPricingCalculator {
    private ChromeDriver driver;

    public GoogleCloudPricingCalculator(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CalculatorFrame switchToCalculator() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'https://cloud.google.com/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        return new CalculatorFrame(driver);
    }
}
