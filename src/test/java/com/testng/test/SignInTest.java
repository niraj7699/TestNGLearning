package com.testng.test;

import com.testng.Base.Base;
import com.testng.Pages.BankingDashboard;
import com.testng.Pages.ProfilePage;
import com.testng.Pages.SignInPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends Base {

    SignInPage signIn;
    BankingDashboard bankingDashboard;
    ProfilePage profilePage;

     @Test
     public void loginTest() throws InterruptedException {
         extentReports.createTest("Login to Banking browser");
         signIn=new SignInPage(driver);
         bankingDashboard=signIn.login();

         WebElement profile=Base.waitForElementVisible(driver,bankingDashboard.loginToastMessageLocator(),2);
         Assert.assertTrue(Base.isDisplayed(profile));
         Thread.sleep(3000);
     }

     @Test
    public void verifyLogin() throws InterruptedException {
         extentReports.createTest("Verify login Details");
         bankingDashboard=new BankingDashboard(driver);
        if(Base.waitForInvisibilityOfElement(driver,bankingDashboard.loginToastMessageLocator(),7)){
            bankingDashboard.clickOnProfileLogo();
         }

        Thread.sleep(1000);

        profilePage=bankingDashboard.clickOnProfile();
        Thread.sleep(2000);

        profilePage=new ProfilePage(driver);
        String profileName= profilePage.getProfileName();
        Assert.assertEquals(profileName,"Nira Kumar");
        Thread.sleep(2000);
        extentReports.flush();
     }

}
