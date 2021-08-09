package pageobjectpastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatedPastePage {

    private By highlightedCodeElement = By.xpath("//div[@class='highlighted-code']//a");
    private By resCode = By.xpath("//textarea[@class='textarea']");
    private ChromeDriver driver;

    public CreatedPastePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getHihlighting() {
        return driver.findElement(highlightedCodeElement).getText();
    }

    public String getCode() {
        return driver.findElement(resCode).getText();
    }


}
