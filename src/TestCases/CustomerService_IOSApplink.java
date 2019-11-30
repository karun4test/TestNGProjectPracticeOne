package TestCases;

import sitePages.CustomerService;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerService_IOSApplink extends DriverUntility {
  /* Launch site > goto Customer service link > Click on IOS app link > Assert title*/
        @Test
        public static void ClickappLink() throws InterruptedException{
           DriverUntility.browserInitiation();
           SiteLaunch.browserLaunch();
            CustomerService.iosApplink();
            Assert.assertEquals (driver.getTitle(),"Connecting to the iTunes Store.");
            driver.close();
            BrowserClose.browserCls();
        }

        @Test (dependsOnMethods = {"ClickappLink"},alwaysRun = true)
        public void browserCloser(){
        BrowserClose.browserCls();
    }
    }

