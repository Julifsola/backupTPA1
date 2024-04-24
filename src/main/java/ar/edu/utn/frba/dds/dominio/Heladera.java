package ar.edu.utn.frba.dds.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Heladera {
    private String nombre;
    private Ubicacion ubicacion;
    private int capacidad;
    private LocalDate fechaEstreno;
    private List<Vianda> viandas;
    private Organizacion org;

    public Heladera(String nombre,Ubicacion ubicacion,int capacidad ,LocalDate unaFechaEstreno){
        if(nombre.equals("") || ubicacion == null || capacidad <= 0){
            throw new RuntimeException("Porfavor, Ingrese datos validos");
        }
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.fechaEstreno = unaFechaEstreno;
        this.viandas = new ArrayList<>();
    }

    public Heladera crearHeladera() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese un nombre para la heladera");
        String nombre = scan.nextLine();

        System.out.println("Ingrese la direccion de la heladera");
        String ubi = scan.nextLine();
        System.out.println("Ingrese latitud de la heladera");
        double lat = scan.nextDouble();
        System.out.println("Ingrese longitud de la heladera");
        double lon = scan.nextDouble();
        Ubicacion ubicacion = new Ubicacion(ubi,lat,lon);

        System.out.println("Ingrese la capacidad de la heladera");
        int capacidad = scan.nextInt();


        System.out.println("Ingrese su fecha de estreno: ");
        System.out.println("1. dia: ");
        int dia = scan.nextInt();
        System.out.println("2. mes: ");
        int mes = scan.nextInt();
        System.out.println("3. anio: ");
        int anio= scan.nextInt();
        this.fechaEstreno = LocalDate.of(anio, mes, dia);

        Heladera unaHeladera = new Heladera(nombre, ubicacion ,capacidad,fechaEstreno);

        scan.close();
        return unaHeladera;
    }

    public void modificarse(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Elija que caracteristica modificar de la heladera: \t 1. Nombre \t 2. Ubicacion \t 3.Capacidad");
        int aux = scan.nextInt();
        switch (aux) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                String nombre = scan.nextLine();
                this.setNombre(nombre);
                break;
            case 2:
                System.out.println("Ingrese Domicilio nuevo");
                String domicilio = scan.nextLine();
                System.out.println("Ingrese longitud nueva");
                Double longitud = scan.nextDouble();
                System.out.println("Ingrese latitud nueva");
                Double latitud = scan.nextDouble();
                Ubicacion ubicacion = new Ubicacion(domicilio, latitud, longitud);
                this.setUbicacion(ubicacion);
                break;
            case 3:
                System.out.println("Ingrese la nueva capacidad");
                int capacidad = scan.nextInt();
                this.setCapacidad(capacidad);
                break;
            default:
                scan.close();
                throw new RuntimeException("Elija una opcion dentro del rango");
        }
        scan.close();
    }

    public Vianda retirarVianda(){
        return viandas.remove(0);
    }



    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        if(nombre.equals("")) throw new IllegalArgumentException("Nombre vacio");
        this.nombre = nombre;
    }

    public void setUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setCapacidad(int capacidad){
        if(capacidad <= 0)  throw new IllegalArgumentException("La heladera no puede tener capacidad menor o igual a 0");
        this.capacidad = capacidad;
    }

    public void ingresarVianda(Vianda vianda){
        if(this.cantidadDeViandas() >= capacidad){
            throw new RuntimeException("No hay espacio para agregar otra vianda");
        }
        viandas.add(vianda);
    }

    public int cantidadDeViandas(){
        return viandas.size();
    }

    public void mostrarInfo(){
        // TODO Funcion que imprime por consola los datos de la heladera
        System.out.println(nombre + "\t \t" + ubicacion.getDomicilio() + "\t\t" + ubicacion.showCoords());
    }

}