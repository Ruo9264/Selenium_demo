package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementPage {
    private final WebDriver driver;
    private static final String YES_BTN = "label[for=yesRadio]";

    public ElementPage(WebDriver driver){
        this.driver=driver;
    }

    public ElementPage clickDropLiRadioBtn(){
        String cssSelector = ".element-group:nth-child(1) .menu-list :nth-child(3)";
        WebElement drpRadioBtn = driver.findElement(By.cssSelector(cssSelector));
        drpRadioBtn.click();
        return this;
    }
    public ElementPage clickYesRadioBtn(){
        WebElement yesBtn = driver.findElement(By.cssSelector(YES_BTN));
        yesBtn.click();
        return this;
    }

    public WebElement getAssertMsg(){
        return driver.findElement(By.cssSelector("p.mt-3"));
    }
}
