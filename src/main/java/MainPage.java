import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    private By goButton = By.xpath("//button[text()='Go!']");
    private By statusButton = By.className("Header_Link__1TAG7");
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void clickGoButton() {
        driver.findElement(goButton).click();
    }
    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }
    public void clickStatusField() {
        driver.findElement(statusField).click();
    }
    public void setStatusField(String status) {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(statusField).isDisplayed());

        driver.findElement(statusField).sendKeys(status);
    }
}
