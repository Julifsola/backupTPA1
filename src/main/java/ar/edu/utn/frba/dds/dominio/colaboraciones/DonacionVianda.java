package ar.edu.utn.frba.dds.dominio.colaboraciones;

import ar.edu.utn.frba.dds.dominio.*;
import ar.edu.utn.frba.dds.dominio.colaboradores.Colaborador;

public class DonacionVianda implements ColaboracionHumana{
    private Colaborador colaborador;
    private Heladera heladera;
    private Vianda vianda;
    private Boolean entregada;

    public void solicitarDatos(){
        this.vianda = vianda.crearVianda(colaborador, heladera);
        this.entregada = vianda.fueEntregada();
        if (entregada) {
            vianda.agregarVianda();
        }
    }

    @Override
    public void colaborar() {
        this.solicitarDatos();
    }
}
