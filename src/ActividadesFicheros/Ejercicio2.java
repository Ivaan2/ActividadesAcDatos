package ActividadesFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio2 {

    public static void main(String[] args) {
        /*Este algoritmo copia el contenido de un archivo en otro*/
        String ruta = "filess/origen.txt";
        String destino = "filess/destino.txt";
        leerFichero(ruta, destino);
    }

    private static void leerFichero(String origen, String destino) {
        String linea;
        try(BufferedReader br = new BufferedReader(new FileReader(origen));){
            {
                try(PrintWriter pw = new PrintWriter(new FileWriter(destino));){
                    {
                        linea = br.readLine();
                        while(linea != null) {
                            pw.println(linea);
                            linea = br.readLine();
                        }
                    }
                }catch(IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
