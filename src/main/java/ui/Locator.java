package ui;

import org.openqa.selenium.By;

public class Locator {

    public final By locator;
    public final String name;

    public Locator(String name, By locator) {
        this.locator = locator;
        this.name = name;
    }

}
