package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends Base {
    public ForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
