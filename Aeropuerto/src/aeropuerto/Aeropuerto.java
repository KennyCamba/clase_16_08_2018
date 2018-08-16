/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class Aeropuerto{
    private String nombre;
    private Set<Vuelo> vuelos;
    public Aeropuerto(String nombre){
        this.nombre = nombre;
        this.vuelos = new HashSet<>();
    }
    
    public HashMap<Ciudad, Set<Vuelo>> getVuelosPorDestino() {
        HashMap<Ciudad, Set<Vuelo>> relacion = new HashMap<>();
        for(Vuelo v: Vuelo.loadVuelos()) {
            Ciudad key = v.getDestino();
            if(!relacion.containsKey(key)) {
                Set<Vuelo> vuel = new HashSet<>();
                relacion.put(key, vuel);
                vuel.add(v);
            }else {
                relacion.get(key).add(v);
            }
        }
        return relacion;
    }
    
    public HashMap<Ciudad, TreeSet<Vuelo>> getVuelosPorDestinoTree() {
        HashMap<Ciudad, TreeSet<Vuelo>> relacion = new HashMap<>();
        for(Vuelo v: Vuelo.loadVuelos()) {
            Ciudad key = v.getDestino();
            if(!relacion.containsKey(key)) {
                TreeSet<Vuelo> vuel = new TreeSet<>();
                relacion.put(key, vuel);
                vuel.add(v);
            }else {
                relacion.get(key).add(v);
            }
        }
        return relacion;
    }
    
    public static void main(String[] args) {
        //for(Ciudad c: new Aeropuerto("").getVuelosPorDestino().keySet())
        //for(Set<Vuelo> v: new Aeropuerto("").getVuelosPorDestino().values())    
        for(Map.Entry<Ciudad, Set<Vuelo>> cv: 
                new Aeropuerto("").getVuelosPorDestino().entrySet()){
            System.out.println("Clave: " + cv.getKey() + " - " + cv.getValue());
        }
    }
}
