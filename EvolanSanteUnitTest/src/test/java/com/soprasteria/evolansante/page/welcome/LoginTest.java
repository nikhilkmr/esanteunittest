package com.soprasteria.evolansante.page.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest
{
    private WebDriver driver;

    @FindBy(xpath = ".//*[@id='mainframe']/div[2]/input")
    private WebElement userName;

    @FindBy(xpath = "//*[@id='mainframe']/div[4]/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id='Layer6']/img")
    private WebElement loginButton;

    private String pageTitle;

    public LoginTest(WebDriver driver)
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageTitle = driver.getTitle();
    }

    public String getPageTitle()
    {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }

    public void setUserNameTxt(String userNameTxt)
    {
        userName.sendKeys(userNameTxt);
    }

    public void setPasswordTxt(String passwordTxt)
    {
        password.sendKeys(passwordTxt);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public boolean doTest()
    {


        driver.switchTo().frame("application");

        if (!pageTitle.toLowerCase().contains("identification")) { return false; }
        setUserNameTxt("EVOL6");
        setPasswordTxt("XEONDM");
        clickLoginButton();

        return true;
    }




}
