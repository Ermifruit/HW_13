import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class EditTest {

    @Test
    public void testEditMessage() throws IOException, URISyntaxException {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.vk.com");

        WebElement emailField = driver.findElement(By.xpath(".//input[@placeholder=\"Телефон или email\"]"));
        emailField.sendKeys("+375293314680");

        WebElement passwordField = driver.findElement(By.xpath(".//input[@placeholder=\"Пароль\"]"));
        passwordField.sendKeys("nikto1987");

        WebElement enterButton = driver.findElement(By.xpath(".//button[@id=\"index_login_button\"]"));
        enterButton.click();

        WebElement myPage = driver.findElement(By.xpath(".//span[text()=\"Моя страница\"]"));
        myPage.click();

        Send send = new Send();
        Edit edit = new Edit();

        WebElement post = driver.findElement(By.xpath(".//div[contains(@data-post-id, " + edit.editMessage(send.sendMessage()) + ")]"));

        Assert.assertTrue(post.isDisplayed());
    }
}