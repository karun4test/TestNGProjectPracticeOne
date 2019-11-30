package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SiteLaunch extends DriverUntility {


    public static void browserLaunch() {

        if (DataFeed.BROWSER == "Firefox") {
            driver = new FirefoxDriver();
            driver.get("https://amt-www2.hm.com/en_gb/index.html");
            driver.get("https://" + DataFeed.ENV + DataFeed.TOUCHPOINT + ".hm.com/" + DataFeed.lOCALE + "/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            try {

                WebElement closecookie = driver.findElement(By.xpath("//button[@class='close icon-close-white js-close']"));
                closecookie.click();

                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='button modalconfirm modalclose js-read-gdpr']"))));
                WebElement popup = driver.findElement(By.xpath("//button[@class='button modalconfirm modalclose js-read-gdpr']"));
                String popupText = popup.getTagName();
                if (popupText.equals("button"))
                    popup.click();


            } catch (Exception e) {

                System.out.println("No Popup Here for Firefox Driver :) ");
            }
            //}
        } else if (DataFeed.BROWSER == "Chrome") {
            //    public static void cWebSite() {
            driver = new ChromeDriver();
            driver.get("https://" + DataFeed.ENV + DataFeed.TOUCHPOINT + ".hm.com/" + DataFeed.lOCALE + "/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            WebDriverWait wait = new WebDriverWait(driver, 10);

            try {

                WebElement closecookie = driver.findElement(By.xpath("//button[@class='close icon-close-white js-close']"));
                closecookie.click();

                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='button modalconfirm modalclose js-read-gdpr']"))));
                WebElement popup = driver.findElement(By.xpath("//button[@class='button modalconfirm modalclose js-read-gdpr']"));
                String popupText = popup.getTagName();
                if (popupText.equals("button"))
                    popup.click();


            } catch (Exception e) {

                System.out.println("No Popup Here for Chrome Driver) ");
            }
            //}
        }
    }
}
