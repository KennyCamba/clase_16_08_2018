/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author rociomera
 */
public class Vuelo implements Comparable<Vuelo>{
    private String identificador;
    private Ciudad destino;
    private LocalDate fecha;
    public Vuelo(String identificador, Ciudad destino, LocalDate fecha){
        this.identificador=identificador;
        this.destino=destino;
        this.fecha = fecha;
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public Ciudad getDestino() {
        return destino;
    }
    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public String toString(){
        return identificador+","+destino+","+fecha;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Vuelo))
            return false;
        return ((Vuelo)o).identificador.equals(this.identificador);
    }
    
    @Override
    public int hashCode() {
        return identificador.hashCode();
    }
    /**
     * Cargar los Vuelos
     * @return 
     */
    public static Set<Vuelo>loadVuelos(){
        Set<Vuelo> vuelos = new HashSet<>();
        String f = new File("").getAbsolutePath();
        f = Paths.get(f, "src", "data", "vuelos.txt").toString();
        
        try(BufferedReader bf = new BufferedReader(new FileReader(f))) {
            String line;
            while((line=bf.readLine()) != null) {
                String[] datos = line.split(";");
                Ciudad c = new Ciudad(datos[1], datos[2]);
                LocalDate ld = LocalDate.parse(datos[3], 
                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                vuelos.add(new Vuelo(datos[0], c, ld));
            }
        }catch(IOException ex) {
        
        }
        return vuelos;
    }
    
    public static void main(String[] args) {
        String f = new File("").getAbsolutePath();
        f = Paths.get(f, "src", "data", "vuelos.txt").toString();
        System.out.println(f);
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 
        for(Vuelo v: Vuelo.loadVuelos()){
            System.out.println(v);
        }
    }

    @Override
    public int compareTo(Vuelo o) {
        return this.fecha.compareTo(o.fecha);
    }
}
