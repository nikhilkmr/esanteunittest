package com.soprasteria.evolansante.page.welcome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ListeDeTachesTest implements Testable
{
    private WebDriver driver;



    private String pageTitle;

    public String getPageTitle()
    {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle)
    {
        this.pageTitle = pageTitle;
    }

    public ListeDeTachesTest(WebDriver driver)
    {
        super();
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public boolean doTest() throws InterruptedException
    {

        Thread.sleep(20000);
        //        driver.switchTo().frame("application");
        pageTitle = driver.getTitle();

        return "Taches - Evolan S@nté".equals(pageTitle);
    }

}
