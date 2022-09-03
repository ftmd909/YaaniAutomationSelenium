package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class EdgeDrivers {
    public static WebDriver driver;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.yaani.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
