package TestCases;

import sitePages.Favorites;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Favorites_adding extends DriverUntility {
    @Test
    public static void AddingFav() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        Favorites.addFavorites();
        WebElement countofFav = driver.findElement(By.xpath("//span[@class='favorite-items-quantity-number ng-binding']"));
        countofFav.getText();
        System.out.println( countofFav.getText());
        Assert.assertNotNull(countofFav);
    }


}
