package Practica_2;

import java.net.URL;
import java.time.format.SignStyle;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Lista {
/***
 * Declaración de nuestro "head" = inicio y 
 * de nuestro "tail" = fin
 */
    private Nodo inicio;
    private Nodo fin;
/***
 * Constructor por defecto
 */
    public Lista() {
        inicio = null;
        fin = null;
    }
/**
 * Función para hacer nuestra lista circular
 * @param inicio el "head" de nuestra lista
 * @param fin el "tail" de nuestra lista
 */
    public void circular(){
        fin = inicio;
        while(fin.getNext() != inicio){
            fin = fin.getNext();
        }
    }
/***
 * Función para agregar un elemnto a nuestra lista uno tras otro
 * @param val
 */
    public void add(int val){
        Nodo nodo = new Nodo(val);
        if(inicio == null){
            inicio=nodo;
            nodo.setNext(inicio);
            nodo.setBack(inicio);
            circular();
        }else{
            nodo.setNext(inicio);
            nodo.setBack(fin);
            fin.setNext(nodo);
            inicio.setBack(nodo);
            circular();
        }
    }
    /***
     * Agregar un valor en la posición indicada
     * @param val valor a agregar
     * @param pos posicion en la que se va a agregar
     * @throws Exception
     */
    public void add(int val, int pos) throws Exception{
        if(pos < 0){
            throw new Exception("Insertar valor de la posición que se encuentre en la lista");
        }
        if(pos == 0){
            Nodo nuevo = new Nodo(val);
            nuevo.setNext(inicio);
            inicio.setBack(nuevo);
            nuevo.setBack(fin);
            fin.setNext(nuevo);
            inicio = nuevo;
        }else{
            Nodo actual = inicio.getNext();
            Nodo actual2 = actual.getNext();
            int contador = 1;
            while(actual != inicio){
                if(contador == pos-1){
                    Nodo nuevo = new Nodo(val);
                    nuevo.setNext(actual.getNext());
                    nuevo.setBack(actual);
                    actual.setNext(nuevo);
                    actual2.setBack(nuevo);
                    circular();
                    break;
                }
                contador ++;
                actual = actual.getNext();
                actual2 = actual2.getNext();
            }
        }
    }
    /**
     * Funcion para buscar un valor especifico
     * @param bus valor que buscara
     * @return valor encontrado
     */
    public Nodo buscar(int bus){
        Nodo actual = inicio;
        int contador = 0;
        while(actual != fin){
            if(actual.getNum() == bus){
                System.out.println("La direccion del numero '"+actual.getNum()+"' es: "+contador);
                break;
            }else{
                contador ++;
                actual = actual.getNext();
            }
        }
        return actual;
    }
    /**
     * Funcion para genrar numeros aleatorios y ordenarlos
     * @param elementos
     */
    public void aleatorios(int elementos){
        int i, num = 0;
        for(i = 0; i < elementos; i++){
            num = Integer.valueOf((int)((Math.random() * (999 - 0 + 1))));
            System.out.println("| "+num+" | ");
            Nodo al = new Nodo(num);
            if(inicio == null){
                inicio = al;
                al.setNext(inicio);
                al.setBack(inicio);
                circular();
            }else{
                al.setNext(inicio);
                al.setBack(fin);
                fin.setNext(al);
                inicio.setBack(al);
                circular();
            }
        }
        /**
         * Ordenar de forma ascendente
         */
        Nodo actual = inicio;
        Nodo siguiente = actual.getNext();
        System.out.println("Numeros ordenados de manera ascendente");
        do{
            if(actual.getNum() > siguiente.getNum()){
                if(actual == inicio){
                    inicio = siguiente;
                }
                if(siguiente == fin){
                    fin = actual;
                }
                actual.getBack().setNext(siguiente);
                siguiente.getNext().setBack(actual);
                actual.setNext(siguiente.getNext());
                siguiente.setNext(actual);
                siguiente.setBack(actual.getBack());
                actual.setBack(siguiente);
                actual = inicio;
                siguiente = inicio.getNext();
            }else{
                actual = actual.getNext();
                siguiente = siguiente.getNext();
            }
        }while(actual != fin);
        mostrar(1);
        /**
         * Ordenar de forma descendente
         */
        System.out.println("Numeros ordenados de manera descendente");
        mostrar(2);
    }
/***
 * Función para mostrar la lista en el orden en que se introdujeron los datos 
*/    
    public void mostrar(int sent){
        if(sent == 1){
            Nodo nodo = inicio;
            do{
                System.out.print("| "+nodo.getNum()+" | ->");
                nodo = nodo.getNext();
            }while(nodo != inicio);
            System.out.println("NULL");
        }else if(sent == 2){
            Nodo nodo = fin;
            do{
                System.out.print("| "+nodo.getNum()+" | ->");
                nodo = nodo.getBack();
            }while(nodo != fin);
            System.out.println("NULL");
        }
    }
}