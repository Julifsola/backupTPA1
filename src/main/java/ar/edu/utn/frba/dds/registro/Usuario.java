package ar.edu.utn.frba.dds.registro;

import java.util.Scanner;
import java.util.List;
import java.util.Objects;
import ar.edu.utn.frba.dds.dominio.Organizacion;
import ar.edu.utn.frba.dds.dominio.colaboradores.*;
import ar.edu.utn.frba.dds.registro.*;

public class Usuario{
    private String username;
    private String password;
    private Colaborador colaborador;
    private Organizacion org;
    
    public Usuario(){
        username = null;
        password = null;
        colaborador= null;
    }

    public String getUsername(){
        return username;
    }

    public String getPasswordHash(){
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = ValidadorCredenciales.calcularHash(password);
    }

    public void setColaborador(Colaborador colaborador){
        this.colaborador=colaborador;
    }

    public Colaborador getColaborador(){
        return colaborador;
    }

    public void cambiarContrasenia(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese su contraseña actual");
        if(!scan.nextLine().equals(password)) {
            scan.close();
            throw new RuntimeException("Contraseña invalida");
        }

        System.out.println("Ingrese su nueva contraseña");
        String aux = scan.nextLine();
        ValidadorCredenciales.validarContrasenia(aux);
        this.setPassword(aux);
        scan.close();
    }

    public void registrarse() {
        Usuario user = new Usuario();
        Scanner scan = new Scanner(System.in);
        String aux;

        System.out.println("Ingrese un nombre de usuario:");
        aux=scan.nextLine();
        user.setUsername(ValidadorCredenciales.validarUsername(aux,org.getListaUsuarios()));
        System.out.println(user.getUsername());

        System.out.println("Ingrese una contrasenia: ");
        aux=scan.nextLine();
        user.setPassword(ValidadorCredenciales.validarContrasenia(aux));
        System.out.println(user.getPasswordHash());

        System.out.println("Ingrese tipo de colaborador:\t 1.Humano \t 2.Juridico");

        switch(scan.nextInt()){
            case 1:
                ColaboradorHumana auxColabH = new ColaboradorHumana();
                auxColabH.completarFormulario();
                user.setColaborador(auxColabH);
                break;
            case 2:
                ColaboradorJuridico auxColabJ= new ColaboradorJuridico();
                auxColabJ.completarFormulario();
                user.setColaborador(auxColabJ);
                break;
            default:
                scan.close();
                throw new IllegalArgumentException("Ingrese un tipo valido de colaborador");
        }
        org.altaColaborador(user);
        scan.close();
    }

}