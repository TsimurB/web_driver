package util;

import org.openqa.selenium.By;

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

//    public static String getPageValue(By resBash){
//        return getDriver().getPageSource();
//    }
}
