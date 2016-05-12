package com.guru99.live.Day2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class day2TestSelenium {

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
    public void costMobileTest() {
        //1. Goto http://live.guru99.com
        driver.get(baseUrl);

        //2. Click on Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();

        //3.In the list of all mobile, read the cost of Sony Xperia mobile. Note the value
        String expectedPrice = driver.findElement(By.id("product-price-1")).getText();

        //4.Click Sony Xperia mobile
        driver.findElement(By.linkText("SONY XPERIA")).click();

        //5. Read the Sony Xperia moble from detail page
        //6. Compare results
        assertEquals(driver.findElement(By.className("price")).getText(),expectedPrice);
    }

    @AfterClass
    public void tearDown () throws Exception
    {
        Thread.sleep(1000);
        driver.close();
    }

}
