package ar.edu.utn.frba.dds.dominio.colaboraciones;
import ar.edu.utn.frba.dds.dominio.*;


public class ColocarHeladera implements ColaboracionJuridica{
    private Heladera heladera;

    public void solicitarDatos() {
        this.heladera = new Heladera(null, null, 0, null);
        this.heladera.crearHeladera();
        this.heladera.registrarHeladeraEnOrganizacion();        
    }
}
