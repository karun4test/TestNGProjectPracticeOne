package sitePages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DriverUntility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.SiteLaunch;
import utilities.WaitTime;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Favorites extends DriverUntility {

    //-----------------Add few products to favorites-----------------------
    public static void addFavorites() throws InterruptedException {
        //Goto Ladies department product listing page
        WebElement LadiesDpt = driver.findElement(By.xpath("//a[@href='/en_gb/ladies.html']"));
       // LadiesDpt.click();
      //  Thread.sleep(3000);

        //AMT viewall location xpath("//*[@id=\"menu-links\"]/li[9]/ul/li[2]/a")
        //WebElement viewAllOption = driver.findElement(By.xpath("//a[@href='/en_gb/ladies/shop-by-product/view-all.html']"));
        //viewAllOption.click();

        Actions action = new Actions(driver);
        action.moveToElement(LadiesDpt).moveToElement(driver.findElement(By.xpath("//a[@href='/en_gb/ladies/shop-by-product/view-all.html']"))).click().build().perform();

        //Collect all products in to list
        List<WebElement> elements = driver.findElements(By.xpath("//ul/li[@class='product-item']"));
        System.out.println("Number of elements:" + elements.size());

        //Count how many products are available
        int FavNumber = elements.size();

        //Goto Each product in product listing page and click on favorite icon
       // Actions action = new Actions(driver);
        for (int i = 0; i < FavNumber - 10; i++) {
            action.moveToElement(elements.get(i)).moveToElement(driver.findElement(By.xpath("//button[@class='favorite icon-favorites js-favorite']"))).click().build().perform();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        Thread.sleep(2000);

        //Goto Favorite page by clicking Favorite button
        WebElement fav = driver.findElement(By.xpath("//a[@href='/en_gb/favourites']"));
        fav.click();

        //Added Favorites count for further assert
        WebElement countofFav = driver.findElement(By.xpath("//span[@class='favorite-items-quantity-number ng-binding']"));
        countofFav.getText();
        System.out.println(countofFav.getText());

    }

    // --------------------deleting product from favorite-----------------------------------
    public static void deleteFav() throws InterruptedException {

        //This case should execute after add favorites
        //Collect all added favorites in List
        List<WebElement> elements = driver.findElements(By.xpath("//li[@class='product-detail-list-item ng-scope']"));
        System.out.println("Total Favorites:" + elements.size());

        //Click on move to bag and if any popup displays from 'notify me' , close it and select X button
        Actions action = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            boolean isPresent = false;
            action.moveToElement(elements.get(i)).moveToElement(driver.findElement(By.xpath(("//button[@class='favorite-add-to-bag  js-open-size-selector ng-scope']")))).click().build().perform();
            Thread.sleep(3000);
            isPresent = driver.findElement(By.id("modal-NIB")).isDisplayed();
            System.out.println(i + ":" + isPresent);
            Thread.sleep(2000);
            if (isPresent) {
                driver.findElement(By.xpath("//*[@id=\"modal-NIB\"]/header/button")).click();
                System.out.println("Its in if loop");
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@class='remove-product icon-close-black js-remove-favorite']")).click();
            }

        }


    }

    // Navigate to favorite page
    public static void FavoritesPage(){

        WebElement fav = driver.findElement(By.xpath("//a[@href='/en_gb/favourites']"));
        fav.click();

    }


    // Move to shopping bag selection


}
