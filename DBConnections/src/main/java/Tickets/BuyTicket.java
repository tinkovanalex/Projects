package Tickets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Alex on 22.12.2016.
 */
public class BuyTicket {

    public void run (){
        String startStation = "Одесса";
        String endStation = "Котовск";
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime());  // get system date
        //String timeStamp =  "25.12.2016";

        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://booking.uz.gov.ua/ru/");

        driver.findElement(By.name("station_from")).sendKeys(startStation);
        driver.findElement(By.name("station_from")).sendKeys(Keys.RIGHT);

        driver.findElement(By.xpath("//div[@id='stations_from' and @klass='autosuggest']"));

        Elements elements = new Elements();

//        driver.findElement(By.id("stations_from")).click();

       // WebElement autoSuggestForFromForm = BrowserController.get().driver().findElement(By.xpath("//div[@id='stations_from' and @class='autosuggest']"));
        //autoSuggestForFromForm.findElement(By.xpath(".//div")).click();

/*
        WebElement inputFrom = BrowserController.get().driver().findElement(By.xpath("//input[@name='station_from']"));
        inputFrom.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        inputFrom.sendKeys("Оде");
        inputFrom.sendKeys(Keys.RIGHT);
        WebElement autoSuggestForFromForm = BrowserController.get().driver().findElement(By.xpath("//div[@id='stations_from' and @class='autosuggest']"));
        autoSuggestForFromForm.findElement(By.xpath(".//div")).click();
*/

/*
        driver.findElement(By.name("station_till")).sendKeys(endStation);
        driver.findElement(By.name("station_till")).sendKeys(Keys.RIGHT);
        driver.findElement(By.id("stations_till")).click();

        driver.findElement(By.id("date_dep")).clear();
        driver.findElement(By.id("date_dep")).sendKeys(timeStamp);
        driver.findElement(By.name("search")).click();

        // this.WaitForElementLoad(15, "//h1[text()='Регистрация']");
        //driver.findElement(By.xpath("//h1[text()='Регистрация']"));
        //driver.findElement(By.xpath("//div[@id='reg-dialog']/form//input[@name='username']")).sendKeys("tttest11@mail.ru");
*/
    }
}
