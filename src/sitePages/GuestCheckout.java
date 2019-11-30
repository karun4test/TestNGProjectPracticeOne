package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DataFeed;
import utilities.DriverUntility;
import utilities.WaitTime;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GuestCheckout extends DriverUntility {

    // Go for guest checkout basic flow first page
    public static void guestCheckout() throws InterruptedException {
        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='button button-big']")))).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)", "");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@ng-click='trackGuestCustomer()']")))).click();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("button.button-big:nth-child(2)")))).click();
        // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/main/div/div/div/section[2]/form[2]/button")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("newBillingAddress-firstName")))).sendKeys(DataFeed.FIRSTNAME);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("newBillingAddress-lastName")))).sendKeys(DataFeed.LASTNAME);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("newBillingAddress-line1")))).sendKeys(DataFeed.ADD1);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("newBillingAddress-town")))).sendKeys(DataFeed.ADD2);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("newBillingAddress-postalCode")))).sendKeys(DataFeed.POSTCODE);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email")))).sendKeys(DataFeed.USERNAME);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("privacy-policy")))).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='checkoutAddressPartForm']/button")))).submit();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("un-validated-address")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='address-validation-popup']/div[2]/button[2]")))).click();

        List<WebElement> paymentMethods = driver.findElements(By.xpath("//li[@data-ng-value='entry.code']"));//*[@id="radio-0"]
        System.out.println("Number of menthods :" + paymentMethods.size());

        driver.findElement(By.id("radio-3")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("radio-0")))).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement PyamentButton = driver.findElement(By.id("checkoutDeliveryPartSubmit"));

        String phnum = driver.findElement(By.id("user-phone")).getText();
        System.out.println(phnum);
        //Thread.sleep(4000);
        //scroll up to the desired element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", PyamentButton);

        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-phone"))));
        // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("user-phone")))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@data-ng-model='newDeliveryAddress.cellPhone']")).sendKeys("7801680000");


        // WebElement myElement = driver.findElement(By.id("user-phone"));

        // WebElement phoneEntry = driver.findElement(By.id("user-phone"));
        // System.out.println("X :" + phoneEntry.getLocation().getX());
        // System.out.println("Y :" + phoneEntry.getLocation().getY());
        // int l=phoneEntry.getLocation().getY();

        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].scrollIntoView();", phoneEntry);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("checkoutDeliveryPartSubmit")))).click();
        //  Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[@id='user-phone']")).click();


        //  driver.findElement(By.xpath("//*[@id='user-phone']")).sendKeys(DataFeed.PHONENUMBER);
        // driver.findElement(By.xpath("//*[@id='user-phone']")).sendKeys(DataFeed.PHONENUMBER);
        // Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.id("user-phone"))).click().build().perform();
        //action.moveToElement(driver.findElement(By.id("user-phone"))).sendKeys(DataFeed.PHONENUMBER).build().perform();

       Thread.sleep(3000);
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-ng-model='$parent.$parent.$parent.card_number']")))).sendKeys(DataFeed.CREDITCARD);
        //Thread.sleep(3000);
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-ng-model='$parent.$parent.$parent.card_month']")))).sendKeys(DataFeed.CCMM);
        //Thread.sleep(3000);
       WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-ng-model='$parent.$parent.$parent.card_year']")))).sendKeys(DataFeed.CCYYYY);

       WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-ng-model='$parent.$parent.$parent.card_cvn']")))).sendKeys(DataFeed.CVC);
        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='placeOrderFormId']/div[2]/button")))).submit();
        System.out.println("All enteries are done .. please check which environment are you testing ..and we will do it dynamic loading these fields later");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);


    }

}
