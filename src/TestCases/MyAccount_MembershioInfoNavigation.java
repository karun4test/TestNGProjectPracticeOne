package TestCases;

import org.testng.annotations.Test;
import sitePages.MyAccount;
import sitePages.StartPage;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;

import java.sql.DriverManager;

public class  MyAccount_MembershioInfoNavigation extends DriverUntility{

    @Test
    public void MyaccountMembershipNavigation() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        StartPage.login();
        MyAccount.myAccountNavigationToMembershipInfo();

    }
    @Test (dependsOnMethods = {"MyaccountMembershipNavigation"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
