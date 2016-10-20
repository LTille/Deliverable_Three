/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Tillie
 */
public class BaseTest {
    public WebDriver driver;
    WebDriverWait wait;
    
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }
    
    @After
    public void teardown() {
        driver.quit();
    }
    
    public void waitUntil(Predicate<WebDriver> predicate) {
        wait.until(predicate);
    }
}
