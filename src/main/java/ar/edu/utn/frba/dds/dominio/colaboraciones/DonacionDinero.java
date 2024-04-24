package ar.edu.utn.frba.dds.dominio.colaboraciones;

import java.time.LocalDate;
import java.util.Scanner;

public class DonacionDinero implements ColaboracionHumana, ColaboracionJuridica{

    private LocalDate fecha;
    private float monto;
    private int frecuencia;

    public void solicitarDatos(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese fecha en la cual se realizara la donacion: ");
        System.out.println("1. dia: ");
        int dia = scan.nextInt();
        System.out.println("2. mes: ");
        int mes = scan.nextInt();
        System.out.println("3. anio: ");
        int anio = scan.nextInt();
        this.fecha = LocalDate.of(anio, mes, dia);

        System.out.println("Ingrese el monto a donar: ");
        this.monto = scan.nextFloat();

        System.out.println("Ingrese la frecuencia en dias en caso de realizar donaciones periodicas: ");
        this.frecuencia = scan.nextInt();
        scan.close();
    }

    @Override
    public void colaborar() {
        this.solicitarDatos();
    }
}
