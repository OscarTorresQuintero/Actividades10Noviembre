
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Ejercicio3 {
    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();

        WebDriverWait wt = new WebDriverWait(
                dr, Duration.ofSeconds(5)
        );

        try {
            dr.get("https://www.selenium.dev/selenium/web/web-form.html");

            dr.manage().window().maximize();


            WebElement textInput = wt.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.id("my-text-id")
                    )

            );

            WebElement password = wt.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("my-password")
                    )

            );
            WebElement TextArea =wt.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));

            TextArea.sendKeys("Automatización");
            textInput.sendKeys("Prueba ADSO");
            password.sendKeys("Sena2026");

            // Buscar el botón Submit
            WebElement button = dr.findElement(By.cssSelector("button"));

            button.click();
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            Boolean Recibido =wt.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"),"Received!"));
            if (Recibido){
                System.out.println("Received!");
            }else {
                System.out.println("no");

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            dr.quit();
        }
    }
}
