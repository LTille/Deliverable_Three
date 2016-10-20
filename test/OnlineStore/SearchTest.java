/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 *
 * @author Tillie
 */

//As a user
//I want to search for specified products
//So that I can find desired product more quickly

public class SearchTest extends BaseTest {
    
     /**
     * Given a not existed product name
     * When I search the product
     * Then I should see message informing me no result
     */
     @Test
     public void searchNotExistedProduct(){
          driver.get("http://store.demoqa.com/");
          WebElement searchBox = driver.findElement(By.className("search"));
          searchBox.clear();
          searchBox.sendKeys("Samsung");
          searchBox.sendKeys(Keys.ENTER);
          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
          String ans = "Sorry, but nothing matched your search criteria. Please try again with some different keywords.";
          assertEquals(ans,driver.findElement(By.xpath("//*[@id=\"content\"]/p")).getText());             
     }
    
     /**
     * Given an existed product name
     * When I search the product
     * Then I should see a list of products
     */
     @Test
     public void searchExistedProduct(){
          driver.get("http://store.demoqa.com/");
          WebElement searchBox = driver.findElement(By.className("search"));
          searchBox.clear();
          searchBox.sendKeys("iphone");
          searchBox.sendKeys(Keys.ENTER);
          driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
          WebElement productList = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div"));
          List<WebElement> images= productList.findElements(By.className("item_image"));
	  assertTrue(images.size()==5);
     }
     
}

