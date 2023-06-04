package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class menuPage extends util {
    //@FindBy(linkText = "REGISTER") protected WebElement btnRegistrar;
    @FindBy(xpath = "//td/a[@href='register.php']") protected WebElement btnRegistrar;

    public menuPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickRegister(){
        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrar));
        btnRegistrar.click();
    }

}
