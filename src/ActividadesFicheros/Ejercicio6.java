package ActividadesFicheros;
import java.io.*;
import java.util.Scanner;

/*
    Clase java que pregutne al usuario un nÃºmero junto a una serie de nombres para crear n ficheros
 */

public class Ejercicio6{

    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int n = solicitarCantidadFicheros();
        createFile(n);
    }

    public static void createFile(int n){
        String fileName = null;
        for (int i = 0; i < n; i++){
            fileName = solicitarNombre();

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

    public static String solicitarNombre(){
        String c;
        System.out.println("Introduce el nombre del fichero: ");
        c = teclado.nextLine();
        return c;
    }
}