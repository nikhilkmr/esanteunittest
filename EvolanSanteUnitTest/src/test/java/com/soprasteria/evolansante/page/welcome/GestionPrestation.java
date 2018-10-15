package com.soprasteria.evolansante.page.welcome;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GestionPrestation
{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"menudiv\"]/nav/ul/li[6]")
    private WebElement suviant;

    @FindBy(xpath = "//*[@id=\"menudiv\"]/nav/ul/li[3]/label")
    private WebElement halisMenu;

    @FindBy(xpath = "//*[@id=\"menudiv\"]/nav/ul/li[3]/div/div/ul/li[7]/div/ul/li[11]")
    private WebElement gestionDesPrestationMenu;

    @FindBy(xpath = "//*[@id=\"mainframe\"]/form/div[8]/label")
    private WebElement gestionDesLotsControllerMenu;

    @FindBy(xpath = "//*[@id=\"mainframe\"]/form/div[3]/div[8]/input")
    private WebElement libelle;

    @FindBy(xpath = "//*[@id=\"mainframe\"]/form/div[3]/div[2]/img")
    private WebElement actualiser;

    @FindBy(xpath = "//*[@id=\"ligne0\"]/td[5]")
    private WebElement blueLink;

    @FindBy(xpath = "//*[@id=\"decompteListe\"]/tbody")
    private List<WebElement> tableRows;
    public void setLibelle(String libelleTxt)
    {
        libelle.sendKeys(libelleTxt);
    }

    private String pageTitle;

    public String getPageTitle()
    {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }

    public GestionPrestation(WebDriver driver)
    {
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public boolean doTest() throws InterruptedException
    {

        Thread.sleep(500);
        //        driver.switchTo().frame("application");
        suviant.click();
        Thread.sleep(500);
        halisMenu.click();
        Thread.sleep(500);
        gestionDesPrestationMenu.click();
        Thread.sleep(500);
        gestionDesLotsControllerMenu.click();
        setLibelle("A*");
        Thread.sleep(500);
        actualiser.click();
        Thread.sleep(1000);
        blueLink.click();
        /* if (tableRows == null || (tableRows != null && tableRows.size() != 10)) { return false; }
        System.out.println("Table Size : " + tableRows.size());*/
        Thread.sleep(5000);
        String pageTitle = driver.getTitle();
        return "LISTE DES DÉCOMPTES".equals(pageTitle);
    }
}
