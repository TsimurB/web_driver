package pageobjectgooglecloud;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static util.Util.*;

public class EmailPage {
    private WebDriver driver;
    private By copyEmailButton = By.id("pre_copy");
    public static final String TAB_NAME="Временная электронная почта";
    private static final String EMAIL_PAGE_ADDRESS = "https://tempmail.plus/ru/#!";

    public EmailPage(WebDriver driver) {
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
