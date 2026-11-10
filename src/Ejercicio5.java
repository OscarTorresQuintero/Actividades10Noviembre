import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio5 {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(10));
        try {
            dr.get("https://demoqa.com/webtables");
            dr.manage().window().maximize();

            WebElement botonAdd = wt.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
            ((JavascriptExecutor) dr).executeScript("arguments[0].click();", botonAdd);

            WebElement nombre = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
            WebElement apellido = dr.findElement(By.id("lastName"));
            WebElement correo = dr.findElement(By.id("userEmail"));
            WebElement edad = dr.findElement(By.id("age"));
            WebElement salario = dr.findElement(By.id("salary"));
            WebElement departamento = dr.findElement(By.id("department"));

            nombre.sendKeys("Carlos");
            apellido.sendKeys("Ramírez");
            correo.sendKeys("carlos@gmail.com");
            edad.sendKeys("25");
            salario.sendKeys("2500000");
            departamento.sendKeys("Sistemas");

            WebElement botonGuardar = wt.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            ((JavascriptExecutor) dr).executeScript("arguments[0].click();", botonGuardar);

            wt.until(ExpectedConditions.textToBePresentInElementLocated(By.className("rt-tbody"), "Carlos"));

            WebElement buscador = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
            buscador.sendKeys("Carlos");

            String resultado = wt.until(ExpectedConditions.visibilityOfElementLocated(By.className("rt-tbody"))).getText();
            System.out.println("Registro encontrado: " + resultado);

            if (resultado.contains("Carlos") && resultado.contains("Ramírez")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            dr.quit();
        }
    }
}