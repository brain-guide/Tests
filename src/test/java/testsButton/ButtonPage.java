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
    private static final By ADD_ELEMENT = By.xpath("//*[text()='Add Element']");
    private static final By DELETE_ELEMENT = By.xpath("//*[text()='Delete']");

    public void open() {
        browser.get(BASE_URL);
    }

    //добавить кнопку
    public void addButton() {
        browser.findElement(ADD_ELEMENT).click();
    }

    //удалить кнопку
    public void deleteButton() {
        browser.findElement(DELETE_ELEMENT).click();
    }

    public List<WebElement> getListButtons() {
        return browser.findElements(DELETE_ELEMENT);
    }
}
