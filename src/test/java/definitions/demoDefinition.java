package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pageobjects.formularioPage;
import pageobjects.menuPage;

import java.io.IOException;

import static support.util.evidencias;

public class demoDefinition {
    formularioPage formulario;
    menuPage menu;
    public demoDefinition(){
        menu = new menuPage();
        formulario = new formularioPage();
    }
    @Dado("que la web esta operativa")
    public void queLaWebEstaOperativa() {
        hooks.driver.get("https://demo.guru99.com/test/newtours/register.php");
    }

    @Y("ingresar a la opcion de registrar")
    public void ingresarALaOpcionDeRegistrar() {
        menu.clickRegister();
    }

    @Y("setear información del contacto {string},{string},{string},{string}")
    public void setearInformaciónDelContacto(String nombre, String apellido, String telefono, String correo) {
        menu.ventanaActiva();
        formulario.setearInformacionDelContacto(nombre, apellido, telefono, correo);
        menu.scrollVertical(1000); // opcional method
    }

    @Y("seteo la información del envio {string},{string},{string},{string},{string}")
    public void seteoLaInformaciónDelEnvio(String direccion, String ciudad, String provincia, String postal, String pais) throws IOException {
        formulario.setearInformacionDelEnvio(direccion, ciudad, provincia, postal, pais);
        evidencias();
    }

    @Y("seteo la información del usuario {string},{string},{string}")
    public void seteoLaInformaciónDelUsuario(String usuario, String contrasena, String confimarContrasena) throws IOException {
        formulario.setearInformacionDelUsuario(usuario, contrasena, confimarContrasena);
        evidencias();
    }

    @Entonces("valido el nombre completo del contacto y del usuario")
    public void validoElNombreCompletoDelContactoYDelUsuario() throws IOException {
        formulario.validoElNombreCompletoDelContactoYDelUsuario();
        evidencias();
    }
}
