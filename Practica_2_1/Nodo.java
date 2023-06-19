package Practica_2_1;
/**
 * Declaración de la variable que recibirá el valor y de nuestro puntero
 */
public class Nodo {
    private String val;
    private Nodo next;
    /**
     * Constructor por defecto
     * @param val almacena el valor tecleado y se lo asigna a la variable val de nuestro nodo
     */
    public Nodo(String val) {
        this.val = val;
    }
    /**
     * get de la variable val
     * @return el valor ingresado
     */
    public String getVal() {
        return val;
    }
    /**
     * set de la variable val
     * @param val recibe el valor ingresado
     */
    public void setVal(String val) {
        this.val = val;
    }
    /**
     * get del puntero next
     * @return la dirección de memoria del nodo siguiente
     */
    public Nodo getNext() {
        return next;
    }
    /**
     * set del apuntador next
     * @param next recibe la dirección de memoria del siguiente nodo
     */
    public void setNext(Nodo next) {
        this.next = next;
    }   
}