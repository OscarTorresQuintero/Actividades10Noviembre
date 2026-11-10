import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio4 {
    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(10));
        try {
            dr.get("https://demoqa.com/buttons");
            dr.manage().window().maximize();

            WebElement boton = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));

            Actions acciones = new Actions(dr);
            acciones.doubleClick(boton).perform();

            String mensaje = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
            System.out.println("Mensaje obtenido: " + mensaje);

            if (mensaje.contains("You have done a double click")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            dr.quit();
        }
    }
}