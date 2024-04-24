package ar.edu.utn.frba.dds.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import ar.edu.utn.frba.dds.registro.*;
import ar.edu.utn.frba.dds.dominio.colaboraciones.ColaboracionHumana;
import ar.edu.utn.frba.dds.dominio.colaboraciones.DistribucionViandas;
import ar.edu.utn.frba.dds.dominio.colaboraciones.DonacionDinero;
import ar.edu.utn.frba.dds.dominio.colaboradores.*;

public class Organizacion{
    private List<Heladera> heladeras;
    private List<Beneficiario> beneficiarios;
    private List<Usuario> usuarios;

    public Organizacion(){
        heladeras = new ArrayList<>();
        beneficiarios = new ArrayList<>();
        usuarios= new ArrayList<>();
    }

    public void registrarBeneficiario(Beneficiario nuevoBeneficiario){
        beneficiarios.add(nuevoBeneficiario);
    }

    public void altaHeladera(Heladera heladera){
        heladeras.add(heladera);
    }

    public void altaColaborador(Usuario usuario){
        usuarios.add(usuario);
    }

    public void modificarHumano(ColaboradorHumana colaborador){
       colaborador.modificarse();
    }
    
    
    public void modificarJuridico(ColaboradorJuridico colaborador){
        colaborador.modificarse();
    }

    public void modificarColaborador(Colaborador colaborador){
        colaborador.modificarse();
    }

    public List<Usuario> getListaUsuarios() {
        return this.usuarios;
    }

    public void bajaHeladera(Heladera heladera){
        if(!heladeras.contains(heladera)) throw new RuntimeException("No existe la heladera");
        heladeras.remove(heladera);
    }

    public void modificarHeladera(Heladera heladera){
        heladera.modificarse();
    }

    public List<Usuario> getUsuarios(){
        return usuarios;
    }

    public void listarHeladeras(){
        for(Heladera heladera: heladeras){
            heladera.mostrarInfo();
        }
    }
}