package Practica_3;
public class ABB {
    /**
     * Declaración del nodo "dios" (primer nodo insertado)
     */
    private Nodo dios;
    /**
     * Constrctor para iniciar nuestro nodo dios
     */
    public ABB(){
        dios = null;
    }
    /**
     * Función para insertar nodos
     * @param valor valor numerico a almacenar
     */
    public void insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(dios == null){
            dios = nuevo;
        }else{
            Nodo padre = dios;
            boolean insertado = false;
            while(!insertado){
                if(nuevo.getValor() == padre.getValor()){
                    padre.setCant(padre.getCant() + 1);
                    insertado = true;
                }else if(nuevo.getValor() < padre.getValor()){
                    if(padre.getNodoI() == null){
                        padre.setNodoIzq(nuevo);
                        nuevo.setPadre(padre);
                        insertado = true;
                    }else{
                        padre = padre.getNodoI();
                    }
                }else{
                    if(padre.getNodoD() == null){
                        padre.setNodoDer(nuevo);
                        nuevo.setPadre(padre);
                        insertado = true;
                    }else{
                        padre = padre.getNodoD();
                    }
                }
            }
        }
    }
    /**
     * Funcion para buscar un valor especifico
     * @param valor valor numerico a buscar
     * @return el nodo en el que se encuentra
     */
    public Nodo buscar(int valor){
        Nodo actual = dios;
        boolean encontrado = false;
        while(!encontrado && actual != null){
            if(actual.getValor() == valor){
                encontrado = true;
            }else if(valor < actual.getValor()){
                actual = actual.getNodoI();
            }else{
                actual = actual.getNodoD();
            }
        }
        return actual;
    }
    /**
     * Función para encontrar el valor mós pequeño en el árbol
     * @param a el árbol en el que buscará el valor
     * @return el valor más pequeño encontrado
     */
    public int minimo(ABB a){
        Nodo actual = a.dios;
        boolean encontrado = false;
        int mini = 0;
        while(!encontrado){
            if(actual.getNodoI() == null){
                mini = actual.getValor();
                encontrado = true;       
            }else{
                actual = actual.getNodoI();   
            }
        }
        return mini;
    }
    /**
     * Función para encontrar el valor más grande en el árbol
     * @param a el árbol en el que buscará el valor
     * @return el valor más grande encontrado
     */
    public int maximo(ABB a){
        Nodo actual = a.dios;
        boolean encontrado = false;
        int max = 0;
        while(!encontrado){
            if(actual.getNodoD() == null){
                max = actual.getValor();
                encontrado = true;       
            }else{
                actual = actual.getNodoD();   
            }
        }
        return max;
    }
}