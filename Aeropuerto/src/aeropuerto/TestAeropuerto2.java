/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Municipio de Gye
 */
public class TestAeropuerto2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aeropuerto a = new Aeropuerto("");
        System.out.print("Ciudad: ");
        String c = sc.nextLine();
        System.out.print("País: ");
        String p = sc.nextLine();
        Ciudad ciudad = new Ciudad(c, p);
        Map<Ciudad, TreeSet<Vuelo>> vu = a.getVuelosPorDestinoTree();
        if(vu.containsKey(ciudad)){
            System.out.println("Primer vuelo: " + vu.get(ciudad).first());
            System.out.println("Primer vuelo: " + vu.get(ciudad).last());
            
            System.out.print("Fecha Incio: ");
            String fi = sc.nextLine();
            System.out.print("Fecha Fin: ");
            String ff = sc.nextLine();
            LocalDate fei = LocalDate.parse(fi, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalDate fef = LocalDate.parse(ff, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            TreeSet<Vuelo> datos = vu.get(ciudad);
            for(Vuelo vv: datos) {
                if(vv.getFecha().compareTo(fei) >=0 && 
                        vv.getFecha().compareTo(fef) <= 0)
                    System.out.println(vv);
            }
        }else {
            System.out.println("Ese destino no existe");
        }
    }
}
