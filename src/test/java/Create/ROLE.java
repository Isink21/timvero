package Create;

import Resources.Config;
import Resources.RANDOM_NAME;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class ROLE {

    @Test
    //Create Role with Admin rights
    public void Role() throws InterruptedException {

        //create new session and login
        open(Config.getUrl1());
        $(By.xpath("//form[@id='login']//input[@name='username']")).setValue("test");
        $(By.cssSelector("[placeholder='Password']")).setValue("1234").pressEnter();
        sleep(1500);

        // move to "new role" page and create role
        open("http://mark43-admin.timvero.xyz/role/new");
        $(By.id("name")).sendKeys(RANDOM_NAME.randomName());
        $(By.id("description")).sendKeys(RANDOM_NAME.randomName());
        $(By.cssSelector("[for='god']")).click();
        $(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]")).click();
        sleep(500);
        $(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
        $(By.cssSelector("form#userRoleForm .btn-success")).click();
        sleep(5000);
        refresh();
        sleep(1000);

        // deleting new role
        $(By.xpath("//a[.='Delete']")).click();
        sleep(1500);
        $(By.xpath("//button[@class='btn btn-success']")).click();

        // quit from window
        closeWindow();
    }
}
