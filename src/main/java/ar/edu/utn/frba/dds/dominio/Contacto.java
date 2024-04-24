package ar.edu.utn.frba.dds.dominio;

import java.util.Scanner;

public class Contacto {
    private String email;
    private int telefono;
    private int whatsapp;
    
    // Constructor
    public Contacto(String email,int telefono,int whatsApp){
        this.email = email;
        this.telefono = telefono;
        this.whatsapp = whatsApp;
    }

    // Setters
    public void setEmail(String emailNuevo){
        email = emailNuevo;
    }    
    public void setWhatsapp(int wspNuevo){
        whatsapp = wspNuevo;
    }
    public void setTelefono(int telefonoNuevo){
        telefono = telefonoNuevo;
    }

    // Getters
    public String getEmail(){
        return email;
    }    
    public int getWhatsapp(){
        return whatsapp;
    }
    public int getTelefono(){
        return telefono;
    }

    public Contacto cargarContactos() {
        Scanner scan = new Scanner(System.in);
        Contacto contacto = new Contacto(null, 0, 0);

        System.out.println("Ingrese al menos un medio de contacto: ");
        System.out.println("1. Correo electronico: ");
        String email = scan.nextLine();
        contacto.setEmail(email);
        System.out.println("2. Telefono: "); // TODO: validar que haya al menos uno
        int telefono = scan.nextInt();
        contacto.setTelefono(telefono);
        System.out.println("3. WhatsApp: ");
        int whatsApp = scan.nextInt();
        contacto.setWhatsapp(whatsApp);

        return contacto;
    }
} 
