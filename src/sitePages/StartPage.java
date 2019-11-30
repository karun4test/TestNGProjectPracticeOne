package sitePages;

import utilities.DataFeed;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitTime;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StartPage extends DriverUntility {


    //-------------Login From Start page---------------------------------
    public static void login() throws InterruptedException {


        WebElement signinOption = driver.findElement(By.xpath("//a[@class='menu__myhm']"));
        System.out.println(signinOption.getText());
        signinOption.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Locate username , password and submit elements
        WebElement userName = driver.findElement(By.id("modal-txt-signin-email"));
        WebElement password = driver.findElement(By.id("modal-txt-signin-password"));
        WebElement submit = driver.findElement(By.xpath("//button[@class='button large js-set-session-storage btn-login']"));

        //Enter username
        System.out.println("Username:" + DataFeed.USERNAME);
        userName.sendKeys(DataFeed.USERNAME);
        //Thread.sleep(3000);

        //Enter Password
        System.out.println("Password:" + DataFeed.PASSWORD);
        WaitTime.wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(DataFeed.PASSWORD);
        //Thread.sleep(3000);
        WaitTime.wait.until(ExpectedConditions.elementToBeClickable(submit));
        //Submit above enries for login
        submit.click();

        //Sigin label text for Assert comparision
        String signinName = signinOption.getText();
        System.out.println("Login successfull");
        Thread.sleep(3000);

    }


    //-----------Logot test after above signin function only we can execute -----------
    public static void logout() throws InterruptedException {
        //After login MyAccount label will display which we need to locate the element
        WebElement myAccount = driver.findElement(By.xpath("//a[@href='/en_gb/account']"));
        //Thread.sleep(3000);
        WaitTime.wait.until(ExpectedConditions.visibilityOf(myAccount));
        //Hover to my account and click on signout option
        Actions hover = new Actions(driver);
        hover.moveToElement(myAccount).moveToElement(driver.findElement(By.xpath("//a[@href='/en_gb/logout']"))).click().build().perform();
        System.out.println("Hover move to MyAccount");
        Thread.sleep(4000);
    }

    //--------------------Department Selection from start page---------------------------
    public static void menDepartmentSelection() throws InterruptedException {
        //locate 'men' department in the start page
        WebElement menDepartment = driver.findElement(By.xpath("//a[@href='/en_gb/men.html']"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(menDepartment));

        //Select men subdepartment and wait until locator available
        Actions action = new Actions(driver);
        action.moveToElement(menDepartment).moveToElement(driver.findElement(By.xpath("//a[@href='/en_gb/men/shop-by-product/view-all.html']"))).click().build().perform();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//a[@href='/en_gb/men/shop-by-product/view-all.html']"))));

    }


    //--------------------Search function -------------------------------------
    public static void search() throws InterruptedException {

        //Find Search editor, Enter "Jeans" and click
        WebElement searchEditor = driver.findElement(By.xpath("//input[@id='main-search']"));
        searchEditor.sendKeys("jeans");
        Thread.sleep(4000);

        //Locate search button and activate bu click search button
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='menu__search_submit']"));
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Load all search result elements in list for future use and print search result size for assertion
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='product-item']"));
        System.out.println("Search result Total Items:" + elements.size());


    }
}
