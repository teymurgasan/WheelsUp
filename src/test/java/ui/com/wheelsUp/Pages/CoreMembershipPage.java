package ui.com.wheelsUp.Pages;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Locator;

public class CoreMembershipPage extends BasePage {

    public Locator privateAviationTitle = new Locator("Private Aviation Title", By.xpath("//h1[contains(text(), " +
            "'Private aviation')]"));
    public Locator privateAviationTitles = new Locator("Private Aviation Titles", By.cssSelector("#ways_to_fly" +
            "-component-3 .title"));
    public Locator learnMoreTodayTitle = new Locator("Learn More Today Title", By.xpath("//h1[contains(text(), " +
            "'Learn')]"));
    public Locator firstNameInput = new Locator("First Name Input", By.cssSelector("#FirstName-clone"));
    public Locator lastNameInput = new Locator("Last Name Input", By.cssSelector("#LastName-clone"));
    public Locator continueButton = new Locator("Continue Button", By.xpath("//a[@class='button normal primary " +
            "default typeB ng-star-inserted']"));

}
