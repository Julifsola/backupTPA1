package ar.edu.utn.frba.dds.dominio;
import java.time.*;


public class Beneficiario{
    private String nombre;
    private LocalDate nacimiento;
    private LocalDate fechaRegistro = LocalDate.now();
    private Ubicacion domicilio;
    private Documento documento;
    private int menoresACargo;

    public Beneficiario(String nombre, LocalDate nacimiento, Documento documento, int menoresACargo){
        if(nombre == null || nombre.equals("") || nacimiento == null || documento == null){ 
            throw new IllegalArgumentException("Ingrese nombre, nacimiento o documento valido");
        }
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.documento = documento;
        this.menoresACargo = menoresACargo;
    }

    public Beneficiario(){
        this.nombre = null;
        this.nacimiento = null;
        this.documento = null;
        this.menoresACargo = 0;
    }
}
