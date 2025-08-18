import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest{

    @Test
    public void upperButtonWorksFineTest(){
        mainPage.openPage();
        mainPage.clickUpperButton();
        WebElement headerText = driver.findElement(By.xpath("//div[text()='Для кого самокат']"));

        String expected = "Для кого самокат"; // ожидаемое сообщение о несовпадении паролей
        String actual = headerText.getText(); // фактическое сообщение
        assertEquals("Верхняя кнопка заказать не веде на страницу оформления заказа",expected, actual);
    }

    @Test
    public void lowerButtonWorksFineTest(){
        mainPage.openPage();
        mainPage.clickLowerButton();
        WebElement headerText = driver.findElement(By.xpath("//div[text()='Для кого самокат']"));

        String expected = "Для кого самокат"; // ожидаемое сообщение о несовпадении паролей
        String actual = headerText.getText(); // фактическое сообщение
        assertEquals("Верхняя кнопка заказать не веде на страницу оформления заказа",expected, actual);    }

    @Test
    public void orderTest(){

    }
}
