package AdminTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

//package Tests;

//import Pages.TaxRegistryPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * Created by atinkovan on 23.01.2016.
 */
public class TaxRegistryCreation {
    private WebDriver driver;
    private String baseUrl;
    private Boolean acceptNextAlert = true;
    private StringBuffer verificationErrors;

    @Before
    public void testSetup() throws Exception{
        driver = new FirefoxDriver();
        verificationErrors = new StringBuffer();
        baseUrl = "http://vnopfapp02.exigengroup.com/ipb-app-int/";
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }
    @After
    public void testShutDown() throws  Exception{
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)){
            fail(verificationErrorString);
            System.out.println("vse");
        }
    }
    @Test
    public void createTaxRegistry() throws Exception{
        //driver.navigate().to("http://vnopfapp02.exigengroup.com/ipb-app-int/");
        driver.get(baseUrl);
        driver.findElement(By.id("loginForm:j_username")).clear();
        driver.findElement(By.id("loginForm:j_username")).sendKeys("qa");
        driver.findElement(By.id("loginForm:j_password")).clear();
        driver.findElement(By.id("loginForm:j_password")).sendKeys("qa");
        driver.findElement(By.id("loginForm:submitForm")).click();
        driver.findElement(By.id("logoutForm:switchToAdmin")).click();
        driver.findElement(By.id("adminTabsForm:adminTopTabsList:11:link")).click();
        driver.findElement(By.id("headSearchForm:searchChoser:1")).click();
        driver.findElement(By.id("searchForm:addBtn")).click();
        driver.findElement(By.id("taxInfoForm:taxInfo_code")).clear();
        driver.findElement(By.id("taxInfoForm:taxInfo_code")).clear();
        driver.findElement(By.id("taxInfoForm:taxInfo_code")).sendKeys("TaxCoverage");
        new Select(driver.findElement(By.id("taxInfoForm:taxInfo_type"))).selectByVisibleText("Federal");
        new Select(driver.findElement(By.id("taxInfoForm:taxInfo_subType"))).selectByVisibleText("VAT");
        driver.findElement(By.id("taxInfoForm:taxInfo_description")).clear();
        driver.findElement(By.id("taxInfoForm:taxInfo_description")).sendKeys("TaxCoverage");
        driver.findElement(By.id("taxInfoForm:okBtnProfile")).click();
        new Select (driver.findElement(By.id("searchForm:taxSearchCriteria_statusTax"))).selectByVisibleText("Active");
    }
    private Boolean isElementPresent (By by){
        try {
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
