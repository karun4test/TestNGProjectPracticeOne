package TestCases;

import sitePages.StartPage;
import utilities.BrowserClose;
import utilities.DriverUntility;
import utilities.SiteLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StartPage_Search extends DriverUntility {
    @Test
    public void Search_add() throws InterruptedException {
        DriverUntility.browserInitiation();
        SiteLaunch.browserLaunch();
        StartPage.search();

        //Verification
        WebElement searchResult = driver.findElement(By.xpath("//div[@class='filter-pagination']"));
        System.out.println("searchresult:" + searchResult);
        Assert.assertNotNull(searchResult.getText());

    }

    @Test (dependsOnMethods = {"Search_add"},alwaysRun = true)
    public void browserCloser(){
        BrowserClose.browserCls();
    }
}
