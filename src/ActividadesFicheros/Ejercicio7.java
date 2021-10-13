package ActividadesFicheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7 {

    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int n = solicitarCantidadFicheros();
        createFile(n);
    }
    public static void createFile(int n){
        String fileName = null;
        String ruta = "src/";
        for (int i = 1; i <= n; i++){
            fileName = solicitarNombre("Introduce el nombre del fichero: " + i);

            File file = new File(fileName);
            if(!file.exists()) {
                file.mkdirs();
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
