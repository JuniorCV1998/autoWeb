package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class formularioPage extends util {

    @FindBy(name = "firstName") protected WebElement inptFirstName;
    @FindBy(name = "lastName") protected WebElement inptLastName;
    @FindBy(name = "phone") protected WebElement inptPhone;
    @FindBy(id = "userName") protected WebElement inptEmail;
    @FindBy(name = "address1") protected WebElement inptAddress;
    @FindBy(name = "city") protected WebElement inptCity;
    @FindBy(name = "state") protected WebElement inptProvincia;
    @FindBy(name = "postalCode") protected WebElement inptPostalCode;
    @FindBy(name = "country") protected WebElement slctCountry;
    @FindBy(id = "email") protected WebElement inptUsername;
    @FindBy(name = "password") protected WebElement inptPassword;
    @FindBy(name = "confirmPassword") protected WebElement inptConfirmPassword;
    @FindBy(name = "submit") protected WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b") protected WebElement lblName;
    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/font/b") protected WebElement lbluserName;




    public formularioPage(){
        PageFactory.initElements(driver, this);
    }

    public void setearInformacionDelContacto(String nombre, String apellido, String telefono, String correo){
        wait.until(ExpectedConditions.elementToBeClickable(inptFirstName));
        inptFirstName.sendKeys(nombre);
        inptLastName.sendKeys(apellido);
        inptPhone.sendKeys(telefono);
        inptEmail.sendKeys(correo);
        setearVariableOnSession("nombre",nombre);
        setearVariableOnSession("apellido",apellido);
        setearVariableOnSession("telefono",telefono);
        setearVariableOnSession("correo",correo);

    }

    public void setearInformacionDelEnvio(String direccion, String ciudad, String provincia, String postal, String pais) {
        inptAddress.sendKeys(direccion);
        inptCity.sendKeys(ciudad);
        inptProvincia.sendKeys(provincia);
        inptPostalCode.sendKeys(postal);
        new Select(slctCountry).selectByVisibleText(pais);
        setearVariableOnSession("direccion",direccion);
        setearVariableOnSession("ciudad",ciudad);
        setearVariableOnSession("provincia",provincia);
        setearVariableOnSession("postal",postal);
    }

    public void setearInformacionDelUsuario(String usuario, String contrasena, String confimarContrasena) {
        inptUsername.sendKeys(usuario);
        inptPassword.sendKeys(contrasena);
        inptConfirmPassword.sendKeys(confimarContrasena);
        setearVariableOnSession("usuario",usuario);
        setearVariableOnSession("contrasena",contrasena);
        setearVariableOnSession("confimarContrasena",confimarContrasena);
        btnSubmit.click();
    }

    public void validoElNombreCompletoDelContactoYDelUsuario() {
        wait.until(ExpectedConditions.elementToBeClickable(lblName));
        String txtName = lblName.getText();
        txtName = txtName.replace("Dear ","").replace(",","");
        String txtUserName = lbluserName.getText();
        txtUserName = txtUserName.replace("Note: Your user name is ","").replace(".","");

        Assert.assertEquals(getvariableOnSession("nombre")+" "+getvariableOnSession("apellido"),txtName);
        Assert.assertEquals(getvariableOnSession("usuario"),txtUserName);
    }
}
