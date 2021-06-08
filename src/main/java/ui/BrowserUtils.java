package ui;

import engine.Driver;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BrowserUtils {

    private final Logger LOG = LoggerFactory.getLogger(BrowserUtils.class);
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BrowserUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }


    public static String takeScreenShot(String testName) {
        File src = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination =
                System.getProperty("user.dir") + "\\ScreenShotFile\\" + testName + System.currentTimeMillis() + ".png";
        File destFile = new File(destination);


        try {
            FileUtils.copyFile(src, destFile);
        } catch (IOException ignored) {
        }
        return destination;
    }

    public String getElementText(Locator locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.locator));

        String result = driver.findElement(locator.locator).getText();
        LOG.info("Text in element " + locator.name + " is equal to '{}'", result);

        return result;
    }

    @Step("Navigating to web page {url}")
    public void goToWebPage(String url) {
        driver.navigate().to(url);
        LOG.info("Navigate to page with url '{}'", url);
    }


    @Step("Print element {locator.name} text")
    public void printElementText(String task, Locator locator) {
        String text = getElementText(locator);
        System.out.println(task + ": \u001B[31m" + text + "\u001B[0m");
        LOG.info("Print element {} text", locator.name);

    }

    @Step("Scroll to element {locator.name}")
    public void scrollToElement(Locator locator) {
        tryScrollToElement(locator);
        LOG.info("Scroll to element {}", locator.name);
    }

    @Step("Scroll to element {locator.name}")
    public void scrollToElementWithJS(Locator locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(locator.locator));
        LOG.info("Scroll to element {}", locator.name);
    }

    private void tryScrollToElement(Locator locator) {
        try {
            driver.findElement(locator.locator);
        } catch (NoSuchElementException exception) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
            tryScrollToElement(locator);
        }
    }

    @Step("Click element {locator.name}")
    public void clickElement(Locator locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.locator));
        driver.findElement(locator.locator).click();
        LOG.info("Click element {}", locator.name);

    }

    @Step("Move to element {locator.name} and click")
    public void moveAndClickElement(Locator locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.locator));
        actions.moveToElement(driver.findElement(locator.locator)).click().build().perform();
        LOG.info("Move to element {} and click", locator.name);

    }

    @Step("Scroll to bottom")
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        LOG.info("Scroll to bottom");
    }

    @Step("Scroll to top")
    public void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        LOG.info("Scroll to top");
    }

    @Step("Print elements {locator.name} text")
    public void printElementsText(Locator locator, String... tasks) {
        List<WebElement> elements = driver.findElements(locator.locator);

        for (int i = 0; i < elements.size(); i++) {
            System.out.println(tasks[i] + ": \u001B[31m" + elements.get(i).getText() + "\u001B[0m");
        }
        LOG.info("Print elements {} text", locator.name);

    }

    @Step("Write text '{text}' to element {locator.name}")
    public void writeText(String text, Locator locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator.locator));
        driver.findElement(locator.locator).sendKeys(text);
        LOG.info("Write text '" + text + "' to element {}", locator.name);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
