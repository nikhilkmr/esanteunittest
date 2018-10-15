package com.soprasteria.evolansante.page.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GestionACSDetailTest implements Testable
{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"ligne0\"]/td[2]")
    private WebElement firstElementOnList;

    public GestionACSDetailTest(WebDriver driver)
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean doTest() throws InterruptedException
    {
        Thread.sleep(5000);
        //        driver.switchTo().frame("application");
        firstElementOnList.click();
        Thread.sleep(10000);

        String pageTitle = driver.getTitle();
        return pageTitle.equals("Gestion ACS - Detail");
    }

}
