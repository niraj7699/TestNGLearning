package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Transfer extends Base {
    public Transfer(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//label[text()='From Account']/../div")
    WebElement fromAccountDropdownBtn;

    @FindBy(xpath="//label[text()='To Account Number']/../div/input")
    WebElement toAccountNumber;

    @FindBy(xpath="//label[text()='Amount']/../div/input")
    WebElement amount;

    @FindBy(xpath="//label[text()='Description (optional)']/../div/input")
    WebElement description;

    @FindBy(xpath="//label[text()='Transfer Type']/../div")
    WebElement transferType;

    @FindBy(xpath="//button[text()='Initiate Transfer']")
    WebElement initiateTransfer;

    public void selectFromAccountOption(String accountNumber){
        driver.findElement(By.xpath("//ul/li[@data-value='"+accountNumber+"']")).click();
    }

    public void transferMoney(String accountNumber,String toaccountNumber,String Amount,String Description) throws InterruptedException {
        Base.click(fromAccountDropdownBtn);
        selectFromAccountOption(accountNumber);
        Base.enterText(toaccountNumber,toAccountNumber);
        Base.enterText(Amount,amount);
        Base.enterText(Description,description);
       // Base.click(transferType);
        Base.click(initiateTransfer);
        Thread.sleep(3000);

    }
}
