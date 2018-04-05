/**
 *
 */
package com.test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author cnoiray
 */
public class TestIEBrowser {

    static String driverPath = "lib/";
    public static WebDriver driver;
    public String baseUrl = "http://www.google.com";

    @BeforeClass
    public static void setUp() {
        System.out.println("*******************");
        System.out.println("launching IE browser");
        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGooglePageTitleInIEBrowser() {
        // lancement google
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // vérification de la page google
        final String strPageTitle = driver.getTitle();
        System.out.println("Page title: - " + strPageTitle);
        Assert.assertEquals("Google", strPageTitle);

        // écrire recherche dans input lst-ib
        driver.findElement(By.id("lst-ib")).sendKeys("bloup");
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            System.out.println("Closing IE browser");
            driver.quit();
        }
    }
}
