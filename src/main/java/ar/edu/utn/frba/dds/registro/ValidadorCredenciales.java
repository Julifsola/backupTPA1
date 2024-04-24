package ar.edu.utn.frba.dds.registro;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ValidadorCredenciales {

    private static void cargarContraseniasDebiles(Set<String> contraseniasDebiles) {
        File archivo = new File("src/main/java/ar/edu/utn/frba/dds/registro/contraseniasDebiles.txt");
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (!linea.isEmpty()) { // Ignorar líneas vacías
                    contraseniasDebiles.add(linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No se pudo encontrar el archivo: " + e.getMessage());
        }
    }

    public static String validarUsername(String username, List<Usuario> usuarios) {
        if(username.isEmpty()) throw new IllegalArgumentException("Por favor, ingrese un nombre de usuario");
        if(esCredencialDefault(username)) throw new IllegalArgumentException("Las credenciales por defecto no estan autorizadas");
        if(usuarioYaExistente(username,usuarios)) throw new IllegalArgumentException("Este usuario ya esta registrado");

        return username;
    }

    public static String validarContrasenia(String password) {
        if(esContrasenaDebil(password)) throw new IllegalArgumentException("Contrasenia muy debil");
        // TODO Al mensaje de requisitos agregarle cuales son dichos requsitos (Leerlos en la pagina web especificada)
        if(noTieneTamanioAdecuado(password)) throw new IllegalArgumentException("Contrasenia debe tener entre 8 y 64 caracteres");

        return password;
    }

    public static boolean esContrasenaDebil(String password) {
        Set<String> contraseniasDebiles = new HashSet<>();
        cargarContraseniasDebiles(contraseniasDebiles);

        return contraseniasDebiles.contains(password);
    }

    private static boolean noTieneTamanioAdecuado(String password) {
        return password.length() < 8 || password.length() > 64;
    }


    public static boolean esCredencialDefault(String username) {
        return username.equals("admin") || username.equals("Admin");
    }

    public static boolean usuarioYaExistente(String username, List<Usuario> usuarios) {
        Set<String> usernamesExistentes= new HashSet<>();
        for(Usuario user: usuarios){
            usernamesExistentes.add(user.getUsername());
        }
        return usernamesExistentes.contains(username);
    }

    public static String calcularHash(String input) {
        try {
            // Obtener la instancia de MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Calcular el hash de la entrada
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convertir el hash a una cadena hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción si el algoritmo no está disponible
            e.printStackTrace();
            return null;
        }

    }

}

/*
A continuación, te describo algunas de las recomendaciones clave de la sección 5.1.1.2 del NIST 800-63
que podrías considerar al alinear tu política de contraseñas:

    Longitud de la Contraseña:
        Las contraseñas deben tener al menos 8 caracteres de longitud cuando las crea el usuario.HECHO

        Deben tener al menos 6 caracteres cuando sean generadas automáticamente por el sistema y sean temporales.HECHO

        Se recomienda permitir una longitud máxima de al menos 64 caracteres para permitir el uso de frases de contraseña.HECHO

    Complejidad:
        Se debe permitir el uso de una amplia gama de caracteres (letras mayúsculas y minúsculas, números, símbolos y espacios). HECHO

        Las contraseñas no deben imponer artificialmente la necesidad de incluir ciertos tipos de caracteres (como al menos una mayúscula, etc.). HECHO
            En cambio, se deben permitir pero no requerir tipos de caracteres mixtos.

        Se desalienta el uso de preguntas de seguridad que permiten respuestas fácilmente adivinables. HECHO

    Rotación de Contraseñas:
        Se aconseja no forzar la rotación de contraseñas periódicamente sin motivo, pues esto puede llevar a una menor
            seguridad si los usuarios eligen contraseñas más débiles y más fáciles de recordar debido a la fatiga de tener que cambiarlas constantemente.

        La rotación de contraseñas solo se debe requerir si hay evidencia de su compromiso. HECHO

    Almacenamiento de Contraseñas:
        Las contraseñas deben almacenarse en forma de hash utilizando un algoritmo de hashing resistente que incluya
            un factor de sal (un valor aleatorio añadido a la contraseña antes de aplicar el hash) y un factor de trabajo
            (que hace computacionalmente costoso calcular el hash).

        Nunca se deben almacenar contraseñas en texto plano.
*/