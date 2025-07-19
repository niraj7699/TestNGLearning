package com.testng.test;

import com.testng.Base.Base;
import com.testng.Pages.BankingDashboard;
import com.testng.Pages.Transfer;
import org.testng.annotations.Test;

public class TransferMoneyTest extends Base {
    BankingDashboard bankingDashboard;
    Transfer transfer;
    @Test
    public void transferMoney() throws InterruptedException {
        transfer=new Transfer(driver);
        bankingDashboard=new BankingDashboard(driver);
        bankingDashboard.clickOnTransferOption();
        Thread.sleep(2000);

        transfer.transferMoney("2937646340","2946468869","200","Testing");
        Thread.sleep(3000);
    }
}
