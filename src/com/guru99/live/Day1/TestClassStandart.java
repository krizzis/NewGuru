package com.guru99.live.Day1;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

//---------------------------------------------------------//

public class TestClassStandart {

    private WebDriver driver;
    private String baseUrl = "http://live.guru99.com/index.php/";


    @BeforeClass
    public void setUp ()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testHomePageTitle()
    {
        //1. Goto http://live.guru99.com
        driver.get(baseUrl);

        //2. Verify Title of the page
        Assert.assertTrue(driver.getTitle().equals("Home page"));
    }

    @Test (dependsOnMethods = "testHomePageTitle")
    public void testMobilePageTitle()
    {
        //3. Click on Mobile menu
        driver.findElement(By.xpath(".//a[contains(text(),\"Mobile\")]")).click();

        //4.Verify title of the page
        Assert.assertTrue(driver.getTitle().equals("Mobile"));
    }


    @Test (dependsOnMethods = {"testMobilePageTitle"})
    public void testSortByName()
    {
        //5. In the list of all mobile, select 'SORT BY' dropdown as 'name'
        Select sortBy = new Select(driver.findElement(By.xpath(".//select[@title=\"Sort By\"]")));
        sortBy.selectByIndex(1);

        //6. Verify all products are sorted by name
        List<WebElement> productsList = driver.findElements(By.tagName("h2"));
        Assert.assertTrue(Util.isAlphabetical(productsList));
    }

    @AfterClass
    public void tearDown () throws Exception
    {
        Thread.sleep(1000);
        driver.close();
    }

}
