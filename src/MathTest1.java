import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MathTest1 {
    public WebDriver driver;
    public String result;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/Automation/Libraries/Selenium/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://antonregis.com/projects/testng/math-test/math-operation");
    }

    @Test(priority=1)
    public void addition() throws InterruptedException {
        MathUtils.performMath(driver, 5, 5, "addend1", "addend2", "addButton");
        result = MathUtils.getResult(driver, "additionResult");
        Assert.assertEquals(result, "10.0");
    }

    @Test(priority=2)
    public void subtraction() throws InterruptedException {
        MathUtils.performMath(driver, 25, 5, "minuend", "subtrahend", "subractButton");
        result = MathUtils.getResult(driver, "subtractionResult");
        Assert.assertEquals(result, "20.0");
    }

    @Test(priority=3)
    public void multiplication() throws InterruptedException {
        MathUtils.performMath(driver, 3, 12, "multiplicand", "multiplier", "multiplyButton");
        result = MathUtils.getResult(driver, "multiplicationResult");
        Assert.assertEquals(result, "36.0");
    }

    @Test(priority=4)
    public void division() throws InterruptedException {
        MathUtils.performMath(driver, 10, 5, "dividend", "divisor", "divideButton");
        result = MathUtils.getResult(driver, "divisionResult");
        Assert.assertEquals(result, "2.0");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }



}