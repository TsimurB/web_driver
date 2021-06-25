package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Util.sleep;

public class CalculatorFrame {

    private final By compEngine = By.xpath("//div[@title=\"Compute Engine\"]");
    private final By numberOfInstances = By.xpath("//input[@id='input_66']");
    private final By operatingSystemAndSoftwareDDD = By.id("select_value_label_58");
    private final By virtualMClassDDD = By.id("select_value_label_59");
    private final By instanceSeriesDDD = By.id("select_value_label_61");
    private final By instanceTypeDDD = By.id("select_value_label_62");
    private final By CheckboxAddGPUs = By.xpath("//form[@name=\"ComputeEngineForm\"]//md-checkbox/div[contains(text(),\"Add GPUs\")]");
    private final By numberOfGPUsDDD = By.xpath("//md-select-value[@id=\"select_value_label_410\"]//div");
    private final By typeGPUsDDD = By.xpath("//md-select-value[@id=\"select_value_label_411\"]//div");
    private final By localSSD = By.xpath("//md-select-value[@id=\"select_value_label_372\"]//div");
    private final By datacenterLocationDDD = By.xpath("//md-select-value[@id=\"select_value_label_63\"]//div");
    private final By committedUsageDDD = By.xpath("//md-select-value[@id=\"select_value_label_105\"]//div");
    private final By submitAddToEstimateComputeEngineForm = By.xpath("/form[@name=\"ComputeEngineForm\"]//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"]");


    private final WebDriver driver;

    public CalculatorFrame(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorFrame initCompEngine() {
        driver.findElement(compEngine).click();
        return this;
    }

    public CalculatorFrame setNumberOfInstances(String text) {
        driver.findElement(numberOfInstances).sendKeys(text);
        sleep(2000);
        return this;
    }


    public CalculatorFrame setOperatingSystemAndSoftware(String text) {
        driver.findElement(operatingSystemAndSoftwareDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text))).click();
        return this;
    }

    public CalculatorFrame setVMClass(String text) {
        driver.findElement(virtualMClassDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text))).click();
        return this;
    }

    public CalculatorFrame setInstanceSeries(String text) {
        driver.findElement(instanceSeriesDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text))).click();
        return this;
    }

    public CalculatorFrame setInstanceType(String type) {
        driver.findElement(instanceTypeDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type))).click();
        return this;
    }

    public CalculatorFrame setCheckboxAddGPUs(Integer number, String type) {
        driver.findElement(CheckboxAddGPUs).click();
        driver.findElement(numberOfGPUsDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", number))).click();
        driver.findElement(typeGPUsDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type))).click();
        return this;
    }

    public CalculatorFrame setLocalSSD(String type) {
        driver.findElement(localSSD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type))).click();
        return this;
    }

    public CalculatorFrame setDatacenterLocation(String type) {
        driver.findElement(datacenterLocationDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type))).click();
        return this;
    }

    public CalculatorFrame setCommittedUsage(String type) {
        driver.findElement(committedUsageDDD).click();
        driver.findElement(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type))).click();
        return this;
    }

    public EstimatePage createEstimatePage() {
        driver.findElement(submitAddToEstimateComputeEngineForm).click();
        return new EstimatePage(driver);
    }


}
