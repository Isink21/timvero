package Create;

import Resources.Config;
import Resources.RANDOM_EMAIL;
import Resources.RANDOM_NAME;
import Resources.RANDOM_PHONE;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class USER {
    @Test
    // Create user with admin role
    public void User() throws InterruptedException {
        //create new session
        System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String strUrl1 = Config.getUrl1();
        driver.get(strUrl1);
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("test");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1234" + Keys.ENTER);
        Thread.sleep(2500);
        driver.get("http://mark43-admin.timvero.xyz/user");
        WebElement btnCreate = driver.findElement(By.xpath("//a[contains(.,'Create')]"));
        btnCreate.click();
        Thread.sleep(500);
        WebElement span = driver.findElement(By.cssSelector(".selectize-input"));
        span.click();
        WebElement role = driver.findElement(By.xpath("//div[@data-value='1']"));
        role.click();
        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys(RANDOM_NAME.randomName());
        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys(RANDOM_NAME.randomName());
        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys(RANDOM_NAME.randomName());
        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys(RANDOM_PHONE.randomPhone());
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(RANDOM_EMAIL.randomEmail());
        WebElement btnSave = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[7]/button[1]"));
        btnSave.click();
        Thread.sleep(6000);
        driver.quit();
    }
}
