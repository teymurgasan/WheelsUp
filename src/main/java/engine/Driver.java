package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static final Logger LOG = LoggerFactory.getLogger(Driver.class);
    private static WebDriver driver;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropertiesReader.CONFIGURATIONS.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    LOG.info("Chrome Driver was initialized");
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    LOG.info("Firefox Driver was initialized");
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    LOG.info("Internet Explorer Driver was initialized");
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        LOG.info("Browser was closed");
        driver = null;
    }
}
