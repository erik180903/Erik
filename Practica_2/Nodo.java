package Practica_2;
/***
 * Declaracion de la variable que recibirá el valor y de los 2 apuntadores
 */
public class Nodo {
    private int num;
    private Nodo next;
    private Nodo back;
    /**
     * contructor por defecto
     * @param val almacena el valor tecleado y se lo asigna a la variable num de nuestro nodo
     */
    public Nodo(int val) {
        this.num = val;
    }
    /**
     * get de mi variable num
     * @return el valor registrado
     */
    public int getNum() {
        return num;
    }
    /**
     * set de mi variable num
     * @param num obtiene el valor del numero registrado
     */
    public void setNum(int num) {
        this.num = num;
    }
    /**
     * get de mi apuntador next
     * @return la direccion de memoria del nodo siguiente
     */
    public Nodo getNext() {
        return next;
    }
    /**
     * set de nuestro apuntador next
     * @param next recibe la direccion de memoria de nuestro siguiente nodo
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
    /**
     * get de nuestro apuntador back
     * @return retorna la direccion de memoria de nuestro nodo anterior
     */
    public Nodo getBack() {
        return back;
    }
    /**
     * set de nuestro apuntador back
     * @param back recibe la direccion de memoria de nuestro nodo anterior
     */
    public void setBack(Nodo back) {
        this.back = back;
    } 
}