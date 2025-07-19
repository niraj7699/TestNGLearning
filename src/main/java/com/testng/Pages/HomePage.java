package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {
    @FindBy(xpath = "//div[text()='Login successful!']")
    WebElement loginToastMessage;

    @FindBy(xpath = "//button[@aria-label='account of current user']")
    WebElement accountButton;

    @FindBy(xpath = "//li[text()='Profile']")
    WebElement profileOption;

    @FindBy(xpath = "//li[text()='Logout']")
    WebElement logoutOption;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickOnProfileLogo(){
        Base.click(accountButton);
    }

    public By loginToastMessageLocator(){
        return By.xpath("//div[text()='Login successful!']");
    }

    public ProfilePage clickOnProfile(){
        Base.click(profileOption);
        return new ProfilePage(driver);
    }

    public SignInPage clickOnLogout(){
        Base.click(logoutOption);
        return new SignInPage(driver);
    }

}
