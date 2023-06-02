package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class menuPage {
    //@FindBy(linkText = "REGISTER") protected WebElement btnRegistrar;
    @FindBy(xpath = "//td/a[@href='register.php']") protected WebElement btnRegistrar;

}
