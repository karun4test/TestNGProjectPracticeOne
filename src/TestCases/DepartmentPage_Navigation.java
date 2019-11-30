package TestCases;

import sitePages.StartPage;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepartmentPage_Navigation extends  DriverUntility {

       @Test
        public static void departmentNavigation() throws InterruptedException {
            DriverUntility.browserInitiation();
            SiteLaunch.browserLaunch();
            StartPage.menDepartmentSelection();

           String currentUrl = driver.getCurrentUrl();
           String expectedUrl = "https://www2.hm.com/en_gb/men/shop-by-product/view-all.html";
           Assert.assertEquals(currentUrl,expectedUrl);
           BrowserClose.browserCls();
        }

    @Test (dependsOnMethods = {"departmentNavigation"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }

    }


