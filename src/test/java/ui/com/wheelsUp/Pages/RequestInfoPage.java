package ui.com.wheelsUp.Pages;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Locator;

public class RequestInfoPage extends BasePage {

    public Locator emailField = new Locator("Email Field", By.cssSelector("#Email-clone"));
    public Locator phoneField = new Locator("Phone Number Field", By.cssSelector("#Phone-clone"));
    public Locator companyField = new Locator("Company Field", By.cssSelector("#Company__c-clone"));
    public Locator addressField = new Locator("Address Field", By.cssSelector("#Address-clone"));
    public Locator cityField = new Locator("City Field", By.cssSelector("#City-clone"));
    public Locator zipField = new Locator("Zip Code Field", By.cssSelector("#PostalCode-clone"));
    public Locator stateField = new Locator("State Field", By.cssSelector("#State-clone"));
    public Locator countryField = new Locator("Country Field", By.cssSelector("#Country-clone"));
    public Locator closeButton = new Locator("Close Button", By.cssSelector(".right-content .icon-close"));
}
