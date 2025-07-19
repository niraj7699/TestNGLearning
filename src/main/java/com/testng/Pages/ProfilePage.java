package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends Base {
    @FindBy(xpath = "//h5[@class='MuiTypography-root MuiTypography-h5 css-1ion2yp']")
    WebElement profileName;

    @FindBy(xpath = "//button[text()='Edit Profile']")
    WebElement editProfile;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String getProfileName(){
        return Base.getText(profileName);
    }
}
