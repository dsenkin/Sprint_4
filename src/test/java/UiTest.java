import org.junit.Test;

public class UiTest extends BaseTest {

    @Test
    public void test() {
        mainPage.openPage();
        mainPage.clickStatusButton();
        //mainPage.clickStatusField();
        mainPage.setStatusField("000");
    }

}
