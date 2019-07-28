import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MathTest2 {
    public WebDriver driver;
    public String result;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/Automation/Libraries/Selenium/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://antonregis.com/projects/testng/math-test/math-operation");
    }

    @Test(priority=5)
    public void addition() throws InterruptedException {
        MathUtils.performMath(driver, 500, 5, "addend1", "addend2", "addButton");
        result = MathUtils.getResult(driver, "additionResult");
        Assert.assertEquals(result, "505.0");
    }

    @Test(priority=6)
    public void subtraction() throws InterruptedException {
        MathUtils.performMath(driver, 250, 5, "minuend", "subtrahend", "subractButton");
        result = MathUtils.getResult(driver, "subtractionResult");
        Assert.assertEquals(result, "245.0");
    }

    @Test(priority=7)
    public void multiplication() throws InterruptedException {
        MathUtils.performMath(driver, 300, 12, "multiplicand", "multiplier", "multiplyButton");
        result = MathUtils.getResult(driver, "multiplicationResult");
        Assert.assertEquals(result, "3600.0");
    }

    @Test(priority=8)
    public void division() throws InterruptedException {
        MathUtils.performMath(driver, 100, 10, "dividend", "divisor", "divideButton");
        result = MathUtils.getResult(driver, "divisionResult");
        System.out.println("NOTE: A bug was intentionally planted in the web page to fail the division test.");
        System.out.println("Division: 100 / 10 = 10.0 but the result was erroneously 10.5");
        Assert.assertEquals(result, "10.0");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}