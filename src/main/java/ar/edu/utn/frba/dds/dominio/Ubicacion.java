package ar.edu.utn.frba.dds.dominio;

import java.util.Scanner;

public class Ubicacion {
    private String domicilio;
    private double latitud;
    private double longitud;

    public Ubicacion(String domicilio, double lat, double lon) {
        if(domicilio.equals("")) throw new IllegalArgumentException("Direccion vacia");
        this.domicilio = domicilio;
        this.latitud= lat;
        this.longitud= lon;
    }

    public String getDomicilio(){
        return domicilio;
    }

    public String showCoords(){
        return "lat  " + latitud + " - long  " + longitud;
    }

}
