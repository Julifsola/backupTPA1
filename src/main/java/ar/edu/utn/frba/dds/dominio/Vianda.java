package ar.edu.utn.frba.dds.dominio;


import ar.edu.utn.frba.dds.dominio.colaboradores.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Vianda {
    private String comida;
    private LocalDate fechaDeCaducidad;
    private LocalDate fechaDonacion;
    private Colaborador colaborador;
    private int calorias;
    private float peso;
    private Heladera heladera;
    private Boolean entregada;
    
    public float getPeso(){
        return peso;
    }

    public void setHeladera(Heladera unaHeladera) {
        this.heladera = unaHeladera;
    }

    // TODO Validaciones de vianda
    public Vianda crearVianda(Colaborador unColaborador, Heladera unaHeladera) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la comida a donar: ");
        this.comida = scan.nextLine();

        System.out.println("Ingrese su fecha de caducidad: ");
        System.out.println("1. dia: ");
        int dia = scan.nextInt();
        System.out.println("2. mes: ");
        int mes = scan.nextInt();
        System.out.println("3. anio: ");
        int anio= scan.nextInt();
        this.fechaDeCaducidad = LocalDate.of(anio, mes, dia);

        System.out.println("Ingrese la fecha de donacion: ");
        System.out.println("1. dia: ");
        int diaDonacion = scan.nextInt();
        System.out.println("2. mes: ");
        int mesDonacion = scan.nextInt();
        System.out.println("3. anio: ");
        int anioDonacion= scan.nextInt();
        this.fechaDonacion = LocalDate.of(anioDonacion, mesDonacion, diaDonacion);

        this.colaborador = unColaborador;
        this.heladera = unaHeladera;

        System.out.println("Ingrese si la vianda ya se encuentra entregada (TRUE/FALSE): ");
        this.entregada = scan.nextBoolean();

        System.out.println("Ingrese las calorias de la comida (opcional): ");
        this.calorias = scan.nextInt();

        System.out.println("Ingrese el peso de la comida (opcional): ");
        this.peso = scan.nextFloat();

        scan.close();
        return this;
    }

    public void agregarVianda() {
        heladera.ingresarVianda(this);
    }

    public Boolean fueEntregada() {
        return this.entregada;
    }
}