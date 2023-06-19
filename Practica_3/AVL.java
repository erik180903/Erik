package Practica_3;
import java.util.Stack;
public class AVL {
    private Nodo dios;
    public Nodo getDios() {
        return dios;
    }
    private Nodo desbalanceado;
    public AVL(){
        dios = null;
    }
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
                        padre.setFacBalance(padre.getFacBalance() + nuevo.getFacBalance() + 1);     
                    }else{
                        padre = padre.getNodoI();
                    }
                }else{
                    if(padre.getNodoD() == null){
                        padre.setNodoDer(nuevo);
                        nuevo.setPadre(padre);
                        insertado = true;
                        padre.setFacBalance(padre.getFacBalance() + nuevo.getFacBalance() - 1);
                    }else{
                        padre = padre.getNodoD();
                    }
                }
            }
        }
        balancear();
    }
    public int altura(Nodo actual){
        if(actual.getAltDer() <= actual.getAltIzq()){
            return actual.getAltIzq();
        }else if(actual.getAltDer() > actual.getAltIzq()){
            return actual.getAltDer();
        }else{
            return 0;
        }
    }
    public void factorNodo(Nodo actual){
        if(actual.getNodoI() != null){
            factorNodo(actual.getNodoI());
            actual.setAltIzq(altura(actual.getNodoI()) + 1);
        }else{
            actual.setAltIzq(0);
        }   
        if(actual.getNodoD() != null){
            factorNodo(actual.getNodoD());
            actual.setAltDer(altura(actual.getNodoD()) + 1);
        }else{
            actual.setAltDer(0);
        }
        actual.setFacBalance(actual.getAltIzq() - actual.getAltDer());
    }
    public void factoresBalance(){
        factorNodo(dios);
    }
    public void nodoDesbalanceado(Nodo actual){
        if(actual.getFacBalance() < -1 || actual.getFacBalance() > 1){
            desbalanceado = actual;
            //System.out.println("Nodo desbalanceado: "+desbalanceado.getValor());
        }
        if(actual.getNodoI() != null){
            nodoDesbalanceado(actual.getNodoI());
        }
        if(actual.getNodoD() != null){
            nodoDesbalanceado(actual.getNodoD());
        }
    }
    public void desbalances(){
        desbalanceado = null;
        nodoDesbalanceado(dios);
    }
    public void balancear(){
        factoresBalance();
        desbalances();
        while(desbalanceado != null){
            AVL arbolaux = new AVL();
            if(desbalanceado.getFacBalance() > 0){
                aux(arbolaux, desbalanceado.getNodoI());
                arbolaux.insertar(desbalanceado.getValor());
                aux(arbolaux, desbalanceado.getNodoD());
            }
            if(desbalanceado.getFacBalance() < 0){
                aux(arbolaux, desbalanceado.getNodoD());
                arbolaux.insertar(desbalanceado.getValor());
                aux(arbolaux, desbalanceado.getNodoI());
            }
            if(desbalanceado == dios){
                this.dios = arbolaux.getDios();
            }else{
                if(desbalanceado.getPadre().getNodoI() == desbalanceado){
                    desbalanceado.getPadre().setNodoIzq(arbolaux.getDios());
                }
                if(desbalanceado.getPadre().getNodoD() == desbalanceado){
                    desbalanceado.getPadre().setNodoDer(arbolaux.getDios());
                }
                arbolaux.getDios().setPadre(desbalanceado.getPadre());
            }
            arbolaux = null;
            factoresBalance();
            desbalances();
        }
    }
    public void aux (AVL arbolaux, Nodo nodo){
        Nodo actual = nodo;
        Stack<Nodo> almacenados = new Stack<>();
        while(actual != null){
            if(actual.getNodoD() != null){
                almacenados.push(actual.getNodoD());
            }
            for(int i = 0; i < actual.getCant(); i++){
                arbolaux.insertar(actual.getValor());
            }
            while(actual.getNodoI() != null){
                actual = actual.getNodoI();
                for(int i = 0; i < actual.getCant(); i++){
                    arbolaux.insertar(actual.getValor());
                }
                if(actual.getNodoD() != null){
                    almacenados.push(actual.getNodoD());
                }
            }
            if(almacenados.isEmpty()){
                actual = null;
            }else{
                actual = almacenados.pop();
            }
        }
    }
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
    public void eliminar(int valor){
        Nodo encontrado = buscar(valor);
        Nodo padre;
        Nodo min;
        if(encontrado != null){
            //caso "extra" el valor esta repetido
            if(encontrado.getCant() > 1){
                encontrado.setCant(encontrado.getCant() - 1);
                return;
            }
            //caso 1 nodo hoja
            if(encontrado.getNodoD() == null && encontrado.getNodoI() == null){
                if(encontrado.getPadre() == null){
                    dios = null;
                }else{
                    padre = encontrado.getPadre();
                    if (padre.getNodoI() == encontrado) {
                        padre.setNodoIzq(null);
                    } else {
                        padre.setNodoDer(null);
                    }
                    encontrado.setPadre(null);
                    balancear();
                }
                //caso 2 un nodo hijo
            }else if(encontrado.getNodoD() == null || encontrado.getNodoI() == null){
                if (encontrado.getPadre() == null) {
                    if (encontrado.getNodoI() != null) {
                        dios = encontrado.getNodoI();
                        encontrado.setNodoIzq(null);
                    } else {
                        dios = encontrado.getNodoD();
                        encontrado.setNodoDer(null);
                    }
                } else {
                    padre = encontrado.getPadre();
                    if (padre.getNodoI() == encontrado) {
                        padre.setNodoIzq(encontrado.getNodoI() != null ? encontrado.getNodoI() : encontrado.getNodoD());
                        padre.getNodoI().setPadre(padre);
                    } else {
                        padre.setNodoDer(encontrado.getNodoI() != null ? encontrado.getNodoI() : encontrado.getNodoD());
                        padre.getNodoD().setPadre(padre);
                    }
                    encontrado.setNodoIzq(null);
                    encontrado.setNodoDer(null);
                    encontrado.setPadre(null);
                    balancear();
                }
            }
            //caso 3 dos nodos hijos
            if(encontrado.getNodoD() != null && encontrado.getNodoI() != null) {
                min = encontrado.getNodoD();
                while (min.getNodoI() != null) {
                    min = min.getNodoI();
                }
                encontrado.setValor(min.getValor());
                encontrado = min;
                balancear();
            }
        }
    }
    public int minimo(AVL a){
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
    public int maximo(AVL a){
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
    public int predecesor(int valor){
        Nodo buscado = buscar(valor);
        boolean encontrado = false;
        int pred = 0;
        //cuando el valor si tiene subarbol Izquierdo
        if(buscado.getNodoI() != null){
            buscado = buscado.getNodoI();
            while(!encontrado){
                if(buscado.getNodoD() == null){
                    pred = buscado.getValor();
                    encontrado = true;
                }else{
                    buscado = buscado.getNodoD();
                }
            }
        }else{
            //cuando el valor no tiene subarbol Izquierdo
            while(!encontrado){
                if(buscado.getPadre().getPadre().getNodoD() == buscado.getPadre()){
                    pred = buscado.getPadre().getPadre().getValor();
                    encontrado = true;
                }else{
                    buscado = buscado.getPadre();
                }
            }
        }
        return pred;
    }
    public int sucesor(int valor){
        Nodo buscado = buscar(valor);
        boolean encontrado = false;
        int suc = 0;
        //cuando el valor si tiene subarbol derecho
        if(buscado.getNodoD() != null){
            buscado = buscado.getNodoD();
            while(!encontrado){
                if(buscado.getNodoI() == null){
                    suc = buscado.getValor();
                    encontrado = true;
                }else{
                    buscado = buscado.getNodoI();
                }
            }
        }else{
            //cuando el valor no tiene subarbol derecho
            while(!encontrado){
                if(buscado.getPadre().getPadre().getNodoI() == buscado.getPadre()){
                    suc = buscado.getPadre().getPadre().getValor();
                    encontrado = true;
                }else{
                    buscado = buscado.getPadre();
                }
            }
        }
        return suc;
    }
    
    
    //Codigo para mostrar el arbol de forma inorden para comprobar su funcionalidad
    /*private void inorden(Nodo nodo){
        if(nodo != null){
            inorden(nodo.getNodoI());
            for(int i = 1;i<=nodo.getCant();i++){
                System.out.println(nodo.getValor()+" -> "+nodo.getFacBalance());
            }
            inorden(nodo.getNodoD());
        }
    }
    public void inorden(){
        factoresBalance();
        desbalances();
        inorden(dios);
        System.out.println();
    }*/
}
