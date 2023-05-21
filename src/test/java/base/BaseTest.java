package base;

import constants.urls.Urls;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.common.IMDbHomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class BaseTest {

    public static WebDriver driver;
    public IMDbHomePage homePage;


    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "/Users/yurimkrtumyan/IdeaProjects/FinalProject_YuriMkrtumyan/resources/drivers/chromedriver");

        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Urls.SUT_URL);
        homePage = new IMDbHomePage(driver);


    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot.toPath(), new File("resources/screenshots/" +  result.getName() + ".png").toPath());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    @AfterMethod
    public static void tearDown() {

        driver.quit();
    }

}
