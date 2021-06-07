package ui.com.wheelsUp.Modules;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Locator;

public class FlyMenu extends BasePage {

    public Locator coreMembershipButton = new Locator("Core Membership Button", By.xpath("//a[contains(text(), 'CORE " +
            "MEMBERSHIP')]"));

}
