package CartTest;

import base.BaseTest;
import constants.messages.AssertionMessages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.IMDbCartPage;
import pages.common.IMDbItemsPage;

public class CartTests extends BaseTest {


    //Checks whether the item was added if yes then it should be in the cart
    @Test
    public void testItemExistenceInCart(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("очки");
        WebElement item = itemsPage.getTheFirstItem();
        IMDbCartPage cartPage = itemsPage.clickOnItem(item);
        cartPage.addToCartAndGoToTheCart();

        Assert.assertEquals(cartPage.isEmpty(), false);
    }

    //Checks whether the item was removed if yes then it should not be in the cart
    @Test
    public void testItemRemoval(){
        IMDbItemsPage itemsPage = homePage.searchForAnItem("очки");
        WebElement item = itemsPage.getTheFirstItem();
        IMDbCartPage cartPage = itemsPage.clickOnItem(item);
        cartPage.addToCartAndGoToTheCart();
        cartPage.removeItem();

        Assert.assertEquals(cartPage.getMessageContent(), AssertionMessages.EMPTY_CART_MESSAGE);
    }


}
