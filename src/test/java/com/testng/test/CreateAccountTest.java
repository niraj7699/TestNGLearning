package com.testng.test;

import com.testng.Base.Base;
import com.testng.Pages.Accounts;
import com.testng.Pages.BankingDashboard;
import org.testng.annotations.Test;

public class CreateAccountTest extends Base {
    BankingDashboard bankingDashboard;
    Accounts accounts;
    @Test
    public void createNewAccount() throws InterruptedException {
        bankingDashboard=new BankingDashboard(driver);
        accounts=bankingDashboard.clickOnAccountOption();
        Thread.sleep(3000);
        accounts.createNewAccount("Savings Account","Main Branch");
    }
}
