package Smoke;

import Resources.Config;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Story;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@Story(value = "Check HTTP Status of App's")
public class HTTPstatus {
    @BeforeSuite
    //Added environments properties in report
    public void BrowserTestRule ()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.quit();
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String os = cap.getPlatform().toString();
        String v = cap.getVersion().toString();
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", browserName)
                        .put("OS", os)
                        .put("Browser.Version", v)
                        .put("URL", "http://mark43-admin.timvero.xyz")
                        .build());
    }
    @Test
    //Here is a test, which appears status code of the app
    public void status() throws Exception {
        String strUrl1 = Config.getUrl1();
        URL url = new URL(strUrl1);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
        if (httpCon.getResponseCode() == 200){
            System.out.println("Response code is " + httpCon.getResponseCode());
            System.out.println("Good");
        } else {
            System.out.println("Response code is " + httpCon.getResponseCode());
            System.out.println("Bad");
        }
    }
}
