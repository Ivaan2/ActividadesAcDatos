package ActividadesFicheros;

import java.io.*;

/*
Implementar una clase Java que permita copiar imágenes.
*/

public class Ejercicio5 {
    private static final int TAM = 1024 * 16;
    public static void main(String[] args) {
        copiarImagen();
    }

    public static void copiarImagen(){
        byte[] buffer = new byte[TAM];

        try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream("src/Archivos/origen.jpg"))) {
            {
                FileOutputStream fos = new FileOutputStream("src/Archivos/destino.jpg");

                int cantidadBytes = 0;

                while((cantidadBytes = bin.read(buffer, 0, TAM)) != -1){
                    fos.write(buffer);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
