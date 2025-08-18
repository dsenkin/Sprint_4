import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import qa_scooter_yandex_praktikum.POM.MainPage;
import qa_scooter_yandex_praktikum.POM.OrderPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    };

    @After
    public void tearDown() throws Exception {
        driver.quit();
    };

}
