package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final String BROWSER_TYPE_PROPERTY = "webdriver.browser";

    public static WebDriver createDriver() {
        String chosenBrowser = PropertiesHelper.getProperty(BROWSER_TYPE_PROPERTY);
        DriverManagerType driverType = DriverManagerType.valueOf(chosenBrowser);

        WebDriverManager.getInstance(driverType).setup();

        try {
            Class<?> driverClass = Class.forName(driverType.browserClass());
            return (WebDriver) driverClass.newInstance();

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
