package webdrivertest;

import driver.ChromeDriverProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageobjectgooglecloud.CalculatorFrame;
import pageobjectgooglecloud.MainPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HurtMyPlenty {

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
    public void verifyThatTitleCorrectTest() {
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
                .createEstimatePage();

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(calculatorFrame.getVMClass()).containsIgnoringCase(VMCLASS);
        assertions.assertThat(calculatorFrame.getInstanceType())
                .contains(INSTANCETYPE.replaceAll("\\(.*\\)", "").trim());
        assertions.assertThat(calculatorFrame.getRegion())
                .contains(REGION.replaceAll("\\(.*\\)", "").trim());
        assertions.assertThat(calculatorFrame.getLocalSSD().replaceAll("[GB | GiB]", "").trim())
                .contains(LOCALSSD.replaceAll("[GB | GiB]", "").trim());
        assertions.assertThat(calculatorFrame.getCommitmentTerm())
                .contains(COMMITMENTTERM);
        assertions.assertAll();
    }

//    @Test
//    public void verifyVMClassTest() {
//        assertThat(estimatePage.getVMClass())
//                .contains(VMCLASS);
//    }

//    @Test
//    public void verifyInstanceTypeTest() {
//        assertThat(estimatePage.getInstanceType())
//                .contains(INSTANCETYPE.replaceAll("\\(.*\\)", "").trim());
//    }

//    @Test
//    public void verifyRegionTest() {
//        assertThat(estimatePage.getRegion())
//                .contains(REGION.replaceAll("\\(.*\\)", "").trim());
//    }

//    @Test
//    public void verifyLocalSSDTest() {
//        assertThat(estimatePage.getLocalSSD().replaceAll("[GB | GiB]", "").trim())
//                .contains(LOCALSSD.replaceAll("[GB | GiB]", "").trim());
//    }

//    @Test
//    public void verifyCommitmentTermTest() {
//        assertThat(estimatePage.getCommitmentTerm())
//                .contains(COMMITMENTTERM);
//    }
}
