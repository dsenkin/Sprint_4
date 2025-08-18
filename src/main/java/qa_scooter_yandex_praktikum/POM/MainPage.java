package qa_scooter_yandex_praktikum.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    // Локатор верхней кнопки "Заказать"
    private By upperOrderButton = By.xpath("//button[@class='Button_Button__ra12g' and text()='Заказать']");;
    // Локатор нижней кнопки "Заказать"
    private By lowerOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Локатор кнопки "Go!" (возле поля ввода заказа)
    private By goButton = By.xpath("//button[text()='Go!']");
    // Локатор кнопки "Статус заказа"
    private By statusButton = By.className("Header_Link__1TAG7");
    // Локатор поля ввода номера заказа
    private By statusField = By.cssSelector("input[placeholder='Введите номер заказа']");
    // Локатор картинки об ошибке номера заказа
    public By errorStatusOrderImage = By.cssSelector("img[alt='Not found']");

    // Конструктор страницы
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть страницу
    public void openPage() {
        driver.get(URL);
    }

    // Кликнуть по объекту с данным локатором
    private void clickLocator(By locator) {
        driver.findElement(locator).click();
    }

    //
    public void clickUpperButton(){
        driver.findElement(upperOrderButton).click();
    }
    //
    public void clickLowerButton(){
        driver.findElement(lowerOrderButton).click();
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

    // Ввести значение в поле ввода номера заказа
    public void setStatusField(String status) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(d -> driver.findElement(statusField).isDisplayed());

        driver.findElement(statusField).clear();
        driver.findElement(statusField).sendKeys(status);
    }

    public List<String> printAccordion() {
        List<String> accordion = new ArrayList<>();

        // Получаем список вопросов
        List<WebElement> allQuestionLinks = driver.findElements(By.className("accordion__button"));

        // Получаем список ответов
        List<WebElement> allAnswersLinks = driver.findElements(By.xpath("//div[@class='accordion__panel']"));//By.className("accordion__panel"));

        int i = 0;
        // Перебираем список вопросов
        for (WebElement webElement : allQuestionLinks) {
            //System.out.println(webElement.getText());

            // Прокручиваем страницу до блока "Вопросы о важном"
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);

            // Кликаем по вопросу
            webElement.click();

            // Получаем ответ на вопрос
            // Подождали пока ответ прогрузится
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            int finalI = i;
            wait.until(webDriver -> ( allAnswersLinks.get(finalI).findElement(By.xpath("./child::p"))).isDisplayed()); //(By.xpath("//div[@class='accordion__panel']/p"))).isDisplayed());
            // Добавляем ответ в список
            accordion.add(allAnswersLinks.get(i).findElement(By.xpath("./child::p")).getText());
            i++;
        }
        // Возвращаем список ответов отображенных на сайте
        return accordion;
    }

}
