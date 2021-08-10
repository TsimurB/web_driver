package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverProvider {
    private static ChromeDriver driver;

    private ChromeDriverProvider() {
    }

    public static ChromeDriver getDriver() {
        if (driver == null) {
//            switch (System.getProperty("browser")) {
//                case "firefox": {
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                }
//                default: {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
//            }
//            driver.manage().window().maximize();
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();

        return driver;
    }
}
