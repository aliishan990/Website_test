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

public class country_list {

    public static WebDriver driver;

    @Test
    public static void countries() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        driver.manage().window().maximize();


        WebElement dropDown = driver.findElement(By.xpath("//div[@class=\"single_tab_div resp-tab-content resp-tab-content-active\"]//p//select"));
        dropDown.click();

        HashMap<String, Integer> map = new HashMap<>();
        List<WebElement> list = driver.findElements(By.xpath("//option[@value]"));
        for (WebElement option : list) {
            String country = option.getText();
            map.put(country, 1);
        }
        for (Map.Entry<String, Integer> options : map.entrySet()) {
            System.out.println(options.getKey() + ":" + options.getValue());
        }
        driver.close();
    }
}
