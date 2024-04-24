package ar.edu.utn.frba.dds;

import ar.edu.utn.frba.dds.dominio.*;
import ar.edu.utn.frba.dds.registro.*;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Organizacion org= new Organizacion();
        org.iniciarMenu();


       // Heladera fridge= new Heladera("Heladera Obelisco",new Ubicacion("Av 9 de Julio",140.3, 139.2),100);
       // fridge.mostrarInfo();
    }
}