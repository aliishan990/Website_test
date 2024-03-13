package Sel_testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cou_lis {

    public static WebDriver driver;

    @Test
    public static void list(){

        int count=0;
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.geodatasource.com/software/country-region-dropdown-menu-demo");
        driver.manage().window().maximize();

        WebElement ddlist=driver.findElement(By.xpath("(//select[@class=\"form-control gds-cr\"])[1]"));
        ddlist.click();

        HashMap<String,Integer>map=new HashMap<>();
        count=2;
        List<WebElement> list=driver.findElements(By.xpath("//option[@value]"));
        System.out.println(list.size());
        for(WebElement country:list){
            String countries=country.getText();
            if(map.containsKey(countries)) {
               map.put(countries,map.get(countries)+1);
            }else {
                map.put(countries,1);
            }
        }
        for(Map.Entry<String,Integer>opt:map.entrySet()){

            if(opt.getValue() > count) {
                System.out.println(opt.getKey() + ":" + opt.getValue());
            }
        }
        driver.close();

    }
}
