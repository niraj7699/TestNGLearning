package com.testng.Pages;

import com.testng.Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts extends Base {
    public Accounts(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[text()='Create Account']")
    WebElement createAccount;

    @FindBy(xpath="//label[text()='Account Type']/../div")
    WebElement accountType;

    @FindBy(xpath="//li[text()='Savings Account']")
    WebElement savingAccountOption;

    @FindBy(xpath="//li[text()='Current Account']")
    WebElement currentAccountOption;

    @FindBy(xpath="//li[text()='Salary Account']")
    WebElement salaryAccountOption;

    @FindBy(xpath="//div[text()='Main Branch']")
    WebElement branchType;

    @FindBy(xpath="//li[text()='Main Branch']")
    WebElement mainBranchOption;

    @FindBy(xpath="//li[text()='North Branch']")
    WebElement northBranchOption;

    @FindBy(xpath="//li[text()='South Branch']")
    WebElement southBranchOption;

    @FindBy(xpath="//button[text()='Create']")
    WebElement createButton;

    public void createNewAccount(String accountTypeOption,String branchTypeOption) throws InterruptedException {
        Base.click(createAccount);
        Base.click(accountType);
        if(accountTypeOption.equals("Savings Account")){
            Base.click(salaryAccountOption);
        } else if (accountTypeOption.equals("Current Account")) {
            Base.click(currentAccountOption);
        }else {
            Base.click(salaryAccountOption);
        }

        if(accountTypeOption.equals("North Branch")){
            Base.click(northBranchOption);
        } else if (accountTypeOption.equals("South Branch")) {
            Base.click(southBranchOption);
        }

        Base.click(createButton);
        Thread.sleep(3000);
    }

}
