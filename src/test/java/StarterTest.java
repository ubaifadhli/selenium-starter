import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.SleepHelper;
import util.WebDriverFactory;

public class StarterTest {
    private WebDriver driver;

    @Before
    public void before() {
        driver = WebDriverFactory.createDriver();
    }

    @Test
    public void fillFormTest() {

    }

    @After
    public void after() {
        SleepHelper.sleepForSeconds(5);
        driver.quit();
    }
}
