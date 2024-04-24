package ar.edu.utn.frba.dds.dominio.colaboradores;

import ar.edu.utn.frba.dds.dominio.colaboraciones.*;
import ar.edu.utn.frba.dds.dominio.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class ColaboradorHumana implements Colaborador{
    private String nombre;
    private String apellido;
    private Contacto contacto;
    private LocalDate fechaDeNacimiento;
    private Ubicacion direccion;

    public void setNombre(String nombre){
        if(nombre.isEmpty()) throw new RuntimeException("No se permiten nombres vacios");
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        if(nombre.isEmpty()) throw new RuntimeException("No se permiten apellidos vacios");
        this.apellido = apellido;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    public void setFechaNacimiento(LocalDate nuevaFechaDeNacimiento) {
        this.fechaDeNacimiento = nuevaFechaDeNacimiento;
    }
    public void setDireccion(Ubicacion direccion) {
        this.direccion = direccion;
    }
 
    public ColaboradorHumana(String nombre,String apellido,Contacto contacto,LocalDate fechaDeNacimiento,Ubicacion direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.direccion = direccion;
    }

    
    @Override
    public void completarFormulario() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese nombre: ");
        this.nombre = scan.nextLine(); 
        
        System.out.println("Ingrese apellido: ");
        this.apellido = scan.nextLine();

        this.setContacto(contacto.cargarContactos());

        System.out.println("Ingrese su fecha de nacimiento: ");
        System.out.println("1. dia: ");
        int dia = scan.nextInt();
        System.out.println("2. mes: ");
        int mes = scan.nextInt();
        System.out.println("3. anio: ");
        int anio= scan.nextInt();
        this.fechaDeNacimiento = LocalDate.of(anio, mes, dia);

        //private String direccion;
        scan.close();
    }

    @Override
    public void colaborar() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Elija la colaboracion humana: \t  1. Donar dinero \t 2. Donar vianda \t 3. Distribuir Vianda");
        int  respuesta = scan.nextInt();
        switch (respuesta){
            case 1:
                DonacionDinero donarDinero = new DonacionDinero();
                donarDinero.solicitarDatos();
                break;
            case 2:
                DonacionVianda donarVianda = new DonacionVianda();
                donarVianda.solicitarDatos();
                break;
            case 3:
                DistribucionViandas distribuirVianda = new DistribucionViandas(null,null,null,null,null);
                distribuirVianda.solicitarDatos();
                break;
            default:
                scan.close();
                throw new IllegalArgumentException("Elija  una opcione entre el rango (1-3)");
        }
        scan.close();
    }


    public void modificarse(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Elija que caracteristica modificar:\t 1. Nombre \t 2.Apellido \t 3.Contacto \t 4.Fecha de nacimiento \t 5. Direccion");
        int respuesta = scan.nextInt();
        switch(respuesta){
            case 1:
                String nombre = scan.nextLine();
                this.setNombre(nombre);
                break;
            case 2:
                String apellido = scan.nextLine();
                this.setApellido(apellido);
                break;
            case 3:
                this.setContacto(contacto.cargarContactos());
                break;
            case 4:
                System.out.println("Ingrese su fecha de estreno: ");
                System.out.println("1. dia: ");
                int dia = scan.nextInt();
                System.out.println("2. mes: ");
                int mes = scan.nextInt();
                System.out.println("3. anio: ");
                int anio= scan.nextInt();
                LocalDate fechaEstreno = LocalDate.of(anio, mes, dia);
                this.setFechaNacimiento(fechaEstreno);
                break;
            case 5:
                System.out.println("Ingrese Domicilio nuevo");
                String domicilio = scan.nextLine();
                System.out.println("Ingrese longitud nueva");
                Double longitud = scan.nextDouble();
                System.out.println("Ingrese latitud nueva");
                Double latitud = scan.nextDouble();
                Ubicacion ubicacion = new Ubicacion(domicilio, latitud, longitud);
                this.setDireccion(ubicacion);
                break;
            default:
                scan.close();
                throw new IllegalArgumentException("Ingrese una opcion valida");
        }
        scan.close();
    }
}
