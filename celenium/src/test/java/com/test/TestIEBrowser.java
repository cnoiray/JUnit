/**
 *
 */
package com.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author cnoiray
 */
public class TestIEBrowser {

    static String driverPath = "lib/";
    public static WebDriver driver;

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
        driver.navigate().to("http://www.google.com");
        final String strPageTitle = driver.getTitle();
        System.out.println("Page title: - " + strPageTitle);
        Assert.assertEquals("Google", strPageTitle);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            System.out.println("Closing IE browser");
            driver.quit();
        }
    }
}
