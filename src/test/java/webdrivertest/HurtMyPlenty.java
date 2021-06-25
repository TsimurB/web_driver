package webdrivertest;

import driver.ChromeDriverProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageobjectgooglecloud.EstimatePage;
import pageobjectgooglecloud.MainPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HurtMyPlenty {

    private static final String VMCLASS = "Regular";
    private static final String INSTANCETYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String REGION = "Frankfurt (europe-west3)";
    private static final String LOCALSSD = "2x375 GB";
    private static final String COMMITMENTTERM = "1 Year";
    private EstimatePage estimatePage;


//    public static class Knjkfl {
//        public static void main(String[] args) {
//            System.out.println("30 GB 30 GiB".replaceAll("[GB | GiB]", "").trim());
//        }
//    }

    @AfterAll
    public void closeDriver() {
        ChromeDriverProvider.getDriver().close();
    }

    @BeforeAll

    public void preparation() {
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
    }

    @Test
    public void verifyVMClassTest() {
        assertThat(estimatePage.getVMClass())
                .contains(VMCLASS);
    }

    @Test
    public void verifyInstanceTypeTest() {
        assertThat(estimatePage.getInstanceType())
                .contains(INSTANCETYPE.replaceAll("\\(.*\\)", "").trim());
    }

    @Test
    public void verifyRegionTest() {
        assertThat(estimatePage.getRegion())
                .contains(REGION.replaceAll("\\(.*\\)", "").trim());
    }

    @Test
    public void verifyLocalSSDTest() {
        assertThat(estimatePage.getLocalSSD().replaceAll("[GB | GiB]", "").trim())
                .contains(LOCALSSD.replaceAll("[GB | GiB]", "").trim());
    }

    @Test
    public void verifyCommitmentTermTest() {
        assertThat(estimatePage.getCommitmentTerm())
                .contains(COMMITMENTTERM);
    }
}
