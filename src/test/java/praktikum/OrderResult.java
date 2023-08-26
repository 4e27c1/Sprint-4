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
            mainPage.open()                     //открываем главную
                    .clickCookies()             //кликаем по кукам
                    .clickRentButtonUP();       //кликаем Заказать

        OrderPage orderPage = new OrderPage(driverRule.getDriver()); //переходим на страницу заказа
                 orderPage.fillInOrderForm()                         //заполняем форму заказа
                          .clickDalee();                               //кликаем далее

        OrderPageNext detailsPage = new OrderPageNext(driverRule.getDriver()); //переходим на вторую часть страницы заказа
                detailsPage.wait10sec()             //ждем на всякий случай для полной отрисовки
                .fillInRentTime()                   // заполняем срок аренды
                .clickCalendar()                    // отправляем дату в календарь
                .selectColour()                     //выбираем цвет
                .zakazatClick();                    //кликаем заказать
    }
    //заказываем через нижнюю кнопку
    @Test
    public void OrderWithBottomButton(){
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()                             //открываем главную
               .clickCookies()                      //убираем куки
                .scrollToBottomButton()             //скроллим до нижней кнопки
                .clickRentButtonBOTTOM();           //кликаем заказать

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
