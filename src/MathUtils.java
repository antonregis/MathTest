import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MathUtils {

    public static void performMath(WebDriver driver, float num1, float num2, String idName1, String idName2, String idButtonName) throws InterruptedException {
        driver.findElement(By.id(idName1)).sendKeys(String.valueOf(num1));
        driver.findElement(By.id(idName2)).sendKeys(String.valueOf(num2));
        driver.findElement(By.id(idButtonName)).click();
        Thread.sleep(1000);
    }

    public static String getResult(WebDriver driver, String idResultField) {
        return driver.findElement(By.id(idResultField)).getAttribute("value");
    }

}
