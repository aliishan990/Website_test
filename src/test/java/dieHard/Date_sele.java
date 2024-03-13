package dieHard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Date_sele {

    static WebDriver driver;

    @Test
    public static void launch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        //opt.
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.get("https://www.redbus.in");
        driver.manage().window().maximize();

        WebElement busTicket = driver.findElement(By.id("src"));
        busTicket.sendKeys("Bangalore");
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.xpath("//text[@class=\"placeHolderMainText\"]"));
        for (WebElement city : list) {
            String citylocations = city.getText();
            if (city.getText().contains("Hebbal")) {
                city.click();
                break;
            }
        }

        Thread.sleep(2000);
        WebElement desti = driver.findElement(By.id("dest"));
        desti.sendKeys("Dharwad");
        Thread.sleep(2000);

        String year_month = " Mar 2024";
        String Date = "25";

        WebElement date = driver.findElement(By.xpath("//i[@class=\"sc-cSHVUG NyvQv icon icon-datev2\"]"));
        date.click();

        List<WebElement> datelist = driver.findElements(By.xpath("//div[@class=\"DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM\"]//div"));
        for (WebElement dates : datelist) {
            String getdates = dates.getText();
            //System.out.println(getdates);
           /*if(getdates.equals("31")){
               break;
           }*/
            if (getdates.contains(Date)) {
                dates.click();
                break;
            }
        }
        //Thread.sleep(2000);
        driver.findElement(By.id("search_button")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
