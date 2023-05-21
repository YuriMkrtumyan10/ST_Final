package FilterTest;

import base.BaseTest;
import constants.locators.IMDbItemsPageConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.IMDbItemsPage;

public class FilerTests extends BaseTest {


    // Should test the listed items in the range 0-1 rubli. Logically it should not give any item or if it
    // will, then when sorted in descending order the very first item should be less than 1 rubli.
    // This test should fail as the filtering has defects in the website and the screenshot will be available
    @Test
    public void testFilterCustomRange1(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("джинсы");
        itemsPage.priceFilter(IMDbItemsPageConstants.CUSTOM_RANGE1_MIN,
                IMDbItemsPageConstants.CUSTOM_RANGE1_MAX);
        itemsPage.sortInDescendingOrder();

        int result = itemsPage.getTheFirstItemPrice();
        Assert.assertEquals(result < Integer.parseInt(IMDbItemsPageConstants.CUSTOM_RANGE1_MAX), true);
    }


    // Should test the listed items in the range 1000-3000 rubli. When sorted in descending order
    // the very first item should be less than 3000 rubli.
    // This test should fail as the filtering has defects in the website and the screenshot will be available

    @Test
    public void testFilterCustomRange2(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("очки");
        itemsPage.priceFilter(IMDbItemsPageConstants.CUSTOM_RANGE2_MIN,
                IMDbItemsPageConstants.CUSTOM_RANGE2_MAX);
        itemsPage.sortInDescendingOrder();

        int result = itemsPage.getTheFirstItemPrice();
        Assert.assertEquals(result < Integer.parseInt(IMDbItemsPageConstants.CUSTOM_RANGE1_MAX), true);
    }

    // Should test the listed items in the range 3000-10000 rubli. When sorted in descending order the
    // very first item should be less than 10000 rubli.
    // This test should fail as the filtering has defects in the website and the screenshot will be available

    @Test
    public void testFilterCustomRange3(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("кроссовки");
        itemsPage.priceFilter(IMDbItemsPageConstants.CUSTOM_RANGE3_MIN,
                IMDbItemsPageConstants.CUSTOM_RANGE3_MAX);
        itemsPage.sortInDescendingOrder();

        int result = itemsPage.getTheFirstItemPrice();
        Assert.assertEquals(result < Integer.parseInt(IMDbItemsPageConstants.CUSTOM_RANGE1_MAX), true);
    }


    // Sorting results in asc dsc orders

    //Should test whether the items are sorted in descending order or not. If the list of the prices of the items
    //is not in descending order, then the test will fail
    @Test
    public void testSortInDescendingOrder(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("кроссовки");
        itemsPage.priceFilter(IMDbItemsPageConstants.CUSTOM_RANGE2_MIN,
                IMDbItemsPageConstants.CUSTOM_RANGE3_MAX);
        itemsPage.sortInDescendingOrder();
        boolean result = itemsPage.isAscendingOrder();
        Assert.assertEquals(result, false);
    }


    //Should test whether the items are sorted in ascending order or not. If the list of the prices of the items
    //is not in ascending order, then the test will fail
    @Test
    public void testSortInAscendingOrder(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("очки");
        itemsPage.priceFilter(IMDbItemsPageConstants.CUSTOM_RANGE2_MIN,
                IMDbItemsPageConstants.CUSTOM_RANGE2_MAX);
        itemsPage.sortInAscendingOrder();
        boolean result = itemsPage.isAscendingOrder();
        Assert.assertEquals(result , true);
    }
}
