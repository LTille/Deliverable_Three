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

/**
 *
 * @author Tillie
 */

//As a user
//I want to log in
//So that buy products

public class LoginTest extends BaseTest{
   
    /**
     * Given a correct username and correct password
     * When I try to log in with those credentials
     * Then I should see the "*." greeting message
     */
    @Test
    public void testAuthenticationSuccessWhenProvidingGoodCredentials(){
        driver.get("http://store.demoqa.com/tools-qa/");
        driver.findElement(By.id("user_login")).sendKeys("tingli");
        driver.findElement(By.id("user_pass")).sendKeys("abc123");     
        driver.findElement(By.id("wp-submit")).submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
        WebElement msg = driver.findElement(By.id("wp-admin-bar-my-account"));
        assertEquals("Howdy, tingli", msg.getText()); 
    }      
    
     /**
     * Given a correct username
     * When I try to log in with those credentials
     * Then I should see the "Error: The password field is empty" message
     */
    @Test
    public void testAuthenticationFailureWhenNotProvidingPassword(){
        driver.get("http://store.demoqa.com/tools-qa/");
        driver.findElement(By.id("user_login")).sendKeys("tingli");    
        driver.findElement(By.id("wp-submit")).submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
        WebElement msg = driver.findElement(By.xpath("//*[@id='login_error']"));
        assertEquals("ERROR: The password field is empty.", msg.getText());
 
    }
    
    /**
     * Given a incorrect username and incorrect password
     * When I try to log in with those credentials
     * Then I should see the "Error: Invalid login credentials." message
     */
    @Test
    public void testAuthenticationFailureWhenProvidingBadCredentials(){
        driver.get("http://store.demoqa.com/tools-qa/");
        driver.findElement(By.id("user_login")).sendKeys("fakeuser");
        driver.findElement(By.id("user_pass")).sendKeys("fakepassword");     
        driver.findElement(By.id("wp-submit")).submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      
        WebElement msg = driver.findElement(By.xpath("//*[@id=\"login_error\"]"));
        assertEquals("ERROR: Invalid login credentials.", msg.getText()); 
   }  

}
