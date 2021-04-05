package Create;

import Resources.RANDOM_NAME;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ROLE {

    @Test
    //Create Role with Admin rights
    public void Role() throws InterruptedException {
        //create new session
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mark43-admin.timvero.xyz/");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("test");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("1234" + Keys.ENTER);
        Thread.sleep(2500);
        // move to "new role" page and create role
        driver.get("http://mark43-admin.timvero.xyz/role/new");
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys(RANDOM_NAME.randomName());
        WebElement description = driver.findElement(By.id("description"));
        description.sendKeys(RANDOM_NAME.randomName());
        WebElement checkbox = driver.findElement(By.id("god"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkbox);
        WebElement startPage = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[1]"));
        startPage.click();
        Thread.sleep(500);
        WebElement dashboard = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]"));
        dashboard.click();
        WebElement btnSave = driver.findElement(By.cssSelector("form#userRoleForm .btn-success"));
        btnSave.click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        // deleting new role
        WebElement btnDelete = driver.findElement(By.xpath("//a[.='Delete']"));
        btnDelete.click();
        Thread.sleep(1000);
        WebElement confirm = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
        confirm.click();
        // quit from window
        driver.quit();
    }
}
