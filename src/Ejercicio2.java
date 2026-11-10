import java.time.Duration;

import org.openqa.selenium.Architecture;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementSelectionStateToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Ejercicio2 {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get("https://demoqa.com/radio-button");
            dr.manage().window().maximize();


            WebElement Radio = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("impressiveRadio")));
            Radio.click();
            elementToBeClickable(Radio);
            WebElement TextoValida = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Impressive']")));

            Boolean TextoResultado =dr.findElement(By.id("impressiveRadio")).isSelected();

            if (TextoResultado) {
                System.out.println("TextoResultado");
            } else {
                System.out.println("no");
            }

        } catch (Exception e) {

            throw new RuntimeException(e);

        }finally{dr.quit();}
    }
}




