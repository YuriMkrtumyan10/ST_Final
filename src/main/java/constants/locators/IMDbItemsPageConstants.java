package constants.locators;

public class IMDbItemsPageConstants {
    public static final String VALID_SEARCH_RESULT_COUNT = "//*[@id=\"catalog\"]/div/div[1]/div/span/span[1]";
    public static final String INVALID_SEARCH_RESULT_ERROR = "body.ru:nth-child(7) div.wrapper:nth-child(1) main.main.left-bg div.main__container div.catalog-page.catalog-page--non-search:nth-child(6) div.catalog-page__main div.catalog-page__not-found.not-found-search:nth-child(1) div.not-found-search__wrap > p.not-found-search__text";
    public static final String ITEMS_PAGE_TITLE = "Wildberries - модный интернет магазин";
    public static final String ITEMS_LIST = "body.ru:nth-child(7) div.wrapper:nth-child(1) main.main.left-bg div.main__container div.catalog-page div.catalog-page__main.new-size:nth-child(4) div.catalog-page__content:nth-child(2) div.product-card-overflow:nth-child(1) > div.product-card-list";




    //for filtering
    public static final String CUSTOM_RANGE1_MIN = "0";
    public static final String CUSTOM_RANGE1_MAX= "1";
    public static final String CUSTOM_RANGE2_MIN = "1000";
    public static final String CUSTOM_RANGE2_MAX= "3000";
    public static final String CUSTOM_RANGE3_MIN = "3000";
    public static final String CUSTOM_RANGE3_MAX= "10000";

    public static final String FILTER_BUTTON = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[9]";
    public static final String FILTER_INPUT_MIN_PRICE_FIELD = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/label[1]/input[1]";
    public static final String FILTER_INPUT_MAX_PRICE_FIELD = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/div[1]/label[1]/input[1]";
    public static final String FILTER_SHOW_BUTTON = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[2]";

    public static final String FILTER_BY_BUTTON = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]";
    public static final String FILTER_PRICE_BY_DESCENDING_ORDER = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[1]";
    public static final String FILTER_PRICE_BY_ASCENDING_ORDER = "/html[1]/body[1]/div[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/div[1]";

}
