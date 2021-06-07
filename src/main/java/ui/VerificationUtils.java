package ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class VerificationUtils {
    private final Logger LOG = LoggerFactory.getLogger(BrowserUtils.class);

    BrowserUtils browserUtils;

    public VerificationUtils(WebDriver driver) {
        browserUtils = new BrowserUtils(driver);
    }

    @Step("Verifying URL contains {text}")
    public void verifyURLContains(String text) {
        LOG.info("Verifying URL contains {}", text);
        Assert.assertTrue(browserUtils.getUrl().contains(text));
    }
}
