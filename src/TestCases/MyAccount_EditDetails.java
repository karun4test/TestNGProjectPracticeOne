package TestCases;

import sitePages.MyAccount
        ;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.testng.annotations.Test;

public class MyAccount_EditDetails {

    @Test
    public void NewAccCreation() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        MyAccount.creatingAccount();
    }



    @Test (dependsOnMethods = {"NewAccCreation"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
