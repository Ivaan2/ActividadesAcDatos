package Pruebas;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class escrituraBytes {

    public static void main(String[] args) {
        String origen = "filess/origen.jpg";
        leerImagenABytes(origen);


    }

    private static void leerImagenABytes(String origen) {
        String destino = "filess/destino.jpg";
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destino));){
            {
                try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origen));){
                    bos.write(bis.read(origen.getBytes()));
                }
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void escribirFicheroBytes() {
        byte[] buffer = new byte[1024 * 32];
        Arrays.fill(buffer, Byte.parseByte("2"));
        BufferedOutputStream bos = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream("src/ejemplo_buffered.dat"));
            bos.write("Hola juancarloo".getBytes());
            bos.write(buffer);

        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }finally {
            if(bos != null)
                try {
                    bos.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
