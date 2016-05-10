package com.guru99.live.Day1;

import org.openqa.selenium.WebElement;

import java.util.List;


class Util {

    static boolean isAlphabetical(List<WebElement> list)
    {

        for (int i = 0; i<list.size()-1; i++)
        {
            String a =  list.get(i).getText();
            String b =  list.get(i+1).getText();
            if (a.compareToIgnoreCase(b)>0) return false;
        }
        return true;
    }
}


