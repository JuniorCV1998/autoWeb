package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class util extends hooks {
    public static WebDriverWait wait;
    //public static JavascriptExecutor js;
    public static JavascriptExecutor js;

    public util() { // wait variable generica a utilizar
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = ((JavascriptExecutor) driver);
    }

    public void ventanaActiva(){ // obtiene los ID de las ventanas activas
        Set<String> identificadores = driver.getWindowHandles();
        // recorro todas las ventanas activa
        for (String id:identificadores) {
            driver.switchTo().window(id);//selenium se ubique en la ultima ventana
        }
    }

    public void ventanaInicial(){
        driver.close();//cierre ventana activa
        driver.switchTo().window("");//regresa ventana inicial
    }

    public void scrollVertical(int value){ //Opcional Method
        js.executeScript("window.scrollBy(0,"+value+")");
    }

    public void setearVariableOnSession(String name, String valor){
        driver.manage().addCookie(new Cookie(name,valor));
    }

    public String getvariableOnSession(String value){
        String aux = value+"=";
        String valor = String.valueOf(driver.manage().getCookieNamed(value));
        String[] list = valor.split(";");
        valor = list[0];
        valor = valor.replace(aux,"");
        return valor;
    }

    public static void evidencias() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        //target > Copy Absolute Path
        String path = "C:/Users/Junior/OneDrive/Documentos/Proyecto Apps/Automatización/autoWeb/target/evidencias/";
        String nombre = formato.format(fecha)+"_evidencia.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path+nombre));
    }

}
