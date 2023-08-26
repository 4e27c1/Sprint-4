package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ScooterTest   {
    public static final String INVALID_ORDER_NUMBER = "123";
    @Rule

    public DriverRule driverRule = new DriverRule();


    @Test
    public void invalidOrderNumber(){
        MainPage mainPage = new MainPage(driverRule.getDriver());

        mainPage.open();
        mainPage.showStatus();
        mainPage.typeOrderNumber(INVALID_ORDER_NUMBER);
        mainPage.clickOnGo();
        mainPage.waitForNoStatus();

    }


}
