package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks { // se configura el antes y despues del test
    public static WebDriver driver;

    @Before //Configuración
    public static void setup(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        //src/test/resources/drivers/chromedriver.exe
        driver = new ChromeDriver(); // abre navegador
        driver.manage().window().maximize(); //maximizamos ventana

    }

    @After //Demoles
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
