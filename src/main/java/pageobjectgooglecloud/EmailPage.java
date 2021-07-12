package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class EmailPage {
    private WebDriver driver;
    private static final String EMAIL_PAGE_ADDRESS = "https://10minutemail.com";
//    private final By createRandomeEmail = By.id("mail_address");

    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public EmailPage open() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + " t ");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(EMAIL_PAGE_ADDRESS);
        return this;
    }

//    public CalculatorFrame copyEmail(String text){
//        driver.get(createRandomeEmail).;
//    }
}
