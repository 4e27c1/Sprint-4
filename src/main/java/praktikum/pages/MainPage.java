package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    public static final By GO_BUTTON = By.cssSelector("[class*='Header_Button_']");
    public static final By ORDER_INPUT = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z Header_Input__xIoUq')]");
    public static final By STATUS_BUTTON = By.xpath(".//button[@class='Header_Link__1TAG7']");
    public static final By NO_IMAGE = By.cssSelector("[alt='Not found']");
   // public static final By ACCORDEON_HEADING = By.id("accordion__heading-");
    private final By upButton = By.xpath(".//button[@class='Button_Button__ra12g']");

   private final By bottomButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;

    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);

        return this;
    }

    public  void waitForNoStatus( ) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(NO_IMAGE));
    }

    public  void clickOnGo( ) {
        driver.findElement(GO_BUTTON).click();
    }

    public  void typeOrderNumber(String orderNumber) {
        driver.findElement(ORDER_INPUT).sendKeys(orderNumber);
    }

    public  void showStatus( ) {
        driver.findElement(STATUS_BUTTON).click();
    }

    public String getAccLocatorAndClick( int accLocator) {

        WebElement element =  driver.findElement(By.id("accordion__heading-"+accLocator));
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.id("accordion__heading-"+accLocator)).click();
        String text = driver.findElement(By.xpath(".//*[@id='accordion__panel-"+accLocator+"']/p")).getText();
        return text;
    }


    public MainPage clickRentButtonUP(){
        driver.findElement(upButton).click();
        return this;
    }
    public MainPage scrollToBottomButton (){
        WebElement element = driver.findElement(By.xpath(".//div[@class='Home_RoadMap__2tal_']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }
    public MainPage clickRentButtonBOTTOM() {
        driver.findElement(bottomButton).click();
        return this;
    }
    public MainPage clickCookies(){
        driver.findElement(By.id("rcc-confirm-button")).click();
        return this;
    }

 }
