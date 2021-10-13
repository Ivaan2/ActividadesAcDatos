package ActividadesFicheros;

import java.io.*;

public class Ejercicio8 {
    public static void main(String[] args) {
        leerFichero("Contenedor.txt");
    }

    private static void leerFichero(String origen) {
        String linea;
        File fichero;
        try (BufferedReader br = new BufferedReader(new FileReader(origen));) {
            {
                while ((linea =br.readLine()) != null) {
                    fichero = new File(linea);
                    if(!fichero.exists()) {
                        fichero.createNewFile();
                    }else{
                        System.out.println("Ya existe, Error.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

