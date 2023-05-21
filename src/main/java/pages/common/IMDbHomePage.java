package pages.common;

import constants.locators.IMDbHomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class IMDbHomePage extends BasePage {

    private WebDriver driver;
    private By search_field = By.id(IMDbHomePageConstants.SEARCH_FIELD_ID);
    private By search_button = By.xpath(IMDbHomePageConstants.SEARCH_BUTTON_ID);

    public IMDbHomePage(WebDriver driver){
        super(driver);
        this.driver = driver;

    }
    public boolean checkURLandTitle(){
        System.out.println(driver.getTitle());

        if (driver.getTitle() == IMDbHomePageConstants.TITLE)
            return true;
        return false;
    }


    public void search(String item)  {

        WebElement searchFieldElement = new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(search_field));
        waitForSeconds(2);
        searchFieldElement.sendKeys(item);
        waitForSeconds(2);
        WebElement searchBtn = new WebDriverWait(driver, Duration.ofSeconds(5)).
                until(ExpectedConditions.elementToBeClickable(search_button));

        searchBtn.click();


    }

    public IMDbItemsPage searchForAnItem(String searchItem){
        search(searchItem);
        return new IMDbItemsPage(driver,searchItem);
    }


    //Unfortunately had problems with explicit wait, spent a day to fix it but couldnt, with
    //the implicit wait works perfectly
    public void waitForSeconds(int seconds){
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
