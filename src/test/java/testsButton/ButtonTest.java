package testsButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.*;

public class ButtonTest extends BaseButtonTest {

    @Test
    public void checkDeleteButton() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(2000);
        browser.findElement(By.xpath("//*[text()='Delete']")).click();
        List<WebElement> list = browser.findElements(By.xpath("//*[text()='Delete']"));
        assertEquals(list.size(), 1);
    }
}
