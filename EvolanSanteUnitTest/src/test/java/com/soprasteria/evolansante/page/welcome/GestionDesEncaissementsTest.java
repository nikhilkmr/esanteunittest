package com.soprasteria.evolansante.page.welcome;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GestionDesEncaissementsTest
{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menudiv\"]/nav/ul/li[7]/label")
    private WebElement mainMenuIndianScreens;

    @FindBy(xpath = "//*[@id=\"menudiv\"]/nav/ul/li[7]/div/div/ul/li[6]/div/ul/li[1]")
    private WebElement subMenuIndianScreens;

    @FindBy(xpath = "//*[@id=\"Titre\"]")
    private WebElement screenTitle;

    @FindBy(xpath = "//*[@id=\"Menu\"]")
    private WebElement menuOnScreen;
    
    @FindBy(xpath = "/html/body/div[1]/div[2]/table/tbody/tr[3]/td[2]/div")
    private WebElement subMenuOnScreen;

    public GestionDesEncaissementsTest(WebDriver driver)
    {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean doTest() throws InterruptedException
    {
        //driver.switchTo().frame("application");
        String pageTitle = driver.getTitle();
        String titleOfScreen = screenTitle.getText();
        String menu = menuOnScreen.getText();
        
        Thread.sleep(5000);        
        mainMenuIndianScreens.click();
        
        Thread.sleep(1000);
        subMenuIndianScreens.click();
        
        Thread.sleep(1000);        
        menuOnScreen.click();
        
        Thread.sleep(1000);        
        subMenuOnScreen.click();
        
        Thread.sleep(1000);
        List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"mainframe\"]/form/div[71]/table/tbody/tr"));
        if (tableRows == null) { return false; }
        System.out.println("Table Size : " + tableRows.size());
        Thread.sleep(5000);
        return pageTitle.equals("Gestion des Encaissements - Liste des lots") && titleOfScreen.equals("GESTION DES ENCAISSEMENTS - LISTE DES LOTS") && menu.equals("Menu");

    }

}
