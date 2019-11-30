package TestCases;

import sitePages.CustomerService;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerService_AndroidApplink extends DriverUntility {

    /* Launch site > goto Customer service link > Click on IOS app link > Assert title*/
    @Test
    public static void ClickappLink() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        CustomerService.appsDownloadLinks();
        Assert.assertEquals(driver.getTitle(), "H&M - we love fashion - Apps on Google Play");
        driver.close();
        BrowserClose.browserCls();
    }

      @Test(dependsOnMethods = {"ClickappLink"}, alwaysRun = true)
        public void browserCloser() {
        BrowserClose.browserCls();
    }
}

