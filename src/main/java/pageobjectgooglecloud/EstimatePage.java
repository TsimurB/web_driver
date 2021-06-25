package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatePage {

    private By virtualMClass = By.xpath("//div[contains(text(),\"VM class: regular\")]");
    private By instanceType = By.xpath("//div[contains(text(),\"Instance type: n1-standard-8\")]");
    private By region = By.xpath("//div[contains(text(),\"Region: Frankfurt\")]");
    private By localSSD = By.xpath("//div[contains(text(),\"local SSD space 2x375 GiB\")]");
    private By commitmentTerm = By.xpath("//div[contains(text(),\"Commitment term: 1 Year\")]");
    private final WebDriver driver;


    public EstimatePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getVMClass() {
        return driver.findElement(virtualMClass).getText();
    }

    public String getInstanceType() {
        return driver.findElement(instanceType).getText();
    }

    public String getRegion() {
        return driver.findElement(region).getText();
    }

    public String getLocalSSD() {
        return driver.findElement(localSSD).getText();
    }

    public String getCommitmentTerm() {
        return driver.findElement(commitmentTerm).getText();
    }
}