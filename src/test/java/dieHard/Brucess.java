package dieHard;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brucess {

    static WebDriver driver;
    @Test
    public static void launch() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       ChromeOptions opt=new ChromeOptions();
       //opt.
       opt.addArguments("--disable-notifications");
        driver=new ChromeDriver(opt);
        driver.get("https://www.redbus.in");
        driver.manage().window().maximize();

        WebElement busTicket=driver.findElement(By.id("src"));
        //Thread.sleep(2000);
        //busTicket.click();
        busTicket.sendKeys("Bangalore");
        Thread.sleep(2000);

        HashMap<String,Integer>map=new HashMap<>();

        List<WebElement>list=driver.findElements(By.xpath("//text[@class=\"placeHolderMainText\"]"));

        /*Alert alert = driver.switchTo().alert();
        alert.dismiss();*/

        for(WebElement city:list){
            String citylocations=city.getText();

            map.put(citylocations,1);
            //System.out.println(citylocations);
            //driver.switchTo().alert().dismiss();
            /*if(city.getText().contains("Hebbal")){
                city.click();
                break;
            }*/
        }

        for(Map.Entry<String,Integer>lol:map.entrySet()){
            System.out.println(lol.getKey()+"="+lol.getValue());
        }
    }
}
