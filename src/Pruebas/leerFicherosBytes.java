package Pruebas;

import java.io.*;

public class leerFicherosBytes {

    public static void main(String[] args) {
        String file = "C:\\Users\\Alumno\\Downloads\\Matriculacion2DAM.png";
        leerBytes(file);

    }

    private static void leerBytes(String file) {
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        final int TAM = 1024 * 16;

        try {
            bin = new BufferedInputStream(new FileInputStream("filess/origen.jpg"));
            bout = new BufferedOutputStream(new FileOutputStream("filess/destino.jpg"));

            int cantidadBytesLeidos = 0;
            byte[] buffer = new byte[TAM];
            int i = 1;

            while((cantidadBytesLeidos = bin.read(buffer, 0 , TAM)) != -1) {
                System.out.println("Leidos " + cantidadBytesLeidos + " Bytes en la interaci�n " + i++ + "-�sima");

            }

			/*
			while(cantidadBytesLeidos != -1) {
				System.out.println("Leidos " + cantidadBytesLeidos + " Bytes en la interaci�n " + i++ + "-�sima");
				cantidadBytesLeidos = bin.read(buffer, 0 , TAM));
			}
			*/

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(bin != null) {
                try {
                    bin.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
