/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_dahan_gonzalez;

/**
 *
 * @author Orly
 */
public class Mecanico extends Thread {

    public Mecanico() {
        
    }
    
    //Tiempo de espera en el que los carros se quedan en el mecánico
    
    public void MecanicoAccion(Carro carro) throws InterruptedException{
        if(carro==null){
            System.out.println("NO ENTRO NINGÚN CARRO AL MECÁNICO");
        }else{
            System.out.println("EL MECANICO ESTA TRABAJANDO");
            this.sleep(1000*5);
        }
        
    }
    
}
