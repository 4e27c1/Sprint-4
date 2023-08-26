package praktikum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class OrderPage {
    final WebDriver driver;
    private final By nameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.className("select-search__input");
    private final By metroClick = By.xpath(".//div[@class='']/div/div[2]/ul/li[@data-value = '5']");
    private final By phone = By.xpath(".//div[@class='Order_Form__17u6u']/div/input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By dalee = By.xpath(".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public  OrderPage fillInOrderForm(){
        driver.findElement(nameInput).sendKeys("Василий");
        driver.findElement(lastNameInput).sendKeys("Паравозов");
        driver.findElement(address).sendKeys("кукуево");
        driver.findElement(metro).click();
        driver.findElement(metroClick).click();
        driver.findElement(phone).sendKeys("79000000000");
        return this;
    }

    public OrderPage clickDalee(){
        driver.findElement(dalee).click();
        return this;
    }


}
