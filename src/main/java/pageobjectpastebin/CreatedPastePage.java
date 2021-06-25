package pageobjectpastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatedPastePage {

    private By highlightedCodeElement = By.xpath("//div[@class='highlighted-code']//a");
    private By resCode = By.xpath("//textarea[@class='textarea']");
    private WebDriver driver;

    public CreatedPastePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHihlighting() {
        return driver.findElement(highlightedCodeElement).getText();
    }

    public String getCode() {
        return driver.findElement(resCode).getText();
    }


}
