package TestManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverCross {

    private static WebDriver driver ;
    private static final DriverOptions driverOptions = new DriverOptions();

    private DriverCross () {

    }

    public static WebDriver getDriver (String browser){
        ConfigReader.getProperty("browser") ;

        if (driver == null){

            switch (browser) {
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default -> driver = new ChromeDriver(driverOptions.chromeOptions());
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

        }
        return driver;
    }

    public static void closeDriver (){
        if (driver != null){
            driver.close();
            driver = null ;
        }
    }

    public static void quitDriver () {
        if (driver != null){
            driver.quit();
            driver = null ;
        }
    }
}
