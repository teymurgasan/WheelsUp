package ui.com.wheelsUp.Pages;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Locator;

public class MainPage extends BasePage {

    public Locator flyingPersonalizedText = new Locator("Text For Flying, Personalized", By.xpath("//h1[@class" +
            "='heading ui-reveal']"));
    public Locator discoverThePossibilitiesText = new Locator("Discover The Possibilities", By.xpath("//h1[@class" +
            "='heading dark-blue-theme ng-star-inserted aos-init aos-animate']"));
    public Locator contactUs = new Locator("Contact Us info", By.xpath("//ul[@id='option_3'] //a"));
    public Locator address = new Locator("Address", By.xpath("//ul[@role='listbox']  //span"));
    public Locator flyMenu = new Locator("Fly Menu", By.xpath("//a[contains(text(), 'Fly')]"));

}
