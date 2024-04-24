package ar.edu.utn.frba.dds.dominio.colaboraciones;

import ar.edu.utn.frba.dds.dominio.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DistribucionViandas implements ColaboracionHumana{

    private Heladera heladeraOrigen;
    private Heladera heladeraDestino;
    private int cantidadViandas;
    private MotivoDistribucionVianda motivo;
    private LocalDate fecha;

    public DistribucionViandas(Heladera heladeraOrigen,Heladera heladeraDestino,int cantidadViandas,MotivoDistribucionVianda motivo, LocalDate unaFecha) {
        this.heladeraOrigen = heladeraOrigen;
        this.heladeraDestino =  heladeraDestino;
        this.cantidadViandas = cantidadViandas;
        this.motivo = motivo;
        this.fecha = unaFecha;
    }

    public void solicitarDatos(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de viandas a distribuir: ");
        this.cantidadViandas = scan.nextInt();
        System.out.println("Indique el motivo de distribucion: ");
        System.out.println("\t 1- Desperfecto en la Heladera ");
        System.out.println("\t 2- Faltante de viandas");
        int respuesta = scan.nextInt();
        switch(respuesta){
            case 1:
                this.motivo = MotivoDistribucionVianda.DESPERFECTO_HELADERA;
            case 2:
                this.motivo = MotivoDistribucionVianda.FALTA_VIANDAS;
        }
        System.out.println("Ingrese la fecha en la cual se realizara la distribucion ");
        System.out.println("\t 1. dia: ");
        int dia = scan.nextInt();
        System.out.println("\t 2. mes: ");
        int mes = scan.nextInt();
        System.out.println("\t 3. anio: ");
        int anio = scan.nextInt();
        this.fecha = LocalDate.of(anio, mes, dia);

        for(int i = 0; i<cantidadViandas; i++) {   //revisar si es < o <=
            Vianda auxiliar = heladeraOrigen.retirarVianda();
            heladeraDestino.ingresarVianda(auxiliar);
        }
        scan.close();
    }

}