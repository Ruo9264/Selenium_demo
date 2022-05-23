package cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElementPage;
import pages.HomePage;

import static org.hamcrest.MatcherAssert.assertThat;


public class toolsPOMTest {
    private static WebDriver driver;
    ElementPage elementPage = new ElementPage(driver);
    pages.HomePage homePage = new HomePage(driver);


    @BeforeAll
    static void beforeAll(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void afterAll() {
        driver.close();
    }


    @Test
    void should_have_Yes_text_after_click_the_radio_yes_button() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage = homePage.open();
        ElementPage elementPage = homePage.clickEleNavBtn();
        WebElement titleName = homePage.getPageHeader();
        Assertions.assertEquals("Elements", titleName.getText());

//        assertThat(titleName.getText(), is("Elements"));
        elementPage = elementPage.clickDropLiRadioBtn();
        elementPage = elementPage.clickYesRadioBtn();
        WebElement Msg = elementPage.getAssertMsg();
//        assertThat(Msg.getText(), is("You have selected Yes"));
        Assertions.assertEquals("You have selected Yes", Msg.getText());
    }
}
