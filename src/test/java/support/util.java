package support;

import definitions.hooks;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class util extends hooks {
    public static WebDriverWait wait;

    public util() { // wait variable generica a utilizar
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

}
