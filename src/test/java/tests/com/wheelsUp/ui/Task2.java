package tests.com.wheelsUp.ui;

import engine.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Task2 extends WheelsUpBaseTest {

    @Test
    @Description("Task2")
    public void task2() {
        browserUtils.goToWebPage(PropertiesReader.URL.getProperty("wheelsUp"));

        browserUtils.printElementText("1 title", mainPage.flyingPersonalizedText);

        browserUtils.scrollToElement(mainPage.discoverThePossibilitiesText);
        browserUtils.printElementText("2 title", mainPage.discoverThePossibilitiesText);

        browserUtils.scrollToBottom();
        browserUtils.printElementsText(mainPage.contactUs, "Phone Number", "Email");
        browserUtils.printElementText("Address", mainPage.address);

        browserUtils.scrollToTop();
        browserUtils.clickElement(mainPage.flyMenu);
        browserUtils.clickElement(flyMenu.coreMembershipButton);

        browserUtils.scrollToElementWithJS(coreMembershipPage.privateAviationTitle);
        browserUtils.printElementsText(coreMembershipPage.privateAviationTitles, "Shared Flights", "Shuttle Flights",
                "Hot Flights");

        browserUtils.scrollToElementWithJS(coreMembershipPage.learnMoreTodayTitle);
        browserUtils.writeText("John", coreMembershipPage.firstNameInput);
        browserUtils.writeText("Doe", coreMembershipPage.lastNameInput);
        browserUtils.clickElement(coreMembershipPage.continueButton);

        verificationUtils.verifyURLContains("request-info");

        browserUtils.writeText("jdoe@gmail.com", requestInfoPage.emailField);
        browserUtils.writeText("000-000-0000", requestInfoPage.phoneField);
        browserUtils.writeText("ABC", requestInfoPage.companyField);
        browserUtils.writeText("000 NoWhere st", requestInfoPage.addressField);
        browserUtils.writeText("AnyCity", requestInfoPage.cityField);
        browserUtils.writeText("00000", requestInfoPage.zipField);
        browserUtils.writeText("AnyState", requestInfoPage.stateField);
        browserUtils.writeText("AnyCountry", requestInfoPage.countryField);
        browserUtils.moveAndClickElement(requestInfoPage.closeButton);
    }

}
