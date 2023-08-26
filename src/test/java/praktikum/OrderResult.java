package praktikum;

import org.junit.Rule;
import org.junit.Test;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;
import praktikum.pages.OrderPageNext;

public class OrderResult {

    @Rule
    public DriverRule driverRule = new DriverRule();


    @Test
    public void orderWithUpButton(){

        MainPage mainPage = new MainPage(driverRule.getDriver());
            mainPage.open()
                    .clickCookies()
                    .clickRentButtonUP();

        OrderPage orderPage = new OrderPage(driverRule.getDriver());
                 orderPage.fillInOrderForm()
                          .clickDalee();

        OrderPageNext detailsPage = new OrderPageNext(driverRule.getDriver());
                detailsPage.wait10sec()
                .fillInRentTime()
                .clickCalendar()
                .selectColour()
                .zakazatClick();
    }
    @Test
    public void OrderWithBottomButton(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
               .clickCookies()
                .scrollToBottomButton()
                .clickRentButtonBOTTOM();

        OrderPage orderPage = new OrderPage(driverRule.getDriver());

        orderPage.fillInOrderForm()
                 .clickDalee();

        OrderPageNext detailsPage = new OrderPageNext(driverRule.getDriver());
            detailsPage.wait10sec()
                .fillInRentTime()
                .clickCalendar()
                .selectColour()
                .zakazatClick();

    }
}
