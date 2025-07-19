package com.testng.Pages;

import com.testng.Base.Base;
import com.testng.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Base {

    @FindBy(id="username") WebElement usernameWebElement;

    @FindBy(id="password") WebElement passwordWebElement;

    @FindBy(xpath="//button[text()='Sign In']") WebElement signInButton;

    @FindBy(xpath="//a[contains(text(),'Sign Up')]") WebElement signUpLink;

    @FindBy(xpath="//button[contains(text(),'Forgot Password?')]") WebElement forgotPassword;

    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

   public void enterUsername(){
        String username=ConfigReader.getProperty("username");
       Base.enterText(username,usernameWebElement);
   }

   public void enterPassword(){
        String password=ConfigReader.getProperty("password");
       Base.enterText(password,passwordWebElement);
   }

   public BankingDashboard clickOnSignInButton(){
        Base.click(signInButton);
        return new BankingDashboard(driver);
   }

    public SignUpPage clickOnSignUpLink(){
         Base.click(signUpLink);
         return new SignUpPage(driver);
    }

    public ForgotPasswordPage clickOnFOrgotPassword(){
        Base.click(forgotPassword);
        return new ForgotPasswordPage(driver);
    }

    public BankingDashboard login(){
        enterUsername();
        enterPassword();
        clickOnSignInButton();
        return new BankingDashboard(driver);
    }

}
