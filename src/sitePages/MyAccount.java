package sitePages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import utilities.DataFeed;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTime;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyAccount extends DriverUntility {


    //---------------create account and goto My account----------------
    public static void creatingAccount() throws InterruptedException {
        //Locate signin button and click for further options
        WebElement signinButton = driver.findElement(By.xpath("//a[@data-remodal-trigger='signin']"));
        signinButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        //Identify Join locator and click on that , join button is taking time to display in DOM hence using explicit wait
        WebElement joinButton;
        joinButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@data-remodal-trigger='join']"))));
        joinButton.click();
        Thread.sleep(3000);

        //Find email Entry locator
        WebElement emailEntry = driver.findElement(By.id("modal-signin-email"));

        //Generating new email with random number at end and enter that email id
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String EmailID = "amtgbtest" + randomInt + "@hm.com";
        System.out.println("emailid:" + EmailID);
        emailEntry.sendKeys(EmailID);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Locate password entery and Enter password
        WebElement passwordEntry = driver.findElement(By.id("modal-signin-password"));
        passwordEntry.sendKeys(DataFeed.PASSWORD);

        //Locate DOB areas and enter hardcoded values
        WebElement DOBdateEntry = driver.findElement(By.id("modal-signin-day"));
        WebElement DOBmonthEntry = driver.findElement(By.id("modal-signin-month"));
        WebElement DOByearEntry = driver.findElement(By.id("modal-signin-year"));
        WebElement submitform = driver.findElement(By.xpath("//button[@data-submit-redirect='/en_gb/register/newcustomer']"));
        Thread.sleep(3000);
        DOBdateEntry.sendKeys("31");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DOBmonthEntry.sendKeys("12");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DOByearEntry.sendKeys("1999");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        submitform.click();
        //After submit wait for few seconds , we can use explicite wait as well
        Thread.sleep(5000);

        //after creating account Klarna widget popup - closing
        WebElement xbutton = driver.findElement(By.xpath("//button[@class='ModalContent--close___367v2']"));
        xbutton.click();
        Thread.sleep(3000);
    }
  //---------------------My Account Navigation-----------------------
    public static void myAccountNavigationToSettings(){

        //Goto MyAccount
        WebElement myAccountButton = driver.findElement(By.xpath("//a[@href='/en_gb/account']"));
        myAccountButton.click();
        //Select MySettings
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/en_gb/settings']")))).click();
        //Select Edit details
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@href='/en_gb/settings/mydetails']")))).click();
       //Collecting email for assertion
        String email= WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email")))).getText();
        String currentUrl = driver.getCurrentUrl();
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("profile-firstName")))).clear();

        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("profile-firstName")))).sendKeys("NewName");


        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("saveProfileDetails")))).click();
        String  updatedName = WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("profile-firstName")))).getText();
        System.out.println(updatedName);

    }

    public static void myAccountNavigationToMembershipInfo() throws InterruptedException {

        //Goto MyAccount
        WebElement myAccountButton = driver.findElement(By.xpath("//a[@href='/en_gb/account']"));
        myAccountButton.click();
        //Select Membership info
        Thread.sleep(3000);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@href='/en_gb/settings']")));


        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,4500)", "");

        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/aside/div[4]/div/ul/li[1]")))).click();
        String membershipPageUrl = driver.getCurrentUrl();

        Assert.assertEquals(membershipPageUrl,"https://www2.hm.com/en_gb/member/info.html");

    }

    public static void myAccountNavigationToClubcard() throws InterruptedException {

        //Goto MyAccount
        WebElement myAccountButton =  driver.findElement(By.xpath("//a[@href='/en_gb/account']"));
        myAccountButton.click();
        Thread.sleep(3000);
         //JavascriptExecutor js=(JavascriptExecutor) driver;
         //js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//a[@role='button']")));

        //Select Membership info
        WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/aside/div[2]")))).click();
        String barCode = WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/aside/div[2]")))).getText();
        String membershipPageUrl = driver.getCurrentUrl();
        System.out.println(barCode);
        Thread.sleep(3000);
         WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"portal\"]/div/div[2]/button")))).click();


        Assert.assertEquals(membershipPageUrl,"https://www2.hm.com/en_gb/account");

    }

}

