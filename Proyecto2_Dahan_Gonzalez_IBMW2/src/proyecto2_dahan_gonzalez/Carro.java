/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_dahan_gonzalez;

import java.util.Queue;

/**
 *
 * @author Orly
 */
public class Carro {
    
    private int id; //Identificador del carro
    private int prioridad; //Prioridad del carro
    private int contI; //Contador para evitar la Inanición

    public Carro(int id, int prioridad, int contI) {
        this.id = id; 
        this.prioridad = prioridad; 
        this.contI = contI; 
    }
    
    //Getters y Setters
    
    public int getId() {
        return id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getContI() {
        return contI;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setContI(int contI) {
        this.contI = contI;
    }
    
    
            
}
