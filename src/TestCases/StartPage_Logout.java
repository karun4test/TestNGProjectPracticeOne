package TestCases;

import utilities.BrowserClose;
import sitePages.StartPage;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartPage_Logout extends DriverUntility {

    @Test
    public static void logoutTest() throws InterruptedException {
        StartPage.logout();
        Thread.sleep(3000);
        WebElement afterLogout = driver.findElement(By.xpath("//a[@data-signin-state='guest']"));
        System.out.println(afterLogout.getText());
        Thread.sleep(3000);

        //Verification
        String afterLogoutLabel = afterLogout.getText();
        Assert.assertEquals(afterLogoutLabel, "Sign in");

    }
    @Test (dependsOnMethods = {"logoutTest"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }

}
