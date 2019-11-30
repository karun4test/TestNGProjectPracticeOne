package TestCases;

import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import sitePages.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartPage_Login extends DriverUntility {

    @Test
    public static void loginTest() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        StartPage.login();
        //BrowserClose.BrowserCls();

        //Verification
        WebElement afterLogin = driver.findElement(By.xpath("//a[@data-signin-state='signedin']"));
        String lableOne = afterLogin.getText();
        Assert.assertEquals(lableOne, "My Account");

    }






}
