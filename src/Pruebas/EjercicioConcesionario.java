package Pruebas;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class EjercicioConcesionario implements Comparable<EjercicioConcesionario>{
    String marca, modelo;
    LocalDate fMatriculacion;
    int kms, precio;

    public EjercicioConcesionario(String marca, String modelo, LocalDate fMatriculacion, int kms, int precio){
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
        String destinoCSV = "src/Archivos/coches.txt";
        String garaje = "src/Archivos/informacion.txt";
        leerAtributos(garaje, destinoCSV);
    }

    public static void leerAtributos(String garaje, String destinoCSV){
        String linea = null;
        EjercicioConcesionario coche = null;
        BufferedWriter bw = null;
        ArrayList<EjercicioConcesionario> conjuntoCoches = new ArrayList<EjercicioConcesionario>();

        try(BufferedReader br = new BufferedReader(new FileReader(garaje));){
            {
                bw = new BufferedWriter(new FileWriter(destinoCSV));
                String[] atributos;
                while((linea = br.readLine()) != null){
                    atributos = linea.split(";");
                    String dia = atributos[2].substring(0,2);
                    String mes = atributos[2].substring(2,4);
                    String anno = atributos[2].substring(4,8);
                    LocalDate date = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mes), Integer.valueOf(dia));


                    coche = new EjercicioConcesionario(atributos[0], atributos[1], date, Integer.parseInt(atributos[3]), Integer.parseInt(atributos[4]));
                    conjuntoCoches.add(coche);


                   // System.out.println(coche);
                }
                Collections.sort(conjuntoCoches);
                for(EjercicioConcesionario coches : conjuntoCoches){
                    System.out.println(coches.toString());
                    bw.write(coches.toString());
                    bw.newLine();
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int compareTo(EjercicioConcesionario o) {
        return this.kms - o.kms;
    }
}
