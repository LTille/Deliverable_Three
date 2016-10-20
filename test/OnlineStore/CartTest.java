/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import java.util.concurrent.TimeUnit;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * @author Tillie
 */

//As a user
//I want to use shopping cart
//So that I manipulate products I want to buy

public class CartTest extends BaseTest {
       
    /**
     * Given an empty cart and iphone 5 product page
     * When I try to add an iphone5 into cart
     * Then I should see the product number in cart turns into 1
     */
    @Test
    public void addNewProductSuccess(){
        driver.get("http://store.demoqa.com/products-page/product-category/n/");
        driver.findElement(By.name("Buy")).submit();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();   
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().refresh();
        String count=driver.findElement(By.className("count")).getText();
        assertEquals("1",count);
    }
    
    /**
     * Given 1 iphone5 in the cart
     * When I try to update the quantity into 3
     * Then I should see the total price triples
     */
   @Test
   public void updatePositiveProductQuatity() throws InterruptedException {

        driver.get("http://store.demoqa.com/products-page/product-category/n/");
        driver.findElement(By.name("Buy")).submit();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/checkout/");
        WebElement quantity = driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"quantity\"]"));
        quantity.clear();
        quantity.sendKeys("3");
        WebElement update = driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"submit\"]"));
        update.click();
        Thread.sleep(50000);
        WebElement price=driver.findElement(By.cssSelector("td.wpsc_product_price.wpsc_product_price_0>span>span"));
      
        String total = price.getText();
        System.out.print(total);
        assertEquals("$36.00", total);   
     }
   
     /**
     * Given 1 iphone5 in the cart
     * When I try to update the quantity into -1
     * Then I should see error message
     */
    @Test
    public void updateNegativeProductQuatity() throws InterruptedException{
        driver.get("http://store.demoqa.com/products-page/product-category/n/");
        driver.findElement(By.name("Buy")).submit();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/products-page/checkout/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement quantity = driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"quantity\"]"));
        quantity.clear();
        quantity.sendKeys("-1");
        WebElement update = driver.findElement(By.cssSelector("form.adjustform.qty > input[name=\"submit\"]"));
        update.click();
        Thread.sleep(50000);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	WebElement msg = driver.findElement(By.xpath("//*[@id='post-29']/div"));
	assertEquals("Oops, there is nothing in your cart.", msg.getText());
    }
     
    /**
     * Given 1 iphone5 in the cart
     * When I try to remove it from cart
     * Then I should see an empty cart
     */
    @Test
    public void removeProduct() throws InterruptedException{
        driver.get("http://store.demoqa.com/products-page/product-category/n/");
        driver.findElement(By.name("Buy")).submit();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
      
        driver.get("http://store.demoqa.com/products-page/checkout/");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement remove = driver.findElement(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]"));
	remove.click();
        if(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("form.adjustform.remove > input[name=\"submit\"]"))));
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"post-29\"]/div"));
        String str =msg.getText();
        assertEquals("Oops, there is nothing in your cart.", str);
      
    } 
}


