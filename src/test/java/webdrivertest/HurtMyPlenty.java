package webdrivertest;

import driver.ChromeDriverProvider;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageobjectgooglecloud.EstimatePage;
import pageobjectgooglecloud.MainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.Util.getPageTitle;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HurtMyPlenty {

    private EstimatePage estimatePage;

    @BeforeAll
    public void openDriver() {
        ChromeDriverProvider.getDriver();
    }

    @AfterAll
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

    @Test
    public void verifyThatTitleCorrectTest() {
        String VMCLASS = "Regular";
        String INSTANCETYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
        String REGION = "Frankfurt (europe-west3)";
        String LOCALSSD = "2x375 GB";
        String COMMITMENTTERM = "1 Year";


        this.estimatePage = new EstimatePage(ChromeDriverProvider.getDriver());
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
        assertions.assertThat(estimatePage.getVMClass()).containsIgnoringCase(VMCLASS);
        assertions.assertThat(estimatePage.getInstanceType())
                .contains(INSTANCETYPE.replaceAll("\\(.*\\)", "").trim());
        assertions.assertThat(estimatePage.getRegion())
                .contains(REGION.replaceAll("\\(.*\\)", "").trim());
        assertions.assertThat(estimatePage.getLocalSSD().replaceAll("[GB | GiB]", "").trim())
                .contains(LOCALSSD.replaceAll("[GB | GiB]", "").trim());
        assertions.assertThat(estimatePage.getCommitmentTerm())
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
