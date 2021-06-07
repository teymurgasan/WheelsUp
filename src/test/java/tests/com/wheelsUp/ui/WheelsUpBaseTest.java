package tests.com.wheelsUp.ui;

import engine.BaseTest;
import ui.com.wheelsUp.Modules.FlyMenu;
import ui.com.wheelsUp.Pages.CoreMembershipPage;
import ui.com.wheelsUp.Pages.MainPage;
import ui.com.wheelsUp.Pages.RequestInfoPage;

public class WheelsUpBaseTest extends BaseTest {

    // Pages
    protected MainPage mainPage = new MainPage();
    protected CoreMembershipPage coreMembershipPage = new CoreMembershipPage();
    protected RequestInfoPage requestInfoPage = new RequestInfoPage();

    //Modules
    protected FlyMenu flyMenu = new FlyMenu();

}
