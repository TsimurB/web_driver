package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;


import static util.Util.*;

public class EmailPage {
    private ChromeDriver driver;
    private By copyEmailButton = By.id("pre_copy");
    public static final String TAB_NAME="Временная электронная почта";
    private static final String EMAIL_PAGE_ADDRESS = "https://tempmail.plus/ru/#!";

    public EmailPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public EmailPage open() {
        openTab(EMAIL_PAGE_ADDRESS);
        switchToTab(1);
        return this;
    }

    public String copyEmail(){
        click(copyEmailButton);
        try {
            return  (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
