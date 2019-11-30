package TestCases;

import sitePages.ShoppingBag;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Shoppingbag_AddProducts extends DriverUntility{
    @Test
    public static void AddingProductsFromSeach() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        ShoppingBag.addProduct();

        //Verification
        WebElement SBitem = driver.findElement(By.xpath("//span[@class='shoppingbag-item-count']"));
        String SBcount = SBitem.getText();
        System.out.println("SBcount :" + SBcount);
        Assert.assertNotNull(SBcount);

    }

    /* @Test (dependsOnMethods = {"AddingProductsFromSeach"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    } */

}
