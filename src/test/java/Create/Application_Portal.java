package Create;

import Resources.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Application_Portal {
    @Test
    public void App () throws InterruptedException {
        open(Config.getUrl2());
        $(By.cssSelector("[placeholder='Enter Your full name']")).setValue(RANDOM_NAME.randomName());
        $(By.id("borrower.personalEmail")).setValue(RANDOM_EMAIL.randomEmail());
        $(By.cssSelector("[placeholder='Enter Your phone number']")).setValue(RANDOM_PHONE.randomPhone());
        $(By.cssSelector("[placeholder='Birthday date']")).setValue("12.12.2012");
        $(By.cssSelector(".Checkout > div:nth-of-type(2) [xmlns='http://www.w3.org/2000/svg']")).click();
        $(By.id("react-select-2-option-58")).click();
        $(By.cssSelector("[placeholder='Enter Your city']")).setValue("123");
        $(By.cssSelector("[placeholder='Enter Your Line 1']")).setValue("123");
        $(By.cssSelector("[placeholder='Enter Your Line 2']")).setValue("123");
        $(By.cssSelector("[placeholder='Enter Your ZIP-code']")).setValue(("123"));
        $(By.cssSelector("[placeholder='Enter Your personal ID']")).setValue("0000000000000004");
        $(By.cssSelector("[placeholder='Enter Your first name']")).setValue("123");
        $(By.cssSelector("[placeholder='Enter Your last name']")).setValue("123");
        $(By.cssSelector(".Checkout > div:nth-of-type(4) > div:nth-of-type(1) [xmlns='http://www.w3.org/2000/svg']")).click();
        $(By.id("react-select-3-option-7")).click();
        $(By.cssSelector(".Checkout > .Registration__block > div:nth-of-type(2) [xmlns='http://www.w3.org/2000/svg']")).click();
        $(By.id("react-select-4-option-0")).click();
        $(By.cssSelector("[placeholder='Enter Your work experience']")).setValue("12");
        $(By.cssSelector("[placeholder='Enter Your current income']")).setValue("2000");
        $(By.cssSelector(".Checkout div:nth-of-type(5) [xmlns='http://www.w3.org/2000/svg']")).click();
        $(By.id("react-select-5-option-4")).click();
        $(By.cssSelector(".button")).click();
        sleep(10000);


        $(By.id("amount")).setValue("10000");
        $(By.cssSelector("[placeholder='Select start date']")).setValue("12052021");
        $(By.id("paymentDay")).setValue("12");
        $(By.cssSelector(".button")).click();
        $(By.xpath("//div[@class='radio-input']//span[@class='checkmark']")).click();
        $(By.cssSelector(".button")).click();
        sleep(10000);


        $(By.cssSelector(".button")).click();
        sleep(5000);


        $(By.id("code")).setValue("121212");
        $(By.cssSelector(".button_success")).click();
        sleep(5000);


        /*$(By.cssSelector(".ESign__default")).click();
        $(By.cssSelector(".ESign__default")).hover();
        $(By.cssSelector(".ESign__default")).click();*/
        SelenideElement element = $(By.cssSelector(".ESign__default"));
        actions().dragAndDropBy(element, 10, 10).perform();
        $(By.cssSelector(".button_success")).click();
        sleep(10000);
    }
}
