package com.guru99.live.Day1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

//---------------------------------------------------------//

public class TestClassStandart {

    public WebDriver driver;

    @Before
    public void setUp ()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogle() throws InterruptedException {

        driver.get("http://www.google.com");
        Thread.sleep(3000);
    }

    @After
    public void tearDown ()
    {
        driver.close();
    }

}
