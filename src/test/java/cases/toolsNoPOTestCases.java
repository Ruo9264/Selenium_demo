package cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class toolsNoPOTestCases
{
    WebDriver driver;

    @BeforeEach
    void setupChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterEach
    void teardown() {
//        if (driver != null) {
//            driver.close();
//        }
        try{
            driver.quit();
        }catch (Exception e){
            System.out.println("Nothing to do with it");
        }
    }

    @Test
    void Homepage2TextBox(){
        driver.get("https://demoqa.com");
        driver.getTitle(); //=>"ToolsQA"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement eleNav = driver.findElement(By.cssSelector(".category-cards .card:nth-child(1)"));
        eleNav.click();
        new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement eleTitle = driver.findElement(By.className("main-header"));
        Assertions.assertEquals("Elements",eleTitle.getText());

        WebElement dropLiBtn = driver.findElement(By.cssSelector(".element-group:nth-child(1) .menu-list :nth-child(3)"));
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(dropLiBtn));
        dropLiBtn.click();
        Assertions.assertEquals("Radio Button",eleTitle.getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement yesBtn = driver.findElement(By.cssSelector("label[for=yesRadio]"));
        yesBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(3));



        WebElement yesMsg = driver.findElement(By.cssSelector("p.mt-3"));
        Assertions.assertEquals("You have selected Yes", yesMsg.getText());




    }
}
