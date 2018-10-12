package com.soprasteria.evolansante.page.welcome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GestionAcsListeTest implements Testable
{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"item6\"]")
    private WebElement mainMenuIndianScreens;

    @FindBy(xpath = "//*[@id=\"item6_1\"]")
    private WebElement subMenuIndianScreens;

    @FindBy(xpath = "//*[@id=\"item6_1_7\"]")
    private WebElement subMenuGestionDesACS;

    //    @FindBy(xpath = "//*[@id=\"mainframe\"]/form/div[34]/table/")
    //    private WebElement table;

    public GestionAcsListeTest(WebDriver driver)
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean doTest() throws InterruptedException
    {
        Thread.sleep(5000);
        //        driver.switchTo().frame("application");
        mainMenuIndianScreens.click();
        Thread.sleep(1000);
        subMenuIndianScreens.click();
        Thread.sleep(1000);
        subMenuGestionDesACS.click();
        Thread.sleep(15000);

        List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"mainframe\"]/form/div[34]/table/tbody/tr"));

        if (tableRows == null || (tableRows != null && tableRows.size() != 10)) { return false; }
        System.out.println("Table Size : " + tableRows.size());
        Thread.sleep(5000);
        String pageTitle = driver.getTitle();
        return pageTitle.equals("GESTION ACS - LISTE");

    }

}
