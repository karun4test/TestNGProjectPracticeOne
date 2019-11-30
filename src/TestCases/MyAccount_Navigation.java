
package TestCases;

import com.google.common.annotations.VisibleForTesting;
import org.testng.Assert;
import org.testng.annotations.Test;
import sitePages.MyAccount;
import sitePages.StartPage;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;

public class MyAccount_Navigation {

    @Test
    public void MyaccountEditDetails() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        StartPage.login();
        MyAccount.myAccountNavigationToSettings();

    }
    @Test (dependsOnMethods = {"MyaccountEditDetails"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
