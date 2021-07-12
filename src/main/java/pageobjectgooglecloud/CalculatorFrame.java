package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static util.Util.click;
import static util.Util.sleep;

public class CalculatorFrame {

    private final By compEngine = By.xpath("//div[@title=\"Compute Engine\"]");
    private final By numberOfInstances = By.xpath("//label[contains(text(),\"Number of instances\")]/following-sibling::input");
    private final By operatingSystemAndSoftwareDDD = By.xpath("//label[contains(text(),\"Operating System / Software\")]/following-sibling::md-select");
    private final By virtualMClassDDD = By.xpath("//label[contains(text(),\"Machine Class\")]/following-sibling::md-select");
    private final By instanceSeriesDDD = By.xpath("//label[text()=\"Series\"]/following-sibling::md-select");
    private final By instanceTypeDDD = By.xpath("//label[text()=\"Machine type\"]/following-sibling::md-select");
    private final By CheckboxAddGPUs = By.xpath("//form[@name=\"ComputeEngineForm\"]//md-checkbox/div[contains(text(),\"Add GPUs\")]");
    private final By numberOfGPUsDDD = By.xpath("//label[text()=\"Number of GPUs\"]/following-sibling::md-select");
    private final By typeGPUsDDD = By.xpath("//label[text()=\"GPU type\"]/following-sibling::md-select");
    private final By localSSD = By.xpath("//label[text()=\"Local SSD\"]/following-sibling::md-select");
    private final By datacenterLocationDDD = By.xpath("//label[text()=\"Datacenter location\"]/following-sibling::md-select");
    private final By committedUsageDDD = By.xpath("//label[text()=\"Committed usage\"]/following-sibling::md-select");
    private final By submitAddToEstimateComputeEngineForm = By.xpath("//form[@name=\"ComputeEngineForm\"]//button[@class=\"md-raised md-primary cpc-button md-button md-ink-ripple\"]");

    private final By virtualMClass = By.xpath("//div[contains(text(),\"VM class: \")]");
    private final By instanceType = By.xpath("//div[contains(text(),\"Instance type: \")]");
    private final By region = By.xpath("//div[contains(text(),\"Region: \")]");
    private final By localSSDcheck = By.xpath("//div[contains(text(),\"local SSD \")]");
    private final By commitmentTerm = By.xpath("//div[contains(text(),\"Commitment term: \")]");

    private final WebDriver driver;

    public CalculatorFrame(WebDriver driver) {
        this.driver = driver;
    }

    public CalculatorFrame initCompEngine() {
        click(compEngine);
        return this;
    }

    public CalculatorFrame setNumberOfInstances(String text) {
        driver.findElement(numberOfInstances).sendKeys(text);
        return this;
    }


    public CalculatorFrame setOperatingSystemAndSoftware(String text) {

        click(operatingSystemAndSoftwareDDD);
        click(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text)));
        return this;
    }

    public CalculatorFrame setVMClass(String text) {
        click(virtualMClassDDD);
        driver.findElements(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text))).get(1).click();
        return this;
    }

    public CalculatorFrame setInstanceSeries(String text) {
        click(instanceSeriesDDD);
        click(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", text)));
        return this;
    }

    public CalculatorFrame setInstanceType(String type) {
        click(instanceTypeDDD);
        click(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type)));
        return this;
    }

    public CalculatorFrame setCheckboxAddGPUs(Integer number, String type) {
        click(CheckboxAddGPUs);
        click(numberOfGPUsDDD);
        click(By.xpath(String.format("//md-option[contains(@ng-repeat,\"supportedGpuNumbers\")]/div[contains(text(),'%s')]", number)));
        click(typeGPUsDDD);
        click(By.xpath(String.format("//md-option[contains(@ng-repeat,\"gpuList\")]/div[contains(text(),'%s')]", type)));
        return this;
    }

    public CalculatorFrame setLocalSSD(String type) {
        click(localSSD);
        click(By.xpath(String.format("//md-option/div[contains(text(),'%s')]", type)));
        return this;
    }

    public CalculatorFrame setDatacenterLocation(String type) {
        click(datacenterLocationDDD);
        click(By.xpath(String.format("//md-select-menu[@class]//md-option[contains(@ng-repeat,\"fullRegionList\")]/div[contains(text(),'%s')]", type)));
        return this;
    }

    public CalculatorFrame setCommittedUsage(String type) {
        driver.findElement(committedUsageDDD).sendKeys(type);
        clickAway();
        return this;
    }

    public CalculatorFrame createEstimatePage() {
        click(submitAddToEstimateComputeEngineForm);
        return this;
    }

    public String getVMClass() {
        return driver.findElement(virtualMClass).getText();
    }

    public String getInstanceType() {
        return driver.findElement(instanceType).getText();
    }

    public String getRegion() { return driver.findElement(region).getText(); }

    public String getLocalSSD() { return driver.findElement(localSSDcheck).getText(); }

    public String getCommitmentTerm() {
        return driver.findElement(commitmentTerm).getText();
    }

    private void clickAway() {
        sleep(200);
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        sleep(500);
    }


}
