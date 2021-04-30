package Smoke;

import Resources.Config;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.lang.Thread.sleep;

public class LOGIN_and_LOGOUT {
    @Story(value = "LogIn")
    @Test
    public void login() throws InterruptedException {
        open(Config.getUrl1());
        $(By.xpath("//form[@id='login']//input[@name='username']")).setValue("test");
        $(By.cssSelector("[placeholder='Password']")).setValue("1234").pressEnter();
        sleep(2500);
        String currentUrl = url();
        String expectedUrl = Config.getUrl1();
        Assert.assertEquals(currentUrl, expectedUrl);
        closeWindow();
    }
   @Story(value = "LogOut")
    @Test
    public void logout() throws InterruptedException {
        open(Config.getUrl1());
        $(By.xpath("//form[@id='login']//input[@name='username']")).setValue("test");
        $(By.cssSelector("[placeholder='Password']")).setValue("1234").pressEnter();
        sleep(2500);
        open("http://mark43-alpha.timvero.xyz/logout");
        refresh();
        String currentUrl = url();
        String expectedUrl = "http://mark43-alpha.timvero.xyz/login?logout";
        Assert.assertEquals(currentUrl, expectedUrl);
        closeWindow();
    }
}

