package com.testng.test;

import com.testng.Base.Base;
import com.testng.Pages.HomePage;
import com.testng.Pages.ProfilePage;
import com.testng.Pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignInTest extends Base {

    SignInPage signIn;
    HomePage homePage;
    ProfilePage profilePage;

     @Test
     public void loginTest() throws InterruptedException {
         signIn=new SignInPage(driver);
         homePage=signIn.login();

         WebElement profile=Base.waitForElementVisible(driver,homePage.loginToastMessageLocator(),2);
         Assert.assertTrue(Base.isDisplayed(profile));

     }

     @Test
    public void verifyLogin() throws InterruptedException {
        homePage=new HomePage(driver);
        if(Base.waitForInvisibilityOfElement(driver,homePage.loginToastMessageLocator(),5)){
             homePage.clickOnProfileLogo();
            //driver.findElement(By.xpath("//button[@aria-label='account of current user']")).click();
         }

        Thread.sleep(1000);

        profilePage=homePage.clickOnProfile();
        Thread.sleep(2000);

        profilePage=new ProfilePage(driver);
        String profileName= profilePage.getProfileName();
        Assert.assertEquals(profileName,"Niraj Kumar");
        Thread.sleep(2000);
     }

}
