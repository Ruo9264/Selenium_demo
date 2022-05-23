package cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.List;

public class testCases {
    WebDriver driver;

    @BeforeAll
    static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest(){
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void addProductToCart() {
        //Login——'Welcome Cup'
        //Add Cart——Cart include Title
        //Logout——'Sign up'


        driver.get("https://www.demoblaze.com/index.html");
        driver.getTitle(); // => "STORE"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement loginNav = driver.findElement(By.id("login2"));
        WebElement signUpNav = driver.findElement(By.id("signin2"));
        WebElement cartNav = driver.findElement(By.id("cartur"));
//        WebElement productName = driver.findElement(By.cssSelector([a=Samsung galaxy s6]))
//        WebElement productName = driver.findElement(By.linkText("Samsung galaxy s6"));
        WebElement homeNav = driver.findElement(By.id("nava"));

        List<WebElement> closeBtnList = driver.findElements(By.tagName("button"));

        WebElement closeBtn = driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-secondary"));
//找到第七个元素列表里的元素        WebElement closeBtn = driver.findElements(By.tagName("button"))[7];
        WebElement usernameInput = driver.findElement(By.id("loginusername"));

        loginNav.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        if(closeBtn.isDisplayed())
        {
            System.out.println("Element found using text");
        }
        else
            System.out.println("Element not found");

        if(closeBtnList.size() !=0)
        {
            System.out.println(closeBtnList.size() + "Elements found by Tagname");
            for(WebElement inputElement : closeBtnList)
            {
                System.out.println(inputElement.getAttribute("class"));
            }
        }


        closeBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        usernameInput.sendKeys("Cup");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homeNav.click();
        signUpNav.click();
        homeNav.click();
        cartNav.click();
        homeNav.click();
//        productName.click();
//        homeNav.click();



//        WebElement searchBox = driver.findElement(By.name("q"));
//        WebElement searchButton = driver.findElement(By.name("btnK"));
//
//        searchBox.sendKeys("Selenium");
//        searchButton.click();
//
//        searchBox = driver.findElement(By.name("q"));
//        searchBox.getAttribute("value"); // => "Selenium"

    }

}

