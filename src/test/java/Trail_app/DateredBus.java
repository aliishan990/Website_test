package Trail_app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DateredBus {

    @Test
    public void launchHRM() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/?gclid=Cj0KCQiAwvKtBhDrARIsAJj-kTh7DFByuyaUwgILQB_eOTFmz6gqfBGR4McYH8eCt5nMKYeGaD6Uw9gaAg_MEALw_wcB");
        Thread.sleep(3000);

        String tdate = "25";
        String month = "Feb";
        String year = "2024";

        driver.findElement(By.id("onwardCal")).click();
        Thread.sleep(2000);

        while (true) {
            String month_name = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']) [2]")).getText();
            String[] cutdate = month_name.split(" ");
            String mm = cutdate[0];
            String YY = cutdate[1];
            //System.out.print(YY);
            String rl = YY.substring(0, 4);
            //System.out.println(rl);

            if (mm.equalsIgnoreCase(month) && rl.equals(year)) {
                break;
            }
        }
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"DayTilesWrapper__RowWrap-sc-19pz9i8-1 fGGTDM\"]//div"));
        Thread.sleep(2000);
        try {
            for (WebElement list1 : list) {
                String dates = list1.getText();
                if (dates.equals(tdate)) {
                    list1.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);
        driver.close();
    }
}
