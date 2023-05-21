package SearchTest;

import base.BaseTest;
import constants.dataproviders.testData;
import constants.messages.AssertionMessages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.IMDbItemsPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class SearchTests extends BaseTest {

    //Should test the starting point page's title which is the HOMEPAGE title
    @Test
    public void testTheStartingDirectory() {
        assertEquals(homePage.checkURLandTitle(), false);
    }

    //Should test if the search-box is available and displayed
    @Test
    public void testTheSearchBox() {
        WebElement search_box = driver.findElement(By.id("searchBlock"));
        assertTrue(search_box.isDisplayed());
    }

    //Should test if the search-box is available and displayed
    @Test
    public void testSuccessfulItemSearchResult() {
        IMDbItemsPage itemsPage = homePage.searchForAnItem("джинсы");
        boolean result = (itemsPage.getSearchResult());
        Assert.assertEquals(result, true);
    }


    //  Should search for an INVALID item and display correct results and an error message
    @Test
    public void testUnSuccessfulItemSearchResult() {
        homePage.searchForAnItem(testData.invalid_itemName);
        assertEquals(AssertionMessages.SEARCH_ERROR_MESSAGE, "Попробуйте поискать по-другому или сократить запрос");
    }




}
