package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import pageobjectgooglecloud.CalculatorFrame;
import pageobjectgooglecloud.EmailEstimatePage;
import pageobjectgooglecloud.EmailPage;
import pageobjectgooglecloud.MainPage;

import static util.Util.switchToTab;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hardcore {
    private CalculatorFrame calculatorFrame;
    public WebDriver driver;

    @BeforeAll
    public void openDriver() {
        driver = ChromeDriverProvider.getDriver();
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
        EmailEstimatePage emailEstimatePage = mainPage.open()
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
        String email = emailPage.open()
        .copyEmail();
        switchToTab(0);
        emailEstimatePage.typeEmail(email);

    }
}
