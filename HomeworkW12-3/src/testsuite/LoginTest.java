package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
//        * Enter “tomsmith” username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
//        * Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
//        * Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
//        * Verify the text “Secure Area”
        String actualResult = driver.findElement(By.xpath("//div[@class='example']/h2")).getText();
        System.out.println(actualResult);
        String expectedResult = "Secure Area";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
//               * Enter “tomsmith1” username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");
//                * Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
//                * Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
//                * Verify the error message “Your username is invalid!”
        String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        System.out.println(actualResult);
        String expectedResult = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
//        * Enter “tomsmith” username
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
//        * Enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");
//        * Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//button[@class='radius']"));
        login.click();
//        * Verify the error message “Your password is invalid!”
        String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        System.out.println(actualResult);
        String expectedResult = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @After
    public void endTest(){
        //closeBrowser();
    }
}