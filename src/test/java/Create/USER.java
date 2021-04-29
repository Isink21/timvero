package Create;

import Resources.Config;
import Resources.RANDOM_EMAIL;
import Resources.RANDOM_NAME;
import Resources.RANDOM_PHONE;
import org.openqa.selenium.*;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class USER {
    @Test
    // Create user with admin role
    public void User() throws InterruptedException {
        //create new session and login
        open(Config.getUrl1());
        $(By.xpath("//form[@id='login']//input[@name='username']")).setValue("test");
        $(By.cssSelector("[placeholder='Password']")).setValue("1234").pressEnter();
        sleep(1500);

        //move to User page and create User
        open("http://mark43-admin.timvero.xyz/user");
        $(By.xpath("//a[contains(.,'Create')]")).click();
        sleep(1000);
        $(By.cssSelector(".selectize-input")).click();
        $(By.xpath("//div[.='Global Admin']")).click();
        $(By.name("login")).sendKeys(RANDOM_NAME.randomName());
        $(By.name("firstName")).sendKeys(RANDOM_NAME.randomName());
        $(By.name("lastName")).sendKeys(RANDOM_NAME.randomName());
        $(By.name("phone")).sendKeys(RANDOM_PHONE.randomPhone());
        $(By.name("email")).sendKeys(RANDOM_EMAIL.randomEmail());
        $(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[7]/button[1]")).click();
        sleep(6000);

        closeWindow();
    }
}
