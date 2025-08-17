import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UiTest extends BaseTest {

    @Test
    public void test() {
        mainPage.openPage();
        mainPage.clickStatusButton();
        //mainPage.clickStatusField();


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

        //new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.visibilityOf(driver.findElement(By.className("Header_Header__214zg\ Header_ShowSearch__1kqpK"))));



        mainPage.setStatusField("000");
    }

}
