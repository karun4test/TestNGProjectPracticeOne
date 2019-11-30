package TestCases;

import org.testng.annotations.Test;
import sitePages.MyAccount;
import sitePages.StartPage;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;

public class MyAccount_ClubNavigation {

    @Test
    public void myAccountNavigationToClubcard() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        StartPage.login();
        MyAccount.myAccountNavigationToClubcard();


    }

    @Test (dependsOnMethods = {"myAccountNavigationToClubcard"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
   }
}
