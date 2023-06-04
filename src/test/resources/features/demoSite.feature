#language: es
  @PrimeraEjecucion
  Característica: Registrar usuario en Demo Site

  @smoke
  Esquema del escenario: : Registrar usuario
    Dado que la web esta operativa
    Y ingresar a la opcion de registrar
    Y setear información del contacto "<nombre>","<apellido>","<telefono>","<correo>"
    Y seteo la información del envio "<direccion>","<ciudad>","<provincia>","<postal>","<pais>"
    Y seteo la información del usuario "<usuario>","<contrasena>","<confimarContrasena>"
    Entonces valido el nombre completo del contacto y del usuario
    Ejemplos: datos del usuario a registrar
      | nombre       | apellido       | telefono  | correo         | direccion      | ciudad | provincia  | postal | pais | usuario  | contrasena | confimarContrasena |
      | Jose Octavio | Cerron Vicente | 987654321 | jose@gmail.com | calle laureles | Lima   | chorrillos | 451    | PERU | joseUser | joseContra | joseContra         |

    @regresion
    Escenario: Registrar solo informacion del contacto
      Dado que la web esta operativa
      Y ingresar a la opcion de registrar
      Y setear información del contacto "Jose","cerron","990909","asd@gmail.com"
