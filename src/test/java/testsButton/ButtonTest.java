package testsButton;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ButtonTest extends BaseButtonTest {

    @Test
    public void AddDeleteButton() throws InterruptedException {
        buttonPage.open();
        buttonPage.addButton(8);
        buttonPage.deleteButton(3);
        assertEquals(buttonPage.getListButtonsCount(), buttonPage.calculateExpected());
    }
}
