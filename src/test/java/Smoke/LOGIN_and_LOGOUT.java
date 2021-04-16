package Smoke;

import Resources.Config;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LOGIN_and_LOGOUT {
    @Story(value = "LogIn")
    @Test
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String strUrl1 = Config.getUrl1();
        driver.get(strUrl1);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("test");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1234" + Keys.ENTER);
        Thread.sleep(2500);
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals("http://mark43-admin.timvero.xyz/dashboard")) {
            System.out.println("Verification Successful");
        } else {
            System.out.println("Verification Failed");
        }
        driver.quit();
    }
    @Story(value = "LogOut")
    @Test
    public void logout() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String strUrl1 = Config.getUrl1();
        driver.get(strUrl1);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("test");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1234" + Keys.ENTER);
        Thread.sleep(2500);
        WebElement client = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/a"));
        client.click();
        WebElement logOut = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/ul/li[3]/a"));
        logOut.click();
        Thread.sleep(1500);
        driver.navigate().refresh();
        String actualUrl2 = driver.getCurrentUrl();
        if (actualUrl2.equals("http://mark43-admin.timvero.xyz/login?logout")) {
            System.out.println("LogOut Successful");
        } else {
            System.out.println("LogOut Failed");
        }
        driver.quit();
    }
}

