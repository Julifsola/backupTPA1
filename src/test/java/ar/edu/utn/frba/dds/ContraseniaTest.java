package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.registro.ValidadorCredenciales;
import ar.edu.utn.frba.dds.registro.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContraseniaTest {

  @Test
  public void unaContraseniaEsDebilSiSeEncuentraEnElArchivo() {
    Assertions.assertTrue(ValidadorCredenciales.esContrasenaDebil("password"));
  }

  @Test
  public void unaContraseniaNoEsDebilSiNoSeEncuentraEnElArchivo() {
    Assertions.assertFalse(ValidadorCredenciales.esContrasenaDebil("!%BuenaPassword14!%%76"));
  }
}
