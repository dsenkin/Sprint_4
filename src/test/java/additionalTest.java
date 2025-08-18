import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class additionalTest extends BaseTest {
    //Если нажать на логотип Самоката, попадёшь на главную страницу Самоката.
    @Test
    public void test() {

    }

    //Если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
    @Test
    public void test2() {


    }

    //Ошибки для всех полей формы заказа.
    @Test
    public void test3() {

    }

    //Если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.
    @Test
    public void errorStatusWrongNumberTest(){
        mainPage.openPage();
        mainPage.clickStatusButton();
        mainPage.setStatusField("123");
        mainPage.clickGoButton();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(webDriver -> (driver.findElement(mainPage.errorStatusOrderImage).isDisplayed()));

        WebElement errorStatusOrderImage = driver.findElement(mainPage.errorStatusOrderImage);
        assertTrue("Сообщение об ошибке не отображается", errorStatusOrderImage.isDisplayed());
    }
}