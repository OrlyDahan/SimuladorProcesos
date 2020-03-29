/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_dahan_gonzalez;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Orly
 */
public class Administrador extends Thread {
    
    private Vista vista;

    public Administrador(Vista vista) {
        this.vista = vista;
    }
    
    
    
    //Método para mantener actualizadas las colas
    public void actualizarColas(Queue<Carro> colaPrioridad1, Queue<Carro> colaPrioridad2, Queue<Carro> colaPrioridad3, 
            Queue<Carro> colaMantenimiento, Carro carro,  Queue<String> aux1,  Queue<String> aux2,  Queue<String> aux3, Queue<String> aux4) throws InterruptedException{
        
        Carro auxCarro; 
        
        if(carro!=null){
            //Realizamos el random para validar las probabilidades de que un carro vaya a la lista de revisar, de mantenimiento o salga al mercado
            int auxProb = (int)(Math.random()*(100)+1);
            //Si el numero es menor a 50 va a la lista de prioridades de acuerdo a su prioridad
            if(auxProb<=50){
                switch(carro.getPrioridad()){
                    case 1:
                         vista.getMecanico().setText("");
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA VUELTO A LA COLA DE PRIORIDAD 1");
                        colaPrioridad1.add(carro);
                        aux1.add(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux1,1);
                        this.sleep(2000);
                        break;
                    case 2:
                         vista.getMecanico().setText("");
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA VUELTO A LA COLA DE PRIORIDAD 2");
                        colaPrioridad2.add(carro);
                        aux2.add(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux2,2);
                        this.sleep(2000);
                        break;
                    case 3:
                        vista.getMecanico().setText("");
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA VUELTO A LA COLA DE PRIORIDAD 3");
                        colaPrioridad3.add(carro);
                        aux3.add(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux3,3);
                        this.sleep(2000);
                        break;
                }
            }
            //Si el numero random esta entre 50 y 80 significa que salió al mercado
            if(auxProb>50 && auxProb<=80){
                switch(carro.getPrioridad()){
                    case 1:
                        colaPrioridad1.remove(carro);
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                        aux1.remove(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux1,1);
                        this.vista.getCarroMercado().setText("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                         vista.getMecanico().setText("");
                        this.sleep(2000);
                        this.vista.getCarroMercado().setText("");
                        break;
                    case 2:
                        colaPrioridad2.remove(carro);
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                        aux2.remove(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux2,2);
                        this.vista.getCarroMercado().setText("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                         vista.getMecanico().setText("");
                        this.sleep(2000);
                         this.vista.getCarroMercado().setText("");
                        break;
                    case 3:
                        colaPrioridad3.remove(carro);
                        System.out.println("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                        aux3.remove(Integer.toString(carro.getId()));
                        this.ModificarVistaCola(aux3,3);
                        this.vista.getCarroMercado().setText("EL CARRO QUE ESTABA EN EL MECANICO HA SALIDO AL MERCADO");
                         vista.getMecanico().setText("");
                        this.sleep(2000);
                         this.vista.getCarroMercado().setText("");
                         
                        break;
                }
            }
            //Si el numero random esta entre 80 y 100 va a la cola de mantenimiento
            if(auxProb>80 && auxProb<=100){
                vista.getMecanico().setText("");
                System.out.println("EL CARRO QUE ESTABA EN EL MECANICO FUE A LA COLA DE MANTENIMIENTO");
                colaMantenimiento.add(carro);
                aux4.add(Integer.toString(carro.getId()));
                this.ModificarVistaCola(aux4,4);
                this.sleep(1000);
            }
        }
        
        // Se valida la probabilidad de que un carro salga de la cola de mantenimiento
        int auxMejora = (int)(Math.random()*(100)+1);
        //Se saca el carro de la cola de mantenimiento y se coloca en su respectiva cola de prioridad
        if(auxMejora<=60){
            if(colaMantenimiento.isEmpty()){
                
            }else {
                auxCarro = colaMantenimiento.peek();
                colaMantenimiento.remove();
                aux4.remove(Integer.toString(auxCarro.getId()));
                this.ModificarVistaCola(aux4,4);
                switch(auxCarro.getPrioridad()){
                    case 1:
                        System.out.println("UNO DE LOS CARROS DE LA COLA DE MANTENIMIENTO VOLVIO A LA PRIORIDAD 1");
                        colaPrioridad1.add(auxCarro);
                        aux1.add(Integer.toString(auxCarro.getId()));
                        this.ModificarVistaCola(aux1,1);
                        this.sleep(2000);
                        break;
                    case 2:
                        System.out.println("UNO DE LOS CARROS DE LA COLA DE MANTENIMIENTO VOLVIO A LA PRIORIDAD 2");
                        colaPrioridad2.add(auxCarro);
                        aux2.add(Integer.toString(auxCarro.getId()));
                        this.ModificarVistaCola(aux2,2);
                        this.sleep(2000);
                        break;
                    case 3:
                        System.out.println("UNO DE LOS CARROS DE LA COLA DE MANTENIMIENTO VOLVIO A LA PRIORIDAD 3");
                        colaPrioridad3.add(auxCarro);
                        aux3.add(Integer.toString(auxCarro.getId()));
                        this.ModificarVistaCola(aux3,3);
                        this.sleep(2000);
                        break;
                }
            }
            
        }
        
        //Se revisa el contador de inanicion de todos los carros y se les aumenta la prioridad de ser necesario
        //Los carros de la cola en primera prioridad no se ven modificados
        for (Carro carroIn : colaPrioridad2){    
            if(carroIn.getContI()>=10){
                carroIn.setContI(0);
                carroIn.setPrioridad(carroIn.getPrioridad()-1);
                colaPrioridad1.add(carroIn);
                aux1.add(Integer.toString(carroIn.getId()));
                this.ModificarVistaCola(aux1,1);
                colaPrioridad2.remove(carroIn);
                aux2.remove(Integer.toString(carroIn.getId()));
                this.ModificarVistaCola(aux2,2);
                System.out.println("EL CARRO " + carroIn.getId() + " HA SUBIDO A LA PRIORIDAD 1");
            }
        }
            
        for (Carro carroIn : colaPrioridad3){
            if(carroIn.getContI()>=10){
                carroIn.setContI(0);
                carroIn.setPrioridad(carroIn.getPrioridad()-1);
                colaPrioridad2.add(carroIn);
                aux2.add(Integer.toString(carroIn.getId()));
                this.ModificarVistaCola(aux2,2);
                colaPrioridad3.remove(carroIn);
                aux3.remove(Integer.toString(carroIn.getId()));
                this.ModificarVistaCola(aux3,3);
                System.out.println("EL CARRO " + carroIn.getId() + " HA SUBIDO A LA PRIORIDAD 2");
            }
        }
        
    }
    
    //Método para crear un nuevo carro
    public int crearCarro(int contID, Queue<Carro> colaPrioridad1, Queue<Carro> colaPrioridad2, Queue<Carro> colaPrioridad3, Queue<String> aux1,  Queue<String> aux2,  Queue<String> aux3, boolean crear) throws InterruptedException{
        
        if(crear){
            //Se seleccionan números al azar entre 1 y 100 para validar la probabilidad del 60%
        int auxProb = (int)(Math.random()*(100)+1);
        //Se escoge un número al azar del 1 al 3 para indicar la prioridad del nuevo carro
        int auxPrioridad = (int) (Math.random()*(3)+1);
        //Se inicializa el contador de inanición en 0
        int contInanicion = 0;
        if(auxProb<=60){
            //Se crea el carro y se agrega en la cola de su respectiva prioridad
            Carro carro = new Carro(contID, auxPrioridad, contInanicion);
            switch(auxPrioridad){
                case 1:
                    System.out.println("SE HA CREADO UN CARRO DE PRIORIDAD 1");
                    colaPrioridad1.add(carro);
                    aux1.add(Integer.toString(carro.getId()));
                    this.ModificarVistaCola(aux1,1);
                    this.sleep(2000);
                    return (contID +1);
                case 2:
                    System.out.println("SE HA CREADO UN CARRO DE PRIORIDAD 2");
                    colaPrioridad2.add(carro);
                    aux2.add(Integer.toString(carro.getId()));
                    this.ModificarVistaCola(aux2,2);
                    this.sleep(2000);
                    return (contID +1);
                case 3:
                    System.out.println("SE HA CREADO UN CARRO DE PRIORIDAD 3");
                    colaPrioridad3.add(carro);
                    aux3.add(Integer.toString(carro.getId()));
                    this.ModificarVistaCola(aux3,3);
                    this.sleep(2000);
                    return (contID +1);
            }
                        
        }
        
        return contID;
        }
        
        return contID;
        
    }
    
    //Metodo para aumentar la inanicion de todos los carros que no pasaron al mecanico
    public void aumentarInanicion(Queue<Carro> colaPrioridad1, Queue<Carro> colaPrioridad2, Queue<Carro> colaPrioridad3, int contID){
        //Se compara el ID del carro que paso con los que quedan en las colas
        for (Carro carro : colaPrioridad1)
            if(carro.getId()!= contID){
                carro.setContI(carro.getContI()+1);
                System.out.println("EL CountInanicion del carro: " + carro.getId() + " AUMENTO A " + carro.getContI());
            }
        
        for (Carro carro : colaPrioridad2)
            if(carro.getId()!= contID){
                carro.setContI(carro.getContI()+1);
                System.out.println("EL CountInanicion del carro: " + carro.getId() + " AUMENTO A " + carro.getContI());
            }
        
        for (Carro carro : colaPrioridad3)
            if(carro.getId()!= contID){
                carro.setContI(carro.getContI()+1);
                System.out.println("EL CountInanicion del carro: " + carro.getId() + " AUMENTO A " + carro.getContI());
            }
    }
    
    // Metodo para seleccionar un carro para que entre al mecánico
    public Carro seleccionarCarro(Queue<Carro> colaPrioridad1, Queue<Carro> colaPrioridad2, Queue<Carro> colaPrioridad3, Queue<String> aux1,  Queue<String> aux2,  Queue<String> aux3) throws InterruptedException{
        Carro carroSeleccionado = null;
        // Se revisa cola por cola hasta encontrar una que no este vacia, retornar el primer elemento de la cola y luego eliminarlo de la misma
        if(colaPrioridad1.isEmpty()){
            if(colaPrioridad2.isEmpty()){
                if(colaPrioridad3.isEmpty()){
                    System.out.println("NO HAY CARROS PARA SELECCIONAR");
                    return carroSeleccionado;
                } else{
                    carroSeleccionado = colaPrioridad3.peek();
                    carroSeleccionado.setContI(0);
                    colaPrioridad3.remove();
                    aux3.remove(Integer.toString(carroSeleccionado.getId()));
                    this.ModificarVistaCola(aux3,3);
                    System.out.println("SE HA SELECCIONADO UN CARRO DE PRIORIDAD 3");
                    vista.getMecanico().setText(Integer.toString(carroSeleccionado.getId()));
                    this.sleep(2000);
                    return carroSeleccionado;
                }
            } else{
                 
                carroSeleccionado = colaPrioridad2.peek();
                carroSeleccionado.setContI(0);
                colaPrioridad2.remove();
                aux2.remove(Integer.toString(carroSeleccionado.getId()));
                this.ModificarVistaCola(aux2,2);
                System.out.println("SE HA SELECCIONADO UN CARRO DE PRIORIDAD 2");
                 vista.getMecanico().setText(Integer.toString(carroSeleccionado.getId()));
                 this.sleep(2000);
                return carroSeleccionado;
            }
          
        } else{
            carroSeleccionado = colaPrioridad1.peek();
            carroSeleccionado.setContI(0);
            colaPrioridad1.remove();
            aux1.remove(Integer.toString(carroSeleccionado.getId()));
            this.ModificarVistaCola(aux1,1);
            System.out.println("SE HA SELECCIONADO UN CARRO DE PRIORIDAD 1");
            vista.getMecanico().setText(Integer.toString(carroSeleccionado.getId()));
            this.sleep(2000);
            return carroSeleccionado;
        }
    }
    
    //Metodos del controlador
    public void ModificarVistaCola(Queue<String> cola, int prioridad){
        switch(prioridad){
            case 1:
                 String[] array = cola.toArray(new String[cola.size()]);
                vista.getCola1().setText(" ");
                 System.out.println("Cola 1 Elements:");
                 for (int j = 0; j < array.length; j++){
                    vista.getCola1().append(array[j] + "\n");
                    System.out.println(array[j]);
                }
                 break;
            case 2:
                String[] array2 = cola.toArray(new String[cola.size()]);
                vista.getCola2().setText(" ");
                 System.out.println("Cola 2 Elements:");
                 for (int k = 0; k < array2.length; k++){
                    vista.getCola2().append(array2[k] + "\n");
                    System.out.println(array2[k]);
                }
                 break;
            case 3:
                String[] array3 = cola.toArray(new String[cola.size()]);
                vista.getCola3().setText(" ");
                 System.out.println("Cola 3 Elements :");
                 for (int j = 0; j < array3.length; j++){
                    vista.getCola3().append(array3[j] + "\n");
                    System.out.println(array3[j]);
                }
                 break;
            case 4:
                String[] array4 = cola.toArray(new String[cola.size()]);
                  vista.getMantenimiento().setText(" ");
                  System.out.println("Cola Elements Mantenimiento:");
                 for (int j = 0; j < array4.length; j++){
                    vista.getMantenimiento().append(array4[j] + "\n");
                    System.out.println(array4[j]);
                }
                 break;
               
                
        }
               
       
         
        
        
    }
    
    //Getters y setters

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }
    
    
}
