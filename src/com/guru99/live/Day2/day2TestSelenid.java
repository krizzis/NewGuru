package com.guru99.live.Day2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

public class day2TestSelenid {

    @BeforeClass
    public static void setUp ()
    {
        Configuration.pageLoadStrategy="normal";
    }

    @Test
    public void selenideTest() {
        //1. Goto http://live.guru99.com
        open("http://live.guru99.com");

        //2. Click on Mobile menu
        $(byText("Mobile")).click();

        //3.In the list of all mobile, read the cost of Sony Xperia mobile. Note the value
        String expectedPrice = $(By.id("product-price-1")).getText();

        //4.Click Sony Xperia mobile
        $(By.linkText("SONY XPERIA")).click();

        //5. Read the Sony Xperia moble from detail page
        //6. Compare results
        $(By.className("price")).shouldHave(text(expectedPrice));

    }

}
