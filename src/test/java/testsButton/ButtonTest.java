package testsButton;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ButtonTest extends BaseButtonTest {

    @Test
    public void AddDeleteButton() {
        buttonPage.open();
        buttonPage.addButton();
        buttonPage.addButton();
        buttonPage.addButton();
        buttonPage.deleteButton();
        assertEquals(buttonPage.getListButtons().size(), 2);
    }
}
