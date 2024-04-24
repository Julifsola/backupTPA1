package ar.edu.utn.frba.dds.dominio.colaboradores;

import ar.edu.utn.frba.dds.dominio.Contacto;
import ar.edu.utn.frba.dds.dominio.TipoJuridico;
import ar.edu.utn.frba.dds.dominio.Ubicacion;
import ar.edu.utn.frba.dds.dominio.colaboraciones.*;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ColaboradorJuridico implements Colaborador {
    private String razonSocial;
    private TipoJuridico tipo;
    private String rubro;
    private Contacto contacto;
    private Ubicacion direccion;
    private ColaboracionJuridica colaboracion;

    public void setRazonSocial(String nuevaRazonSocial) {
        this.razonSocial = nuevaRazonSocial;
    }
    public void setTipo(TipoJuridico nuevoTipo) {
        this.tipo = nuevoTipo;
    }
    public void setRubro(String nuevaRubro) {
        this.rubro = nuevaRubro;
    }
    public void setContacto(Contacto nuevoContacto) {
        this.contacto = nuevoContacto;
    }
    public void setDireccion(Ubicacion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }


    public ColaboradorJuridico(){
        razonSocial = null;
        tipo = null;
        rubro = null;
        contacto  = null;
        direccion = null;
    }

    @Override
    public void completarFormulario() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese razon social: ");
        this.razonSocial = scan.nextLine(); 
        
        System.out.println("Ingrese tipo de organización: \n 1.Gubernamental \n 2.ONG \n 3.Empresa");
        switch(scan.nextInt()){
            case 1:
                this.tipo=TipoJuridico.Gubernamental;
                break;
            case 2:
                this.tipo=TipoJuridico.ONG;
                break;
            case 3:
                this.tipo=TipoJuridico.Empresa;
                break;
            default:
                System.out.println("ingrese un tipo jurpudico válido");    

        } 

        System.out.println("Ingrese su rubro:");
        this.rubro=scan.nextLine();

        this.setContacto(contacto.cargarContactos());
        scan.close();
    }

    @Override
    public void colaborar() {

    }

    public void  modificarse(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Elija que caracteristica modificar: \t 1.Razon social \t 2.Tipo \t 3.Rubro  \t 4.Contacto \t 5.Direccion");
        int respuesta = scan.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Ingrese razon social nueva");
                String razonSocial = scan.nextLine();
                this.setRazonSocial(razonSocial);
                break;
            case 2:
                System.out.println("Ingrese la opciona a la que quiere cambiar: \t 1. ONG \t 2. Empresa \t 3. Institucion \t 4.Gubernamental");
                int opcion = scan.nextInt();
                if(opcion > 4 || opcion < 1)  throw new RuntimeException("Opcion invalida");
                if(opcion == 1){
                    this.setTipo(TipoJuridico.ONG);
                }else if(opcion == 2){
                    this.setTipo(TipoJuridico.Empresa);
                }else if(opcion == 3){
                    this.setTipo(TipoJuridico.Institucion);
                }else{
                    this.setTipo(TipoJuridico.Gubernamental); 
                }
                break;
            case 3:
                System.out.println("Ingrese un nuevo rubro");
                this.setRubro(scan.nextLine());
                break;
            case 4:
                System.out.println("1. Correo electronico: ");
                String email = scan.nextLine();
                contacto.setEmail(email);
                System.out.println("2. Telefono: ");
                int telefono = scan.nextInt();
                contacto.setTelefono(telefono);
                System.out.println("3. WhatsApp: ");
                int whatsApp = scan.nextInt();
                contacto.setWhatsapp(whatsApp);
                Contacto contacto = new Contacto(email,telefono,whatsApp);
                this.setContacto(contacto);
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
                throw new RuntimeException("Elija una opcion viable");
            }
        scan.close();
    } 
}
