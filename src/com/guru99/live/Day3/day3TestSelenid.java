package com.guru99.live.Day3;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by krizziz on 13.05.2016.
 */
public class day3TestSelenid {

    @BeforeClass
    public static void setUp() {
        Configuration.pageLoadStrategy = "normal";
    }

    @Test
    public void selenideTest() {
        //1. Goto http://live.guru99.com
        open("http://live.guru99.com");

        $(byText("Mobile")).click();

        $(".button.btn-cart").click();

        $(".product-cart-actions>input").val("1000");
        $(".button.btn-update").click();

        $(".item-msg.error").should(visible).shouldHave(text("The maximum quantity allowed for purchase is 500"));
        $(".error-msg>ul>li>span").should(visible).shouldHave(text("Some of the products cannot be ordered"));

        $("#empty_cart_button").click();

        $(".page-title>h1").shouldHave(text("Shopping Cart is Empty"));

        sleep(1000);
    }
}