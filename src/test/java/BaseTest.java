import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumservices.qascooter.pageobjects.MainPage;
import ru.praktikumservices.qascooter.pageobjects.OrderPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
    public void setUp() {
        switch ("chrome") {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "fox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        }
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    };

    @After
    public void tearDown() {
        driver.quit();
    };
}
