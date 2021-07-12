package webdrivertest;

import driver.ChromeDriverProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageobjectgooglecloud.CalculatorFrame;
import pageobjectgooglecloud.EmailPage;
import pageobjectgooglecloud.MainPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hardcore {
    private CalculatorFrame calculatorFrame;

    @BeforeAll
    public void openDriver() {
        ChromeDriverProvider.getDriver();
    }

//    @AfterAll
//    public void closeDriver() {
//        ChromeDriverProvider.getDriver().close();
//    }

    @Test
    public void verifyThatSendEmailCorrespondsToTheDataOfTheCalculatorTest() {
        String VMCLASS = "Regular";
        String INSTANCETYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        String REGION = "Frankfurt (europe-west3)";
        String LOCALSSD = "2x375 GB";
        String COMMITMENTTERM = "1 Year";

        this.calculatorFrame = new CalculatorFrame(ChromeDriverProvider.getDriver());
        MainPage mainPage = new MainPage(ChromeDriverProvider.getDriver());
        mainPage.open()
                .searchPage("Google Cloud Platform Pricing Calculator" + "\n")
                .findCalk()
                .switchToCalculator()
                .initCompEngine()
                .setNumberOfInstances("4")
                .setOperatingSystemAndSoftware("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS")
                .setVMClass(VMCLASS)
                .setInstanceSeries("N1")
                .setInstanceType(INSTANCETYPE)
                .setCheckboxAddGPUs(1, "NVIDIA Tesla V100")
                .setLocalSSD(LOCALSSD)
                .setDatacenterLocation(REGION)
                .setCommittedUsage(COMMITMENTTERM)
                .createEstimatePage()
                .createEmailEstimate();

        EmailPage emailPage = new EmailPage(ChromeDriverProvider.getDriver());
        emailPage.open();


    }
}
