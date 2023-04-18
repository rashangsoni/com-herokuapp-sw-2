package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter "tomsmith" username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        //Enter "Supersecretpassword!" password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on 'login' button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify the text "secure Area"
        String expectedResult = "You logged into a secure area!\n" +"×";
        String actualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();
        Assert.assertEquals("You logge into a secure area!",expectedResult,actualResult);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter "tomsmith1" username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith1");

        //Enter "Supersecretpassword!" password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on 'login' button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify the error message"your username is invalid"
        String expectedMessage = "Your username is invalid!\n" +"×";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Your username is invalid!",expectedMessage,actualMessage);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter "tomsmith" username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");

        //Enter "Supersecretpassword" password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");

        //Click on 'login' button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        //Verify the error message "your password is invalid"
        String expectedMessage ="Your password is invalid!\n" +"×";
        String actualMessage = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Your password is invalid!",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}