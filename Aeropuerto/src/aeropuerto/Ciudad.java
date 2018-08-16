/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import java.util.Objects;

/**
 *
 * @author rociomera
 */
public class Ciudad {
    private String nombre;
    private String country;
    public Ciudad(String nombre, String country){
        this.nombre=nombre;
        this.country=country;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String toString(){
        return nombre+"-"+country;
    }
    
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Ciudad))
            return false;
        Ciudad c = (Ciudad)o;
        return this.country.equals(c.country) && this.nombre.equals(c.nombre);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.country);
        return hash;
    }
    
    
}
