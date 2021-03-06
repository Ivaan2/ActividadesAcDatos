package ActividadesFicheros;
import java.io.*;
import java.util.Scanner;

/*
    Implementar clase java que solicita al usuario número de ficheros a crear y los nombres de los mismos.
    A continuación creará los ficheros indicados.
 */

public class Ejercicio6{

    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int n = solicitarCantidadFicheros();
        createFile(n);
    }

    public static void createFile(int n){
        String fileName = null;
        for (int i = 1; i <= n; i++){
            fileName = solicitarNombre("Introduce el nombre del fichero: " + i);

            File file = new File(fileName);
            if(!file.exists()) {
                try {
                    file.createNewFile();

                }catch(IOException e) {
                    e.getStackTrace();
                }
            }else {
                System.out.println("Error, ese fichero ya existe.");
                //No se crea, no cuenta
                i--;
            }
        }
    }

    public static int solicitarCantidadFicheros(){
        int i;
        System.out.println("Introduzca la cantidad de ficheros a crear: ");
        i = Integer.parseInt(teclado.nextLine());
        return i;
    }

    public static String solicitarNombre(String s){
        String c;
        System.out.println(s);
        c = teclado.nextLine();
        return c;
    }
}