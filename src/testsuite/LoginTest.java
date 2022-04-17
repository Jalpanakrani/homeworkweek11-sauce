package testsuite;

import browserfactory.BaseTest;
import graphql.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


    public class LoginTest extends BaseTest {
        String baseUrl = "https://www.saucedemo.com/";

        @Before
        public void setup() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyUserShouldLoginSuccessfullyWithValid() {

            //Enter valid username
            WebElement username = driver.findElement(By.id("user-name"));
            //sending field invalid username
            username.sendKeys("standard_user");

            // Find the invalid password field element
            WebElement passwordField = driver.findElement(By.name("password"));
            //     Sending invalid Password to password field element
            passwordField.sendKeys("secret_sauce");

            //find login button and click on LoginInButton
            WebElement LoginInbutton = driver.findElement(By.id("login-button"));
            LoginInbutton.click();

            //This is from requirement
            String expectedMessage = "PRODUCTS";

            //find the PRODUCTS text element and get the text
            WebElement actualMessageElement = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
            String actualMessage = actualMessageElement.getText();
            System.out.println(actualMessage);
            //validate actual and expected message
            org.junit.Assert.assertEquals("Not navigagte to login page", expectedMessage, actualMessage);
        }

        @Test
        public void verifyThatSixProductAreDisplayedOnPage() {
            //Enter valid username
            WebElement username = driver.findElement(By.id("user-name"));
            //sending field invalid username
            username.sendKeys("standard_user");


            // Find the invalid password field element
            WebElement passwordField = driver.findElement(By.name("password"));
            //     Sending invalid Password to password field element
            passwordField.sendKeys("secret_sauce");
            //find login button and click on LoginInButton
            WebElement LoginInbutton = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
            LoginInbutton.click();


            //This is from requirement
            String expectedMessage = "6 Products are displayed on the page";

            //invalid email or password text element and get the text
            WebElement actualMessageElement = driver.findElement(By.xpath("//div[@id='']"));
            String actualMessage = actualMessageElement.getText();
            System.out.println(actualMessage);
            //validate actual and expected message
            org.junit.Assert.assertEquals("Products page ", expectedMessage, actualMessage);
             String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = driver.findElement(By.className("button button-primary g-recaptcha")).getText();
        }

       @After
        public void tearDown(){
           closeBrowser();
        }
    }

