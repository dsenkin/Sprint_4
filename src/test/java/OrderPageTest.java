import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class OrderPageTest {

    @RunWith(Parameterized.class)
    public static class OrderTest extends BaseTest {
        private final String name;
        private final String lastName;
        private final String address;
        private final String metro;
        private final String phone;
        private final String date;
        private final String duration;
        private final String color;
        private final String comment;

        public OrderTest(String name, String lastName, String address, String metro, String phone, String date, String duration, String color, String comment) {
            this.name = name;
            this.lastName = lastName;
            this.address = address;
            this.metro = metro;
            this.phone = phone;
            this.date = date;
            this.duration = duration;
            this.color = color;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getOrder() {
            return new Object[][]{
                    {"Иван", "Иванов", "Проспект мира, 5", "Черкизовская", "+79998887766", "12.09.2025", "1", "black", "Спасибо"},
                    {"Петр", "Петров", "Московский проспект, 40", "Фрунзенская", "+70008881122", "02.10.2026", "5", "grey", "Срочно"},
            };
        }

        @Test
        public void orderTest() {
            mainPage.openPage();
            mainPage.clickUpperButton();

            // Первая форма заказа Шаг1
            orderPage.fillStep1Form(name, lastName, address, metro, phone);

            //Вторая форма заказа Шаг2
            orderPage.fillStep2Form(date, duration, color, comment);

            // Проверка, что заказ принят
            assertTrue("Не появляется окно с информацией об успешном оформлении заказа", driver.findElement(orderPage.getOrderSuccess()).isDisplayed());
        }
    }
    public static class OrderPage extends BaseTest {
        @Test
        public void upperButtonWorksFineTest() {
            mainPage.openPage();
            mainPage.clickUpperButton();
            WebElement headerText = driver.findElement(By.xpath("//div[text()='Для кого самокат']"));

            String expected = "Для кого самокат"; // ожидаемое сообщение о несовпадении паролей
            String actual = headerText.getText(); // фактическое сообщение
            assertEquals("Верхняя кнопка заказать не ведет на страницу оформления заказа", expected, actual);
        }

        @Test
        public void lowerButtonWorksFineTest() {
            mainPage.openPage();
            mainPage.clickLowerButton();
            WebElement headerText = driver.findElement(By.xpath("//div[text()='Для кого самокат']"));

            String expected = "Для кого самокат"; // ожидаемое сообщение о несовпадении паролей
            String actual = headerText.getText(); // фактическое сообщение
            assertEquals("Верхняя кнопка заказать не ведет на страницу оформления заказа", expected, actual);
        }
    }
}