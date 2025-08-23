package ru.praktikumservices.qascooter.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;

    // Локатор верхней кнопки "Заказать"
    private By upperOrderButton = By.xpath("//button[@class='Button_Button__ra12g' and text()='Заказать']");;
    // Локатор нижней кнопки "Заказать"
    private By lowerOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Локатор кнопки Cookie
    private By cookieButton = By.xpath(".//button[text() = 'да все привыкли']");
    // Локатор списка вопросов FAQ
    private By faqQuestionsListItems = By.className("accordion__button");
    //Локатор списка ответов FAQ
    private By faqAnswersListItems = By.xpath("//div[@class='accordion__panel']");
    // Локатор текста (потомок элемента в списке ответов)
    private By faqAnswerItem = By.xpath("./child::p");

    // Конструктор страницы
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Открыть страницу и согласиться на куки
    public void openPage() {
        driver.get(URL);
        if (driver.findElement(cookieButton).isDisplayed())  clickLocator(cookieButton);
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

    public String printAccordion(int faqIndex) {
    // Получаем список вопросов
        List<WebElement> allQuestionLinks = driver.findElements(faqQuestionsListItems);
    // Получаем список ответов
        List<WebElement> allAnswersLinks = driver.findElements(faqAnswersListItems);

        WebElement questionLink = allQuestionLinks.get(faqIndex);
    // Прокручиваем страницу до блока "Вопросы о важном"
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionLink);

    // Подождали подгрузки вопроса
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        int finalI = faqIndex;
        wait.until(webDriver -> ( allQuestionLinks.get(finalI).isDisplayed()));

    // Кликаем по вопросу
        questionLink.click();

    // Подождали пока ответ прогрузится
        wait.until(webDriver -> ( allAnswersLinks.get(finalI).findElement(faqAnswerItem)).isDisplayed());

    // Возвращаем фактический ответ с сайта
        return allAnswersLinks.get(faqIndex).findElement(faqAnswerItem).getText();
    }
}
