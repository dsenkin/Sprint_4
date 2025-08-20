package qa_scooter_yandex_praktikum.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    // Локаторы Шаг1
    // Локатор поля ИМЯ
    private By inputFieldName= By.xpath(".//input[@placeholder = '* Имя']");

    // Локатор поля Фамилия
    private By inputFieldLastName= By.xpath(".//input[@placeholder = '* Фамилия']");

    // Локатор поля Адрес
    private By inputFieldAddress= By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Локатор поля Станция метро
    private By inputFieldMetro= By.xpath(".//input[@placeholder = '* Станция метро']");

    // Локатор поля Телефон
    private By inputFieldPhone= By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Локатор кнопки Далее
    private By nextButton = By.xpath(".//button[text() = 'Далее']");

    // Локаторы Шаг2
    // Локатор поля Даты
    private By inputFieldDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Локатор поля Продолжительности аренды
    private By inputFieldDuration = By.xpath(".//div[contains(@class, 'Dropdown-placeholder')]");
    private By inputFieldDuration1 = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='сутки']");
    private By inputFieldDuration5 = By.xpath(".//div[contains(@class, 'Dropdown-option') and text()='пятеро суток']");

    // Локатор чекбокса Выбора цвета самоката
    private By inputFieldColorBlack = By.xpath(".//input[@id='black']");
    private By inputFieldColorGrey = By.xpath(".//input[@id='grey']");

    // Локатор поля Комментарий для курьера
    private By inputFieldComment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Локатор кнопки Заказать внизу страницы на шаге2
    private By lowerOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Локатор кнопки Да, в окне подтверждения заказа
    private By yesOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // Локатор текста подтверждения заказа
    private By orderSuccess = By.xpath(".//div[text()='Заказ оформлен']/div[contains(text(), 'Номер заказа:')]");
    public By getOrderSuccess() {
        return orderSuccess;
    }

    // Конструктор страницы
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Кликнуть по объекту с данным локатором
    public void clickLocator(By locator) {
        driver.findElement(locator).click();
    }

    // Ввести текстовое значение в поле ввода по локатору
    public void inputField(By locator, String value) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(locator).isDisplayed());

        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    // Ввести значение кнопки Keys в поле ввода по локатору
    public void inputField(By locator, Keys value) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> driver.findElement(locator).isDisplayed());

        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    // Заполнение первой формы заказа Шаг1
    public void fillStep1Form (String name, String lastName, String address, String metro, String phone) {
        // Поле Имя
        inputField(inputFieldName, name);

        //Поле Фамилия
        inputField(inputFieldLastName, lastName);

        // Поле Адрес
        inputField(inputFieldAddress, address);

        // Поле Метро
        inputField(inputFieldMetro, metro);
        inputField(inputFieldMetro, Keys.ARROW_DOWN);
        inputField(inputFieldMetro, Keys.ENTER);

        // Поле телефон
        inputField(inputFieldPhone, phone);

        //Кнопка перехода на следующий шаг (валидация полей Шага 1)
        clickLocator(nextButton);
    }

    // Заполнение второй формы заказа Шаг2
    public void fillStep2Form (String date, String duration, String color, String comment) {
        // Поле Дата
        inputField(inputFieldDate, date);
        inputField(inputFieldDate, Keys.ENTER);

        // Поле продолжительность
        clickLocator(inputFieldDuration);
        switch (duration) {
            case "1":
                clickLocator(inputFieldDuration1);
                break;
            case "5":
                clickLocator(inputFieldDuration5);
                break;
        }

        // Чекбокс цвета
        switch (color) {
            case "black":
                clickLocator(inputFieldColorBlack);
                break;
            case "grey":
                clickLocator(inputFieldColorGrey);
                break;
        }

        // Поле комментария
        inputField(inputFieldComment, comment);

        // Кнопка Заказать
        clickLocator(lowerOrderButton);

        // Кнопка подтвердить заказ
        clickLocator(yesOrderButton);
    }
}
