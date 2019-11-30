package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import sitePages.GuestCheckout;
import sitePages.ShoppingBag;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;

public class GuestCheckout_Navigation extends DriverUntility {

    @Test
    public void guestCheckout() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        ShoppingBag.addProduct();
        GuestCheckout.guestCheckout();
       String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,"https://www2.hm.com/en_gb/checkout#!#error-popup");
    }
    @Test (dependsOnMethods = {"guestCheckout"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
