package pages.common;


import constants.locators.IMDbCartPageConstants;
import constants.locators.IMDbItemsPageConstants;
import constants.urls.Urls;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class IMDbItemsPage extends BasePage {
    private WebDriver driver;
    private String item;

    private String catalog_url = Urls.ITEMS_URL;
    private By valid_search_result_count= By.xpath(IMDbItemsPageConstants.VALID_SEARCH_RESULT_COUNT);

    private By customRange1Min= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE1_MIN);
    private By customRange1Max= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE1_MAX);
    private By customRange2Min= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE2_MIN);
    private By customRange2Max= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE2_MAX);
    private By customRange3Min= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE3_MIN);
    private By customRange3Max= By.xpath(IMDbItemsPageConstants.CUSTOM_RANGE3_MAX);
    private By filterButton= By.xpath(IMDbItemsPageConstants.FILTER_BUTTON);
    private By maxField= By.xpath(IMDbItemsPageConstants.FILTER_INPUT_MAX_PRICE_FIELD);
    private By minField= By.xpath(IMDbItemsPageConstants.FILTER_INPUT_MIN_PRICE_FIELD);
    private By showButton = By.xpath(IMDbItemsPageConstants.FILTER_SHOW_BUTTON);
    private By descendingOrder = By.xpath(IMDbItemsPageConstants.FILTER_PRICE_BY_DESCENDING_ORDER);
    private By ascendingOrder = By.xpath(IMDbItemsPageConstants.FILTER_PRICE_BY_ASCENDING_ORDER);
    private By filterByButton = By.xpath(IMDbItemsPageConstants.FILTER_BY_BUTTON);
    private By addCartButton = By.xpath(IMDbCartPageConstants.ADD_BUTTON);


    public IMDbItemsPage(WebDriver driver, String item){
        super(driver);
        this.driver = driver;
        this.item=item;

    }


    public boolean checkURLandTitle(){

        String urlPart = catalog_url.substring(0, catalog_url.indexOf('/', catalog_url.indexOf("catalog") + 7));

        if (driver.getTitle() == IMDbItemsPageConstants.ITEMS_PAGE_TITLE
            && driver.getCurrentUrl() == urlPart)
            return true;

        return false;
    }
    public boolean getSearchResult(){

        waitForSeconds(2);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(valid_search_result_count));

        if (Integer.parseInt(searchResult.getText().toString().replaceAll("\\s", "")) > 0){
            return true;
        } else{
            return false;
        }
    }

    public void priceFilter(String min, String max){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)");
        waitForSeconds(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement filterBtn = wait.until(ExpectedConditions.elementToBeClickable(filterButton));

        filterBtn.click();

        WebElement min_Field = wait.until(ExpectedConditions.elementToBeClickable(minField));
        WebElement max_Field = wait.until(ExpectedConditions.elementToBeClickable(maxField));
        WebElement filterSubmitBtn = wait.until(ExpectedConditions.elementToBeClickable(showButton));


        waitForSeconds(2);
        min_Field.clear();
        min_Field.sendKeys(min);

        waitForSeconds(2);
        max_Field.clear();
        max_Field.sendKeys(max);

        waitForSeconds(2);
        filterSubmitBtn.click();

    }


    public void sortInAscendingOrder(){
        waitForSeconds(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement filterByBtn = wait.until(ExpectedConditions.elementToBeClickable(filterByButton));
        filterByBtn.click();
        WebElement descendingOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(ascendingOrder));
        descendingOrderBtn.click();
    }
    public void sortInDescendingOrder(){
        waitForSeconds(2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement filterByBtn = wait.until(ExpectedConditions.elementToBeClickable(filterByButton));
        filterByBtn.click();
        WebElement descendingOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(descendingOrder));
        descendingOrderBtn.click();
    }
    public boolean isAscendingOrder() {
        waitForSeconds(2);
        WebElement productCardList = driver.findElement(By.className("product-card-list"));
        List<WebElement> articles = productCardList.findElements(By.tagName("article"));
        List<Integer> prices = new ArrayList<>();

        for (WebElement article : articles) {

            WebElement priceElement = article.findElement(By.className("price__lower-price"));
            String priceText = priceElement.getText().trim().replaceAll("[^0-9]", "");
            prices.add(Integer.parseInt(priceText));
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }



    public int getTheFirstItemPrice(){

        WebElement productCardList = driver.findElement(By.className("product-card-list"));
        List<WebElement> articles = productCardList.findElements(By.tagName("article"));

        WebElement priceElement = articles.get(0).findElement(By.className("price__lower-price"));
        String priceText = priceElement.getText().trim().replaceAll("[^0-9]", "");
        int price = Integer.parseInt(priceText);

        return price;
    }
    public WebElement getTheFirstItem(){

        waitForSeconds(2);
        WebElement productCardList = driver.findElement(By.className("product-card-list"));
        WebElement item = productCardList.findElement(By.tagName("article"));
        waitForSeconds(2);

        return item;
    }
    public IMDbCartPage clickOnItem(WebElement item) {
        item.click();
        return new IMDbCartPage(driver);
    }


        public void waitForSeconds(int seconds){
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
