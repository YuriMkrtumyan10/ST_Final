//package DashboardTest;
//
//import base.BaseTest;
//import constants.dataproviders.testData;
//import constants.locators.IMDbItemsPageConstants;
//import org.junit.Test;
//import pages.common.IMDbItemsPage;
//
//import static constants.locators.IMDbItemsPageConstants.Dashboard_URL;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class DashboardTests extends BaseTest {
//
//    @Test
//    public void testDashboardTitle() {
//        IMDbLoginPage loginPage = homePage.clickLogInButton();
//        loginPage.login(testData.username, testData.password);
//        String pageTitle = driver.getTitle();
//        assertEquals(IMDbItemsPageConstants.TITLE, pageTitle);
//    }
//    @Test
//    public void testDashboardURL() {
//        String currentUrl = driver.getCurrentUrl();
//        assertEquals(currentUrl, Dashboard_URL);
//    }
//
//    @Test
//    public void testDashboardProfileMenu() {
//        IMDbItemsPage dshBoard = new IMDbItemsPage(driver);
//        assertTrue(dshBoard.getProfileMenu().isEnabled()
//                && dshBoard.getProfileMenu().isDisplayed());
//    }
//}
