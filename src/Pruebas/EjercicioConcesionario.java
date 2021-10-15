package Pruebas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EjercicioConcesionario {
    String marca, modelo;
    Date fMatriculacion;
    int kms, precio;

    public EjercicioConcesionario(String marca, String modelo, Date fMatriculacion, int kms, int precio){
        this.marca = marca;
        this.modelo = modelo;
        this.fMatriculacion = fMatriculacion;
        this.kms = kms;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "EjercicioConcesionario{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fMatriculacion=" + fMatriculacion +
                ", kms=" + kms +
                ", precio=" + precio +
                '}';
    }

    public static void main(String[] args) {
        String garaje = "src/Archivos/coches.txt";
        leerAtributos(garaje);
    }

    public static void leerAtributos(String garaje){
        String linea = null;
        EjercicioConcesionario coche;
        try(BufferedReader br = new BufferedReader(new FileReader(garaje));){
            {
                String[] atributos;
                while((linea = br.readLine()) != null){
                    atributos = linea.split(";");
                    String dia = atributos[2].substring(0,2);
                    String mes = atributos[2].substring(2,4);
                    String anno = atributos[2].substring(4,8);
                    Date date = new Date(Integer.valueOf(dia), Integer.valueOf(mes), Integer.valueOf(anno));

                    coche = new EjercicioConcesionario(atributos[0], atributos[1], date, Integer.parseInt(atributos[3]), Integer.parseInt(atributos[4]));
                    System.out.println(coche);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
