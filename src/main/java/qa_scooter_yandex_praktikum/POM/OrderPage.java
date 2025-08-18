package qa_scooter_yandex_praktikum.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    // Конструктор страницы
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кликнуть по объекту с данным локатором
    public void clickLocator(By locator) {
        driver.findElement(locator).click();
    }




    //driver.findElement(By.tagName("input")).clear();
    //driver.findElement(By.tagName("input")).sendKeys("Практикум");
}
