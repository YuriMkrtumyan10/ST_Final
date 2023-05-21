package pages.common;

import constants.locators.IMDbCartPageConstants;
import constants.locators.IMDbHomePageConstants;
import constants.urls.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class IMDbCartPage extends BasePage {

    private WebDriver driver;
    private String item;

    private  String url = Urls.CART_URL;
    private By addButton = By.xpath(IMDbCartPageConstants.ADD_BUTTON);
    private By deleteButton = By.xpath(IMDbCartPageConstants.DELETE_BUTTON);
    private By cartItem = By.xpath(IMDbCartPageConstants.CART_ITEM);
    private By message = By.xpath(IMDbCartPageConstants.CART_EMPTY_MESSAGE);


    public IMDbCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public boolean checkURL(){
        waitForSeconds(4);

        if (this.driver.getCurrentUrl().toString() == url)
            return true;

        return false;
    }

    public String getMessageContent(){
        WebElement message_ = driver.findElement(message);
        return message_.getText().toString();
    }
    public void addToCartAndGoToTheCart(){

        waitForSeconds(4);
        WebElement addBtn = driver.findElement(addButton);
        addBtn.click();
        waitForSeconds(4);
        WebElement carBtn = driver.findElement(By.xpath(IMDbHomePageConstants.CART_ICON));
        carBtn.click();
        waitForSeconds(7);

    }
    public boolean isEmpty(){
        waitForSeconds(2);
        WebElement item = driver.findElement(cartItem);

        if (item.isDisplayed()){
            return false;
        }

        return true;
    }

    public void removeItem(){
        waitForSeconds(3);
        WebElement deleteBtn = driver.findElement(deleteButton);
        deleteBtn.click();
        waitForSeconds(3);
    }
    public void waitForSeconds(int seconds){
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
