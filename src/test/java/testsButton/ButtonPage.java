package testsButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ButtonPage extends BasePage {

    public ButtonPage(WebDriver browser) {
        super(browser);
    }

    // константа, не изменна, если есть эти три слова
    private int addedCount = 0;
    private int deletedCount = 0;
    private static final By ADD_ELEMENT = By.xpath("//*[text()='Add Element']");
    private static final By DELETE_ELEMENT = By.xpath("//*[text()='Delete']");
    private static final By LIST = By.xpath("//*[text()='Delete']");

    public void open() {
        browser.get(BASE_URL);
    }

    //добавить кнопку
    public void addButton(int addClicks) {
        for (int i = 0; i < addClicks; i++) {
            browser.findElement(ADD_ELEMENT).click();
        }
        addedCount += addClicks; // считаем добавленные
    }

    //удалить кнопку
    public void deleteButton(int deleteClicks) {
        for (int i = 0; i < deleteClicks; i++) {
            browser.findElement(DELETE_ELEMENT).click();
        }
        deletedCount += deleteClicks; // считаем удаленные
    }

    // Формула расчета ожидаемого количества (использует внутренние счетчики)
    public int calculateExpected() {
        return addedCount - deletedCount;
    }

    // Считаем реальное количество кнопок на странице
    public int getListButtonsCount() {
        List<WebElement> list = browser.findElements(LIST);
        return list.size();
    }
}
