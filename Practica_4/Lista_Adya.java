package Practica_4;
/**
 * Librerias
 */
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Lista_Adya {
    /**
     * Declaración de la tabla (matriz de adyacencia), la cola para el recorrido en anchura
     * y la pila para el recorrido en profundidad
     */
    private Hashtable<String, List<String>> listaAdyacencia;
    private Queue<String> queue;
    private Stack<String> stack;
    
    /**
     * Constructor por defecto
     */
    public Lista_Adya() {
        queue = new ConcurrentLinkedQueue<String>();
        stack = new Stack<String>();
        listaAdyacencia = new Hashtable<String, List<String>>();
    }

    /**
     * Función para agregar un vertice
     * @param s valor a guardar en el vertice
     */
    public void addVertice(String s) {
        listaAdyacencia.put(s, new LinkedList<String>());
    }

    /**
     * Función para agregar una arista
     * @param o valor del nodo donde inicia la arista
     * @param d valor del nodo donde llega la arista
     * @throws Exception en caso de que no exista el nodo
     */
    public void addArista(String o, String d) throws Exception {
        if (!listaAdyacencia.containsKey(o))
            throw new Exception("Vertice no valido.");
        if (!listaAdyacencia.containsKey(d))
            throw new Exception("Vertice no valido.");

        if (!listaAdyacencia.get(o).contains(d))
            listaAdyacencia.get(o).add(d);
    }

    /**
     * Función para el recorrido en anchura
     * @param a valor en el que empieza a recorrer
     * @throws Exception en caso de que el nodo no exista
     */
    public void anchura(String a) throws Exception {
        List<String> visitados = new LinkedList<String>();
        queue.clear();
        if(!listaAdyacencia.containsKey(a)) throw new Exception("El vertice no existe.");
        queue.add(a);
        while(!queue.isEmpty()) {
            String s = queue.poll();
            System.out.print(s + " ");
            visitados.add(s);
            for (String string : listaAdyacencia.get(s)) {
                if(!visitados.contains(string) && !queue.contains(string)) {
                    queue.add(string);
                }
            }
        }
    }

    /**
     * Función para el recorrido en profundidad
     * @param a valor en el que empieza a recorrer
     * @throws Exception en caso de que el nodo no exista
     */
    public void profundidad(String a) throws Exception {
        List<String> visitados = new LinkedList<String>();
        stack.clear();
        if(!listaAdyacencia.containsKey(a)) throw new Exception("El vertice no existe.");
        stack.add(a);
        while(!stack.isEmpty()) {
            String s = stack.pop();
            System.out.print(s + " ");
            visitados.add(s);
            for (String string : listaAdyacencia.get(s)) {
                if(!visitados.contains(string) && !stack.contains(string)) {
                    stack.add(string);
                }
            }
        }
    }
}