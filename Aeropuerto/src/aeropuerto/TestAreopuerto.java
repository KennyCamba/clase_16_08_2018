/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class TestAreopuerto {
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
            System.out.println("Vuelos del destino: " + ciudad);
            for(Vuelo vuelo: vu.get(ciudad)){
                System.out.println(vuelo);
            }
        }else {
            System.out.println("Ese destino no existe");
        }
    }
    
}
