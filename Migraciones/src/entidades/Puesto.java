/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author nicoleagila
 */
public class Puesto {
    private int id;
    private boolean disponible;
    private static int IDP=0;

    public Puesto() {
        this.id = IDP++;
        this.disponible=true;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Puesto)){
            return false;
        }
        
        Puesto other = (Puesto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

}
