package TestCases;

import sitePages.ShoppingBag;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Shoppingbag_Login extends DriverUntility{
    @Test
    public void EmptySBLogin() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        ShoppingBag.emptySBLogin();
        WebElement afterLogin = driver.findElement(By.xpath("//a[@data-signin-state='signedin']"));
        String lableOne = afterLogin.getText();
        Assert.assertEquals(lableOne , "My Account");

    }
    @Test (dependsOnMethods = {"EmptySBLogin"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
