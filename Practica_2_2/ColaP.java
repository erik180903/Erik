package Practica_2_2;
public class ColaP {
    /**
     * Declaracion de nodos que ocuparemos y de la variable con el tamaño de nuestra cola
     */
    Nodo head;
    Nodo tail1;
    Nodo tail2;
    Nodo tail3;
    int size; 
    /**
     * Función para inicializar nuestros nodos y de nuestra valiable del tamaño
     * @param c la cola en la que estaremos almacenando
     */
    public void init(ColaP c){
        c.head = c.tail1 = c.tail2 = tail3 = null;
        c.size = 0;
    }
    /**
     * Función para agregar nodos con "prioridad 1"
     * @param c la cola en la que estaremos almacenando
     * @param valor es el valor que se desea almacenar
     * @return 
     */
    public int add1(ColaP c, int valor){
        Nodo nodo = new Nodo();
        if(nodo == null) return 0;
        nodo.setValor(valor);
        nodo.setPrioridad(1);
        nodo.setNext(null);
        if(c.head == null){
            c.head = nodo;
            c.tail1 = nodo;
        }else{
            if(c.tail1 == null){
                nodo.setNext(c.head);
                c.head = nodo;
                c.tail1 = nodo;
            }else{
                nodo.setNext(c.tail1.getNext());
                c.tail1.setNext(nodo);
                c.tail1 = nodo;
            }
        }
        c.size ++;
        return 0;
    }
    /**
     * Función para agregar nodos con "prioridad 2"
     * @param c la cola en la que estaremos almacenando
     * @param valor es el valor que se desea almacenar
     * @return
     */
    public int add2(ColaP c, int valor){
        Nodo nodo = new Nodo();
        if(nodo == null) return 0;
        nodo.setValor(valor);
        nodo.setPrioridad(2);
        nodo.setNext(null);
        if(c.head == null){
            c.head = nodo;
            c.tail2 = nodo;
        }else{
            if(c.tail2 == null){
                nodo.setNext(c.head);
                c.head = nodo;
                c.tail2 = nodo;
            }else{
                nodo.setNext(c.tail2.getNext());
                c.tail2.setNext(nodo);
                c.tail2 = nodo;
            }
        }
        c.size ++;
        return 0;
    }
    /**
     * Función para agregar nodos con "prioridad 3"
     * @param c la cola en la que estaremos almacenando
     * @param valor es el valor que se desea almacenar
     * @return
     */
    public int add3(ColaP c, int valor){
        Nodo nodo = new Nodo();
        if(nodo == null) return 0;
        nodo.setValor(valor);
        nodo.setPrioridad(3);
        nodo.setNext(null);
        if(c.head == null){
            c.head = nodo;
            c.tail3 = nodo;
        }else{
            if(c.tail3 == null){
                nodo.setNext(c.head);
                c.head = nodo;
                c.tail3 = nodo;
            }else{
                nodo.setNext(c.tail3.getNext());
                c.tail3.setNext(nodo);
                c.tail3 = nodo;
            }
        }
        c.size ++;
        return 0;
    } 
    /**
     * Función para agregar los nodos una vez que se defina su prioridad
     * @param c la cola en la que estaremos almacenando
     * @param val es el valor que se desea almacenar
     * @param prio es la prioridad del nodo a almacenar
     * @return
     */
    public int add(ColaP c, int val, int prio){
        if(prio == 1){
            return add1(c, val);   
        }else if(prio == 2){
            return add2(c, val);
        }else if(prio == 3){
            return add3(c, val);
        }else{
            return 0;
        }
    }
    /**
     * Función para obtener el primer valor ingresado de la cola
     * @param c la cola en la que estaremos almacenando
     * @return
     */
    public int peek(ColaP c){
        int val = 0;
        if(c.head == null) return 0;
        if(c.head == c.tail3){
            c.head = c.head.getNext();
            val = c.tail3.getValor();
            c.tail3 = null;
        }else if(c.head == c.tail2){
            c.head = c.head.getNext();
            val = c.tail2.getValor();
            c.tail2 = null;
        }else if(c.head == c.tail1){
            c.head = c.head.getNext();
            val = c.tail1.getValor();
            c.tail1 = null;
        }else{
            Nodo nodo = c.head;
            val = nodo.getValor();
            c.head = c.head.getNext();
            nodo = null;
        }
        return val;
    }
    /**
     * Función para imprimir la cola
     * @param c la cola en la que estaremos almacenando
     */
    public void print(ColaP c){
        Nodo current = c.head;
        System.out.print("[");
        while(current != null){
            System.out.print(current.getValor()+", ");
            current = current.getNext();
        }
        System.out.println("]\n");
    }
}