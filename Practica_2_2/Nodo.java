package Practica_2_2;

public class Nodo {
    /**
     * Declaración de la variable que recibirá el valor, la variable 
     * que recibira la prioridad y de nuestro puntero
     */
    
    private int valor;
    private int prioridad;
    private Nodo next;

    /**
     * get de la variable valor
     * @return el valor almacenado
     */
    public int getValor() {
        return valor;
    }
    /**
     * set de la variable valor
     * @param valor recibe el valor a almacenar
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * get de la variable prioridad
     * @return la prioridad almacenada
     */
    public int getPrioridad() {
        return prioridad;
    }
    /**
     * set de la variable prioridad
     * @param prioridad recibe la prioridad a almacenar
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    /**
     * get del apuntador next
     * @return la dirección del siguiente nodo
     */
    public Nodo getNext() {
        return next;
    }
    /**
     * set del apuntador next
     * @param next recibe la dirección del siguiente nodo
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
}