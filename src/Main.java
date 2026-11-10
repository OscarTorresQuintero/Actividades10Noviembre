import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.chrome.ChromeDriver;


public class Main {
    public static void  main (String[]arg){
        WebDriver dr  = new ChromeDriver();
        WebDriverWait wt= new WebDriverWait(dr, Duration.ofSeconds(5));
        try {
            dr.get("https://demoqa.com/text-box");
            dr.manage().window().maximize();


            WebElement Nombre = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            WebElement correo = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));



            Nombre.sendKeys("Laura Martínez");
            correo.sendKeys("laura@gmail.com");


            String ResultadoNombre = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).getText();
            String ResultadoCorreo = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).getText();
           // String ResultadoDireccion = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("CurrentAddress"))).getText();
          //  String ResultadoDireccionExacta = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("permanentAddress"))).getText();

            if (ResultadoNombre.contains("Laura Martínez")) {
                System.out.println(ResultadoNombre);
            } else {
                System.out.println("no ");
            }
            if (ResultadoNombre.contains("laura@gmail.com")) {
                System.out.println(ResultadoCorreo);
            }else {
                System.out.println("no");
            }

        }finally{
            dr.quit();
        }
    }
}
