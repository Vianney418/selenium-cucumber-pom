package StepDefinitions;

import java.time.Duration;
import java.util.UUID;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

public class Hooks {
	public static WebDriver driver;

    @Before
    public void openBrowser() throws Exception {

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions.addArguments("--disable-notifications"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    @AfterStep
    public void embedScreenshot(Scenario scenario) {

        try {
            String screenshotName = "screenshot_" + UUID.randomUUID() + ".png";
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void quitBrowser(){
        driver.quit();
    }


}
