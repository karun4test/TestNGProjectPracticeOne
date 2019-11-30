package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import sitePages.Favorites;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import utilities.WaitTime;

public class FavoritePage_Navigation extends DriverUntility {

    @Test
    public static void Favorite() {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        Favorites.FavoritesPage();
        String header = WaitTime.wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='favorite-heading']")))).getText();
        System.out.println(header);
        Assert.assertEquals(header, "FAVOURITES");
    }



    @Test (dependsOnMethods = {"Favorite"},alwaysRun = true)
     public void browserCloser()
    {
        BrowserClose.browserCls();
    }
}
