package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static util.Util.click;

public class EmailEstimatePage {
public static final String TAB_NAME="Google Cloud Platform";
private By emailField = By.xpath("//input[@type=\"email\"]");

    private final ChromeDriver driver;

    public EmailEstimatePage(ChromeDriver driver) {
        this.driver = driver;
//        PageFactory.initElements(driver, this);
    }

    public EmailEstimatePage typeEmail(String email){

        driver.findElement(emailField).sendKeys(email);
        return this;
    }


//    public void createEmailEstimate() {
//    }
}
