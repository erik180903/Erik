package Practica_3;
public final class Nodo {
    /**
     * Variables para almacenar los datos de cada nodo
     */
    private int valor;
    private int cant;
    private Nodo izq;
    private Nodo der;
    private Nodo padre;
    private int facBalance;
    private int altIzq;
    private int altDer;
    
    /**
     * Constructor por defecto a utilizar
     * @param valor valor numerico que alamenara el nodo
     */
    public Nodo(int valor){
        this.valor = valor;
        this.cant = 1;
        this.izq = this.der = this.padre = null;
        this.facBalance = 0;
    }

    /**
     * Regresa el nodo a la izquierda
     * @return izq
     */
    public Nodo getNodoI(){
        return izq;
    }
    /**
     * Asigna un nodo a la izquierda
     * @param izquierdo
     */
    public void setNodoIzq(Nodo izquierdo){
        izq = izquierdo;
    }

    /**
     * Regresa el nodo a la derecha
     * @return der
     */
    public Nodo getNodoD(){
        return der;
    }
    /**
     * Asigna un nodo a la derecha
     * @param derecho
     */
    public void setNodoDer(Nodo derecho){
        der = derecho;
    }
    
    /**
     * Regresa el valor almacenado en el nodo
     * @return valor
     */
    public int getValor() {
        return valor;
    }
    /**
     * Recibe el valor a almacenar en el nodo
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Regresa la cantidad de veces que se repite el valor
     * @return cant
     */
    public int getCant() {
        return cant;
    }
    /**
     * Asigna la cantidad de veces que se repite el valor del nodo
     * @param cant
     */
    public void setCant(int cant) {
        this.cant = cant;
    }

    /**
     * Regresa el nodo anterior (nodo padre)
     * @return padre
     */
    public Nodo getPadre() {
        return padre;
    }
    /**
     * Asigna un nodo padre
     * @param padre
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    /**
     * Regresa el factor de balance en cada nodo
     * @return facBalance
     */
    public int getFacBalance() {
        return facBalance;
    }
    /**
     * Asigna el factor de balance de cada nodo
     * @param facBalance
     */
    public void setFacBalance(int facBalance) {
        this.facBalance = facBalance;
    }

    /**
     * Regresa la altura de la rama izquierda del nodo
     * @return altIzq
     */
    public int getAltIzq() {
        return altIzq;
    }
    /**
     * Asigna la altura que tiene la rama izquierda del nodo
     * @param altIzq
     */
    public void setAltIzq(int altIzq) {
        this.altIzq = altIzq;
    }

    /**
     * Regresa la altura de la rama derecha
     * @return altDer
     */
    public int getAltDer() {
        return altDer;
    }
    /**
     * Asigna la altura que tiene la rama derecha del nodo
     * @param altDer
     */
    public void setAltDer(int altDer) {
        this.altDer = altDer;
    }

    /*public boolean balanceado(){
        if(facBalance >= -1 && facBalance <= 1){
            return true;
        }else{
            return false;
        }
    }*/
}