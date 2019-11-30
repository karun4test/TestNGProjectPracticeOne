package sitePages;

import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class CustomerService extends DriverUntility {

    // Navigate to Customer service page

    public static void appsDownloadLinks() throws InterruptedException {

        /* Click on three dots > navigate to android app link > click on that > new window will open > handle that > assert with Title or Url */

        WebElement androidAppLink, threeDots, iOSappLink, newsLetter;
        threeDots = driver.findElement(By.xpath("//button[@class='icon-more more-links__button']"));
        threeDots.click();

        androidAppLink = driver.findElement(By.xpath("//a[@href='https://play.google.com/store/apps/details?id=com.hm.goe']"));
        androidAppLink.click();
        Thread.sleep(5000);


        System.out.println("Intial Window:" + driver.getTitle());
        //To handle Window
        Set<String> winIds = driver.getWindowHandles();
        Iterator<String> Itera = winIds.iterator();
            /* while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {  */
        String masterWindow = Itera.next();
        String masterWindowTitle = driver.getTitle();
        System.out.println("Master Window:" + masterWindowTitle);
        String childWindow = Itera.next();

        driver.switchTo().window(childWindow);
        String childWindowTitle = driver.getTitle();
        System.out.println("Child Window:" + childWindowTitle);


    }

    public static void iosApplink() throws InterruptedException {

        /* Click on three dots > navigate to android app link > click on that > new window will open > handle that > assert with Title or Url */

        WebElement androidAppLink, threeDots, iOSappLink, newsLetter;
        threeDots = driver.findElement(By.xpath("//button[@class='icon-more more-links__button']"));
        threeDots.click();

        androidAppLink = driver.findElement(By.xpath("//a[@href='https://itunes.apple.com/app/h-m/id589351740']"));
        androidAppLink.click();
        Thread.sleep(5000);


        System.out.println("Intial Window:" + driver.getTitle());
        //To handle Window
        Set<String> winIds = driver.getWindowHandles();
        Iterator<String> Itera = winIds.iterator();
            /* while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {  */
        String masterWindow = Itera.next();
        String masterWindowTitle = driver.getTitle();
        System.out.println("Master Window:" + masterWindowTitle);
        String childWindow = Itera.next();

        driver.switchTo().window(childWindow);
        String childWindowTitle = driver.getTitle();
        System.out.println("Child Window:" + childWindowTitle);


    }


}

//Fill any form like news letter subscription from Customer service

