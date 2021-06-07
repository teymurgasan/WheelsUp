package engine;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ui.BrowserUtils;


public class ListenerConfig implements ITestListener {
    private static final Logger LOG = LoggerFactory.getLogger(ListenerConfig.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info("{} test is started", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info("{} test successfully passed", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.warn("{} test failed", result.getName());

        String destination = BrowserUtils.takeScreenShot(result.getTestName());
        takeScreenShot();
        LOG.info("ScreenShot was saved at destination '{}'", destination);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOG.warn("{} test was skipped", result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] takeScreenShot() {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
