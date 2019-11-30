package TestCases;

import sitePages.Favorites;
import utilities.BrowserClose;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Favorites_Deletion extends DriverUntility {
    @Test
    public static void FavDel() throws InterruptedException {
        Favorites.deleteFav();

        //Verification
        WebElement countofFav = driver.findElement(By.xpath("//span[@class='favorite-items-quantity-number ng-binding']"));
        countofFav.getText();
        System.out.println( countofFav.getText());
        Assert.assertNull(countofFav);
        BrowserClose.browserCls();
    }

    @Test (dependsOnMethods = {"FavDel"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
