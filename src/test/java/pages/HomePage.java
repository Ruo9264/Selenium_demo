package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public HomePage open(){
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        return this;
    }

    public ElementPage clickEleNavBtn(){
//        String cssSelector = ".category-cards .card:nth-child(\%d)";
//        cssSelector = String.format(cssSelector, navNum);
//        System.out.println(cssSelector);
        WebElement navBtn = driver.findElement(By.cssSelector(".category-cards .card:nth-child(1)"));
        navBtn.click();
        return new ElementPage(driver);
    }

    public WebElement getPageHeader(){
        return driver.findElement(By.className("main-header"));
    }

}

