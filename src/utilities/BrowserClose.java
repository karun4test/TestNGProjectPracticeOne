package utilities;

import org.testng.annotations.Test;

public class BrowserClose extends DriverUntility {


    public static void browserCls() {

        driver.quit();
        //  driver.manage().deleteAllCookies();

        System.out.println("Browser closed successfully");
    }

}
