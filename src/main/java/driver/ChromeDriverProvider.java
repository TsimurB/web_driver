package driver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverProvider {
    private static ChromeDriver driver;

    public static ChromeDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

}
