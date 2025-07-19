package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends Base {
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
