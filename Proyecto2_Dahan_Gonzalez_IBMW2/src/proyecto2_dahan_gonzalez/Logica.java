/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_dahan_gonzalez;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Amanda Gonzalez
 */
public class Logica extends Thread{

    public Logica() {
    }
        
   public void Inicio() throws InterruptedException{
        //Creando las colas de prioridades y de mantenimiento
    Queue<Carro> colaPrioridad1 = new ConcurrentLinkedQueue<Carro>();
    Queue<Carro> colaPrioridad2 = new ConcurrentLinkedQueue<Carro>();
    Queue<Carro> colaPrioridad3 = new ConcurrentLinkedQueue<Carro>();
    Queue<Carro> colaMantenimiento = new ConcurrentLinkedQueue<Carro>();
    //Colas auxiliares para el manejo de la interfaz
    Queue<String> aux1 = new LinkedList<String>(); 
    Queue<String> aux2 = new LinkedList<String>(); 
    Queue<String> aux3 = new LinkedList<String>(); 
     Queue<String> aux4 = new LinkedList<String>(); 
    Vista vista = new Vista();
    vista.setVisible(true);
    //Creando contadores
    int contID = 0;
    
    //Creando administrador, mecanico y el prime carro
    Administrador admin = new Administrador(vista);
    Mecanico mecanico = new Mecanico();
    int auxPrioridad = (int) (Math.random()*(3)+1);
    Carro primerCarro = new Carro(contID, auxPrioridad, 0);
    contID = contID +1;
    
    
    System.out.println("SE HA CREADO EL PRIMER CARRO CON PRIORIDAD " + auxPrioridad);
    
    //Variable donde se alamcaena el carro que estuvo en el mecanico
    Carro auxCarro = primerCarro;
    //Mostrar el primer auto creado en la interfaz
    if(auxCarro.getPrioridad()==1){
        admin.getVista().getCola1().setText(Integer.toString(auxCarro.getId()));
        this.sleep(2000);
        admin.getVista().getCola1().setText(" ");
        admin.getVista().getMecanico().setText(Integer.toString(auxCarro.getId()));
    }else if(auxCarro.getPrioridad()==2){
        admin.getVista().getCola2().setText(Integer.toString(auxCarro.getId()));
        this.sleep(2000);
        admin.getVista().getCola2().setText(" ");
        admin.getVista().getMecanico().setText(Integer.toString(auxCarro.getId()));
    } else if(auxCarro.getPrioridad()==3){
        admin.getVista().getCola3().setText(Integer.toString(auxCarro.getId()));
        this.sleep(2000);
        admin.getVista().getCola3().setText(" ");
        admin.getVista().getMecanico().setText(Integer.toString(auxCarro.getId()));
        
    }
    
    
    boolean crear = false;
    while(true){
        mecanico.MecanicoAccion(auxCarro);
        if(auxCarro!=null){
            admin.aumentarInanicion(colaPrioridad1,colaPrioridad2, colaPrioridad3, auxCarro.getId());
        }
        admin.actualizarColas(colaPrioridad1, colaPrioridad2, colaPrioridad3, colaMantenimiento, auxCarro, aux1,aux2,aux3, aux4);
        contID = admin.crearCarro(contID, colaPrioridad1, colaPrioridad2, colaPrioridad3, aux1,aux2,aux3, crear);
        auxCarro = admin.seleccionarCarro(colaPrioridad1, colaPrioridad2, colaPrioridad3, aux1,aux2,aux3);
        crear = !crear;
        
        if(crear){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }
    }
    
    }
    
}
