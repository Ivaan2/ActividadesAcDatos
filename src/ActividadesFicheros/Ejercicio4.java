package ActividadesFicheros;

import javax.imageio.plugins.tiff.BaselineTIFFTagSet;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/*
Escribir un fichero de bytes con un mensaje (no será legible) y
enviárselo a un compañero para que lo “descifre” mediante la lectura,
transformación y escritura por pantalla del mismo.
 */

public class Ejercicio4 {

    private static final int TAM = 1024 * 16;
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        String origen = "prueba.dat";
        crearFichero(origen);
        leerFichero(origen);
    }

    private static void crearFichero(String origen) {
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(origen));){
            {
                System.out.println("Escribe un mensaje: ");
                String mensaje = teclado.nextLine();
                bos.write(mensaje.getBytes());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void leerFichero(String origen){
        FileInputStream fis = null;
        DataInputStream din = null;


        try {
            fis = new FileInputStream(origen);
            din = new DataInputStream(fis);
            byte[] buffer = new byte[fis.available()];

            din.read(buffer);
            String cadena = new String(buffer, StandardCharsets.UTF_8);

            System.out.println(cadena);

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

