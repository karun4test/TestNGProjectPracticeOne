package sitePages;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DataFeed;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.WaitTime;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingBag extends DriverUntility {

    //-------------------- Empty Shopping bag login--------------
    public static void emptySBLogin() throws InterruptedException {
        //Click on SB icon
        WebElement sbIcon = driver.findElement(By.xpath("//a[@href='/en_gb/cart']"));
        sbIcon.click();
        Thread.sleep(4000);

        //Identify EmptyShoppingbag signin click
        WebElement emptySBsignin = driver.findElement(By.xpath("//a[@data-remodal-trigger='signin']"));
        emptySBsignin.click();

        //On this page signin option getText() for future assertion
        WebElement signinOption = driver.findElement(By.xpath("//a[@class='menu__myhm']"));
        // System.out.println(signinOption.getText());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //on present signin page find elements for login, password and submit buton
        WebElement userName = driver.findElement(By.id("modal-txt-signin-email"));
        WebElement password = driver.findElement(By.id("modal-txt-signin-password"));
        WebElement submit = driver.findElement(By.xpath("//button[@class='button large js-set-session-storage btn-login']"));

        //Enter username
        System.out.println("Username:" + DataFeed.USERNAME);
        userName.sendKeys(DataFeed.USERNAME);
        Thread.sleep(3000);

        //Enter Password
        System.out.println("Password:" + DataFeed.PASSWORD);
        password.sendKeys(DataFeed.PASSWORD);
        Thread.sleep(3000);

        //Submit the entries
        submit.click();
        String signinName = signinOption.getText();
        System.out.println("Login successfull");
        Thread.sleep(3000);

        //Get afterLogin element for assertion in testcase
        WebElement afterLogin = driver.findElement(By.xpath("//a[@data-signin-state='signedin']"));

    }

    //-----------Add product to shopping bag from search result-----------------
    public static void addProduct() throws InterruptedException {
        //Identify search Editor and enter "jeans" word
        WebElement searchEditor = driver.findElement(By.xpath("//input[@id='main-search']"));
        searchEditor.sendKeys("jeans");
        searchEditor.click();

        //Click on search button for initiate search

        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='menu__search_submit']")))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Store the search result in list for future use
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='product-item']"));

        //Select for search result item
        elements.get(1).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //on Search PDP , select addToBag button
        // WebElement addToBag = driver.findElement(By.xpath("//span[@class='icon icon-shopping-bag-white']"));
        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='icon icon-shopping-bag-white']")))).click();

        //On clicking addToBag button size options will display and click on first available size
        List<WebElement> sizeElements = driver.findElements(By.xpath("//ul[@class='picker-list js-active-list scrollable-list']"));

        System.out.println("Product available sizes: " + sizeElements.size());
        for (int i = 0; i < sizeElements.size(); i++) {
            System.out.println("First Product:" + sizeElements.get(i).getText());
        }

        sizeElements.get(0).click();

        //WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@type='button']")))).click();


        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/en_gb/cart']")))).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
}
