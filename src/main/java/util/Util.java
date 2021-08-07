package util;

import driver.ChromeDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static driver.ChromeDriverProvider.getDriver;

public class Util {
    private static final String EMAIL_PAGE_ADDRESS = "https://tempmail.plus/ru/#!";
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
        sleep(500);
    }

    private static Wait getWait(int seconds) {
        return new FluentWait<>(ChromeDriverProvider.getDriver())
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    public static void openTab(String address) {
        ((JavascriptExecutor) ChromeDriverProvider.getDriver()).executeScript(String.format("window.open('%s');",address));
    }

    public static void switchToTab(int tabIndex){
        List<String> requireTab = ChromeDriverProvider.getDriver().getWindowHandles().stream()
               .collect(Collectors.toList());
        ChromeDriverProvider.getDriver().switchTo().window(requireTab.get(tabIndex));
    }
}
