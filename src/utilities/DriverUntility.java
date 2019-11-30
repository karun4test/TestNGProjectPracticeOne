package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class DriverUntility {
    //will create driver instance and make it availabel for all Methods/Tests
    public static WebDriver driver;

   /*  @BeforeSuite
     public static void fFBrowserInitiation()
    {

        System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        //driver.manage().deleteAllCookies();

    }

    @BeforeSuite
    public static void chromebrowserInitiation(){

         System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

    } */

    @BeforeSuite
    public static void browserInitiation(){
         if (DataFeed.BROWSER=="Chrome"){
             System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
         } else if(DataFeed.BROWSER=="Firefox"){
             System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
         }
    }

}
