package managers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import enums.DriverType;
import enums.EnvironmentType;

public class DriverManager {
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public DriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public void getDriver() {
        this.createDriver();
    }

    private void createDriver() {

        switch (environmentType) {
            case LOCAL : this.createLocalDriver();
                break;
            case REMOTE : this.createRemoteDriver();
                break;
        }
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private void createLocalDriver() {

        if(FileReaderManager.getInstance().getConfigReader().getHeadlessMode()) {
            Configuration.headless = true;
        }

        switch (driverType) {
            case FIREFOX :
                Configuration.browser = Browsers.FIREFOX;
                break;
            case CHROME :
                Configuration.browser = Browsers.CHROME;
                break;
            case EDGE:
                Configuration.browser = Browsers.EDGE;
                break;
            case SAFARI:
                Configuration.browser = Browsers.SAFARI;
                break;
        }
        Configuration.pageLoadTimeout = 5000;
        Configuration.timeout = 5000;
    }


    public void clearDriver() {
        WebDriverRunner.clearBrowserCache();
    }

    public static void quitDriver() {
        WebDriverRunner.closeWebDriver();
    }

}