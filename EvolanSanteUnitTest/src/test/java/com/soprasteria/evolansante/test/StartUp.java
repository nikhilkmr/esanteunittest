package com.soprasteria.evolansante.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.soprasteria.evolansante.page.welcome.GestionACSDetailTest;
import com.soprasteria.evolansante.page.welcome.GestionAcsListeTest;
import com.soprasteria.evolansante.page.welcome.GestionPrestation;
import com.soprasteria.evolansante.page.welcome.ListeDeTachesTest;
import com.soprasteria.evolansante.page.welcome.LoginTest;

public class StartUp
{
    private WebDriver driver;



    @Test
    public void test() throws InterruptedException
    {
        LoginTest loginTest = new LoginTest(driver);
        Assert.assertTrue(loginTest.doTest());


        ListeDeTachesTest listeDeTachesTest = new ListeDeTachesTest(driver);
        Assert.assertTrue(listeDeTachesTest.doTest());
        
        GestionAcsListeTest acsListeTest = new GestionAcsListeTest(driver);
        Assert.assertTrue(acsListeTest.doTest());
        
        GestionACSDetailTest acsDetailTest = new GestionACSDetailTest(driver);
        Assert.assertTrue(acsDetailTest.doTest());
        GestionPrestation gestionPrestation = new GestionPrestation(driver);
        Assert.assertTrue(gestionPrestation.doTest());

    }

    @BeforeTest
    public void beforeTest() throws InterruptedException
    {

        File file = new File("C:/Selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver)
            {
                System.out.println("JGJHHG :::: " + ((JavascriptExecutor) driver).executeScript("return document.readyState"));
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        });
        driver.navigate().to("http://localhost:7080/EVS/PopEvolan.do");



    }

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }
}
