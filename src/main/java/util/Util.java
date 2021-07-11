package util;

import driver.ChromeDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static driver.ChromeDriverProvider.getDriver;

public abstract class Util {
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getPageTitle() {
        return getDriver().getTitle();
    }

    public static void click(By locator) {
        getWait(5).until(driver -> ExpectedConditions.elementToBeClickable(locator));
        WebElement element1 = ChromeDriverProvider.getDriver().findElement(locator);
        element1.click();
    }

    private static Wait getWait(int seconds){
        return new FluentWait<>(ChromeDriverProvider.getDriver())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }
}
